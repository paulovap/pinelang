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
		OR=30, DOUBLE_QUOTE_OPEN=31, Identifier=32, ObjectType=33, IntegerLiteral=34, 
		FloatLiteral=35, DOUBLE_QUOTE_CLOSE=36, DoubleQuoteString=37, WS=38, COMMENT=39, 
		LINE_COMMENT=40, LineTerminator=41;
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
			"PLUS", "MINUS", "MULTI", "DIV", "REMAINDER", "AND", "OR", "DOUBLE_QUOTE_OPEN", 
			"Identifier", "ObjectType", "UnicodeConnectorPunctuation", "ZWNJ", "ZWJ", 
			"UnicodeDigit", "UnicodeCombiningMark", "UnicodeLetter", "IntegerLiteral", 
			"FloatLiteral", "DecimalIntegerLiteral", "ExponentPart", "DOUBLE_QUOTE_CLOSE", 
			"DoubleQuoteString", "DoubleStringCharacter", "SingleStringCharacter", 
			"EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", 
			"ExtendedUnicodeEscapeSequence", "SingleEscapeCharacter", "HexDigit", 
			"NonEscapeCharacter", "EscapeCharacter", "LineContinuation", "LineTerminatorSequence", 
			"WS", "COMMENT", "LINE_COMMENT", "LineTerminator"
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
			"DOUBLE_QUOTE_OPEN", "Identifier", "ObjectType", "IntegerLiteral", "FloatLiteral", 
			"DOUBLE_QUOTE_CLOSE", "DoubleQuoteString", "WS", "COMMENT", "LINE_COMMENT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0188\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3!\3!\7!\u00e0\n!\f!\16!\u00e3\13!\3\"\3\"\7\"\u00e7"+
		"\n\"\f\"\16\"\u00ea\13\"\3#\5#\u00ed\n#\3$\3$\3%\3%\3&\5&\u00f4\n&\3\'"+
		"\5\'\u00f7\n\'\3(\5(\u00fa\n(\3)\3)\3*\3*\3*\7*\u0101\n*\f*\16*\u0104"+
		"\13*\3*\5*\u0107\n*\3*\3*\6*\u010b\n*\r*\16*\u010c\3*\5*\u0110\n*\5*\u0112"+
		"\n*\3+\6+\u0115\n+\r+\16+\u0116\3,\3,\5,\u011b\n,\3,\6,\u011e\n,\r,\16"+
		",\u011f\3-\3-\3-\3-\3.\7.\u0127\n.\f.\16.\u012a\13.\3/\3/\3/\3/\5/\u0130"+
		"\n/\3\60\3\60\3\60\3\60\5\60\u0136\n\60\3\61\3\61\3\61\3\61\3\61\5\61"+
		"\u013d\n\61\3\62\3\62\5\62\u0141\n\62\3\63\3\63\3\63\3\63\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\65\3\65\3\65\6\65\u0150\n\65\r\65\16\65\u0151\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\38\39\39\59\u015e\n9\3:\3:\3:\3;\3;\3;\5"+
		";\u0166\n;\3<\3<\3<\3<\3=\3=\3=\3=\7=\u0170\n=\f=\16=\u0173\13=\3=\3="+
		"\3=\3=\3=\3>\3>\3>\3>\7>\u017e\n>\f>\16>\u0181\13>\3>\3>\3?\3?\3?\3?\3"+
		"\u0171\2@\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34"+
		"\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35"+
		":\36<\37> @!B\"D#F\2H\2J\2L\2N\2P\2R$T%V\2X\2Z&\\\'^\2`\2b\2d\2f\2h\2"+
		"j\2l\2n\2p\2r\2t\2v\2x(z)|*~+\4\2\3\26\3\2c|\6\2\62;C\\aac|\3\2C\\\5\2"+
		"C\\aac|\t\2aa\u2041\u2042\u30fd\u30fd\ufe35\ufe36\ufe4f\ufe51\uff41\uff41"+
		"\uff67\uff67\26\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1"+
		"\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1"+
		"\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u0f22\u0f2b\u1042\u104b\u136b\u1373"+
		"\u17e2\u17eb\u1812\u181b\uff12\uff1bf\2\u0302\u0350\u0362\u0364\u0485"+
		"\u0488\u0593\u05a3\u05a5\u05bb\u05bd\u05bf\u05c1\u05c1\u05c3\u05c4\u05c6"+
		"\u05c6\u064d\u0657\u0672\u0672\u06d8\u06de\u06e1\u06e6\u06e9\u06ea\u06ec"+
		"\u06ef\u0713\u0713\u0732\u074c\u07a8\u07b2\u0903\u0905\u093e\u093e\u0940"+
		"\u094f\u0953\u0956\u0964\u0965\u0983\u0985\u09be\u09c6\u09c9\u09ca\u09cd"+
		"\u09cf\u09d9\u09d9\u09e4\u09e5\u0a04\u0a04\u0a3e\u0a3e\u0a40\u0a44\u0a49"+
		"\u0a4a\u0a4d\u0a4f\u0a72\u0a73\u0a83\u0a85\u0abe\u0abe\u0ac0\u0ac7\u0ac9"+
		"\u0acb\u0acd\u0acf\u0b03\u0b05\u0b3e\u0b3e\u0b40\u0b45\u0b49\u0b4a\u0b4d"+
		"\u0b4f\u0b58\u0b59\u0b84\u0b85\u0bc0\u0bc4\u0bc8\u0bca\u0bcc\u0bcf\u0bd9"+
		"\u0bd9\u0c03\u0c05\u0c40\u0c46\u0c48\u0c4a\u0c4c\u0c4f\u0c57\u0c58\u0c84"+
		"\u0c85\u0cc0\u0cc6\u0cc8\u0cca\u0ccc\u0ccf\u0cd7\u0cd8\u0d04\u0d05\u0d40"+
		"\u0d45\u0d48\u0d4a\u0d4c\u0d4f\u0d59\u0d59\u0d84\u0d85\u0dcc\u0dcc\u0dd1"+
		"\u0dd6\u0dd8\u0dd8\u0dda\u0de1\u0df4\u0df5\u0e33\u0e33\u0e36\u0e3c\u0e49"+
		"\u0e50\u0eb3\u0eb3\u0eb6\u0ebb\u0ebd\u0ebe\u0eca\u0ecf\u0f1a\u0f1b\u0f37"+
		"\u0f37\u0f39\u0f39\u0f3b\u0f3b\u0f40\u0f41\u0f73\u0f86\u0f88\u0f89\u0f92"+
		"\u0f99\u0f9b\u0fbe\u0fc8\u0fc8\u102e\u1034\u1038\u103b\u1058\u105b\u17b6"+
		"\u17d5\u18ab\u18ab\u20d2\u20de\u20e3\u20e3\u302c\u3031\u309b\u309c\ufb20"+
		"\ufb20\ufe22\ufe25\u0104\2C\\c|\u00ac\u00ac\u00b7\u00b7\u00bc\u00bc\u00c2"+
		"\u00d8\u00da\u00f8\u00fa\u0221\u0224\u0235\u0252\u02af\u02b2\u02ba\u02bd"+
		"\u02c3\u02d2\u02d3\u02e2\u02e6\u02f0\u02f0\u037c\u037c\u0388\u0388\u038a"+
		"\u038c\u038e\u038e\u0390\u03a3\u03a5\u03d0\u03d2\u03d9\u03dc\u03f5\u0402"+
		"\u0483\u048e\u04c6\u04c9\u04ca\u04cd\u04ce\u04d2\u04f7\u04fa\u04fb\u0533"+
		"\u0558\u055b\u055b\u0563\u0589\u05d2\u05ec\u05f2\u05f4\u0623\u063c\u0642"+
		"\u064c\u0673\u06d5\u06d7\u06d7\u06e7\u06e8\u06fc\u06fe\u0712\u0712\u0714"+
		"\u072e\u0782\u07a7\u0907\u093b\u093f\u093f\u0952\u0952\u095a\u0963\u0987"+
		"\u098e\u0991\u0992\u0995\u09aa\u09ac\u09b2\u09b4\u09b4\u09b8\u09bb\u09de"+
		"\u09df\u09e1\u09e3\u09f2\u09f3\u0a07\u0a0c\u0a11\u0a12\u0a15\u0a2a\u0a2c"+
		"\u0a32\u0a34\u0a35\u0a37\u0a38\u0a3a\u0a3b\u0a5b\u0a5e\u0a60\u0a60\u0a74"+
		"\u0a76\u0a87\u0a8d\u0a8f\u0a8f\u0a91\u0a93\u0a95\u0aaa\u0aac\u0ab2\u0ab4"+
		"\u0ab5\u0ab7\u0abb\u0abf\u0abf\u0ad2\u0ad2\u0ae2\u0ae2\u0b07\u0b0e\u0b11"+
		"\u0b12\u0b15\u0b2a\u0b2c\u0b32\u0b34\u0b35\u0b38\u0b3b\u0b3f\u0b3f\u0b5e"+
		"\u0b5f\u0b61\u0b63\u0b87\u0b8c\u0b90\u0b92\u0b94\u0b97\u0b9b\u0b9c\u0b9e"+
		"\u0b9e\u0ba0\u0ba1\u0ba5\u0ba6\u0baa\u0bac\u0bb0\u0bb7\u0bb9\u0bbb\u0c07"+
		"\u0c0e\u0c10\u0c12\u0c14\u0c2a\u0c2c\u0c35\u0c37\u0c3b\u0c62\u0c63\u0c87"+
		"\u0c8e\u0c90\u0c92\u0c94\u0caa\u0cac\u0cb5\u0cb7\u0cbb\u0ce0\u0ce0\u0ce2"+
		"\u0ce3\u0d07\u0d0e\u0d10\u0d12\u0d14\u0d2a\u0d2c\u0d3b\u0d62\u0d63\u0d87"+
		"\u0d98\u0d9c\u0db3\u0db5\u0dbd\u0dbf\u0dbf\u0dc2\u0dc8\u0e03\u0e32\u0e34"+
		"\u0e35\u0e42\u0e48\u0e83\u0e84\u0e86\u0e86\u0e89\u0e8a\u0e8c\u0e8c\u0e8f"+
		"\u0e8f\u0e96\u0e99\u0e9b\u0ea1\u0ea3\u0ea5\u0ea7\u0ea7\u0ea9\u0ea9\u0eac"+
		"\u0ead\u0eaf\u0eb2\u0eb4\u0eb5\u0ebf\u0ec6\u0ec8\u0ec8\u0ede\u0edf\u0f02"+
		"\u0f02\u0f42\u0f6c\u0f8a\u0f8d\u1002\u1023\u1025\u1029\u102b\u102c\u1052"+
		"\u1057\u10a2\u10c7\u10d2\u10f8\u1102\u115b\u1161\u11a4\u11aa\u11fb\u1202"+
		"\u1208\u120a\u1248\u124a\u124a\u124c\u124f\u1252\u1258\u125a\u125a\u125c"+
		"\u125f\u1262\u1288\u128a\u128a\u128c\u128f\u1292\u12b0\u12b2\u12b2\u12b4"+
		"\u12b7\u12ba\u12c0\u12c2\u12c2\u12c4\u12c7\u12ca\u12d0\u12d2\u12d8\u12da"+
		"\u12f0\u12f2\u1310\u1312\u1312\u1314\u1317\u131a\u1320\u1322\u1348\u134a"+
		"\u135c\u13a2\u13f6\u1403\u1678\u1683\u169c\u16a2\u16ec\u1782\u17b5\u1822"+
		"\u1879\u1882\u18aa\u1e02\u1e9d\u1ea2\u1efb\u1f02\u1f17\u1f1a\u1f1f\u1f22"+
		"\u1f47\u1f4a\u1f4f\u1f52\u1f59\u1f5b\u1f5b\u1f5d\u1f5d\u1f5f\u1f5f\u1f61"+
		"\u1f7f\u1f82\u1fb6\u1fb8\u1fbe\u1fc0\u1fc0\u1fc4\u1fc6\u1fc8\u1fce\u1fd2"+
		"\u1fd5\u1fd8\u1fdd\u1fe2\u1fee\u1ff4\u1ff6\u1ff8\u1ffe\u2081\u2081\u2104"+
		"\u2104\u2109\u2109\u210c\u2115\u2117\u2117\u211b\u211f\u2126\u2126\u2128"+
		"\u2128\u212a\u212a\u212c\u212f\u2131\u2133\u2135\u213b\u2162\u2185\u3007"+
		"\u3009\u3023\u302b\u3033\u3037\u303a\u303c\u3043\u3096\u309f\u30a0\u30a3"+
		"\u30fc\u30fe\u3100\u3107\u312e\u3133\u3190\u31a2\u31b9\u3402\u3402\u4db7"+
		"\u4db7\u4e02\u4e02\u9fa7\u9fa7\ua002\ua48e\uac02\uac02\ud7a5\ud7a5\uf902"+
		"\ufa2f\ufb02\ufb08\ufb15\ufb19\ufb1f\ufb1f\ufb21\ufb2a\ufb2c\ufb38\ufb3a"+
		"\ufb3e\ufb40\ufb40\ufb42\ufb43\ufb45\ufb46\ufb48\ufbb3\ufbd5\ufd3f\ufd52"+
		"\ufd91\ufd94\ufdc9\ufdf2\ufdfd\ufe72\ufe74\ufe76\ufe76\ufe78\ufefe\uff23"+
		"\uff3c\uff43\uff5c\uff68\uffc0\uffc4\uffc9\uffcc\uffd1\uffd4\uffd9\uffdc"+
		"\uffde\3\2\62;\4\2GGgg\4\2--//\6\2\f\f\17\17$$^^\6\2\f\f\17\17))^^\13"+
		"\2$$))^^ddhhppttvvxx\5\2\62;CHch\16\2\f\f\17\17$$))\62;^^ddhhppttvxzz"+
		"\5\2\62;wwzz\6\2\13\f\17\17\"\"==\4\2\f\f\17\17\5\2\f\f\17\17\u202a\u202b"+
		"\2\u018a\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2"+
		"\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3"+
		"\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2"+
		"$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60"+
		"\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2"+
		"\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2R\3\2\2\2\2T"+
		"\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\3Z\3\2\2\2\3\\\3"+
		"\2\2\2\4\u0080\3\2\2\2\6\u0083\3\2\2\2\b\u0086\3\2\2\2\n\u0089\3\2\2\2"+
		"\f\u008c\3\2\2\2\16\u008e\3\2\2\2\20\u0090\3\2\2\2\22\u0092\3\2\2\2\24"+
		"\u0094\3\2\2\2\26\u0099\3\2\2\2\30\u009e\3\2\2\2\32\u00a4\3\2\2\2\34\u00a6"+
		"\3\2\2\2\36\u00a8\3\2\2\2 \u00aa\3\2\2\2\"\u00ad\3\2\2\2$\u00b0\3\2\2"+
		"\2&\u00b2\3\2\2\2(\u00b4\3\2\2\2*\u00b6\3\2\2\2,\u00b8\3\2\2\2.\u00ba"+
		"\3\2\2\2\60\u00c1\3\2\2\2\62\u00c8\3\2\2\2\64\u00ca\3\2\2\2\66\u00cc\3"+
		"\2\2\28\u00ce\3\2\2\2:\u00d0\3\2\2\2<\u00d2\3\2\2\2>\u00d6\3\2\2\2@\u00d9"+
		"\3\2\2\2B\u00dd\3\2\2\2D\u00e4\3\2\2\2F\u00ec\3\2\2\2H\u00ee\3\2\2\2J"+
		"\u00f0\3\2\2\2L\u00f3\3\2\2\2N\u00f6\3\2\2\2P\u00f9\3\2\2\2R\u00fb\3\2"+
		"\2\2T\u0111\3\2\2\2V\u0114\3\2\2\2X\u0118\3\2\2\2Z\u0121\3\2\2\2\\\u0128"+
		"\3\2\2\2^\u012f\3\2\2\2`\u0135\3\2\2\2b\u013c\3\2\2\2d\u0140\3\2\2\2f"+
		"\u0142\3\2\2\2h\u0146\3\2\2\2j\u014c\3\2\2\2l\u0155\3\2\2\2n\u0157\3\2"+
		"\2\2p\u0159\3\2\2\2r\u015d\3\2\2\2t\u015f\3\2\2\2v\u0165\3\2\2\2x\u0167"+
		"\3\2\2\2z\u016b\3\2\2\2|\u0179\3\2\2\2~\u0184\3\2\2\2\u0080\u0081\7q\2"+
		"\2\u0081\u0082\7p\2\2\u0082\5\3\2\2\2\u0083\u0084\7f\2\2\u0084\u0085\7"+
		"r\2\2\u0085\7\3\2\2\2\u0086\u0087\7r\2\2\u0087\u0088\7z\2\2\u0088\t\3"+
		"\2\2\2\u0089\u008a\7k\2\2\u008a\u008b\7f\2\2\u008b\13\3\2\2\2\u008c\u008d"+
		"\7\60\2\2\u008d\r\3\2\2\2\u008e\u008f\7*\2\2\u008f\17\3\2\2\2\u0090\u0091"+
		"\7+\2\2\u0091\21\3\2\2\2\u0092\u0093\7.\2\2\u0093\23\3\2\2\2\u0094\u0095"+
		"\7p\2\2\u0095\u0096\7w\2\2\u0096\u0097\7n\2\2\u0097\u0098\7n\2\2\u0098"+
		"\25\3\2\2\2\u0099\u009a\7v\2\2\u009a\u009b\7t\2\2\u009b\u009c\7w\2\2\u009c"+
		"\u009d\7g\2\2\u009d\27\3\2\2\2\u009e\u009f\7h\2\2\u009f\u00a0\7c\2\2\u00a0"+
		"\u00a1\7n\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7g\2\2\u00a3\31\3\2\2\2\u00a4"+
		"\u00a5\7?\2\2\u00a5\33\3\2\2\2\u00a6\u00a7\7]\2\2\u00a7\35\3\2\2\2\u00a8"+
		"\u00a9\7_\2\2\u00a9\37\3\2\2\2\u00aa\u00ab\7(\2\2\u00ab\u00ac\7(\2\2\u00ac"+
		"!\3\2\2\2\u00ad\u00ae\7~\2\2\u00ae\u00af\7~\2\2\u00af#\3\2\2\2\u00b0\u00b1"+
		"\7A\2\2\u00b1%\3\2\2\2\u00b2\u00b3\7=\2\2\u00b3\'\3\2\2\2\u00b4\u00b5"+
		"\7<\2\2\u00b5)\3\2\2\2\u00b6\u00b7\7}\2\2\u00b7+\3\2\2\2\u00b8\u00b9\7"+
		"\177\2\2\u00b9-\3\2\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd"+
		"\7v\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7p\2\2\u00c0"+
		"/\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4\7r\2\2\u00c4"+
		"\u00c5\7q\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7v\2\2\u00c7\61\3\2\2\2\u00c8"+
		"\u00c9\7-\2\2\u00c9\63\3\2\2\2\u00ca\u00cb\7/\2\2\u00cb\65\3\2\2\2\u00cc"+
		"\u00cd\7,\2\2\u00cd\67\3\2\2\2\u00ce\u00cf\7\61\2\2\u00cf9\3\2\2\2\u00d0"+
		"\u00d1\7\'\2\2\u00d1;\3\2\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"\u00d5\7f\2\2\u00d5=\3\2\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7t\2\2\u00d8"+
		"?\3\2\2\2\u00d9\u00da\7$\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b \2\2\u00dc"+
		"A\3\2\2\2\u00dd\u00e1\t\2\2\2\u00de\u00e0\t\3\2\2\u00df\u00de\3\2\2\2"+
		"\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2C\3"+
		"\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e8\t\4\2\2\u00e5\u00e7\t\5\2\2\u00e6"+
		"\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2"+
		"\2\2\u00e9E\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ed\t\6\2\2\u00ec\u00eb"+
		"\3\2\2\2\u00edG\3\2\2\2\u00ee\u00ef\7\u200e\2\2\u00efI\3\2\2\2\u00f0\u00f1"+
		"\7\u200f\2\2\u00f1K\3\2\2\2\u00f2\u00f4\t\7\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"M\3\2\2\2\u00f5\u00f7\t\b\2\2\u00f6\u00f5\3\2\2\2\u00f7O\3\2\2\2\u00f8"+
		"\u00fa\t\t\2\2\u00f9\u00f8\3\2\2\2\u00faQ\3\2\2\2\u00fb\u00fc\5V+\2\u00fc"+
		"S\3\2\2\2\u00fd\u00fe\5V+\2\u00fe\u0102\7\60\2\2\u00ff\u0101\t\n\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0107\5X,\2\u0106\u0105"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0112\3\2\2\2\u0108\u010a\7\60\2\2"+
		"\u0109\u010b\t\n\2\2\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u0110\5X,\2\u010f"+
		"\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u00fd\3\2"+
		"\2\2\u0111\u0108\3\2\2\2\u0112U\3\2\2\2\u0113\u0115\t\n\2\2\u0114\u0113"+
		"\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"W\3\2\2\2\u0118\u011a\t\13\2\2\u0119\u011b\t\f\2\2\u011a\u0119\3\2\2\2"+
		"\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011e\t\n\2\2\u011d\u011c"+
		"\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"Y\3\2\2\2\u0121\u0122\7$\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b-\3\2\u0124"+
		"[\3\2\2\2\u0125\u0127\5^/\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129]\3\2\2\2\u012a\u0128\3\2\2\2"+
		"\u012b\u0130\n\r\2\2\u012c\u012d\7^\2\2\u012d\u0130\5b\61\2\u012e\u0130"+
		"\5t:\2\u012f\u012b\3\2\2\2\u012f\u012c\3\2\2\2\u012f\u012e\3\2\2\2\u0130"+
		"_\3\2\2\2\u0131\u0136\n\16\2\2\u0132\u0133\7^\2\2\u0133\u0136\5b\61\2"+
		"\u0134\u0136\5t:\2\u0135\u0131\3\2\2\2\u0135\u0132\3\2\2\2\u0135\u0134"+
		"\3\2\2\2\u0136a\3\2\2\2\u0137\u013d\5d\62\2\u0138\u013d\7\62\2\2\u0139"+
		"\u013d\5f\63\2\u013a\u013d\5h\64\2\u013b\u013d\5j\65\2\u013c\u0137\3\2"+
		"\2\2\u013c\u0138\3\2\2\2\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013b\3\2\2\2\u013dc\3\2\2\2\u013e\u0141\5l\66\2\u013f\u0141\5p8\2\u0140"+
		"\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141e\3\2\2\2\u0142\u0143\7z\2\2\u0143"+
		"\u0144\5n\67\2\u0144\u0145\5n\67\2\u0145g\3\2\2\2\u0146\u0147\7w\2\2\u0147"+
		"\u0148\5n\67\2\u0148\u0149\5n\67\2\u0149\u014a\5n\67\2\u014a\u014b\5n"+
		"\67\2\u014bi\3\2\2\2\u014c\u014d\7w\2\2\u014d\u014f\7}\2\2\u014e\u0150"+
		"\5n\67\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7\177\2\2\u0154k\3\2\2"+
		"\2\u0155\u0156\t\17\2\2\u0156m\3\2\2\2\u0157\u0158\t\20\2\2\u0158o\3\2"+
		"\2\2\u0159\u015a\n\21\2\2\u015aq\3\2\2\2\u015b\u015e\5l\66\2\u015c\u015e"+
		"\t\22\2\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2\2\2\u015es\3\2\2\2\u015f"+
		"\u0160\7^\2\2\u0160\u0161\5v;\2\u0161u\3\2\2\2\u0162\u0163\7\17\2\2\u0163"+
		"\u0166\7\f\2\2\u0164\u0166\5~?\2\u0165\u0162\3\2\2\2\u0165\u0164\3\2\2"+
		"\2\u0166w\3\2\2\2\u0167\u0168\t\23\2\2\u0168\u0169\3\2\2\2\u0169\u016a"+
		"\b<\4\2\u016ay\3\2\2\2\u016b\u016c\7\61\2\2\u016c\u016d\7,\2\2\u016d\u0171"+
		"\3\2\2\2\u016e\u0170\13\2\2\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2"+
		"\u0171\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0174\u0175\7,\2\2\u0175\u0176\7\61\2\2\u0176\u0177\3\2\2\2\u0177"+
		"\u0178\b=\4\2\u0178{\3\2\2\2\u0179\u017a\7\61\2\2\u017a\u017b\7\61\2\2"+
		"\u017b\u017f\3\2\2\2\u017c\u017e\n\24\2\2\u017d\u017c\3\2\2\2\u017e\u0181"+
		"\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182\3\2\2\2\u0181"+
		"\u017f\3\2\2\2\u0182\u0183\b>\4\2\u0183}\3\2\2\2\u0184\u0185\t\25\2\2"+
		"\u0185\u0186\3\2\2\2\u0186\u0187\b?\5\2\u0187\177\3\2\2\2\34\2\3\u00e1"+
		"\u00e8\u00ec\u00f3\u00f6\u00f9\u0102\u0106\u010c\u010f\u0111\u0116\u011a"+
		"\u011f\u0128\u012f\u0135\u013c\u0140\u0151\u015d\u0165\u0171\u017f\6\7"+
		"\3\2\6\2\2\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}