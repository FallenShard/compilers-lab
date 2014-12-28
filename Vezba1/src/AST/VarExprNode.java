package AST;
import java.io.*;

import SymbolTable.VarNode;

public class VarExprNode extends ExprNode
{
	private final VarNode targetVar;
	
	public VarExprNode(VarNode var)
	{
		targetVar = var;
	}
	
    @Override
	public void translate(BufferedWriter out) throws IOException
	{
		result = targetVar.name;
	}
}
