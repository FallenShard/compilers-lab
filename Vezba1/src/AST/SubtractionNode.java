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
public class SubtractionNode extends BinaryExprNode
{
	
	public SubtractionNode(ExprNode left, ExprNode right)
	{
		super(left, right);
	}
	
    @Override
	protected String opCode()
	{
		return "Sub";
	}
}
