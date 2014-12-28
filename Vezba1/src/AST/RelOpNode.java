/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST;

/**
 *
 * @author FallenShard
 */
public class RelOpNode extends BinaryExprNode
{
	private final String relOp;
    
	public RelOpNode(ExprNode left, ExprNode right, String relOp)
	{
		super(left, right);
        
        this.relOp = relOp;
	}
	
    @Override
	protected String opCode()
	{
		return relOp;
	}
}
