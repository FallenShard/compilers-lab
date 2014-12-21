/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FallenShard
 */
public class SymbolNode
{
    public static final int TYPE = 0;
    public static final int VAR = 1;
    
    public String name;
    public int kind;
    public TypeNode type;
    public SymbolNode next;
    
    public SymbolNode(String sName, int sKind, TypeNode sType, SymbolNode sNext)
    {
        name = sName;
        kind = sKind;
        type = sType;
        next = sNext;
    }

    @Override
    public String toString()
    {
        return name + " - " + kind;
    }
}
