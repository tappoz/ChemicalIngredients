package org.tappoz.service;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.stereotype.Service;
import org.tappoz.bean.BasicAmount;
import org.tappoz.listener.CustomIngredientListener;
import org.tappoz.parser.ChemicalIngredientsGrammarLexer;
import org.tappoz.parser.ChemicalIngredientsGrammarParser;

import java.util.Arrays;

/**
 * Created by tappoz on 11/07/14.
 */
@Service
public class ChemicalStringProcessorService {

    public BasicAmount parseThisIngredient(String ingredientToBeParsed) {


        System.out.println("Just cleaned the list of amounts.");

        ChemicalIngredientsGrammarLexer lexer = new ChemicalIngredientsGrammarLexer(new ANTLRInputStream(ingredientToBeParsed));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ChemicalIngredientsGrammarParser parser = new ChemicalIngredientsGrammarParser(tokens);

        ParseTreeWalker walker = new ParseTreeWalker();
        CustomIngredientListener listener = new CustomIngredientListener();

        ChemicalIngredientsGrammarParser.MeasureContext measureContext = parser.measure();
        walker.walk(listener, measureContext);

        String value = listener.getValue();
        String unit = listener.getUnitOfMeasure();
        String[] rangeValue = listener.getRangeValue();

        System.out.println("+++++++++ value: '" + value + "'");
        System.out.println("+++++++++ unitOfMeasure: '" + unit + "'");
        System.out.println("+++++++++ rangeValue: '" + Arrays.toString(rangeValue) + "'");

        BasicAmount basicAmount = new BasicAmount();
        // the following if/else is due to some limits of the current context-free grammar
        // kept as it is to not become too much complex
        if (rangeValue == null) {
            basicAmount.setValue(value);
        } else {
            basicAmount.setRangeValue(rangeValue);
        }
        basicAmount.setUnitOfMeasure(unit);

        return basicAmount;
    }
}
