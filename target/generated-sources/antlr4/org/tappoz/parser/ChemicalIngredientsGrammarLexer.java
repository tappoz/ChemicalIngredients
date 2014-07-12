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
		NUMBER_AS_WORD=5, LINK_IN_RANGE=6, UNITS=7, WHITESPACE=8, PUNCTUATION=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'"
	};
	public static final String[] ruleNames = {
		"DIGI", "SIMPLE_FRACTION", "NUMBER_WITH_DECIMALS", "COMPLEX_FRACTION", 
		"NUMBER_AS_WORD", "LINK_IN_RANGE", "UNITS", "WHITESPACE", "PUNCTUATION"
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
		case 7: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  if(ignore) skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13\u00c4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3"+
		"\2\6\2\27\n\2\r\2\16\2\30\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\"\n\4\3\5\3"+
		"\5\3\5\5\5\'\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\7\3\7\3\7\3\7\5\7V\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ba\n\b\3\t\6\t\u00bd\n\t"+
		"\r\t\16\t\u00be\3\t\3\t\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\3\2\5\3\2\62;\5\2\13\f\17\17\"\"\7\2##..\60\60<=AA\u00e4\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\26\3\2\2\2\5\32\3\2\2\2\7\36"+
		"\3\2\2\2\t#\3\2\2\2\13O\3\2\2\2\rU\3\2\2\2\17\u00b9\3\2\2\2\21\u00bc\3"+
		"\2\2\2\23\u00c2\3\2\2\2\25\27\t\2\2\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26"+
		"\3\2\2\2\30\31\3\2\2\2\31\4\3\2\2\2\32\33\5\3\2\2\33\34\7\61\2\2\34\35"+
		"\5\3\2\2\35\6\3\2\2\2\36!\5\3\2\2\37 \7\60\2\2 \"\5\3\2\2!\37\3\2\2\2"+
		"!\"\3\2\2\2\"\b\3\2\2\2#&\5\3\2\2$%\7\"\2\2%\'\5\5\3\2&$\3\2\2\2&\'\3"+
		"\2\2\2\'\n\3\2\2\2()\7q\2\2)*\7p\2\2*P\7g\2\2+,\7v\2\2,-\7y\2\2-P\7q\2"+
		"\2./\7v\2\2/\60\7j\2\2\60\61\7t\2\2\61\62\7g\2\2\62P\7g\2\2\63\64\7h\2"+
		"\2\64\65\7q\2\2\65\66\7w\2\2\66P\7t\2\2\678\7h\2\289\7k\2\29:\7x\2\2:"+
		"P\7g\2\2;<\7u\2\2<=\7k\2\2=P\7z\2\2>?\7u\2\2?@\7g\2\2@A\7x\2\2AB\7g\2"+
		"\2BP\7p\2\2CD\7g\2\2DE\7k\2\2EF\7i\2\2FG\7j\2\2GP\7v\2\2HI\7p\2\2IJ\7"+
		"k\2\2JK\7p\2\2KP\7g\2\2LM\7v\2\2MN\7g\2\2NP\7p\2\2O(\3\2\2\2O+\3\2\2\2"+
		"O.\3\2\2\2O\63\3\2\2\2O\67\3\2\2\2O;\3\2\2\2O>\3\2\2\2OC\3\2\2\2OH\3\2"+
		"\2\2OL\3\2\2\2P\f\3\2\2\2QR\7v\2\2RV\7q\2\2ST\7q\2\2TV\7t\2\2UQ\3\2\2"+
		"\2US\3\2\2\2V\16\3\2\2\2WX\7o\2\2X\u00ba\7n\2\2YZ\7i\2\2Z[\7t\2\2[\\\7"+
		"c\2\2\\]\7o\2\2]\u00ba\7u\2\2^\u00ba\7i\2\2_`\7i\2\2`a\7t\2\2ab\7c\2\2"+
		"b\u00ba\7o\2\2cd\7e\2\2de\7w\2\2e\u00ba\7r\2\2f\u00ba\7n\2\2gh\7n\2\2"+
		"hi\7k\2\2ij\7v\2\2jk\7t\2\2kl\7g\2\2l\u00ba\7u\2\2mn\7n\2\2no\7k\2\2o"+
		"p\7v\2\2pq\7g\2\2qr\7t\2\2r\u00ba\7u\2\2st\7v\2\2tu\7g\2\2uv\7c\2\2vw"+
		"\7u\2\2wx\7r\2\2xy\7q\2\2yz\7q\2\2z\u00ba\7p\2\2{|\7v\2\2|}\7g\2\2}~\7"+
		"c\2\2~\177\7u\2\2\177\u0080\7r\2\2\u0080\u0081\7q\2\2\u0081\u0082\7q\2"+
		"\2\u0082\u0083\7p\2\2\u0083\u00ba\7u\2\2\u0084\u0085\7v\2\2\u0085\u0086"+
		"\7c\2\2\u0086\u0087\7d\2\2\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2\u0089"+
		"\u008a\7u\2\2\u008a\u008b\7r\2\2\u008b\u008c\7q\2\2\u008c\u008d\7q\2\2"+
		"\u008d\u00ba\7p\2\2\u008e\u008f\7e\2\2\u008f\u0090\7c\2\2\u0090\u0091"+
		"\7p\2\2\u0091\u00ba\7u\2\2\u0092\u0093\7q\2\2\u0093\u0094\7w\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0096\7e\2\2\u0096\u0097\7g\2\2\u0097\u00ba\7u\2\2"+
		"\u0098\u0099\7q\2\2\u0099\u009a\7w\2\2\u009a\u009b\7p\2\2\u009b\u009c"+
		"\7e\2\2\u009c\u00ba\7g\2\2\u009d\u009e\7v\2\2\u009e\u009f\7c\2\2\u009f"+
		"\u00a0\7d\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7u\2\2"+
		"\u00a3\u00a4\7r\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7"+
		"\7p\2\2\u00a7\u00ba\7u\2\2\u00a8\u00a9\7n\2\2\u00a9\u00ba\7d\2\2\u00aa"+
		"\u00ab\7r\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7v\2\2"+
		"\u00ae\u00ba\7u\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7d\2\2\u00b1\u00ba"+
		"\7u\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7w\2\2\u00b4\u00ba\7r\2\2\u00b5"+
		"\u00b6\7e\2\2\u00b6\u00b7\7w\2\2\u00b7\u00b8\7r\2\2\u00b8\u00ba\7u\2\2"+
		"\u00b9W\3\2\2\2\u00b9Y\3\2\2\2\u00b9^\3\2\2\2\u00b9_\3\2\2\2\u00b9c\3"+
		"\2\2\2\u00b9f\3\2\2\2\u00b9g\3\2\2\2\u00b9m\3\2\2\2\u00b9s\3\2\2\2\u00b9"+
		"{\3\2\2\2\u00b9\u0084\3\2\2\2\u00b9\u008e\3\2\2\2\u00b9\u0092\3\2\2\2"+
		"\u00b9\u0098\3\2\2\2\u00b9\u009d\3\2\2\2\u00b9\u00a8\3\2\2\2\u00b9\u00aa"+
		"\3\2\2\2\u00b9\u00af\3\2\2\2\u00b9\u00b2\3\2\2\2\u00b9\u00b5\3\2\2\2\u00ba"+
		"\20\3\2\2\2\u00bb\u00bd\t\3\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2"+
		"\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1"+
		"\b\t\2\2\u00c1\22\3\2\2\2\u00c2\u00c3\t\4\2\2\u00c3\24\3\2\2\2\n\2\30"+
		"!&OU\u00b9\u00be\3\3\t\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}