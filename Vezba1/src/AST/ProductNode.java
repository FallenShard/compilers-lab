package AST;

public class ProductNode extends BinaryExprNode
{
	
	public ProductNode(ExprNode left, ExprNode right)
	{
		super(left, right);
	}
	
    @Override
	protected String opCode()
	{
		return "Mul";
	}
}
