// Generated from PineScript.g4 by ANTLR 4.8

    package com.flex.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PineScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SUFFIX_DP=1, SUFFIX_PX=2, ID=3, DOT=4, LPAREN=5, RPAREN=6, COMMA=7, NULL=8, 
		TRUE=9, FALSE=10, EQ=11, LBRACKET=12, RBRACKET=13, AND_AND=14, OR_OR=15, 
		QUESTION=16, SEMICOLON=17, COLON=18, LBRACE=19, RBRACE=20, RETURN=21, 
		IMPORT=22, Identifier=23, ObjectDeclaration=24, IntegerLiteral=25, FloatLiteral=26, 
		StringLiteral=27, WS=28, COMMENT=29, LINE_COMMENT=30, LineTerminator=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SUFFIX_DP", "SUFFIX_PX", "ID", "DOT", "LPAREN", "RPAREN", "COMMA", "NULL", 
			"TRUE", "FALSE", "EQ", "LBRACKET", "RBRACKET", "AND_AND", "OR_OR", "QUESTION", 
			"SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", "IMPORT", "Identifier", 
			"ObjectDeclaration", "UnicodeConnectorPunctuation", "ZWNJ", "ZWJ", "UnicodeDigit", 
			"UnicodeCombiningMark", "UnicodeLetter", "IntegerLiteral", "FloatLiteral", 
			"DecimalIntegerLiteral", "ExponentPart", "StringLiteral", "DoubleStringCharacter", 
			"SingleStringCharacter", "EscapeSequence", "CharacterEscapeSequence", 
			"HexEscapeSequence", "UnicodeEscapeSequence", "ExtendedUnicodeEscapeSequence", 
			"SingleEscapeCharacter", "HexDigit", "NonEscapeCharacter", "EscapeCharacter", 
			"LineContinuation", "LineTerminatorSequence", "WS", "COMMENT", "LINE_COMMENT", 
			"LineTerminator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'dp'", "'px'", "'id'", "'.'", "'('", "')'", "','", "'null'", "'true'", 
			"'false'", "'='", "'['", "']'", "'&&'", "'||'", "'?'", "';'", "':'", 
			"'{'", "'}'", "'return'", "'import'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SUFFIX_DP", "SUFFIX_PX", "ID", "DOT", "LPAREN", "RPAREN", "COMMA", 
			"NULL", "TRUE", "FALSE", "EQ", "LBRACKET", "RBRACKET", "AND_AND", "OR_OR", 
			"QUESTION", "SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", "IMPORT", 
			"Identifier", "ObjectDeclaration", "IntegerLiteral", "FloatLiteral", 
			"StringLiteral", "WS", "COMMENT", "LINE_COMMENT", "LineTerminator"
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


	public PineScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PineScript.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u0165\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\7\30\u00b3"+
		"\n\30\f\30\16\30\u00b6\13\30\3\31\3\31\7\31\u00ba\n\31\f\31\16\31\u00bd"+
		"\13\31\3\32\5\32\u00c0\n\32\3\33\3\33\3\34\3\34\3\35\5\35\u00c7\n\35\3"+
		"\36\5\36\u00ca\n\36\3\37\5\37\u00cd\n\37\3 \3 \3!\3!\3!\7!\u00d4\n!\f"+
		"!\16!\u00d7\13!\3!\5!\u00da\n!\3!\3!\6!\u00de\n!\r!\16!\u00df\3!\5!\u00e3"+
		"\n!\5!\u00e5\n!\3\"\3\"\7\"\u00e9\n\"\f\"\16\"\u00ec\13\"\3#\3#\5#\u00f0"+
		"\n#\3#\6#\u00f3\n#\r#\16#\u00f4\3$\3$\7$\u00f9\n$\f$\16$\u00fc\13$\3$"+
		"\3$\3$\7$\u0101\n$\f$\16$\u0104\13$\3$\5$\u0107\n$\3%\3%\3%\3%\5%\u010d"+
		"\n%\3&\3&\3&\3&\5&\u0113\n&\3\'\3\'\3\'\3\'\3\'\5\'\u011a\n\'\3(\3(\5"+
		"(\u011e\n(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\6+\u012d\n+\r+\16+\u012e"+
		"\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\5/\u013b\n/\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\5\61\u0143\n\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u014d"+
		"\n\63\f\63\16\63\u0150\13\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\64\7\64\u015b\n\64\f\64\16\64\u015e\13\64\3\64\3\64\3\65\3\65\3\65\3"+
		"\65\3\u014e\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2"+
		"\67\29\2;\2=\2?\33A\34C\2E\2G\35I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a"+
		"\2c\36e\37g i!\3\2\27\3\2c|\6\2\62;C\\aac|\3\2C\\\5\2C\\aac|\t\2aa\u2041"+
		"\u2042\u30fd\u30fd\ufe35\ufe36\ufe4f\ufe51\uff41\uff41\uff67\uff67\26"+
		"\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8"+
		"\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52"+
		"\u0e5b\u0ed2\u0edb\u0f22\u0f2b\u1042\u104b\u136b\u1373\u17e2\u17eb\u1812"+
		"\u181b\uff12\uff1bf\2\u0302\u0350\u0362\u0364\u0485\u0488\u0593\u05a3"+
		"\u05a5\u05bb\u05bd\u05bf\u05c1\u05c1\u05c3\u05c4\u05c6\u05c6\u064d\u0657"+
		"\u0672\u0672\u06d8\u06de\u06e1\u06e6\u06e9\u06ea\u06ec\u06ef\u0713\u0713"+
		"\u0732\u074c\u07a8\u07b2\u0903\u0905\u093e\u093e\u0940\u094f\u0953\u0956"+
		"\u0964\u0965\u0983\u0985\u09be\u09c6\u09c9\u09ca\u09cd\u09cf\u09d9\u09d9"+
		"\u09e4\u09e5\u0a04\u0a04\u0a3e\u0a3e\u0a40\u0a44\u0a49\u0a4a\u0a4d\u0a4f"+
		"\u0a72\u0a73\u0a83\u0a85\u0abe\u0abe\u0ac0\u0ac7\u0ac9\u0acb\u0acd\u0acf"+
		"\u0b03\u0b05\u0b3e\u0b3e\u0b40\u0b45\u0b49\u0b4a\u0b4d\u0b4f\u0b58\u0b59"+
		"\u0b84\u0b85\u0bc0\u0bc4\u0bc8\u0bca\u0bcc\u0bcf\u0bd9\u0bd9\u0c03\u0c05"+
		"\u0c40\u0c46\u0c48\u0c4a\u0c4c\u0c4f\u0c57\u0c58\u0c84\u0c85\u0cc0\u0cc6"+
		"\u0cc8\u0cca\u0ccc\u0ccf\u0cd7\u0cd8\u0d04\u0d05\u0d40\u0d45\u0d48\u0d4a"+
		"\u0d4c\u0d4f\u0d59\u0d59\u0d84\u0d85\u0dcc\u0dcc\u0dd1\u0dd6\u0dd8\u0dd8"+
		"\u0dda\u0de1\u0df4\u0df5\u0e33\u0e33\u0e36\u0e3c\u0e49\u0e50\u0eb3\u0eb3"+
		"\u0eb6\u0ebb\u0ebd\u0ebe\u0eca\u0ecf\u0f1a\u0f1b\u0f37\u0f37\u0f39\u0f39"+
		"\u0f3b\u0f3b\u0f40\u0f41\u0f73\u0f86\u0f88\u0f89\u0f92\u0f99\u0f9b\u0fbe"+
		"\u0fc8\u0fc8\u102e\u1034\u1038\u103b\u1058\u105b\u17b6\u17d5\u18ab\u18ab"+
		"\u20d2\u20de\u20e3\u20e3\u302c\u3031\u309b\u309c\ufb20\ufb20\ufe22\ufe25"+
		"\u0104\2C\\c|\u00ac\u00ac\u00b7\u00b7\u00bc\u00bc\u00c2\u00d8\u00da\u00f8"+
		"\u00fa\u0221\u0224\u0235\u0252\u02af\u02b2\u02ba\u02bd\u02c3\u02d2\u02d3"+
		"\u02e2\u02e6\u02f0\u02f0\u037c\u037c\u0388\u0388\u038a\u038c\u038e\u038e"+
		"\u0390\u03a3\u03a5\u03d0\u03d2\u03d9\u03dc\u03f5\u0402\u0483\u048e\u04c6"+
		"\u04c9\u04ca\u04cd\u04ce\u04d2\u04f7\u04fa\u04fb\u0533\u0558\u055b\u055b"+
		"\u0563\u0589\u05d2\u05ec\u05f2\u05f4\u0623\u063c\u0642\u064c\u0673\u06d5"+
		"\u06d7\u06d7\u06e7\u06e8\u06fc\u06fe\u0712\u0712\u0714\u072e\u0782\u07a7"+
		"\u0907\u093b\u093f\u093f\u0952\u0952\u095a\u0963\u0987\u098e\u0991\u0992"+
		"\u0995\u09aa\u09ac\u09b2\u09b4\u09b4\u09b8\u09bb\u09de\u09df\u09e1\u09e3"+
		"\u09f2\u09f3\u0a07\u0a0c\u0a11\u0a12\u0a15\u0a2a\u0a2c\u0a32\u0a34\u0a35"+
		"\u0a37\u0a38\u0a3a\u0a3b\u0a5b\u0a5e\u0a60\u0a60\u0a74\u0a76\u0a87\u0a8d"+
		"\u0a8f\u0a8f\u0a91\u0a93\u0a95\u0aaa\u0aac\u0ab2\u0ab4\u0ab5\u0ab7\u0abb"+
		"\u0abf\u0abf\u0ad2\u0ad2\u0ae2\u0ae2\u0b07\u0b0e\u0b11\u0b12\u0b15\u0b2a"+
		"\u0b2c\u0b32\u0b34\u0b35\u0b38\u0b3b\u0b3f\u0b3f\u0b5e\u0b5f\u0b61\u0b63"+
		"\u0b87\u0b8c\u0b90\u0b92\u0b94\u0b97\u0b9b\u0b9c\u0b9e\u0b9e\u0ba0\u0ba1"+
		"\u0ba5\u0ba6\u0baa\u0bac\u0bb0\u0bb7\u0bb9\u0bbb\u0c07\u0c0e\u0c10\u0c12"+
		"\u0c14\u0c2a\u0c2c\u0c35\u0c37\u0c3b\u0c62\u0c63\u0c87\u0c8e\u0c90\u0c92"+
		"\u0c94\u0caa\u0cac\u0cb5\u0cb7\u0cbb\u0ce0\u0ce0\u0ce2\u0ce3\u0d07\u0d0e"+
		"\u0d10\u0d12\u0d14\u0d2a\u0d2c\u0d3b\u0d62\u0d63\u0d87\u0d98\u0d9c\u0db3"+
		"\u0db5\u0dbd\u0dbf\u0dbf\u0dc2\u0dc8\u0e03\u0e32\u0e34\u0e35\u0e42\u0e48"+
		"\u0e83\u0e84\u0e86\u0e86\u0e89\u0e8a\u0e8c\u0e8c\u0e8f\u0e8f\u0e96\u0e99"+
		"\u0e9b\u0ea1\u0ea3\u0ea5\u0ea7\u0ea7\u0ea9\u0ea9\u0eac\u0ead\u0eaf\u0eb2"+
		"\u0eb4\u0eb5\u0ebf\u0ec6\u0ec8\u0ec8\u0ede\u0edf\u0f02\u0f02\u0f42\u0f6c"+
		"\u0f8a\u0f8d\u1002\u1023\u1025\u1029\u102b\u102c\u1052\u1057\u10a2\u10c7"+
		"\u10d2\u10f8\u1102\u115b\u1161\u11a4\u11aa\u11fb\u1202\u1208\u120a\u1248"+
		"\u124a\u124a\u124c\u124f\u1252\u1258\u125a\u125a\u125c\u125f\u1262\u1288"+
		"\u128a\u128a\u128c\u128f\u1292\u12b0\u12b2\u12b2\u12b4\u12b7\u12ba\u12c0"+
		"\u12c2\u12c2\u12c4\u12c7\u12ca\u12d0\u12d2\u12d8\u12da\u12f0\u12f2\u1310"+
		"\u1312\u1312\u1314\u1317\u131a\u1320\u1322\u1348\u134a\u135c\u13a2\u13f6"+
		"\u1403\u1678\u1683\u169c\u16a2\u16ec\u1782\u17b5\u1822\u1879\u1882\u18aa"+
		"\u1e02\u1e9d\u1ea2\u1efb\u1f02\u1f17\u1f1a\u1f1f\u1f22\u1f47\u1f4a\u1f4f"+
		"\u1f52\u1f59\u1f5b\u1f5b\u1f5d\u1f5d\u1f5f\u1f5f\u1f61\u1f7f\u1f82\u1fb6"+
		"\u1fb8\u1fbe\u1fc0\u1fc0\u1fc4\u1fc6\u1fc8\u1fce\u1fd2\u1fd5\u1fd8\u1fdd"+
		"\u1fe2\u1fee\u1ff4\u1ff6\u1ff8\u1ffe\u2081\u2081\u2104\u2104\u2109\u2109"+
		"\u210c\u2115\u2117\u2117\u211b\u211f\u2126\u2126\u2128\u2128\u212a\u212a"+
		"\u212c\u212f\u2131\u2133\u2135\u213b\u2162\u2185\u3007\u3009\u3023\u302b"+
		"\u3033\u3037\u303a\u303c\u3043\u3096\u309f\u30a0\u30a3\u30fc\u30fe\u3100"+
		"\u3107\u312e\u3133\u3190\u31a2\u31b9\u3402\u3402\u4db7\u4db7\u4e02\u4e02"+
		"\u9fa7\u9fa7\ua002\ua48e\uac02\uac02\ud7a5\ud7a5\uf902\ufa2f\ufb02\ufb08"+
		"\ufb15\ufb19\ufb1f\ufb1f\ufb21\ufb2a\ufb2c\ufb38\ufb3a\ufb3e\ufb40\ufb40"+
		"\ufb42\ufb43\ufb45\ufb46\ufb48\ufbb3\ufbd5\ufd3f\ufd52\ufd91\ufd94\ufdc9"+
		"\ufdf2\ufdfd\ufe72\ufe74\ufe76\ufe76\ufe78\ufefe\uff23\uff3c\uff43\uff5c"+
		"\uff68\uffc0\uffc4\uffc9\uffcc\uffd1\uffd4\uffd9\uffdc\uffde\3\2\62;\3"+
		"\2\63;\4\2GGgg\4\2--//\6\2\f\f\17\17$$^^\6\2\f\f\17\17))^^\13\2$$))^^"+
		"ddhhppttvvxx\5\2\62;CHch\16\2\f\f\17\17$$))\62;^^ddhhppttvxzz\5\2\62;"+
		"wwzz\6\2\13\f\17\17\"\"==\4\2\f\f\17\17\5\2\f\f\17\17\u202a\u202b\2\u016a"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2G\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5n\3\2\2\2\7q\3\2\2\2\tt\3\2\2\2\13"+
		"v\3\2\2\2\rx\3\2\2\2\17z\3\2\2\2\21|\3\2\2\2\23\u0081\3\2\2\2\25\u0086"+
		"\3\2\2\2\27\u008c\3\2\2\2\31\u008e\3\2\2\2\33\u0090\3\2\2\2\35\u0092\3"+
		"\2\2\2\37\u0095\3\2\2\2!\u0098\3\2\2\2#\u009a\3\2\2\2%\u009c\3\2\2\2\'"+
		"\u009e\3\2\2\2)\u00a0\3\2\2\2+\u00a2\3\2\2\2-\u00a9\3\2\2\2/\u00b0\3\2"+
		"\2\2\61\u00b7\3\2\2\2\63\u00bf\3\2\2\2\65\u00c1\3\2\2\2\67\u00c3\3\2\2"+
		"\29\u00c6\3\2\2\2;\u00c9\3\2\2\2=\u00cc\3\2\2\2?\u00ce\3\2\2\2A\u00e4"+
		"\3\2\2\2C\u00e6\3\2\2\2E\u00ed\3\2\2\2G\u0106\3\2\2\2I\u010c\3\2\2\2K"+
		"\u0112\3\2\2\2M\u0119\3\2\2\2O\u011d\3\2\2\2Q\u011f\3\2\2\2S\u0123\3\2"+
		"\2\2U\u0129\3\2\2\2W\u0132\3\2\2\2Y\u0134\3\2\2\2[\u0136\3\2\2\2]\u013a"+
		"\3\2\2\2_\u013c\3\2\2\2a\u0142\3\2\2\2c\u0144\3\2\2\2e\u0148\3\2\2\2g"+
		"\u0156\3\2\2\2i\u0161\3\2\2\2kl\7f\2\2lm\7r\2\2m\4\3\2\2\2no\7r\2\2op"+
		"\7z\2\2p\6\3\2\2\2qr\7k\2\2rs\7f\2\2s\b\3\2\2\2tu\7\60\2\2u\n\3\2\2\2"+
		"vw\7*\2\2w\f\3\2\2\2xy\7+\2\2y\16\3\2\2\2z{\7.\2\2{\20\3\2\2\2|}\7p\2"+
		"\2}~\7w\2\2~\177\7n\2\2\177\u0080\7n\2\2\u0080\22\3\2\2\2\u0081\u0082"+
		"\7v\2\2\u0082\u0083\7t\2\2\u0083\u0084\7w\2\2\u0084\u0085\7g\2\2\u0085"+
		"\24\3\2\2\2\u0086\u0087\7h\2\2\u0087\u0088\7c\2\2\u0088\u0089\7n\2\2\u0089"+
		"\u008a\7u\2\2\u008a\u008b\7g\2\2\u008b\26\3\2\2\2\u008c\u008d\7?\2\2\u008d"+
		"\30\3\2\2\2\u008e\u008f\7]\2\2\u008f\32\3\2\2\2\u0090\u0091\7_\2\2\u0091"+
		"\34\3\2\2\2\u0092\u0093\7(\2\2\u0093\u0094\7(\2\2\u0094\36\3\2\2\2\u0095"+
		"\u0096\7~\2\2\u0096\u0097\7~\2\2\u0097 \3\2\2\2\u0098\u0099\7A\2\2\u0099"+
		"\"\3\2\2\2\u009a\u009b\7=\2\2\u009b$\3\2\2\2\u009c\u009d\7<\2\2\u009d"+
		"&\3\2\2\2\u009e\u009f\7}\2\2\u009f(\3\2\2\2\u00a0\u00a1\7\177\2\2\u00a1"+
		"*\3\2\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7v\2\2\u00a5"+
		"\u00a6\7w\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7p\2\2\u00a8,\3\2\2\2\u00a9"+
		"\u00aa\7k\2\2\u00aa\u00ab\7o\2\2\u00ab\u00ac\7r\2\2\u00ac\u00ad\7q\2\2"+
		"\u00ad\u00ae\7t\2\2\u00ae\u00af\7v\2\2\u00af.\3\2\2\2\u00b0\u00b4\t\2"+
		"\2\2\u00b1\u00b3\t\3\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\60\3\2\2\2\u00b6\u00b4\3\2\2"+
		"\2\u00b7\u00bb\t\4\2\2\u00b8\u00ba\t\5\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\62\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00c0\t\6\2\2\u00bf\u00be\3\2\2\2\u00c0\64\3\2\2"+
		"\2\u00c1\u00c2\7\u200e\2\2\u00c2\66\3\2\2\2\u00c3\u00c4\7\u200f\2\2\u00c4"+
		"8\3\2\2\2\u00c5\u00c7\t\7\2\2\u00c6\u00c5\3\2\2\2\u00c7:\3\2\2\2\u00c8"+
		"\u00ca\t\b\2\2\u00c9\u00c8\3\2\2\2\u00ca<\3\2\2\2\u00cb\u00cd\t\t\2\2"+
		"\u00cc\u00cb\3\2\2\2\u00cd>\3\2\2\2\u00ce\u00cf\5C\"\2\u00cf@\3\2\2\2"+
		"\u00d0\u00d1\5C\"\2\u00d1\u00d5\7\60\2\2\u00d2\u00d4\t\n\2\2\u00d3\u00d2"+
		"\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00da\5E#\2\u00d9\u00d8\3\2\2"+
		"\2\u00d9\u00da\3\2\2\2\u00da\u00e5\3\2\2\2\u00db\u00dd\7\60\2\2\u00dc"+
		"\u00de\t\n\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00e3\5E#\2\u00e2\u00e1"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00d0\3\2\2\2\u00e4"+
		"\u00db\3\2\2\2\u00e5B\3\2\2\2\u00e6\u00ea\t\13\2\2\u00e7\u00e9\t\n\2\2"+
		"\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00ebD\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ef\t\f\2\2\u00ee"+
		"\u00f0\t\r\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2"+
		"\2\2\u00f1\u00f3\t\n\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5F\3\2\2\2\u00f6\u00fa\7$\2\2\u00f7"+
		"\u00f9\5I%\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2"+
		"\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u0107"+
		"\7$\2\2\u00fe\u0102\7)\2\2\u00ff\u0101\5K&\2\u0100\u00ff\3\2\2\2\u0101"+
		"\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2"+
		"\2\2\u0104\u0102\3\2\2\2\u0105\u0107\7)\2\2\u0106\u00f6\3\2\2\2\u0106"+
		"\u00fe\3\2\2\2\u0107H\3\2\2\2\u0108\u010d\n\16\2\2\u0109\u010a\7^\2\2"+
		"\u010a\u010d\5M\'\2\u010b\u010d\5_\60\2\u010c\u0108\3\2\2\2\u010c\u0109"+
		"\3\2\2\2\u010c\u010b\3\2\2\2\u010dJ\3\2\2\2\u010e\u0113\n\17\2\2\u010f"+
		"\u0110\7^\2\2\u0110\u0113\5M\'\2\u0111\u0113\5_\60\2\u0112\u010e\3\2\2"+
		"\2\u0112\u010f\3\2\2\2\u0112\u0111\3\2\2\2\u0113L\3\2\2\2\u0114\u011a"+
		"\5O(\2\u0115\u011a\7\62\2\2\u0116\u011a\5Q)\2\u0117\u011a\5S*\2\u0118"+
		"\u011a\5U+\2\u0119\u0114\3\2\2\2\u0119\u0115\3\2\2\2\u0119\u0116\3\2\2"+
		"\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011aN\3\2\2\2\u011b\u011e"+
		"\5W,\2\u011c\u011e\5[.\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e"+
		"P\3\2\2\2\u011f\u0120\7z\2\2\u0120\u0121\5Y-\2\u0121\u0122\5Y-\2\u0122"+
		"R\3\2\2\2\u0123\u0124\7w\2\2\u0124\u0125\5Y-\2\u0125\u0126\5Y-\2\u0126"+
		"\u0127\5Y-\2\u0127\u0128\5Y-\2\u0128T\3\2\2\2\u0129\u012a\7w\2\2\u012a"+
		"\u012c\7}\2\2\u012b\u012d\5Y-\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2"+
		"\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131"+
		"\7\177\2\2\u0131V\3\2\2\2\u0132\u0133\t\20\2\2\u0133X\3\2\2\2\u0134\u0135"+
		"\t\21\2\2\u0135Z\3\2\2\2\u0136\u0137\n\22\2\2\u0137\\\3\2\2\2\u0138\u013b"+
		"\5W,\2\u0139\u013b\t\23\2\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013b"+
		"^\3\2\2\2\u013c\u013d\7^\2\2\u013d\u013e\5a\61\2\u013e`\3\2\2\2\u013f"+
		"\u0140\7\17\2\2\u0140\u0143\7\f\2\2\u0141\u0143\5i\65\2\u0142\u013f\3"+
		"\2\2\2\u0142\u0141\3\2\2\2\u0143b\3\2\2\2\u0144\u0145\t\24\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\u0147\b\62\2\2\u0147d\3\2\2\2\u0148\u0149\7\61\2\2\u0149"+
		"\u014a\7,\2\2\u014a\u014e\3\2\2\2\u014b\u014d\13\2\2\2\u014c\u014b\3\2"+
		"\2\2\u014d\u0150\3\2\2\2\u014e\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7,\2\2\u0152\u0153\7\61"+
		"\2\2\u0153\u0154\3\2\2\2\u0154\u0155\b\63\2\2\u0155f\3\2\2\2\u0156\u0157"+
		"\7\61\2\2\u0157\u0158\7\61\2\2\u0158\u015c\3\2\2\2\u0159\u015b\n\25\2"+
		"\2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\b\64\2\2"+
		"\u0160h\3\2\2\2\u0161\u0162\t\26\2\2\u0162\u0163\3\2\2\2\u0163\u0164\b"+
		"\65\3\2\u0164j\3\2\2\2\35\2\u00b4\u00bb\u00bf\u00c6\u00c9\u00cc\u00d5"+
		"\u00d9\u00df\u00e2\u00e4\u00ea\u00ef\u00f4\u00fa\u0102\u0106\u010c\u0112"+
		"\u0119\u011d\u012e\u013a\u0142\u014e\u015c\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}