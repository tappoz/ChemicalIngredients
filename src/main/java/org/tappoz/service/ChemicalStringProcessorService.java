package org.tappoz.service;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tappoz.bean.BasicAmount;
import org.tappoz.listener.CustomIngredientListener;
import org.tappoz.parser.ChemicalIngredientsGrammarLexer;
import org.tappoz.parser.ChemicalIngredientsGrammarParser;

@Service
public class ChemicalStringProcessorService {

    private final static Logger log = LoggerFactory.getLogger(ChemicalStringProcessorService.class);

    /**
     * This method prepares the Java code created by ANTLR for the context free grammar,
     * then runs the input string against the grammar code,
     * then retrieves the parsed values,
     * then returns a bean containing those values.
     *
     * @see {@link org.tappoz.listener.CustomIngredientListener}
     *
     * @param ingredientToBeParsed an input string
     * @return {@link org.tappoz.bean.BasicAmount}
     */
    public BasicAmount parseThisIngredient(String ingredientToBeParsed) {

        ChemicalIngredientsGrammarLexer lexer = new ChemicalIngredientsGrammarLexer(new ANTLRInputStream(ingredientToBeParsed));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ChemicalIngredientsGrammarParser parser = new ChemicalIngredientsGrammarParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        CustomIngredientListener listener = new CustomIngredientListener();
        log.info("Just set all the parsing environment.");

        // the following statements are to suppress error messages in the log
        // because the grammar is currently complaining about the
        // string suffixes representing the ingredient names
        // which are not defined in any lexer/parser rule in the grammar itself
        // (in fact they are treated outside of the grammar using some regex)
        lexer.removeErrorListeners();
        parser.removeErrorListeners();

        ChemicalIngredientsGrammarParser.MeasureContext measureContext = parser.measure();
        walker.walk(listener, measureContext);
        log.info("Just walked on the input string according to the grammar rules.");

        String value = listener.getValue();
        String unit = listener.getUnitOfMeasure();
        String[] rangeValue = listener.getRangeValue();
        log.debug("Just got the parameters from the grammar rules listener.");

        BasicAmount basicAmount = new BasicAmount();
        // the following if/else is due to some limits of the current context-free grammar
        // kept as it is to not become too much complex
        if (rangeValue == null) {
            basicAmount.setValue(value);
        } else {
            basicAmount.setRangeValue(rangeValue);
        }
        basicAmount.setUnitOfMeasure(unit);

        log.info("About to return a validated amount.");
        return basicAmount;
    }
}
