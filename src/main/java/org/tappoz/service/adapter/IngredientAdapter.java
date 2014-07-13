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

@Service
public class IngredientAdapter {

    private final static Logger log = LoggerFactory.getLogger(IngredientAdapter.class);

    /**
     * This is just a convenient mehtod for lists of objects,
     * it loops on a list of input beans using the functionality defined in another method
     * of this same class.
     * Cfr. {@link #validateAmountsInIngredientContent(org.tappoz.bean.IngredientContent)}
     *
     * @param ingredientContentList a list of input beans
     * @return a list of validated beans
     */
    public List<ValidatedChemicalIngredient> validateAmountsInIngredientContent(List<IngredientContent> ingredientContentList) {
        List<ValidatedChemicalIngredient> outputList = Lists.newArrayList();
        for(IngredientContent currentIngredient : ingredientContentList) {
            ValidatedChemicalIngredient currentValidatedIngredient = this.validateAmountsInIngredientContent(currentIngredient);
            outputList.add(currentValidatedIngredient);
        }

        log.info("About to return the validated ingredients as a list of size: " + outputList.size());
        return outputList;
    }

    /**
     * This method returns a validated objects using other methods of
     * this same class for their internal components.
     * @see {@link #validateBasicAmount(org.tappoz.bean.BasicAmount)}
     * @see {@link #validateWrapperAmount(org.tappoz.bean.WrapperAmount)}
     *
     * @param ingredientContent the input bean {@link org.tappoz.bean.IngredientContent}
     * @return the validated bean {@link org.tappoz.bean.validated.ValidatedChemicalIngredient}
     */
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

    /**
     * Sometimes in quite complex strings to parse there is an ingredient with an amount specified
     * inside round brackets and another amount specified outside round brackets.
     * In this scenario, e.g. "5 tablespoons (70 grams) of lye" the basic amount is considered
     * "70 grams", this is the amount validated in this case.
     * In all the other scenarios where there is only one amount to validate,
     * e.g. in "1 1/2 grams of sodium carbonate", this is the basic amount.
     * (cfr. {@link org.tappoz.bean.BasicAmount})
     * @see {@link org.tappoz.util.AmountStaticUtil#parseNumber(String)}
     *
     * For the validation of the unit of measure,
     * @see {@link org.tappoz.enums.UnitOfMeasure#find(String)}
     *
     * A basic amount might contain a range of values, e.g. in "3 to 4 ml of water".
     * In this case a mean is used instead of the two bound values in the range,
     * @see {@link org.tappoz.util.AmountStaticUtil#getMean(String[])}
     *
     * @param basicAmount on of the possible 2 amounts in the input string to parse
     * @return {@link org.tappoz.bean.validated.ValidatedAmount}
     */
    public ValidatedAmount validateBasicAmount(BasicAmount basicAmount) {

        ValidatedAmount validatedAmount = new ValidatedAmount();

        // validating the amount
        if (basicAmount.getRangeValue() != null) {
            validatedAmount.setAmount(AmountStaticUtil.getMean(basicAmount.getRangeValue()));
        } else {
            validatedAmount.setAmount(AmountStaticUtil.parseNumber(basicAmount.getValue()));
        }

        // validating the unit of measure
        if(basicAmount.getUnitOfMeasure() == null) {
            UnitOfMeasure defaultUnitOfMeasure = UnitOfMeasure.unit;
            log.warn("It seems we could not find a unit of measure in the original ingredient, set it to: '" + defaultUnitOfMeasure + "'");
            validatedAmount.setUnitOfMeasure(defaultUnitOfMeasure);
        } else {
            validatedAmount.setUnitOfMeasure(UnitOfMeasure.find(basicAmount.getUnitOfMeasure()));
        }

        return validatedAmount;
    }

    /**
     * Sometimes in quite complex strings to parse there is an ingredient with an amount specified
     * inside round brackets and another amount specified outside round brackets.
     * In this scenario, e.g. "5 tablespoons (70 grams) of lye" the wrapper amount is considered
     * "5 tablespoons", this is the amount validated in this case
     * (cfr. {@link org.tappoz.bean.WrapperAmount})
     * @see {@link org.tappoz.util.AmountStaticUtil#parseNumber(String)}
     *
     * For the validation of the unit of measure,
     * @see {@link org.tappoz.enums.UnitOfMeasure#find(String)}
     *
     * @param wrapperAmount on of the possible 2 amounts in the input string to parse
     * @return {@link org.tappoz.bean.validated.ValidatedAmount}
     */
    public ValidatedAmount validateWrapperAmount(WrapperAmount wrapperAmount) {

        ValidatedAmount validatedAmount = new ValidatedAmount();
        validatedAmount.setAmount(AmountStaticUtil.parseNumber(wrapperAmount.getValue()));
        // validation of the unit of measure through the enum class
        validatedAmount.setUnitOfMeasure(UnitOfMeasure.find(wrapperAmount.getUnitOfMeasure()));

        return validatedAmount;
    }
}
