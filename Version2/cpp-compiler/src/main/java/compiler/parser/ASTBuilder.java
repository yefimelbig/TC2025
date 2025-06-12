package compiler.parser;

import compiler.antlr.*;
import org.antlr.v4.runtime.tree.*;

public class ASTBuilder extends CPPGrammarBaseVisitor<ASTNode> {
    
    @Override
    public ASTNode visitProgram(CPPGrammarParser.ProgramContext ctx) {
        ASTNode programNode = new ASTNode("PROGRAM", null);
        
        for (CPPGrammarParser.DeclarationContext decl : ctx.declaration()) {
            ASTNode declNode = visit(decl);
            if (declNode != null) {
                programNode.addChild(declNode);
            }
        }
        
        for (CPPGrammarParser.FunctionDeclarationContext func : ctx.functionDeclaration()) {
            ASTNode funcNode = visit(func);
            if (funcNode != null) {
                programNode.addChild(funcNode);
            }
        }
        
        return programNode;
    }
    
    @Override
    public ASTNode visitVariableDeclaration(CPPGrammarParser.VariableDeclarationContext ctx) {
        ASTNode varDeclNode = new ASTNode("VARIABLE_DECLARATION", null);
        
        // Tipo de dato
        ASTNode typeNode = new ASTNode("TYPE", ctx.dataType().getText());
        varDeclNode.addChild(typeNode);
        
        // Identificador
        ASTNode idNode = new ASTNode("IDENTIFIER", ctx.IDENTIFIER().getText());
        varDeclNode.addChild(idNode);
        
        // Inicialización (si existe)
        if (ctx.expression() != null) {
            ASTNode initNode = new ASTNode("INITIALIZATION", null);
            initNode.addChild(visit(ctx.expression()));
            varDeclNode.addChild(initNode);
        }
        
        return varDeclNode;
    }
    
    @Override
    public ASTNode visitFunctionDeclaration(CPPGrammarParser.FunctionDeclarationContext ctx) {
        ASTNode funcDeclNode = new ASTNode("FUNCTION_DECLARATION", null);
        
        // Tipo de retorno
        ASTNode returnTypeNode = new ASTNode("RETURN_TYPE", ctx.dataType().getText());
        funcDeclNode.addChild(returnTypeNode);
        
        // Nombre de la función
        ASTNode nameNode = new ASTNode("FUNCTION_NAME", ctx.IDENTIFIER().getText());
        funcDeclNode.addChild(nameNode);
        
        // Parámetros
        if (ctx.parameterList() != null) {
            ASTNode paramsNode = visit(ctx.parameterList());
            funcDeclNode.addChild(paramsNode);
        }
        
        // Cuerpo de la función
        ASTNode bodyNode = visit(ctx.block());
        funcDeclNode.addChild(bodyNode);
        
        return funcDeclNode;
    }
    
    @Override
    public ASTNode visitParameterList(CPPGrammarParser.ParameterListContext ctx) {
        ASTNode paramListNode = new ASTNode("PARAMETER_LIST", null);
        
        for (CPPGrammarParser.ParameterContext param : ctx.parameter()) {
            ASTNode paramNode = visit(param);
            paramListNode.addChild(paramNode);
        }
        
        return paramListNode;
    }
    
    @Override
    public ASTNode visitParameter(CPPGrammarParser.ParameterContext ctx) {
        ASTNode paramNode = new ASTNode("PARAMETER", null);
        
        ASTNode typeNode = new ASTNode("TYPE", ctx.dataType().getText());
        paramNode.addChild(typeNode);
        
        ASTNode idNode = new ASTNode("IDENTIFIER", ctx.IDENTIFIER().getText());
        paramNode.addChild(idNode);
        
        return paramNode;
    }
    
    @Override
    public ASTNode visitBlock(CPPGrammarParser.BlockContext ctx) {
        ASTNode blockNode = new ASTNode("BLOCK", null);
        
        for (CPPGrammarParser.StatementContext stmt : ctx.statement()) {
            ASTNode stmtNode = visit(stmt);
            if (stmtNode != null) {
                blockNode.addChild(stmtNode);
            }
        }
        
        return blockNode;
    }
    
    @Override
    public ASTNode visitIfStatement(CPPGrammarParser.IfStatementContext ctx) {
        ASTNode ifNode = new ASTNode("IF_STATEMENT", null);
        
        // Condición
        ASTNode conditionNode = new ASTNode("CONDITION", null);
        conditionNode.addChild(visit(ctx.expression()));
        ifNode.addChild(conditionNode);
        
        // Bloque then
        ASTNode thenNode = new ASTNode("THEN", null);
        thenNode.addChild(visit(ctx.statement(0)));
        ifNode.addChild(thenNode);
        
        // Bloque else (si existe)
        if (ctx.statement().size() > 1) {
            ASTNode elseNode = new ASTNode("ELSE", null);
            elseNode.addChild(visit(ctx.statement(1)));
            ifNode.addChild(elseNode);
        }
        
        return ifNode;
    }
    
