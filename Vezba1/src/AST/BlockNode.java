package AST;


import java.io.*;
import java.util.ArrayList;

public class BlockNode extends StatementNode
{
	private final ArrayList<StatementNode> statements = new ArrayList();
	
	public void addStatement(StatementNode newStatement)
	{
		statements.add(newStatement);
	}
	
    @Override
	public void translate(BufferedWriter out) throws IOException
	{
        for (StatementNode statement : statements)
        {
            statement.translate(out);
        }
	}
}


