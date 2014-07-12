package org.tappoz.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tappoz.bean.BasicAmount;
import org.tappoz.bean.IngredientContent;
import org.tappoz.bean.WrapperAmount;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tappoz on 11/07/14.
 */
@Service
public class ChemicalParsingService {

    private final static Logger log = LoggerFactory.getLogger(ChemicalParsingService.class);

    private final static String AMOUNT_IN_BRAKETS = "\\([0-9]+\\/?[\\w]+[^\\(]*\\):?"; // matches the brackets and their content in: "2 (14 1/2 ounce) cans"

    @Autowired
    private ChemicalStringProcessorService chemicalStringProcessorService;
    @Autowired
    private IngredientLabelCleaningService ingredientLabelCleaningService;

    public IngredientContent processComplexIngredient(String complexIngredient) {

        String expectedIngredientName;

        // regex stuff to find strings contained in round brackets
        Pattern patternAmountInBrackets = Pattern.compile(AMOUNT_IN_BRAKETS);
        Matcher matcherAmountInBrackets = patternAmountInBrackets.matcher(complexIngredient);

        // PROCESS the amount in round brackets and get BasicAmount, then clean the input string
        IngredientContent ingredientContent = new IngredientContent();
        BasicAmount basicAmount;
        WrapperAmount wrapperAmount = new WrapperAmount(); // the amount outside of the round brackets e.g. "2 (14 1/2 ounce) cans"
        if(matcherAmountInBrackets.find()) {
            String matchedSubStringRegardingAmountInBrackets = matcherAmountInBrackets.group();
            log.debug("found a hidden amount inside brackets: '" + matchedSubStringRegardingAmountInBrackets + "'");
            basicAmount = chemicalStringProcessorService.parseThisIngredient(matchedSubStringRegardingAmountInBrackets);
            ingredientContent.setBasicAmount(basicAmount);

            // removing the already parsed stuff
            // (matchedSubStringRegardingAmountInBrackets is treated as regex so we need to add the extra brackets)
            String cleanedComplexIngredient = StringUtils.remove(complexIngredient, matchedSubStringRegardingAmountInBrackets);

            BasicAmount basicAmountCarrier = chemicalStringProcessorService.parseThisIngredient(cleanedComplexIngredient);
            wrapperAmount.setValue(basicAmountCarrier.getValue());
            wrapperAmount.setUnitOfMeasure(basicAmountCarrier.getUnitOfMeasure());
            ingredientContent.setWrapperAmount(wrapperAmount);

            // cleaning the stuff parsed for the wrapper amount
            expectedIngredientName = StringUtils.remove(cleanedComplexIngredient,wrapperAmount.getValue());
            expectedIngredientName = StringUtils.remove(expectedIngredientName,wrapperAmount.getUnitOfMeasure());
        }
        else {
            log.debug("Just found a simple ingredient to parse. No amounts inside brackets to parse.");

            basicAmount = chemicalStringProcessorService.parseThisIngredient(complexIngredient);
            ingredientContent.setBasicAmount(basicAmount);

            // cleaning the stuff for the basic amount
            expectedIngredientName = StringUtils.remove(complexIngredient,basicAmount.getValue());
            if(basicAmount.getRangeValue() != null) {
                expectedIngredientName = StringUtils.remove(expectedIngredientName,basicAmount.getRangeValue()[0]);
                expectedIngredientName = StringUtils.remove(expectedIngredientName,basicAmount.getRangeValue()[1]);
                // TODO refactor the following adding a parser to the LINK_IN_RANGE lexer, then getting its values
                expectedIngredientName = StringUtils.remove(expectedIngredientName,"to ");
                expectedIngredientName = StringUtils.remove(expectedIngredientName,"or ");

                log.debug("Just cleaned all the stuff regarding a range of amounts.");
            }
            // cleaning the unit of measure
            expectedIngredientName = StringUtils.remove(expectedIngredientName,basicAmount.getUnitOfMeasure());
        }

        // setting what is remaining after the parsing of the amounts
        ingredientContent.setIngredientName(expectedIngredientName);
        // cleaning the ingredient name
        ingredientContent = ingredientLabelCleaningService.cleanIngredientName(ingredientContent);

        log.info("About to return a parsed chemical ingredient for the input string: '" + complexIngredient + "'");
        return ingredientContent;
    }

    public List<IngredientContent> processComplexIngredient(List<String> complexIngredientList) {

        List<IngredientContent> ingredientContentList = Lists.newArrayList();

        for(String currentComplexIngredient : complexIngredientList) {
            IngredientContent currentIngredientContent = this.processComplexIngredient(currentComplexIngredient);
            ingredientContentList.add(currentIngredientContent);
        }

        log.info("Just parsed chemical ingredients in a list of size: " + ingredientContentList.size());
        return ingredientContentList;
    }
}
