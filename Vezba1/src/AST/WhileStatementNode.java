/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author FallenShard
 */
public class WhileStatementNode extends StatementNode
{
	private final ExprNode condition;
    private final StatementNode body;
	
	public WhileStatementNode(ExprNode e, StatementNode b)
	{
		condition = e;
		body = b;
	}

    @Override
    public void translate(BufferedWriter out) throws IOException
    {
		String loopLabel = ASTNode.genLab();
		String endLabel = ASTNode.genLab();
        
        // This is the label to jump back on in the loop
        out.newLine();
        out.write(loopLabel + ":");
        out.newLine();
        
        // While condition, if false (0), go to body
        condition.translate(out);
		condition.genLoad("R1", out);
        out.write(String.format("\t%-15s %s" , "JumpIfZero", endLabel));
		out.newLine();
        
        body.translate(out);
        out.write(String.format("\t%-15s %s" , "Jump", loopLabel));
        out.newLine();
    }
}
