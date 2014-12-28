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
        if (targetConst.value instanceof Boolean)
        {
            boolean b = (Boolean)targetConst.value;
            result = b ? "1" : "0";
        }
        else
            result = targetConst.value.toString();
	}
	
    @Override
	protected void genLoad(String reg, BufferedWriter out) throws IOException
	{
        out.write(String.format("\t%-15s %s, %s" , "Load_Const", reg, result));
		out.newLine();
	}
}
