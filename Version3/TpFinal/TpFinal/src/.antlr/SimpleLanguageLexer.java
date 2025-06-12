// Generated from c:/Users/pc/Desktop/Facu/Cursando/TC/TpFinal/src/SimpleLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, NUM=2, RELOP=3, IF=4, THEN=5, ELSE=6, TRUE=7, FALSE=8, ASSIGN=9, 
		PLUS=10, MULTIPLY=11, LPAREN=12, RPAREN=13, WS=14, COMMENT=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "NUM", "RELOP", "IF", "THEN", "ELSE", "TRUE", "FALSE", "ASSIGN", 
			"PLUS", "MULTIPLY", "LPAREN", "RPAREN", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'if'", "'then'", "'else'", "'true'", "'false'", 
			"':='", "'+'", "'*'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "NUM", "RELOP", "IF", "THEN", "ELSE", "TRUE", "FALSE", "ASSIGN", 
			"PLUS", "MULTIPLY", "LPAREN", "RPAREN", "WS", "COMMENT"
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


	public SimpleLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLanguage.g4"; }

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
		"\u0004\u0000\u000fl\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001"+
		"\u0001\u0004\u0001(\b\u0001\u000b\u0001\f\u0001)\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0004\r\\\b\r\u000b\r\f\r]\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000ef\b\u000e\n\u000e\f\u000ei\t"+
		"\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0005"+
		"\u0002\u0000AZaz\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r\r "+
		" \u0002\u0000\n\n\r\rt\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000"+
		"\u0000\u0000\u0003\'\u0001\u0000\u0000\u0000\u00055\u0001\u0000\u0000"+
		"\u0000\u00077\u0001\u0000\u0000\u0000\t:\u0001\u0000\u0000\u0000\u000b"+
		"?\u0001\u0000\u0000\u0000\rD\u0001\u0000\u0000\u0000\u000fI\u0001\u0000"+
		"\u0000\u0000\u0011O\u0001\u0000\u0000\u0000\u0013R\u0001\u0000\u0000\u0000"+
		"\u0015T\u0001\u0000\u0000\u0000\u0017V\u0001\u0000\u0000\u0000\u0019X"+
		"\u0001\u0000\u0000\u0000\u001b[\u0001\u0000\u0000\u0000\u001da\u0001\u0000"+
		"\u0000\u0000\u001f#\u0007\u0000\u0000\u0000 \"\u0007\u0001\u0000\u0000"+
		"! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$\u0002\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000&(\u0007\u0002\u0000\u0000\'&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*\u0004\u0001\u0000\u0000\u0000+,\u0005=\u0000\u0000,6\u0005=\u0000"+
		"\u0000-.\u0005!\u0000\u0000.6\u0005=\u0000\u0000/6\u0005<\u0000\u0000"+
		"01\u0005<\u0000\u000016\u0005=\u0000\u000026\u0005>\u0000\u000034\u0005"+
		">\u0000\u000046\u0005=\u0000\u00005+\u0001\u0000\u0000\u00005-\u0001\u0000"+
		"\u0000\u00005/\u0001\u0000\u0000\u000050\u0001\u0000\u0000\u000052\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u00006\u0006\u0001\u0000\u0000"+
		"\u000078\u0005i\u0000\u000089\u0005f\u0000\u00009\b\u0001\u0000\u0000"+
		"\u0000:;\u0005t\u0000\u0000;<\u0005h\u0000\u0000<=\u0005e\u0000\u0000"+
		"=>\u0005n\u0000\u0000>\n\u0001\u0000\u0000\u0000?@\u0005e\u0000\u0000"+
		"@A\u0005l\u0000\u0000AB\u0005s\u0000\u0000BC\u0005e\u0000\u0000C\f\u0001"+
		"\u0000\u0000\u0000DE\u0005t\u0000\u0000EF\u0005r\u0000\u0000FG\u0005u"+
		"\u0000\u0000GH\u0005e\u0000\u0000H\u000e\u0001\u0000\u0000\u0000IJ\u0005"+
		"f\u0000\u0000JK\u0005a\u0000\u0000KL\u0005l\u0000\u0000LM\u0005s\u0000"+
		"\u0000MN\u0005e\u0000\u0000N\u0010\u0001\u0000\u0000\u0000OP\u0005:\u0000"+
		"\u0000PQ\u0005=\u0000\u0000Q\u0012\u0001\u0000\u0000\u0000RS\u0005+\u0000"+
		"\u0000S\u0014\u0001\u0000\u0000\u0000TU\u0005*\u0000\u0000U\u0016\u0001"+
		"\u0000\u0000\u0000VW\u0005(\u0000\u0000W\u0018\u0001\u0000\u0000\u0000"+
		"XY\u0005)\u0000\u0000Y\u001a\u0001\u0000\u0000\u0000Z\\\u0007\u0003\u0000"+
		"\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0006"+
		"\r\u0000\u0000`\u001c\u0001\u0000\u0000\u0000ab\u0005/\u0000\u0000bc\u0005"+
		"/\u0000\u0000cg\u0001\u0000\u0000\u0000df\b\u0004\u0000\u0000ed\u0001"+
		"\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000jk\u0006\u000e\u0000\u0000k\u001e\u0001\u0000\u0000\u0000\u0006"+
		"\u0000#)5]g\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}