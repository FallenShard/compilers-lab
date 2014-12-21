/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FallenShard
 */
public class ConstNode
{
    public TypeNode type;
    public Object value;
    
    public ConstNode(TypeNode cType, Object val)
    {
        type = cType;
        value = val;
    }
}
