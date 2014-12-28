package AST;


import java.io.*;

public abstract class ASTNode
{
    // Number of temp variables
	private static int varNo;
	
	// Number of created labels
	private static int labNo;
	
	public static String genVar()
	{
		// This variable should be written into the symbol table
		return "$tmp" + varNo++;
	}
	
	public static String genLab()
	{
		return "lab" + labNo++;
	}
	
	public abstract void translate(BufferedWriter out) throws IOException;
}
