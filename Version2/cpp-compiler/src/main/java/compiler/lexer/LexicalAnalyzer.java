package compiler.lexer;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import compiler.antlr.CPPGrammarLexer;
import java.util.*;

public class LexicalAnalyzer {
    private List<Token> tokens;
    private List<String> lexicalErrors;
    
    public LexicalAnalyzer() {
        this.tokens = new ArrayList<>();
        this.lexicalErrors = new ArrayList<>();
    }
    
    public void analyze(String sourceCode) {
        try {
            CharStream input = CharStreams.fromString(sourceCode);
            CPPGrammarLexer lexer = new CPPGrammarLexer(input);
            
            // Agregar listener para errores léxicos
            lexer.removeErrorListeners();
            lexer.addErrorListener(new LexicalErrorListener());
            
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            tokenStream.fill();
            
            // Extraer tokens
            for (org.antlr.v4.runtime.Token token : tokenStream.getTokens()) {
                if (token.getType() != org.antlr.v4.runtime.Token.EOF) {
                    String tokenType = lexer.getVocabulary().getSymbolicName(token.getType());
                    if (tokenType == null) {
                        tokenType = lexer.getVocabulary().getLiteralName(token.getType());
                    }
                    
                    tokens.add(new Token(
                        tokenType,
                        token.getText(),
                        token.getLine(),
                        token.getCharPositionInLine()
                    ));
                }
            }
            
        } catch (Exception e) {
            lexicalErrors.add("Error léxico general: " + e.getMessage());
        }
    }
    
    public List<Token> getTokens() {
        return tokens;
    }
    
    public List<String> getLexicalErrors() {
        return lexicalErrors;
    }
    
    public void printTokenTable() {
        System.out.println("\n========== TABLA DE TOKENS ==========");
        System.out.printf("%-15s %-20s %-6s %-8s%n", "TIPO", "VALOR", "LÍNEA", "COLUMNA");
        System.out.println("-----------------------------------------------------");
        
        for (Token token : tokens) {
            System.out.printf("%-15s %-20s %-6d %-8d%n", 
                            token.getType(), 
                            token.getValue(), 
                            token.getLine(), 
                            token.getColumn());
        }
    }
    
    // Clase interna para manejo de errores léxicos
    private class LexicalErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                              int line, int charPositionInLine, String msg, 
                              RecognitionException e) {
            lexicalErrors.add(String.format("Error léxico en línea %d, columna %d: %s", 
                                          line, charPositionInLine, msg));
        }
    }
}