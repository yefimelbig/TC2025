import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

/**
 * Compilador principal sin dependencias de JavaFX
 * Compatible con Java 8+
 */
public class CompilerMainNoFX {
    
    // Códigos de color ANSI para terminal
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    
    public static void main(String[] args) {
        try {
            // Entrada de prueba solicitada
            String input = "if id relop id + then id := num";
            
            printHeader();
            System.out.println(CYAN + "Entrada: " + RESET + input);
            System.out.println();
            
            // Crear el analizador léxico
            ANTLRInputStream inputStream = new ANTLRInputStream(input);
            SimpleLanguageLexer lexer = new SimpleLanguageLexer(inputStream);
            
            // Configurar lexer para no usar JavaFX
            lexer.removeErrorListeners();
            lexer.addErrorListener(new ConsoleErrorListener());
            
            // Obtener tokens para el análisis léxico
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();
            
            // Mostrar análisis léxico
            System.out.println(BLUE + "=== ANÁLISIS LÉXICO ===" + RESET);
            showLexicalAnalysis(tokens);
            
            // Crear el analizador sintáctico
            tokens.reset();
            SimpleLanguageParser parser = new SimpleLanguageParser(tokens);
            
            // Configurar parser para no usar JavaFX
            parser.removeErrorListeners();
            parser.addErrorListener(new ConsoleErrorListener());
            
            // Realizar análisis sintáctico
            System.out.println(BLUE + "\n=== ANÁLISIS SINTÁCTICO ===" + RESET);
            ParseTree tree = parser.start();
            
            // Verificar si hubo errores
            if (parser.getNumberOfSyntaxErrors() == 0) {
                System.out.println(GREEN + "✅ Análisis sintáctico exitoso!" + RESET);
                System.out.println(BLUE + "\n=== ÁRBOL SINTÁCTICO ===" + RESET);
                printTree(tree, parser, 0);
                
                // Mostrar representación del árbol
                System.out.println(BLUE + "\n=== REPRESENTACIÓN LISP DEL AST ===" + RESET);
                System.out.println(tree.toStringTree(parser));
                
                // Análisis adicional
                performAdditionalAnalysis(tree, parser);
                
            } else {
                System.out.println(RED + "❌ Se encontraron errores sintácticos." + RESET);
            }
            
        } catch (Exception e) {
            System.err.println(RED + "Error durante la compilación: " + e.getMessage() + RESET);
            e.printStackTrace();
        }
    }
    
