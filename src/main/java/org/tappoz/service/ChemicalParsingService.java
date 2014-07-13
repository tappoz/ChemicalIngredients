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

@Service
public class ChemicalParsingService {

    private final static Logger log = LoggerFactory.getLogger(ChemicalParsingService.class);

    // matches the brackets and their content in: "2 (14 1/2 ounce) cans"
    private final static String AMOUNT_IN_BRAKETS = "\\([0-9]+\\/?[\\w]+[^\\(]*\\):?";

    @Autowired
    private ChemicalStringProcessorService chemicalStringProcessorService;
    @Autowired
    private IngredientLabelCleaningService ingredientLabelCleaningService;

    /**
     * This method, given an input string representing a chemical ingredient
     * e.g. "5 tablespoons (70 grams) of lye" parses all its parts.
     * (the detailed amount, the generic amount if present, the chemical ingredient name)
     *
     * @see {@link org.tappoz.bean.IngredientContent}
     * @see {@link org.tappoz.service.ChemicalStringProcessorService#parseThisIngredient(String)}
     * @see {@link org.tappoz.service.IngredientLabelCleaningService#cleanIngredientName(org.tappoz.bean.IngredientContent)}
     *
     * There is another method containing the same functionality, that can be applied to lists of strings.
     * @see {@link #processComplexIngredient(java.util.List)}
     *
     * @param complexIngredient a string representing an ingredient
     * @return {@link org.tappoz.bean.IngredientContent}
     */
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

        // cleaning the ingredient name
        expectedIngredientName = ingredientLabelCleaningService.cleanIngredientName(expectedIngredientName);
        // setting what is remaining after the parsing of the amounts
        ingredientContent.setIngredientName(expectedIngredientName);

        log.info("About to return a parsed chemical ingredient for the input string: '" + complexIngredient + "'");
        log.debug("The parsed java bean is: " + ingredientContent.toJson());
        return ingredientContent;
    }

    /**
     * This method contains the same functionality described in:
     * @see {@link #processComplexIngredient(String)}
     *
     * @param complexIngredientList a list of strings representing ingredients
     * @return a list of {@link org.tappoz.bean.IngredientContent}
     */
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
