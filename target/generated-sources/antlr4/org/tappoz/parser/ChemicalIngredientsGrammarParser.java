// Generated from org/tappoz/parser/ChemicalIngredientsGrammar.g4 by ANTLR 4.3
package org.tappoz.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ChemicalIngredientsGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGI=1, SIMPLE_FRACTION=2, NUMBER_WITH_DECIMALS=3, COMPLEX_FRACTION=4, 
		LINK_IN_RANGE=5, UNITS=6, WHITESPACE=7, PUNCTUATION=8;
	public static final String[] tokenNames = {
		"<INVALID>", "DIGI", "SIMPLE_FRACTION", "NUMBER_WITH_DECIMALS", "COMPLEX_FRACTION", 
		"LINK_IN_RANGE", "UNITS", "WHITESPACE", "PUNCTUATION"
	};
	public static final int
		RULE_measure = 0, RULE_unit = 1, RULE_number = 2, RULE_numberWithDecimals = 3, 
		RULE_simpleFraction = 4, RULE_complexFranction = 5, RULE_value = 6, RULE_lowerBoundValue = 7, 
		RULE_upperBoundValue = 8, RULE_rangeValue = 9;
	public static final String[] ruleNames = {
		"measure", "unit", "number", "numberWithDecimals", "simpleFraction", "complexFranction", 
		"value", "lowerBoundValue", "upperBoundValue", "rangeValue"
	};

	@Override
	public String getGrammarFileName() { return "ChemicalIngredientsGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ChemicalIngredientsGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MeasureContext extends ParserRuleContext {
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public RangeValueContext rangeValue() {
			return getRuleContext(RangeValueContext.class,0);
		}
		public MeasureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_measure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterMeasure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitMeasure(this);
		}
	}

	public final MeasureContext measure() throws RecognitionException {
		MeasureContext _localctx = new MeasureContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_measure);
		int _la;
		try {
			setState(28);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(20); value();
				setState(22);
				_la = _input.LA(1);
				if (_la==UNITS) {
					{
					setState(21); unit();
					}
				}

				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(24); rangeValue();
				setState(26);
				_la = _input.LA(1);
				if (_la==UNITS) {
					{
					setState(25); unit();
					}
				}

				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitContext extends ParserRuleContext {
		public TerminalNode UNITS() { return getToken(ChemicalIngredientsGrammarParser.UNITS, 0); }
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitUnit(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_unit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(UNITS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode DIGI() { return getToken(ChemicalIngredientsGrammarParser.DIGI, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(32); match(DIGI);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberWithDecimalsContext extends ParserRuleContext {
		public TerminalNode NUMBER_WITH_DECIMALS() { return getToken(ChemicalIngredientsGrammarParser.NUMBER_WITH_DECIMALS, 0); }
		public NumberWithDecimalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberWithDecimals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterNumberWithDecimals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitNumberWithDecimals(this);
		}
	}

	public final NumberWithDecimalsContext numberWithDecimals() throws RecognitionException {
		NumberWithDecimalsContext _localctx = new NumberWithDecimalsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numberWithDecimals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); match(NUMBER_WITH_DECIMALS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleFractionContext extends ParserRuleContext {
		public TerminalNode SIMPLE_FRACTION() { return getToken(ChemicalIngredientsGrammarParser.SIMPLE_FRACTION, 0); }
		public SimpleFractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleFraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterSimpleFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitSimpleFraction(this);
		}
	}

	public final SimpleFractionContext simpleFraction() throws RecognitionException {
		SimpleFractionContext _localctx = new SimpleFractionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_simpleFraction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(SIMPLE_FRACTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexFranctionContext extends ParserRuleContext {
		public TerminalNode COMPLEX_FRACTION() { return getToken(ChemicalIngredientsGrammarParser.COMPLEX_FRACTION, 0); }
		public ComplexFranctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexFranction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterComplexFranction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitComplexFranction(this);
		}
	}

	public final ComplexFranctionContext complexFranction() throws RecognitionException {
		ComplexFranctionContext _localctx = new ComplexFranctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_complexFranction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); match(COMPLEX_FRACTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public SimpleFractionContext simpleFraction() {
			return getRuleContext(SimpleFractionContext.class,0);
		}
		public NumberWithDecimalsContext numberWithDecimals() {
			return getRuleContext(NumberWithDecimalsContext.class,0);
		}
		public ComplexFranctionContext complexFranction() {
			return getRuleContext(ComplexFranctionContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(44);
			switch (_input.LA(1)) {
			case DIGI:
				enterOuterAlt(_localctx, 1);
				{
				setState(40); number();
				}
				break;
			case NUMBER_WITH_DECIMALS:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); numberWithDecimals();
				}
				break;
			case SIMPLE_FRACTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(42); simpleFraction();
				}
				break;
			case COMPLEX_FRACTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(43); complexFranction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LowerBoundValueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LowerBoundValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerBoundValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterLowerBoundValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitLowerBoundValue(this);
		}
	}

	public final LowerBoundValueContext lowerBoundValue() throws RecognitionException {
		LowerBoundValueContext _localctx = new LowerBoundValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lowerBoundValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpperBoundValueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public UpperBoundValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upperBoundValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterUpperBoundValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitUpperBoundValue(this);
		}
	}

	public final UpperBoundValueContext upperBoundValue() throws RecognitionException {
		UpperBoundValueContext _localctx = new UpperBoundValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_upperBoundValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeValueContext extends ParserRuleContext {
		public LowerBoundValueContext lowerBoundValue() {
			return getRuleContext(LowerBoundValueContext.class,0);
		}
		public UpperBoundValueContext upperBoundValue() {
			return getRuleContext(UpperBoundValueContext.class,0);
		}
		public TerminalNode LINK_IN_RANGE() { return getToken(ChemicalIngredientsGrammarParser.LINK_IN_RANGE, 0); }
		public RangeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterRangeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitRangeValue(this);
		}
	}

	public final RangeValueContext rangeValue() throws RecognitionException {
		RangeValueContext _localctx = new RangeValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rangeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); lowerBoundValue();
			setState(51); match(LINK_IN_RANGE);
			setState(52); upperBoundValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n9\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\5\2\31\n\2\3\2\3\2\5\2\35\n\2\5\2\37\n\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\5\b/\n\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\64\2\36\3\2\2\2\4 \3"+
		"\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n&\3\2\2\2\f(\3\2\2\2\16.\3\2\2\2\20\60"+
		"\3\2\2\2\22\62\3\2\2\2\24\64\3\2\2\2\26\30\5\16\b\2\27\31\5\4\3\2\30\27"+
		"\3\2\2\2\30\31\3\2\2\2\31\37\3\2\2\2\32\34\5\24\13\2\33\35\5\4\3\2\34"+
		"\33\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\26\3\2\2\2\36\32\3\2\2\2\37"+
		"\3\3\2\2\2 !\7\b\2\2!\5\3\2\2\2\"#\7\3\2\2#\7\3\2\2\2$%\7\5\2\2%\t\3\2"+
		"\2\2&\'\7\4\2\2\'\13\3\2\2\2()\7\6\2\2)\r\3\2\2\2*/\5\6\4\2+/\5\b\5\2"+
		",/\5\n\6\2-/\5\f\7\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\17\3\2\2"+
		"\2\60\61\5\16\b\2\61\21\3\2\2\2\62\63\5\16\b\2\63\23\3\2\2\2\64\65\5\20"+
		"\t\2\65\66\7\7\2\2\66\67\5\22\n\2\67\25\3\2\2\2\6\30\34\36.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}