package org.tappoz.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tappoz.bean.BasicAmount;
import org.tappoz.bean.IngredientContent;
import org.tappoz.bean.WrapperAmount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tappoz on 11/07/14.
 */
@Service
public class ChemicalParsingService {

    private final static Logger log = LoggerFactory.getLogger(ChemicalParsingService.class);

    @Autowired
    ChemicalStringProcessorService chemicalStringProcessorService;

    public IngredientContent processComplexIngredient(String complexIngredient) {

        String ingredientToProcess = complexIngredient;
        String expectedIngredientName;

        // regex stuff to find strings contained in round brackets
        String AMOUNT_IN_BRAKETS = "\\([0-9]+\\/?[\\w]+[^\\(]*\\):?"; // matches the brackets and their content in: "2 (14 1/2 ounce) cans"
        Pattern patternAmountInBrakets = Pattern.compile(AMOUNT_IN_BRAKETS);
        Matcher matcherAmountInBrakets = patternAmountInBrakets.matcher(ingredientToProcess);

        // PROCESS the amount in round brackets and get BasicAmount, then clean the input string
        IngredientContent ingredientContent = new IngredientContent();
        BasicAmount basicAmount;
        WrapperAmount wrapperAmount = new WrapperAmount(); // the amount outside of the round brackets e.g. "2 (14 1/2 ounce) cans"
        if(matcherAmountInBrakets.find()) {
            String matchedSubStringRegardingAmountInBrakets = matcherAmountInBrakets.group();
            log.debug("found a hidden amount inside brackets: '" + matchedSubStringRegardingAmountInBrakets + "'");
            basicAmount = chemicalStringProcessorService.parseThisIngredient(matchedSubStringRegardingAmountInBrakets);
            ingredientContent.setBasicAmount(basicAmount);

            // removing the already parsed stuff
            // (matchedSubStringRegardingAmountInBrakets is treated as regex so we need to add the extra brackets)
            String cleanedComplexIngredient = StringUtils.remove(ingredientToProcess, matchedSubStringRegardingAmountInBrakets);

            BasicAmount basicAmountCarrier = chemicalStringProcessorService.parseThisIngredient(cleanedComplexIngredient);
            wrapperAmount.setValue(basicAmountCarrier.getValue());
            wrapperAmount.setUnitOfMeasure(basicAmountCarrier.getUnitOfMeasure());
            ingredientContent.setWrapperAmount(wrapperAmount);

            // cleaning the stuff parsed for the wrapper amount
            expectedIngredientName = StringUtils.remove(cleanedComplexIngredient,wrapperAmount.getValue());
            expectedIngredientName = StringUtils.remove(expectedIngredientName,wrapperAmount.getUnitOfMeasure());
        }
        else {
            basicAmount = chemicalStringProcessorService.parseThisIngredient(ingredientToProcess);
            ingredientContent.setBasicAmount(basicAmount);

            // cleaning the stuff for the basic amount
            expectedIngredientName = StringUtils.remove(ingredientToProcess,basicAmount.getValue());
            if(basicAmount.getRangeValue() != null) {
                expectedIngredientName = StringUtils.remove(expectedIngredientName,basicAmount.getRangeValue()[0]);
                expectedIngredientName = StringUtils.remove(expectedIngredientName,basicAmount.getRangeValue()[1]);
                // TODO refactor the following adding a parser to the LINK_IN_RANGE lexer, then getting its values
                expectedIngredientName = StringUtils.remove(expectedIngredientName,"to ");
                expectedIngredientName = StringUtils.remove(expectedIngredientName,"or ");
            }
            expectedIngredientName = StringUtils.remove(expectedIngredientName,basicAmount.getUnitOfMeasure());
        }

        // setting what is remaining after the parsing of the amounts
        ingredientContent.setIngredientName(StringUtils.normalizeSpace(expectedIngredientName));

        return ingredientContent;
    }
}
