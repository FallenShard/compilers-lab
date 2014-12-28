package AST;



import java.io.*;

import SymbolTable.ConstNode;

public class ConstExprNode extends ExprNode
{
	private final ConstNode targetConst;
	
	public ConstExprNode(ConstNode c)
	{
		targetConst = c;
	}
	
    @Override
	public void translate(BufferedWriter out) throws IOException
	{
		result = targetConst.value.toString();
	}
	
    @Override
	protected void genLoad(String reg, BufferedWriter out) throws IOException
	{
		out.write("\tLoad_Const\t" + reg + ", " + result);
		out.newLine();
	}
}
