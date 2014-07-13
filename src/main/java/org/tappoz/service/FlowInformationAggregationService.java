package org.tappoz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tappoz.bean.IngredientContent;
import org.tappoz.bean.validated.ValidatedChemicalIngredient;
import org.tappoz.service.adapter.IngredientAdapter;

import java.util.List;

@Service
public class FlowInformationAggregationService {

    private final static Logger log = LoggerFactory.getLogger(FlowInformationAggregationService.class);

    @Autowired
    private ChemicalParsingService chemicalParsingService;
    @Autowired
    private IngredientAdapter ingredientAdapter;

    /**
     * Given a list of input strings, this method calls different services to process those strings
     * and return a list of validated objects.
     *
     * @see {@link org.tappoz.service.ChemicalParsingService#processComplexIngredient(String)}
     * @see {@link org.tappoz.service.adapter.IngredientAdapter#validateAmountsInIngredientContent(org.tappoz.bean.IngredientContent)}
     *
     * @param rawIngredients a list of strings
     * @return a list of validated objects
     */
    public List<ValidatedChemicalIngredient> processInputList(List<String> rawIngredients) {

        // the following 2 steps (for loops) are kept separate
        // in order to have a better idea of the process flow
        // they can be combined in a unique for loop

        // step 1: use the context free grammar to parse every string in the list
        List<IngredientContent> ingredientContentList = chemicalParsingService.processComplexIngredient(rawIngredients);
        log.info("Just got all the ingredients, in a list of objects, as parsed by the context free grammar.");

        // step 2: validate the fields previously extracted and set in every object
        List<ValidatedChemicalIngredient> validatedChemicalIngredientList = ingredientAdapter.validateAmountsInIngredientContent(ingredientContentList);
        log.info("Just got all the validated ingredients in a list of objects");

        return validatedChemicalIngredientList;
    }
}
