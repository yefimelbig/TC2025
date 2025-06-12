// Generated from c:/Users/pc/Desktop/Facu/Cursando/TC/MiCarpeta/demo/src/main/antlr4/com/compilador/MiniLenguaje.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniLenguajeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INTEGER=2, STRING=3, BOOLEAN=4, KEYWORD=5, OPERATOR=6, SEPARATOR=7, 
		WS=8, COMMENT=9, BLOCK_COMMENT=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "INTEGER", "STRING", "BOOLEAN", "KEYWORD", "OPERATOR", "SEPARATOR", 
			"WS", "COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "INTEGER", "STRING", "BOOLEAN", "KEYWORD", "OPERATOR", "SEPARATOR", 
			"WS", "COMMENT", "BLOCK_COMMENT"
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


	public MiniLenguajeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniLenguaje.g4"; }

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
		"\u0004\u0000\n\u008c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001\u0004\u0001"+
		"\u001e\b\u0001\u000b\u0001\f\u0001\u001f\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002%\b\u0002\n\u0002\f\u0002(\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00035\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004X\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005i\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0004\u0007n\b\u0007\u000b\u0007\f\u0007o\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bx\b\b\n\b\f\b{\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0083\b\t\n\t\f\t\u0086\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\u0084\u0000\n\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0001\u0000\t\u0002\u0000AZaz\u0004\u000009AZ__az\u0001"+
		"\u000009\u0003\u0000\n\n\r\r\"\"\u0005\u0000%%*+--//==\u0002\u0000<<>"+
		">\u0006\u0000(),,..;;{{}}\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u00a1"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0001\u0015"+
		"\u0001\u0000\u0000\u0000\u0003\u001d\u0001\u0000\u0000\u0000\u0005!\u0001"+
		"\u0000\u0000\u0000\u00074\u0001\u0000\u0000\u0000\tW\u0001\u0000\u0000"+
		"\u0000\u000bh\u0001\u0000\u0000\u0000\rj\u0001\u0000\u0000\u0000\u000f"+
		"m\u0001\u0000\u0000\u0000\u0011s\u0001\u0000\u0000\u0000\u0013~\u0001"+
		"\u0000\u0000\u0000\u0015\u0019\u0007\u0000\u0000\u0000\u0016\u0018\u0007"+
		"\u0001\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u001b\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u0002\u0001\u0000\u0000\u0000\u001b\u0019\u0001"+
		"\u0000\u0000\u0000\u001c\u001e\u0007\u0002\u0000\u0000\u001d\u001c\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d\u0001"+
		"\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0004\u0001\u0000\u0000"+
		"\u0000!&\u0005\"\u0000\u0000\"%\b\u0003\u0000\u0000#%\u0005\"\u0000\u0000"+
		"$\"\u0001\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000"+
		"\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000"+
		"\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0005\"\u0000\u0000*\u0006\u0001"+
		"\u0000\u0000\u0000+,\u0005t\u0000\u0000,-\u0005r\u0000\u0000-.\u0005u"+
		"\u0000\u0000.5\u0005e\u0000\u0000/0\u0005f\u0000\u000001\u0005a\u0000"+
		"\u000012\u0005l\u0000\u000023\u0005s\u0000\u000035\u0005e\u0000\u0000"+
		"4+\u0001\u0000\u0000\u00004/\u0001\u0000\u0000\u00005\b\u0001\u0000\u0000"+
		"\u000067\u0005v\u0000\u000078\u0005a\u0000\u00008X\u0005r\u0000\u0000"+
		"9:\u0005i\u0000\u0000:X\u0005f\u0000\u0000;<\u0005e\u0000\u0000<=\u0005"+
		"l\u0000\u0000=>\u0005s\u0000\u0000>X\u0005e\u0000\u0000?@\u0005p\u0000"+
		"\u0000@A\u0005r\u0000\u0000AB\u0005i\u0000\u0000BC\u0005n\u0000\u0000"+
		"CX\u0005t\u0000\u0000DE\u0005w\u0000\u0000EF\u0005h\u0000\u0000FG\u0005"+
		"i\u0000\u0000GH\u0005l\u0000\u0000HX\u0005e\u0000\u0000IJ\u0005f\u0000"+
		"\u0000JK\u0005u\u0000\u0000KL\u0005n\u0000\u0000LM\u0005c\u0000\u0000"+
		"MN\u0005t\u0000\u0000NO\u0005i\u0000\u0000OP\u0005o\u0000\u0000PX\u0005"+
		"n\u0000\u0000QR\u0005r\u0000\u0000RS\u0005e\u0000\u0000ST\u0005t\u0000"+
		"\u0000TU\u0005u\u0000\u0000UV\u0005r\u0000\u0000VX\u0005n\u0000\u0000"+
		"W6\u0001\u0000\u0000\u0000W9\u0001\u0000\u0000\u0000W;\u0001\u0000\u0000"+
		"\u0000W?\u0001\u0000\u0000\u0000WD\u0001\u0000\u0000\u0000WI\u0001\u0000"+
		"\u0000\u0000WQ\u0001\u0000\u0000\u0000X\n\u0001\u0000\u0000\u0000Yi\u0007"+
		"\u0004\u0000\u0000Z[\u0005=\u0000\u0000[i\u0005=\u0000\u0000\\]\u0005"+
		"!\u0000\u0000]i\u0005=\u0000\u0000^i\u0007\u0005\u0000\u0000_`\u0005<"+
		"\u0000\u0000`i\u0005=\u0000\u0000ab\u0005>\u0000\u0000bi\u0005=\u0000"+
		"\u0000cd\u0005&\u0000\u0000di\u0005&\u0000\u0000ef\u0005|\u0000\u0000"+
		"fi\u0005|\u0000\u0000gi\u0005!\u0000\u0000hY\u0001\u0000\u0000\u0000h"+
		"Z\u0001\u0000\u0000\u0000h\\\u0001\u0000\u0000\u0000h^\u0001\u0000\u0000"+
		"\u0000h_\u0001\u0000\u0000\u0000ha\u0001\u0000\u0000\u0000hc\u0001\u0000"+
		"\u0000\u0000he\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000i\f\u0001"+
		"\u0000\u0000\u0000jk\u0007\u0006\u0000\u0000k\u000e\u0001\u0000\u0000"+
		"\u0000ln\u0007\u0007\u0000\u0000ml\u0001\u0000\u0000\u0000no\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001"+
		"\u0000\u0000\u0000qr\u0006\u0007\u0000\u0000r\u0010\u0001\u0000\u0000"+
		"\u0000st\u0005/\u0000\u0000tu\u0005/\u0000\u0000uy\u0001\u0000\u0000\u0000"+
		"vx\b\b\u0000\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|}\u0006\b\u0000\u0000}\u0012\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005/\u0000\u0000\u007f\u0080\u0005*\u0000\u0000"+
		"\u0080\u0084\u0001\u0000\u0000\u0000\u0081\u0083\t\u0000\u0000\u0000\u0082"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085"+
		"\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005*\u0000\u0000\u0088\u0089\u0005/\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0006\t\u0000\u0000\u008b\u0014\u0001\u0000"+
		"\u0000\u0000\u000b\u0000\u0019\u001f$&4Whoy\u0084\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}