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
		NUMBER_AS_WORD=5, LINK_IN_RANGE=6, UNITS=7, WHITESPACE=8, PUNCTUATION=9;
	public static final String[] tokenNames = {
		"<INVALID>", "DIGI", "SIMPLE_FRACTION", "NUMBER_WITH_DECIMALS", "COMPLEX_FRACTION", 
		"NUMBER_AS_WORD", "LINK_IN_RANGE", "UNITS", "WHITESPACE", "PUNCTUATION"
	};
	public static final int
		RULE_measure = 0, RULE_unit = 1, RULE_digi = 2, RULE_numberAsWord = 3, 
		RULE_number = 4, RULE_numberWithDecimals = 5, RULE_simpleFraction = 6, 
		RULE_complexFranction = 7, RULE_value = 8, RULE_lowerBoundValue = 9, RULE_upperBoundValue = 10, 
		RULE_rangeValue = 11;
	public static final String[] ruleNames = {
		"measure", "unit", "digi", "numberAsWord", "number", "numberWithDecimals", 
		"simpleFraction", "complexFranction", "value", "lowerBoundValue", "upperBoundValue", 
		"rangeValue"
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
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(24); value();
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

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(28); rangeValue();
				setState(30);
				_la = _input.LA(1);
				if (_la==UNITS) {
					{
					setState(29); unit();
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
			setState(34); match(UNITS);
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

	public static class DigiContext extends ParserRuleContext {
		public TerminalNode DIGI() { return getToken(ChemicalIngredientsGrammarParser.DIGI, 0); }
		public DigiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterDigi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitDigi(this);
		}
	}

	public final DigiContext digi() throws RecognitionException {
		DigiContext _localctx = new DigiContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_digi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(DIGI);
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

	public static class NumberAsWordContext extends ParserRuleContext {
		public TerminalNode NUMBER_AS_WORD() { return getToken(ChemicalIngredientsGrammarParser.NUMBER_AS_WORD, 0); }
		public NumberAsWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberAsWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).enterNumberAsWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChemicalIngredientsGrammarListener ) ((ChemicalIngredientsGrammarListener)listener).exitNumberAsWord(this);
		}
	}

	public final NumberAsWordContext numberAsWord() throws RecognitionException {
		NumberAsWordContext _localctx = new NumberAsWordContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numberAsWord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); match(NUMBER_AS_WORD);
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
		public DigiContext digi() {
			return getRuleContext(DigiContext.class,0);
		}
		public NumberAsWordContext numberAsWord() {
			return getRuleContext(NumberAsWordContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_number);
		try {
			setState(42);
			switch (_input.LA(1)) {
			case DIGI:
				enterOuterAlt(_localctx, 1);
				{
				setState(40); digi();
				}
				break;
			case NUMBER_AS_WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); numberAsWord();
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
		enterRule(_localctx, 10, RULE_numberWithDecimals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(NUMBER_WITH_DECIMALS);
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
		enterRule(_localctx, 12, RULE_simpleFraction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(SIMPLE_FRACTION);
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
		enterRule(_localctx, 14, RULE_complexFranction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(COMPLEX_FRACTION);
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
		enterRule(_localctx, 16, RULE_value);
		try {
			setState(54);
			switch (_input.LA(1)) {
			case DIGI:
			case NUMBER_AS_WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(50); number();
				}
				break;
			case NUMBER_WITH_DECIMALS:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); numberWithDecimals();
				}
				break;
			case SIMPLE_FRACTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(52); simpleFraction();
				}
				break;
			case COMPLEX_FRACTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(53); complexFranction();
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
		enterRule(_localctx, 18, RULE_lowerBoundValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); value();
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
		enterRule(_localctx, 20, RULE_upperBoundValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); value();
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
		enterRule(_localctx, 22, RULE_rangeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); lowerBoundValue();
			setState(61); match(LINK_IN_RANGE);
			setState(62); upperBoundValue();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\5\2\35\n\2\3\2\3\2\5\2!\n\2\5\2#\n\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\5\6-\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\5\n9\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\2\2=\2\"\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b(\3\2\2\2\n,\3"+
		"\2\2\2\f.\3\2\2\2\16\60\3\2\2\2\20\62\3\2\2\2\228\3\2\2\2\24:\3\2\2\2"+
		"\26<\3\2\2\2\30>\3\2\2\2\32\34\5\22\n\2\33\35\5\4\3\2\34\33\3\2\2\2\34"+
		"\35\3\2\2\2\35#\3\2\2\2\36 \5\30\r\2\37!\5\4\3\2 \37\3\2\2\2 !\3\2\2\2"+
		"!#\3\2\2\2\"\32\3\2\2\2\"\36\3\2\2\2#\3\3\2\2\2$%\7\t\2\2%\5\3\2\2\2&"+
		"\'\7\3\2\2\'\7\3\2\2\2()\7\7\2\2)\t\3\2\2\2*-\5\6\4\2+-\5\b\5\2,*\3\2"+
		"\2\2,+\3\2\2\2-\13\3\2\2\2./\7\5\2\2/\r\3\2\2\2\60\61\7\4\2\2\61\17\3"+
		"\2\2\2\62\63\7\6\2\2\63\21\3\2\2\2\649\5\n\6\2\659\5\f\7\2\669\5\16\b"+
		"\2\679\5\20\t\28\64\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29\23\3"+
		"\2\2\2:;\5\22\n\2;\25\3\2\2\2<=\5\22\n\2=\27\3\2\2\2>?\5\24\13\2?@\7\b"+
		"\2\2@A\5\26\f\2A\31\3\2\2\2\7\34 \",8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}