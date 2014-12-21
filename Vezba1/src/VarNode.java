/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FallenShard
 */
public class VarNode extends SymbolNode
{
    public int lastDef;
    public int lastUse;
    
    public VarNode(String name, TypeNode type, SymbolNode next)
    {
        super(name, SymbolNode.VAR, type, next);
        lastDef = -1;
        lastUse = -1;
    }
}
