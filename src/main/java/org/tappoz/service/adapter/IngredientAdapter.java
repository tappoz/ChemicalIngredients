package org.tappoz.service.adapter;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tappoz.bean.BasicAmount;
import org.tappoz.bean.IngredientContent;
import org.tappoz.bean.WrapperAmount;
import org.tappoz.bean.validated.ValidatedAmount;
import org.tappoz.bean.validated.ValidatedChemicalIngredient;
import org.tappoz.enums.UnitOfMeasure;
import org.tappoz.util.AmountStaticUtil;

import java.util.List;

/**
 * Created by tappoz on 12/07/14.
 */
@Service
public class IngredientAdapter {

    private final static Logger log = LoggerFactory.getLogger(IngredientAdapter.class);

    public List<ValidatedChemicalIngredient> validateAmountsInIngredientContent(List<IngredientContent> ingredientContentList) {
        List<ValidatedChemicalIngredient> outputList = Lists.newArrayList();
        for(IngredientContent currentIngredient : ingredientContentList) {
            ValidatedChemicalIngredient currentValidatedIngredient = this.validateAmountsInIngredientContent(currentIngredient);
            outputList.add(currentValidatedIngredient);
        }

        log.info("About to return the validated ingredients as a list of size: " + outputList.size());
        return outputList;
    }

    public ValidatedChemicalIngredient validateAmountsInIngredientContent(IngredientContent ingredientContent) {

        ValidatedChemicalIngredient ingredient = new ValidatedChemicalIngredient();

        if(ingredientContent.getBasicAmount() != null) {
            // we are setting the part that is in brackets
            // e.g. "70 grams" in the original string "5 tablespoons (70 grams) of lye"
            ingredient.setDetailedAmount(this.validateBasicAmount(ingredientContent.getBasicAmount()));
        }

        if(ingredientContent.getWrapperAmount() != null) {
            // we are setting the part outside the brackets
            // e.g. "5 tablespoons" in the original string "5 tablespoons (70 grams) of lye"
            // which is considered more general than the one inside the brackets
            ingredient.setGenericAmount(this.validateWrapperAmount(ingredientContent.getWrapperAmount()));
        }

        ingredient.setName(ingredientContent.getIngredientName());

        return ingredient;
    }

    public ValidatedAmount validateBasicAmount(BasicAmount basicAmount) {

        ValidatedAmount validatedAmount = new ValidatedAmount();

        // validating the amount
        if (basicAmount.getRangeValue() != null) {
            validatedAmount.setAmount(AmountStaticUtil.getMean(basicAmount.getRangeValue()));
        } else {
            validatedAmount.setAmount(AmountStaticUtil.parseNumber(basicAmount.getValue()));
        }

        // validating the unit of measure
        validatedAmount.setUnitOfMeasure(UnitOfMeasure.find(basicAmount.getUnitOfMeasure()));

        return validatedAmount;
    }

    public ValidatedAmount validateWrapperAmount(WrapperAmount wrapperAmount) {

        ValidatedAmount validatedAmount = new ValidatedAmount();
        validatedAmount.setAmount(AmountStaticUtil.parseNumber(wrapperAmount.getValue()));
        validatedAmount.setUnitOfMeasure(UnitOfMeasure.find(wrapperAmount.getUnitOfMeasure()));

        return validatedAmount;
    }
}
