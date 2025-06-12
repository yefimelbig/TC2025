import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

// Evitar dependencias de JavaFX

public class CompilerMain {
    
    public static void main(String[] args) {
        try {
            // Entrada de prueba solicitada
            String input = "if id relop id + then id := num";
            
            System.out.println("=== COMPILADOR PARA SUBCONJUNTO DE C++ ===");
            System.out.println("Entrada: " + input);
            System.out.println();
            
            // Crear el analizador léxico
            ANTLRInputStream inputStream = new ANTLRInputStream(input);
            SimpleLanguageLexer lexer = new SimpleLanguageLexer(inputStream);
            
            // Obtener tokens para el análisis léxico
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();
            
            // Mostrar análisis léxico
            System.out.println("=== ANÁLISIS LÉXICO ===");
            showLexicalAnalysis(tokens);
            
            // Crear el analizador sintáctico
            tokens.reset();
            SimpleLanguageParser parser = new SimpleLanguageParser(tokens);
            
            // Agregar listener de errores personalizado
            parser.removeErrorListeners();
            parser.addErrorListener(new CustomErrorListener());
            
            // Realizar análisis sintáctico
            System.out.println("\n=== ANÁLISIS SINTÁCTICO ===");
            ParseTree tree = parser.start();
            
            // Verificar si hubo errores
            if (parser.getNumberOfSyntaxErrors() == 0) {
                System.out.println("✅ Análisis sintáctico exitoso!");
                System.out.println("\n=== ÁRBOL SINTÁCTICO ===");
                printTree(tree, parser, 0);
                
                // Mostrar representación del árbol
                System.out.println("\n=== REPRESENTACIÓN LISP DEL AST ===");
                System.out.println(tree.toStringTree(parser));
            } else {
                System.out.println("❌ Se encontraron errores sintácticos.");
            }
            
        } catch (Exception e) {
            System.err.println("Error durante la compilación: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Muestra el análisis léxico con tabla de tokens
     */
    private static void showLexicalAnalysis(CommonTokenStream tokens) {
        System.out.println("Tabla de Tokens:");
        System.out.println("+---------+----------------+----------+----------+");
        System.out.println("| Token # | Tipo           | Lexema   | Posición |");
        System.out.println("+---------+----------------+----------+----------+");
        
        List<Token> tokenList = tokens.getTokens();
        int tokenNumber = 1;
        
        for (Token token : tokenList) {
            if (token.getType() != Token.EOF) {
                String tokenType = getTokenTypeName(token.getType());
                String lexeme = token.getText();
                String position = token.getLine() + ":" + token.getCharPositionInLine();
                
                System.out.printf("| %-7d | %-14s | %-8s | %-8s |\n", 
                    tokenNumber++, tokenType, lexeme, position);
            }
        }
        System.out.println("+---------+----------------+----------+----------+");
        
        // Verificar errores léxicos
        boolean hasLexicalErrors = false;
        for (Token token : tokenList) {
            if (token.getType() == Token.INVALID_TYPE) {
                if (!hasLexicalErrors) {
                    System.out.println("\n❌ ERRORES LÉXICOS ENCONTRADOS:");
                    hasLexicalErrors = true;
                }
                System.out.println("Error léxico en posición " + 
                    token.getLine() + ":" + token.getCharPositionInLine() + 
                    " - Token inválido: '" + token.getText() + "'");
            }
        }
        
        if (!hasLexicalErrors) {
            System.out.println("✅ Análisis léxico completado sin errores.");
        }
    }
    
    /**
     * Obtiene el nombre del tipo de token
     */
    private static String getTokenTypeName(int tokenType) {
        switch (tokenType) {
            case SimpleLanguageLexer.ID: return "ID";
            case SimpleLanguageLexer.NUM: return "NUM";
            case SimpleLanguageLexer.RELOP: return "RELOP";
            case SimpleLanguageLexer.IF: return "IF";
            case SimpleLanguageLexer.THEN: return "THEN";
            case SimpleLanguageLexer.ELSE: return "ELSE";
            case SimpleLanguageLexer.TRUE: return "TRUE";
            case SimpleLanguageLexer.FALSE: return "FALSE";
            case SimpleLanguageLexer.ASSIGN: return "ASSIGN";
            case SimpleLanguageLexer.PLUS: return "PLUS";
            case SimpleLanguageLexer.MULTIPLY: return "MULTIPLY";
            case SimpleLanguageLexer.LPAREN: return "LPAREN";
            case SimpleLanguageLexer.RPAREN: return "RPAREN";
            default: return "UNKNOWN";
        }
    }
    
    /**
     * Imprime el árbol sintáctico de forma jerárquica
     */
    private static void printTree(ParseTree tree, Parser parser, int indent) {
        String spaces = "  ".repeat(indent);
        
        if (tree instanceof TerminalNode) {
            System.out.println(spaces + "├─ " + tree.getText());
        } else {
            String ruleName = parser.getRuleNames()[((RuleContext) tree).getRuleIndex()];
            System.out.println(spaces + "├─ " + ruleName);
            
            for (int i = 0; i < tree.getChildCount(); i++) {
                printTree(tree.getChild(i), parser, indent + 1);
            }
        }
    }
}

/**
 * Listener personalizado para manejar errores sintácticos
 */
class CustomErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                          int line, int charPositionInLine,
                          String msg, RecognitionException e) {
        
        System.err.println("❌ ERROR SINTÁCTICO:");
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