package compiler;

import compiler.lexer.LexicalAnalyzer;
import compiler.parser.SyntacticAnalyzer;
import compiler.parser.ASTNode;
import compiler.utils.ColorUtils;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java compiler.Main <archivo.cpp>");
            System.exit(1);
        }
        
        try {
            // Leer archivo de entrada
            String sourceCode = new String(Files.readAllBytes(Paths.get(args[0])));
            
            System.out.println("=== COMPILADOR C++ - ANÁLISIS LÉXICO Y SINTÁCTICO ===\n");
            System.out.println("Archivo: " + args[0]);
            System.out.println("Código fuente:");
            System.out.println("----------------------------------------");
            System.out.println(sourceCode);
            System.out.println("----------------------------------------\n");
            
            // Fase 1: Análisis Léxico
            System.out.println("FASE 1: ANÁLISIS LÉXICO");
            LexicalAnalyzer lexer = new LexicalAnalyzer();
            lexer.analyze(sourceCode);
            
            if (!lexer.getLexicalErrors().isEmpty()) {
                ColorUtils.printError("Errores léxicos encontrados:");
                for (String error : lexer.getLexicalErrors()) {
                    ColorUtils.printError("  " + error);
                }
                System.exit(1);
            } else {
                ColorUtils.printSuccess("✓ Análisis léxico completado exitosamente");
                lexer.printTokenTable();
            }
            
            // Fase 2: Análisis Sintáctico
            System.out.println("\nFASE 2: ANÁLISIS SINTÁCTICO");
            SyntacticAnalyzer parser = new SyntacticAnalyzer();
            ASTNode ast = parser.analyze(sourceCode);
            
            if (!parser.getSyntacticErrors().isEmpty()) {
                ColorUtils.printError("Errores sintácticos encontrados:");
                for (String error : parser.getSyntacticErrors()) {
                    ColorUtils.printError("  " + error);
                }
                System.exit(1);
            } else {
                ColorUtils.printSuccess("✓ Análisis sintáctico completado exitosamente");
                parser.printAST();
            }
            
            ColorUtils.printSuccess("\n=== COMPILACIÓN COMPLETADA EXITOSAMENTE ===");
            
        } catch (IOException e) {
            ColorUtils.printError("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            ColorUtils.printError("Error general: " + e.getMessage());
            e.printStackTrace();
        }
    }
}