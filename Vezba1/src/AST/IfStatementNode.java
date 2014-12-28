package AST;

import java.io.*;


public class IfStatementNode extends StatementNode
{
	private StatementNode thenStatement;
	private StatementNode elseStatement;
	private ExprNode condition;
	
	public IfStatementNode(ExprNode e, StatementNode thenS, StatementNode elseS)
	{
		condition = e;
		thenStatement = thenS;
		elseStatement = elseS;
	}
	
    @Override
	public void translate(BufferedWriter out) throws IOException
	{
		condition.translate(out);
		condition.genLoad("R1", out);
		String elseLabel = ASTNode.genLab();
		String endLabel = ASTNode.genLab();
		out.write("\tJumpIfZero\tR1, " + elseLabel);
		out.newLine();
		thenStatement.translate(out);
		out.write("\tJump\t" + endLabel);
		out.newLine();
		out.write(elseLabel + ":");
		out.newLine();
		elseStatement.translate(out);
		out.write(endLabel + ":");
		out.newLine();
	}
}


