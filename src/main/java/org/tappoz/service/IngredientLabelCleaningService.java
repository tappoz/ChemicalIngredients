package org.tappoz.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tappoz.bean.IngredientContent;

import java.util.List;

/**
 * Created by tappoz on 12/07/14.
 */
@Service
public class IngredientLabelCleaningService {

    private final static Logger log = LoggerFactory.getLogger(IngredientLabelCleaningService.class);

    // this list might become longer according to new cleaning rules
    private final static String[] STOP_WORD_REGEX = {"^of\\s", };

    public IngredientContent cleanIngredientName(IngredientContent ingredientContent) {
        String ingredientNameToBeCleaned = ingredientContent.getIngredientName();

        // normalising white spaces:
        // removing leading and trailing whitespace,
        // then replacing sequences of white space characters by a single space
        String cleanedIngredientName = StringUtils.normalizeSpace(ingredientNameToBeCleaned);

        for(String currentRegex : STOP_WORD_REGEX) {
            // cleaning the string according to the current regex
            cleanedIngredientName = cleanedIngredientName.replaceAll(currentRegex, "");
        }

        ingredientContent.setIngredientName(cleanedIngredientName);
        log.debug("About to return the object with the cleaned name: '" + cleanedIngredientName + "'");
        return ingredientContent;
    }

    public List<IngredientContent> cleanIngredientName(List<IngredientContent> ingredientContentList) {

        List<IngredientContent> outputList = Lists.newArrayList();
        for(IngredientContent currentIngredientContent : ingredientContentList) {
            outputList.add(this.cleanIngredientName(currentIngredientContent));
        }

        log.info("Just cleaned a list of ingredient names of size: " + outputList.size());
        return outputList;
    }
}
