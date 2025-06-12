package compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import compiler.antlr.*;
import java.util.*;

public class SyntacticAnalyzer {
    private ASTNode ast;
    private List<String> syntacticErrors;
    
    public SyntacticAnalyzer() {
        this.syntacticErrors = new ArrayList<>();
    }
    
    public ASTNode analyze(String sourceCode) {
        try {
            CharStream input = CharStreams.fromString(sourceCode);
            CPPGrammarLexer lexer = new CPPGrammarLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CPPGrammarParser parser = new CPPGrammarParser(tokens);
            
            // Agregar listener para errores sintácticos
            parser.removeErrorListeners();
            parser.addErrorListener(new SyntacticErrorListener());
            
            // Analizar y construir AST
            ParseTree tree = parser.program();
            
            if (syntacticErrors.isEmpty()) {
                ASTBuilder astBuilder = new ASTBuilder();
                ast = astBuilder.visit(tree);
            }
            
        } catch (Exception e) {
            syntacticErrors.add("Error sintáctico general: " + e.getMessage());
        }
        
        return ast;
    }
    
    public ASTNode getAST() {
        return ast;
    }
    
    public List<String> getSyntacticErrors() {
        return syntacticErrors;
    }
    
    public void printAST() {
        if (ast != null) {
            System.out.println("\n========== ÁRBOL SINTÁCTICO ABSTRACTO ==========");
            ast.printTree(0);
        } else {
            System.out.println("No se pudo generar el AST debido a errores sintácticos.");
        }
    }
    
    // Clase interna para manejo de errores sintácticos
    private class SyntacticErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                              int line, int charPositionInLine, String msg, 
                              RecognitionException e) {
            syntacticErrors.add(String.format("Error sintáctico en línea %d, columna %d: %s", 
                                            line, charPositionInLine, msg));
        }
    }
}