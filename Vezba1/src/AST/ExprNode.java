package AST;
import java.io.*;


public abstract class ExprNode extends ASTNode
{	
	protected String result;
	
	protected void genLoad(String reg, BufferedWriter out) throws IOException
	{
        out.write(String.format("\t%-15s %s, %s" , "Load_Mem", reg, result));
		out.newLine();
	}
}

