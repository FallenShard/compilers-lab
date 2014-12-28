package SymbolTable;


import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FallenShard
 */
public class TypeNode extends SymbolNode
{
    public static final int Int = 0;
    public static final int Char = 1;
    public static final int Bool = 2;
    public static final int Real = 3;
    public static final int Unknown = 4;
    
    public int typeKind;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public TypeNode(String name, int tKind, SymbolNode next)
    {
        super(name, SymbolNode.TYPE, null, next);
        typeKind = tKind;
        type = this;
    }
}
