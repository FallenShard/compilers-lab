
import java.util.Stack;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FallenShard
 */
public class SymbolTable
{
    private SymbolNode types;
    private SymbolNode vars;
    
    private int scopeIdCounter;
    public int activeScope;
    
    private Stack<Integer> scopeStack = new Stack<>();
    
    public boolean firstStatement = true;
    
    public SymbolTable()
    {
        types = new TypeNode("unknown", TypeNode.Unknown, null);
        types = new TypeNode("real", TypeNode.Real, types);
        types = new TypeNode("char", TypeNode.Char, types);
        types = new TypeNode("bool", TypeNode.Bool, types);
        types = new TypeNode("int", TypeNode.Int, types);
        
        scopeIdCounter = 0;
        activeScope = -1;
        vars = null;
    }
    
    public boolean addVar(String name, TypeNode type)
    {
        VarNode existing = getVar(name);
        if (existing != null && existing.scope == activeScope)
            return false;
        
        vars = new VarNode(name, type, vars, activeScope);
        return true;
    }
    
    public VarNode getVar(String name)
    {
        SymbolNode current = vars;
        while (current != null)
        {
            if (current.name.compareTo(name) == 0)
                break;
            else
                current = current.next;
        }

        return (VarNode)current;
    }
    
    public TypeNode getType(String typeName)
    {
        SymbolNode current = types;
        while (current != null && current.name.compareTo(typeName) != 0)
            current = current.next;
        return (TypeNode) current;
    }
    
    public SymbolNode getVariables()
    {
        return vars;
    }
    
    public void printAllVars()
    {
        SymbolNode current = vars;
        while (current != null)
        {
            System.out.println(((VarNode)current).toString());
            current = current.next;
        }
    }
    
    public void incrScope()
    {
        scopeStack.push(activeScope);
        activeScope = scopeIdCounter;
        scopeIdCounter++;
    }
    
    public void decrScope()
    {
        activeScope = scopeStack.pop();
    }
}
