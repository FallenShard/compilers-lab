package AST;

public class MultiplicationNode extends BinaryExprNode
{
	
	public MultiplicationNode(ExprNode left, ExprNode right)
	{
		super(left, right);
	}
	
    @Override
	protected String opCode()
	{
		return "Mul";
	}
}
