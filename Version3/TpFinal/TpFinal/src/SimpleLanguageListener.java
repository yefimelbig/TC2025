// Generated from SimpleLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLanguageParser}.
 */
public interface SimpleLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLanguageParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SimpleLanguageParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLanguageParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SimpleLanguageParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link SimpleLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleLanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link SimpleLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleLanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link SimpleLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(SimpleLanguageParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link SimpleLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(SimpleLanguageParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalCondition}
	 * labeled alternative in {@link SimpleLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterRelationalCondition(SimpleLanguageParser.RelationalConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalCondition}
	 * labeled alternative in {@link SimpleLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitRelationalCondition(SimpleLanguageParser.RelationalConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueCondition}
	 * labeled alternative in {@link SimpleLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterTrueCondition(SimpleLanguageParser.TrueConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueCondition}
	 * labeled alternative in {@link SimpleLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitTrueCondition(SimpleLanguageParser.TrueConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseCondition}
	 * labeled alternative in {@link SimpleLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterFalseCondition(SimpleLanguageParser.FalseConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseCondition}
	 * labeled alternative in {@link SimpleLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitFalseCondition(SimpleLanguageParser.FalseConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermExpression}
	 * labeled alternative in {@link SimpleLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTermExpression(SimpleLanguageParser.TermExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermExpression}
	 * labeled alternative in {@link SimpleLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTermExpression(SimpleLanguageParser.TermExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpression}
	 * labeled alternative in {@link SimpleLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(SimpleLanguageParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpression}
	 * labeled alternative in {@link SimpleLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(SimpleLanguageParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplyTerm}
	 * labeled alternative in {@link SimpleLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyTerm(SimpleLanguageParser.MultiplyTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplyTerm}
	 * labeled alternative in {@link SimpleLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyTerm(SimpleLanguageParser.MultiplyTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorTerm}
	 * labeled alternative in {@link SimpleLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFactorTerm(SimpleLanguageParser.FactorTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorTerm}
	 * labeled alternative in {@link SimpleLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFactorTerm(SimpleLanguageParser.FactorTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdFactor}
	 * labeled alternative in {@link SimpleLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterIdFactor(SimpleLanguageParser.IdFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdFactor}
	 * labeled alternative in {@link SimpleLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitIdFactor(SimpleLanguageParser.IdFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumFactor}
	 * labeled alternative in {@link SimpleLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterNumFactor(SimpleLanguageParser.NumFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumFactor}
	 * labeled alternative in {@link SimpleLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitNumFactor(SimpleLanguageParser.NumFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenFactor}
	 * labeled alternative in {@link SimpleLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterParenFactor(SimpleLanguageParser.ParenFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenFactor}
	 * labeled alternative in {@link SimpleLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitParenFactor(SimpleLanguageParser.ParenFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimpleLanguageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimpleLanguageParser.AssignmentContext ctx);
}