    @Override
    public ASTNode visitWhileStatement(CPPGrammarParser.WhileStatementContext ctx) {
        ASTNode whileNode = new ASTNode("WHILE_STATEMENT", null);
        
        // Condición
        ASTNode conditionNode = new ASTNode("CONDITION", null);
        conditionNode.addChild(visit(ctx.expression()));
        whileNode.addChild(conditionNode);
        
        // Cuerpo
        ASTNode bodyNode = new ASTNode("BODY", null);
        bodyNode.addChild(visit(ctx.statement()));
        whileNode.addChild(bodyNode);
        
        return whileNode;
    }
    
    @Override
    public ASTNode visitAssignmentStatement(CPPGrammarParser.AssignmentStatementContext ctx) {
        ASTNode assignNode = new ASTNode("ASSIGNMENT", null);
        
        ASTNode varNode = new ASTNode("VARIABLE", ctx.IDENTIFIER().getText());
        assignNode.addChild(varNode);
        
        ASTNode exprNode = visit(ctx.expression());
        assignNode.addChild(exprNode);
        
        return assignNode;
    }
    
    @Override
    public ASTNode visitAdditiveExpression(CPPGrammarParser.AdditiveExpressionContext ctx) {
        if (ctx.multiplicativeExpression().size() == 1) {
            return visit(ctx.multiplicativeExpression(0));
        }
        
        ASTNode leftNode = visit(ctx.multiplicativeExpression(0));
        
        for (int i = 1; i < ctx.multiplicativeExpression().size(); i++) {
            String operator = ctx.getChild(2*i-1).getText(); // +, -
            ASTNode rightNode = visit(ctx.multiplicativeExpression(i));
            
            ASTNode opNode = new ASTNode("BINARY_OP", operator);
            opNode.addChild(leftNode);
            opNode.addChild(rightNode);
            leftNode = opNode;
        }
        
        return leftNode;
    }
    
    @Override
    public ASTNode visitMultiplicativeExpression(CPPGrammarParser.MultiplicativeExpressionContext ctx) {
        if (ctx.unaryExpression().size() == 1) {
            return visit(ctx.unaryExpression(0));
        }
        
        ASTNode leftNode = visit(ctx.unaryExpression(0));
        
        for (int i = 1; i < ctx.unaryExpression().size(); i++) {
            String operator = ctx.getChild(2*i-1).getText(); // *, /, %
            ASTNode rightNode = visit(ctx.unaryExpression(i));
            
            ASTNode opNode = new ASTNode("BINARY_OP", operator);
            opNode.addChild(leftNode);
            opNode.addChild(rightNode);
            leftNode = opNode;
        }
        
        return leftNode;
    }
    
    @Override
    public ASTNode visitPrimaryExpression(CPPGrammarParser.PrimaryExpressionContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return new ASTNode("IDENTIFIER", ctx.IDENTIFIER().getText());
        } else if (ctx.INTEGER() != null) {
            return new ASTNode("INTEGER_LITERAL", ctx.INTEGER().getText());
        } else if (ctx.CHAR_LITERAL() != null) {
            return new ASTNode("CHAR_LITERAL", ctx.CHAR_LITERAL().getText());
        } else if (ctx.DOUBLE_LITERAL() != null) {
            return new ASTNode("DOUBLE_LITERAL", ctx.DOUBLE_LITERAL().getText());
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        }
        
        return null;
    }
    
    @Override
    public ASTNode visitFunctionCall(CPPGrammarParser.FunctionCallContext ctx) {
        ASTNode callNode = new ASTNode("FUNCTION_CALL", ctx.IDENTIFIER().getText());
        
        if (ctx.argumentList() != null) {
            ASTNode argsNode = visit(ctx.argumentList());
            callNode.addChild(argsNode);
        }
        
        return callNode;
    }
    
    @Override
    public ASTNode visitArgumentList(CPPGrammarParser.ArgumentListContext ctx) {
        ASTNode argListNode = new ASTNode("ARGUMENT_LIST", null);
        
        for (CPPGrammarParser.ExpressionContext expr : ctx.expression()) {
            ASTNode argNode = visit(expr);
            argListNode.addChild(argNode);
        }
        
        return argListNode;
    }
}