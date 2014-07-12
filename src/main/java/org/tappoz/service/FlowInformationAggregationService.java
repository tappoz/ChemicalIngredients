package org.tappoz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tappoz.bean.IngredientContent;
import org.tappoz.bean.validated.ValidatedChemicalIngredient;
import org.tappoz.service.adapter.IngredientAdapter;

import java.util.List;

/**
 * Created by tappoz on 12/07/14.
 */
@Service
public class FlowInformationAggregationService {

    private final static Logger log = LoggerFactory.getLogger(FlowInformationAggregationService.class);

    @Autowired
    private ChemicalParsingService chemicalParsingService;
    @Autowired
    private IngredientAdapter ingredientAdapter;


    public List<ValidatedChemicalIngredient> processInputList(List<String> rawIngredients) {

        // the following 2 steps (for loops) are kept separate
        // in order to have a better idea of the process flow
        // they can be combined in a unique for loop

        // step 1: use the grammar to parse the string
        List<IngredientContent> ingredientContentList = chemicalParsingService.processComplexIngredient(rawIngredients);
        log.info("Just got all the ingredients, in a list of objects, as parsed by the context free grammar.");

        // step 2: validate the fields extracted and set in every object
        List<ValidatedChemicalIngredient> validatedChemicalIngredientList = ingredientAdapter.validateAmountsInIngredientContent(ingredientContentList);
        log.info("Just got all the validated ingredients in a list of objects");

        return validatedChemicalIngredientList;
    }
}
