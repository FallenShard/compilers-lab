/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FallenShard
 */
public class MySym
{
    // EOF
    public final static int EOF = 0;
    
    // KEY WORDS
    // Reserved functions
	public final static int MAIN = 1;
    public final static int READ = 20;
	public final static int WRITE = 21;
    
    // Separators
    // Block separators
    public final static int LBPAR = 50;
    public final static int RBPAR = 51;
    
    // Expression separators
	public final static int LPAR = 52;
	public final static int RPAR = 53;
    
    // Expression assignment
	public final static int ASSIGN = 60;
    
    // Statement separator
	public final static int SEMICOLON = 61;
    
    // Type declaration separator
    public final static int COLON = 62;
    
    // Namelist separator
	public final static int COMMA = 63;

    // Other keywords
    public final static int ID    = 100;
    public final static int CONST = 101;
    
    // Special values (bool)
    public final static int TRUE  = 110;
    public final static int FALSE = 111;
    
    // Types
	public final static int INT = 200;
    public final static int CHAR = 201;
    public final static int REAL = 202;
	public final static int BOOL = 203;
    
    // Block control
    public final static int WHILE = 220;
	
    // Arithmetic operators
    public final static int ADD = 300;
    public final static int SUB = 301;
    public final static int MUL = 302;
    public final static int DIV = 303;
    
    // Relational operators
    public final static int LT  = 350;
    public final static int LTE = 351;
    public final static int EQ  = 352;
    public final static int NEQ = 353;
    public final static int GT  = 354;
    public final static int GTE = 355;
    
    // Logical operators
    public final static int AND = 360;
    public final static int OR  = 361;
}
