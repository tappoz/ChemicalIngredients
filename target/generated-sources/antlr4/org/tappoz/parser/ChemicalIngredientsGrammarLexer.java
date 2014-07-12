// Generated from org/tappoz/parser/ChemicalIngredientsGrammar.g4 by ANTLR 4.3
package org.tappoz.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ChemicalIngredientsGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGI=1, SIMPLE_FRACTION=2, NUMBER_WITH_DECIMALS=3, COMPLEX_FRACTION=4, 
		LINK_IN_RANGE=5, UNITS=6, WHITESPACE=7, PUNCTUATION=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'"
	};
	public static final String[] ruleNames = {
		"DIGI", "SIMPLE_FRACTION", "NUMBER_WITH_DECIMALS", "COMPLEX_FRACTION", 
		"LINK_IN_RANGE", "UNITS", "WHITESPACE", "PUNCTUATION"
	};


	    boolean ignore=true;


	public ChemicalIngredientsGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ChemicalIngredientsGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 6: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  if(ignore) skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u0094\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\25"+
		"\n\2\r\2\16\2\26\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4 \n\4\3\5\3\5\3\5\5\5"+
		"%\n\5\3\6\3\6\3\6\3\6\5\6+\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008a\n\7\3\b"+
		"\6\b\u008d\n\b\r\b\16\b\u008e\3\b\3\b\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\3\2\5\3\2\62;\5\2\13\f\17\17\"\"\7\2##..\60\60<=AA\u00a9"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\24\3\2\2\2\5\30\3\2\2\2\7\34\3\2\2\2"+
		"\t!\3\2\2\2\13*\3\2\2\2\r\u0089\3\2\2\2\17\u008c\3\2\2\2\21\u0092\3\2"+
		"\2\2\23\25\t\2\2\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3\2"+
		"\2\2\27\4\3\2\2\2\30\31\5\3\2\2\31\32\7\61\2\2\32\33\5\3\2\2\33\6\3\2"+
		"\2\2\34\37\5\3\2\2\35\36\7\60\2\2\36 \5\3\2\2\37\35\3\2\2\2\37 \3\2\2"+
		"\2 \b\3\2\2\2!$\5\3\2\2\"#\7\"\2\2#%\5\5\3\2$\"\3\2\2\2$%\3\2\2\2%\n\3"+
		"\2\2\2&\'\7v\2\2\'+\7q\2\2()\7q\2\2)+\7t\2\2*&\3\2\2\2*(\3\2\2\2+\f\3"+
		"\2\2\2,-\7o\2\2-\u008a\7n\2\2./\7i\2\2/\60\7t\2\2\60\61\7c\2\2\61\62\7"+
		"o\2\2\62\u008a\7u\2\2\63\64\7e\2\2\64\65\7w\2\2\65\u008a\7r\2\2\66\u008a"+
		"\7n\2\2\678\7n\2\289\7k\2\29:\7v\2\2:;\7t\2\2;<\7g\2\2<\u008a\7u\2\2="+
		">\7n\2\2>?\7k\2\2?@\7v\2\2@A\7g\2\2AB\7t\2\2B\u008a\7u\2\2CD\7v\2\2DE"+
		"\7g\2\2EF\7c\2\2FG\7u\2\2GH\7r\2\2HI\7q\2\2IJ\7q\2\2J\u008a\7p\2\2KL\7"+
		"v\2\2LM\7g\2\2MN\7c\2\2NO\7u\2\2OP\7r\2\2PQ\7q\2\2QR\7q\2\2RS\7p\2\2S"+
		"\u008a\7u\2\2TU\7v\2\2UV\7c\2\2VW\7d\2\2WX\7n\2\2XY\7g\2\2YZ\7u\2\2Z["+
		"\7r\2\2[\\\7q\2\2\\]\7q\2\2]\u008a\7p\2\2^_\7e\2\2_`\7c\2\2`a\7p\2\2a"+
		"\u008a\7u\2\2bc\7q\2\2cd\7w\2\2de\7p\2\2ef\7e\2\2fg\7g\2\2g\u008a\7u\2"+
		"\2hi\7q\2\2ij\7w\2\2jk\7p\2\2kl\7e\2\2l\u008a\7g\2\2mn\7v\2\2no\7c\2\2"+
		"op\7d\2\2pq\7n\2\2qr\7g\2\2rs\7u\2\2st\7r\2\2tu\7q\2\2uv\7q\2\2vw\7p\2"+
		"\2w\u008a\7u\2\2xy\7n\2\2y\u008a\7d\2\2z{\7r\2\2{|\7c\2\2|}\7t\2\2}~\7"+
		"v\2\2~\u008a\7u\2\2\177\u0080\7n\2\2\u0080\u0081\7d\2\2\u0081\u008a\7"+
		"u\2\2\u0082\u0083\7e\2\2\u0083\u0084\7w\2\2\u0084\u008a\7r\2\2\u0085\u0086"+
		"\7e\2\2\u0086\u0087\7w\2\2\u0087\u0088\7r\2\2\u0088\u008a\7u\2\2\u0089"+
		",\3\2\2\2\u0089.\3\2\2\2\u0089\63\3\2\2\2\u0089\66\3\2\2\2\u0089\67\3"+
		"\2\2\2\u0089=\3\2\2\2\u0089C\3\2\2\2\u0089K\3\2\2\2\u0089T\3\2\2\2\u0089"+
		"^\3\2\2\2\u0089b\3\2\2\2\u0089h\3\2\2\2\u0089m\3\2\2\2\u0089x\3\2\2\2"+
		"\u0089z\3\2\2\2\u0089\177\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0085\3\2"+
		"\2\2\u008a\16\3\2\2\2\u008b\u008d\t\3\2\2\u008c\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\b\b\2\2\u0091\20\3\2\2\2\u0092\u0093\t\4\2\2\u0093\22\3\2\2\2\t"+
		"\2\26\37$*\u0089\u008e\3\3\b\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}