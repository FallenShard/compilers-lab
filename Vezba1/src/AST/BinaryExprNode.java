package AST;

import java.io.*;


public abstract class BinaryExprNode extends ExprNode
{
	private final ExprNode left;
	private final ExprNode right;
	
	public BinaryExprNode(ExprNode l,ExprNode r)
	{
		left = l;
		right = r;
	}
	
	protected abstract String opCode();
	
    @Override
	public void translate(BufferedWriter out) throws IOException
	{
		left.translate(out);
		right.translate(out);
		left.genLoad("R1", out);
		right.genLoad("R2", out);
        out.write(String.format("\t%-15s %s, %s" , opCode(), "R1", "R2"));
		out.newLine();
		this.result = ASTNode.genVar();
		out.write("\tStore\t\tR1, " + this.result);
		out.newLine();
	}	
}



