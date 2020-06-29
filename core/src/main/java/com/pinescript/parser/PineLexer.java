// Generated from PineLexer.g4 by ANTLR 4.8

    package com.pinescript.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PineLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ON=1, SUFFIX_DP=2, SUFFIX_PX=3, ID=4, DOT=5, LPAREN=6, RPAREN=7, COMMA=8, 
		NULL=9, TRUE=10, FALSE=11, EQ=12, LBRACKET=13, RBRACKET=14, AND_AND=15, 
		OR_OR=16, QUESTION=17, SEMICOLON=18, COLON=19, LBRACE=20, RBRACE=21, RETURN=22, 
		IMPORT=23, PLUS=24, MINUS=25, MULTI=26, DIV=27, REMAINDER=28, AND=29, 
		OR=30, Identifier=31, ObjectType=32, DOUBLE_QUOTE_OPEN=33, DOUBLE_QUOTE_CLOSE=34, 
		STRING=35, IntegerLiteral=36, FloatLiteral=37, WS=38, COMMENT=39, LINE_COMMENT=40, 
		LineTerminator=41;
	public static final int
		LineString=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "LineString"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ON", "SUFFIX_DP", "SUFFIX_PX", "ID", "DOT", "LPAREN", "RPAREN", "COMMA", 
			"NULL", "TRUE", "FALSE", "EQ", "LBRACKET", "RBRACKET", "AND_AND", "OR_OR", 
			"QUESTION", "SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", "IMPORT", 
			"PLUS", "MINUS", "MULTI", "DIV", "REMAINDER", "AND", "OR", "Identifier", 
			"ObjectType", "DOUBLE_QUOTE_OPEN", "DOUBLE_QUOTE_CLOSE", "STRING", "ESC", 
			"SAFECODEPOINT", "UNICODE", "HEX", "IntegerLiteral", "FloatLiteral", 
			"DecimalIntegerLiteral", "ExponentPart", "WS", "COMMENT", "LINE_COMMENT", 
			"LineTerminator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'on'", "'dp'", "'px'", "'id'", "'.'", "'('", "')'", "','", "'null'", 
			"'true'", "'false'", "'='", "'['", "']'", "'&&'", "'||'", "'?'", "';'", 
			"':'", "'{'", "'}'", "'return'", "'import'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ON", "SUFFIX_DP", "SUFFIX_PX", "ID", "DOT", "LPAREN", "RPAREN", 
			"COMMA", "NULL", "TRUE", "FALSE", "EQ", "LBRACKET", "RBRACKET", "AND_AND", 
			"OR_OR", "QUESTION", "SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", 
			"IMPORT", "PLUS", "MINUS", "MULTI", "DIV", "REMAINDER", "AND", "OR", 
			"Identifier", "ObjectType", "DOUBLE_QUOTE_OPEN", "DOUBLE_QUOTE_CLOSE", 
			"STRING", "IntegerLiteral", "FloatLiteral", "WS", "COMMENT", "LINE_COMMENT", 
			"LineTerminator"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PineLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PineLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u012e\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3 \3 \7 \u00be\n \f \16 \u00c1\13 \3!\3!"+
		"\7!\u00c5\n!\f!\16!\u00c8\13!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\7$\u00d4"+
		"\n$\f$\16$\u00d7\13$\3%\3%\3%\5%\u00dc\n%\3&\3&\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3*\7*\u00ed\n*\f*\16*\u00f0\13*\3*\5*\u00f3\n*\3"+
		"*\3*\6*\u00f7\n*\r*\16*\u00f8\3*\5*\u00fc\n*\5*\u00fe\n*\3+\6+\u0101\n"+
		"+\r+\16+\u0102\3,\3,\5,\u0107\n,\3,\6,\u010a\n,\r,\16,\u010b\3-\3-\3-"+
		"\3-\3.\3.\3.\3.\7.\u0116\n.\f.\16.\u0119\13.\3.\3.\3.\3.\3.\3/\3/\3/\3"+
		"/\7/\u0124\n/\f/\16/\u0127\13/\3/\3/\3\60\3\60\3\60\3\60\3\u0117\2\61"+
		"\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20"+
		" \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37"+
		"> @!B\"D#F$H%J\2L\2N\2P\2R&T\'V\2X\2Z(\\)^*`+\4\2\3\17\3\2c|\6\2\62;C"+
		"\\aac|\3\2C\\\5\2C\\aac|\n\2$$\61\61^^ddhhppttvv\5\2\2!$$^^\5\2\62;CH"+
		"ch\3\2\62;\4\2GGgg\4\2--//\6\2\13\f\17\17\"\"==\4\2\f\f\17\17\5\2\f\f"+
		"\17\17\u202a\u202b\2\u0135\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2"+
		"\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2"+
		"\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2"+
		"\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2"+
		"\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3"+
		"\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2"+
		"\2\2R\3\2\2\2\2T\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2"+
		"\3F\3\2\2\2\3H\3\2\2\2\4b\3\2\2\2\6e\3\2\2\2\bh\3\2\2\2\nk\3\2\2\2\fn"+
		"\3\2\2\2\16p\3\2\2\2\20r\3\2\2\2\22t\3\2\2\2\24v\3\2\2\2\26{\3\2\2\2\30"+
		"\u0080\3\2\2\2\32\u0086\3\2\2\2\34\u0088\3\2\2\2\36\u008a\3\2\2\2 \u008c"+
		"\3\2\2\2\"\u008f\3\2\2\2$\u0092\3\2\2\2&\u0094\3\2\2\2(\u0096\3\2\2\2"+
		"*\u0098\3\2\2\2,\u009a\3\2\2\2.\u009c\3\2\2\2\60\u00a3\3\2\2\2\62\u00aa"+
		"\3\2\2\2\64\u00ac\3\2\2\2\66\u00ae\3\2\2\28\u00b0\3\2\2\2:\u00b2\3\2\2"+
		"\2<\u00b4\3\2\2\2>\u00b8\3\2\2\2@\u00bb\3\2\2\2B\u00c2\3\2\2\2D\u00c9"+
		"\3\2\2\2F\u00cd\3\2\2\2H\u00d5\3\2\2\2J\u00d8\3\2\2\2L\u00dd\3\2\2\2N"+
		"\u00df\3\2\2\2P\u00e5\3\2\2\2R\u00e7\3\2\2\2T\u00fd\3\2\2\2V\u0100\3\2"+
		"\2\2X\u0104\3\2\2\2Z\u010d\3\2\2\2\\\u0111\3\2\2\2^\u011f\3\2\2\2`\u012a"+
		"\3\2\2\2bc\7q\2\2cd\7p\2\2d\5\3\2\2\2ef\7f\2\2fg\7r\2\2g\7\3\2\2\2hi\7"+
		"r\2\2ij\7z\2\2j\t\3\2\2\2kl\7k\2\2lm\7f\2\2m\13\3\2\2\2no\7\60\2\2o\r"+
		"\3\2\2\2pq\7*\2\2q\17\3\2\2\2rs\7+\2\2s\21\3\2\2\2tu\7.\2\2u\23\3\2\2"+
		"\2vw\7p\2\2wx\7w\2\2xy\7n\2\2yz\7n\2\2z\25\3\2\2\2{|\7v\2\2|}\7t\2\2}"+
		"~\7w\2\2~\177\7g\2\2\177\27\3\2\2\2\u0080\u0081\7h\2\2\u0081\u0082\7c"+
		"\2\2\u0082\u0083\7n\2\2\u0083\u0084\7u\2\2\u0084\u0085\7g\2\2\u0085\31"+
		"\3\2\2\2\u0086\u0087\7?\2\2\u0087\33\3\2\2\2\u0088\u0089\7]\2\2\u0089"+
		"\35\3\2\2\2\u008a\u008b\7_\2\2\u008b\37\3\2\2\2\u008c\u008d\7(\2\2\u008d"+
		"\u008e\7(\2\2\u008e!\3\2\2\2\u008f\u0090\7~\2\2\u0090\u0091\7~\2\2\u0091"+
		"#\3\2\2\2\u0092\u0093\7A\2\2\u0093%\3\2\2\2\u0094\u0095\7=\2\2\u0095\'"+
		"\3\2\2\2\u0096\u0097\7<\2\2\u0097)\3\2\2\2\u0098\u0099\7}\2\2\u0099+\3"+
		"\2\2\2\u009a\u009b\7\177\2\2\u009b-\3\2\2\2\u009c\u009d\7t\2\2\u009d\u009e"+
		"\7g\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7t\2\2\u00a1"+
		"\u00a2\7p\2\2\u00a2/\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7o\2\2\u00a5"+
		"\u00a6\7r\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7v\2\2"+
		"\u00a9\61\3\2\2\2\u00aa\u00ab\7-\2\2\u00ab\63\3\2\2\2\u00ac\u00ad\7/\2"+
		"\2\u00ad\65\3\2\2\2\u00ae\u00af\7,\2\2\u00af\67\3\2\2\2\u00b0\u00b1\7"+
		"\61\2\2\u00b19\3\2\2\2\u00b2\u00b3\7\'\2\2\u00b3;\3\2\2\2\u00b4\u00b5"+
		"\7c\2\2\u00b5\u00b6\7p\2\2\u00b6\u00b7\7f\2\2\u00b7=\3\2\2\2\u00b8\u00b9"+
		"\7q\2\2\u00b9\u00ba\7t\2\2\u00ba?\3\2\2\2\u00bb\u00bf\t\2\2\2\u00bc\u00be"+
		"\t\3\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0A\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c6\t\4\2\2"+
		"\u00c3\u00c5\t\5\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7C\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00ca\7$\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\"\2\2\u00ccE\3\2\2\2\u00cd"+
		"\u00ce\7$\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\b#\3\2\u00d0G\3\2\2\2\u00d1"+
		"\u00d4\5J%\2\u00d2\u00d4\5L&\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2"+
		"\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6I\3"+
		"\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\7^\2\2\u00d9\u00dc\t\6\2\2\u00da"+
		"\u00dc\5N\'\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dcK\3\2\2\2\u00dd"+
		"\u00de\n\7\2\2\u00deM\3\2\2\2\u00df\u00e0\7w\2\2\u00e0\u00e1\5P(\2\u00e1"+
		"\u00e2\5P(\2\u00e2\u00e3\5P(\2\u00e3\u00e4\5P(\2\u00e4O\3\2\2\2\u00e5"+
		"\u00e6\t\b\2\2\u00e6Q\3\2\2\2\u00e7\u00e8\5V+\2\u00e8S\3\2\2\2\u00e9\u00ea"+
		"\5V+\2\u00ea\u00ee\7\60\2\2\u00eb\u00ed\t\t\2\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f2\3\2"+
		"\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f3\5X,\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3\u00fe\3\2\2\2\u00f4\u00f6\7\60\2\2\u00f5\u00f7\t\t\2\2"+
		"\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00fc\5X,\2\u00fb\u00fa\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00e9\3\2\2\2\u00fd\u00f4\3\2"+
		"\2\2\u00feU\3\2\2\2\u00ff\u0101\t\t\2\2\u0100\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103W\3\2\2\2\u0104"+
		"\u0106\t\n\2\2\u0105\u0107\t\13\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3"+
		"\2\2\2\u0107\u0109\3\2\2\2\u0108\u010a\t\t\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010cY\3\2\2\2"+
		"\u010d\u010e\t\f\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b-\4\2\u0110[\3\2"+
		"\2\2\u0111\u0112\7\61\2\2\u0112\u0113\7,\2\2\u0113\u0117\3\2\2\2\u0114"+
		"\u0116\13\2\2\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0118\3"+
		"\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a"+
		"\u011b\7,\2\2\u011b\u011c\7\61\2\2\u011c\u011d\3\2\2\2\u011d\u011e\b."+
		"\4\2\u011e]\3\2\2\2\u011f\u0120\7\61\2\2\u0120\u0121\7\61\2\2\u0121\u0125"+
		"\3\2\2\2\u0122\u0124\n\r\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0128\u0129\b/\4\2\u0129_\3\2\2\2\u012a\u012b\t\16\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\u012d\b\60\5\2\u012da\3\2\2\2\23\2\3\u00bf\u00c6\u00d3"+
		"\u00d5\u00db\u00ee\u00f2\u00f8\u00fb\u00fd\u0102\u0106\u010b\u0117\u0125"+
		"\6\7\3\2\6\2\2\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}