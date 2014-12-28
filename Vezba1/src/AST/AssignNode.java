package AST;

import java.io.BufferedWriter;
import java.io.IOException;

import SymbolTable.VarNode;

public class AssignNode extends StatementNode
{
	private final VarNode left;
	private final ExprNode right;
	
	public AssignNode(VarNode var, ExprNode e)
	{
		left = var;
		right = e;
	}
	
    @Override
	public void translate(BufferedWriter out) throws IOException 
	{
		right.translate(out);
		right.genLoad("R1", out);
		out.write("\tStore\t\tR1, " + left.name);
		out.newLine();
	}
}
