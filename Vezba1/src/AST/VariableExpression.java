package AST;
import java.io.*;

import SymbolTable.VarNode;

public class VariableExpression 
extends Expression {
	private VarNode targetVar;
	
	public VariableExpression( VarNode var )
	{
		targetVar = var;
	}
	
	public void translate( BufferedWriter out )
	throws IOException
	{
		this.result = targetVar.name;
	}
}
