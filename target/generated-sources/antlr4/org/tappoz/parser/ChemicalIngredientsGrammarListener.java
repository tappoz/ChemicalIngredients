// Generated from org/tappoz/parser/ChemicalIngredientsGrammar.g4 by ANTLR 4.3
package org.tappoz.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ChemicalIngredientsGrammarParser}.
 */
public interface ChemicalIngredientsGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#simpleFraction}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFraction(@NotNull ChemicalIngredientsGrammarParser.SimpleFractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#simpleFraction}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFraction(@NotNull ChemicalIngredientsGrammarParser.SimpleFractionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#complexFranction}.
	 * @param ctx the parse tree
	 */
	void enterComplexFranction(@NotNull ChemicalIngredientsGrammarParser.ComplexFranctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#complexFranction}.
	 * @param ctx the parse tree
	 */
	void exitComplexFranction(@NotNull ChemicalIngredientsGrammarParser.ComplexFranctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull ChemicalIngredientsGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull ChemicalIngredientsGrammarParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(@NotNull ChemicalIngredientsGrammarParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(@NotNull ChemicalIngredientsGrammarParser.UnitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#measure}.
	 * @param ctx the parse tree
	 */
	void enterMeasure(@NotNull ChemicalIngredientsGrammarParser.MeasureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#measure}.
	 * @param ctx the parse tree
	 */
	void exitMeasure(@NotNull ChemicalIngredientsGrammarParser.MeasureContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#numberWithDecimals}.
	 * @param ctx the parse tree
	 */
	void enterNumberWithDecimals(@NotNull ChemicalIngredientsGrammarParser.NumberWithDecimalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#numberWithDecimals}.
	 * @param ctx the parse tree
	 */
	void exitNumberWithDecimals(@NotNull ChemicalIngredientsGrammarParser.NumberWithDecimalsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#lowerBoundValue}.
	 * @param ctx the parse tree
	 */
	void enterLowerBoundValue(@NotNull ChemicalIngredientsGrammarParser.LowerBoundValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#lowerBoundValue}.
	 * @param ctx the parse tree
	 */
	void exitLowerBoundValue(@NotNull ChemicalIngredientsGrammarParser.LowerBoundValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#upperBoundValue}.
	 * @param ctx the parse tree
	 */
	void enterUpperBoundValue(@NotNull ChemicalIngredientsGrammarParser.UpperBoundValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#upperBoundValue}.
	 * @param ctx the parse tree
	 */
	void exitUpperBoundValue(@NotNull ChemicalIngredientsGrammarParser.UpperBoundValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#rangeValue}.
	 * @param ctx the parse tree
	 */
	void enterRangeValue(@NotNull ChemicalIngredientsGrammarParser.RangeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#rangeValue}.
	 * @param ctx the parse tree
	 */
	void exitRangeValue(@NotNull ChemicalIngredientsGrammarParser.RangeValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ChemicalIngredientsGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ChemicalIngredientsGrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChemicalIngredientsGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ChemicalIngredientsGrammarParser.ValueContext ctx);
}