    private static void printHeader() {
        System.out.println(GREEN + "╔════════════════════════════════════════════════╗" + RESET);
        System.out.println(GREEN + "║        COMPILADOR PARA SUBCONJUNTO DE C++      ║" + RESET);
        System.out.println(GREEN + "║              Técnicas de Compilación           ║" + RESET);
        System.out.println(GREEN + "║                   Fase 1 y 2                   ║" + RESET);
        System.out.println(GREEN + "╚════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
    
    /**
     * Muestra el análisis léxico con tabla de tokens
     */
    private static void showLexicalAnalysis(CommonTokenStream tokens) {
        System.out.println("Tabla de Tokens:");
        System.out.println("┌─────────┬────────────────┬──────────┬──────────┐");
        System.out.println("│ Token # │ Tipo           │ Lexema   │ Posición │");
        System.out.println("├─────────┼────────────────┼──────────┼──────────┤");
        
        List<Token> tokenList = tokens.getTokens();
        int tokenNumber = 1;
        
        for (Token token : tokenList) {
            if (token.getType() != Token.EOF) {
                String tokenType = getTokenTypeName(token.getType());
                String lexeme = token.getText();
                String position = token.getLine() + ":" + token.getCharPositionInLine();
                
                System.out.printf("│ %-7d │ %-14s │ %-8s │ %-8s │\n", 
                    tokenNumber++, tokenType, lexeme, position);
            }
        }
        System.out.println("└─────────┴────────────────┴──────────┴──────────┘");
        
        // Verificar errores léxicos
        checkLexicalErrors(tokenList);
    }
    
    private static void checkLexicalErrors(List<Token> tokenList) {
        boolean hasLexicalErrors = false;
        for (Token token : tokenList) {
            if (token.getType() == Token.INVALID_TYPE) {
                if (!hasLexicalErrors) {
                    System.out.println(RED + "\n❌ ERRORES LÉXICOS ENCONTRADOS:" + RESET);
                    hasLexicalErrors = true;
                }
                System.out.println(RED + "Error léxico en posición " + 
                    token.getLine() + ":" + token.getCharPositionInLine() + 
                    " - Token inválido: '" + token.getText() + "'" + RESET);
            }
        }
        
        if (!hasLexicalErrors) {
            System.out.println(GREEN + "✅ Análisis léxico completado sin errores." + RESET);
        }
    }
    
    /**
     * Obtiene el nombre del tipo de token con colores
     */
    private static String getTokenTypeName(int tokenType) {
        switch (tokenType) {
            case SimpleLanguageLexer.ID: return CYAN + "ID" + RESET;
            case SimpleLanguageLexer.NUM: return YELLOW + "NUM" + RESET;
            case SimpleLanguageLexer.RELOP: return BLUE + "RELOP" + RESET;
            case SimpleLanguageLexer.IF: return GREEN + "IF" + RESET;
            case SimpleLanguageLexer.THEN: return GREEN + "THEN" + RESET;
            case SimpleLanguageLexer.ELSE: return GREEN + "ELSE" + RESET;
            case SimpleLanguageLexer.TRUE: return GREEN + "TRUE" + RESET;
            case SimpleLanguageLexer.FALSE: return GREEN + "FALSE" + RESET;
            case SimpleLanguageLexer.ASSIGN: return BLUE + "ASSIGN" + RESET;
            case SimpleLanguageLexer.PLUS: return YELLOW + "PLUS" + RESET;
            case SimpleLanguageLexer.MULTIPLY: return YELLOW + "MULTIPLY" + RESET;
            case SimpleLanguageLexer.LPAREN: return "LPAREN";
            case SimpleLanguageLexer.RPAREN: return "RPAREN";
            default: return RED + "UNKNOWN" + RESET;
        }
    }
    
    /**
     * Imprime el árbol sintáctico de forma jerárquica con colores
     */
    private static void printTree(ParseTree tree, Parser parser, int indent) {
        String spaces = "  ".repeat(indent);
        String prefix = indent == 0 ? "" : "├─ ";
        
        if (tree instanceof TerminalNode) {
            String tokenText = tree.getText();
            System.out.println(spaces + prefix + CYAN + tokenText + RESET);
        } else {
            String ruleName = parser.getRuleNames()[((RuleContext) tree).getRuleIndex()];
            System.out.println(spaces + prefix + GREEN + ruleName + RESET);
            
            for (int i = 0; i < tree.getChildCount(); i++) {
                printTree(tree.getChild(i), parser, indent + 1);
            }
        }
    }
    
    /**
     * Realiza análisis adicional del AST
     */
    private static void performAdditionalAnalysis(ParseTree tree, Parser parser) {
        System.out.println(BLUE + "\n=== ANÁLISIS ADICIONAL ===" + RESET);
        
        // Contar nodos
        int nodeCount = countNodes(tree);
        System.out.println("Número total de nodos en el AST: " + nodeCount);
        
        // Analizar profundidad
        int depth = calculateDepth(tree);
        System.out.println("Profundidad del AST: " + depth);
        
        // Identificar tipos de nodos
        analyzeNodeTypes(tree, parser);
    }
    
    private static int countNodes(ParseTree tree) {
        int count = 1;
        for (int i = 0; i < tree.getChildCount(); i++) {
            count += countNodes(tree.getChild(i));
        }
        return count;
    }
    
    private static int calculateDepth(ParseTree tree) {
        if (tree.getChildCount() == 0) {
            return 1;
        }
        
        int maxChildDepth = 0;
        for (int i = 0; i < tree.getChildCount(); i++) {
            int childDepth = calculateDepth(tree.getChild(i));
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }
        return 1 + maxChildDepth;
    }
    
    private static void analyzeNodeTypes(ParseTree tree, Parser parser) {
        Map<String, Integer> nodeTypes = new HashMap<>();
        collectNodeTypes(tree, parser, nodeTypes);
        
        System.out.println("Tipos de nodos encontrados:");
        for (Map.Entry<String, Integer> entry : nodeTypes.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    private static void collectNodeTypes(ParseTree tree, Parser parser, Map<String, Integer> nodeTypes) {
        String nodeType;
        if (tree instanceof TerminalNode) {
            nodeType = "Terminal[" + tree.getText() + "]";
        } else {
            nodeType = parser.getRuleNames()[((RuleContext) tree).getRuleIndex()];
        }
        
        nodeTypes.put(nodeType, nodeTypes.getOrDefault(nodeType, 0) + 1);
        
        for (int i = 0; i < tree.getChildCount(); i++) {
            collectNodeTypes(tree.getChild(i), parser, nodeTypes);
        }
    }
}

/**
 * Listener personalizado para errores de consola
 */
class ConsoleErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                          int line, int charPositionInLine,
                          String msg, RecognitionException e) {
        
        System.err.println(CompilerMainNoFX.RED + "❌ ERROR SINTÁCTICO:" + CompilerMainNoFX.RESET);
        System.err.println("   Línea: " + line);
        System.err.println("   Posición: " + charPositionInLine);
        System.err.println("   Mensaje: " + msg);
        
        if (offendingSymbol instanceof Token) {
            Token token = (Token) offendingSymbol;
            System.err.println("   Token problemático: '" + token.getText() + "'");
        }
        System.err.println();
    }
}