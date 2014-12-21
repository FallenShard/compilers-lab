
import java.util.Hashtable;
import java.util.Map;

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
    
    public SymbolTable()
    {
        types = new TypeNode("unknown", TypeNode.Unknown, null);
        types = new TypeNode("real", TypeNode.Real, types);
        types = new TypeNode("char", TypeNode.Char, types);
        types = new TypeNode("bool", TypeNode.Bool, types);
        types = new TypeNode("int", TypeNode.Int, types);
        
        vars = null;
    }
    
    public boolean addVar(String name, TypeNode type)
    {
        VarNode existing = getVar(name);
        if (existing != null)
            return false;
        
        vars = new VarNode(name, type, vars);
        return true;
    }
    
    public VarNode getVar(String name)
    {
        SymbolNode current = vars;
        while (current != null && current.name.compareTo(name) != 0)
            current = current.next;
        
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
}
