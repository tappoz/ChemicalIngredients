package org.tappoz.listener;

import org.antlr.v4.runtime.misc.NotNull;
import org.tappoz.parser.ChemicalIngredientsGrammarBaseListener;
import org.tappoz.parser.ChemicalIngredientsGrammarParser;

/**
 * Created by tappoz on 09/07/14.
 */
public class CustomIngredientListener extends ChemicalIngredientsGrammarBaseListener {

    private String value;
    private String unitOfMeasure;
    private String[] rangeValue;

    @Override
    public void enterValue(@NotNull ChemicalIngredientsGrammarParser.ValueContext ctx) {

        ChemicalIngredientsGrammarParser.NumberContext numberContext = ctx.number();
        if (numberContext != null) {
            String number = numberContext.getText();
            if (number != null ) {
                value = number;
                return;
            }
        }

        ChemicalIngredientsGrammarParser.NumberWithDecimalsContext numberWithDecimalsContext = ctx.numberWithDecimals();
        if (numberWithDecimalsContext != null) {
            String numberWithDecimals = numberWithDecimalsContext.getText();
            if (numberWithDecimals != null ) {
                value = numberWithDecimals;
                return;
            }
        }

        ChemicalIngredientsGrammarParser.SimpleFractionContext simpleFractionContext = ctx.simpleFraction();
        if (simpleFractionContext != null) {
            String simpleFraction = simpleFractionContext.getText();
            if(simpleFraction != null ) {
                value = simpleFraction;
                return;
            }
        }

        ChemicalIngredientsGrammarParser.ComplexFranctionContext complexFranctionContext = ctx.complexFranction();
        if (complexFranctionContext != null) {
            String complexFraction = complexFranctionContext.getText();
            if(complexFraction != null ) {
                value = complexFraction;
                return;
            }
        }
    }

    @Override
    public void enterUnit(@NotNull ChemicalIngredientsGrammarParser.UnitContext ctx) {
        unitOfMeasure = null;
        String foundText = ctx.getText();
        unitOfMeasure = foundText;
    }

    @Override
    public void enterRangeValue(@NotNull ChemicalIngredientsGrammarParser.RangeValueContext ctx) {
        ChemicalIngredientsGrammarParser.LowerBoundValueContext lowerBoundValueContext = ctx.lowerBoundValue();
        ChemicalIngredientsGrammarParser.UpperBoundValueContext upperBoundValueContext = ctx.upperBoundValue();
        this.rangeValue = new String[2];
        this.rangeValue[0] = upperBoundValueContext.getText();
        this.rangeValue[1] = lowerBoundValueContext.getText();
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public String getValue() {
        return value;
    }

    public String[] getRangeValue() {
        return rangeValue;
    }

}
