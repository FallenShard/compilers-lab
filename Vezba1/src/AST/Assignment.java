package AST;

import java.io.BufferedWriter;
import java.io.IOException;

import SymbolTable.VarNode;

public class Assignment extends Statement {
	private VarNode left;
	private Expression right;
	
	public Assignment( VarNode var, Expression e )
	{
		left = var;
		right = e;
	}
	
	public void translate( BufferedWriter out )
	throws IOException 
	{
		right.translate( out );
		right.genLoad( "R1", out );
		out.write( "\tStore\t\tR1, " + left.name );
		out.newLine();
	}
}
