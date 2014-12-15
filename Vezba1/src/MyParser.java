
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Tue Dec 16 00:00:07 CET 2014
//----------------------------------------------------

import java_cup.runtime.*;
import java.io.*;

/** CUP v0.10k generated parser.
  * @version Tue Dec 16 00:00:07 CET 2014
  */
public class MyParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public MyParser() {super();}

  /** Constructor which sets the default scanner. */
  public MyParser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\007\000\002\003\007\000\002\002\004\000\002\004" +
    "\003\000\002\004\003\000\002\005\006\000\002\006\005" +
    "\000\002\006\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\004\004\001\002\000\004\005\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\000\001\002" +
    "\000\004\006\010\001\002\000\004\007\011\001\002\000" +
    "\006\004\004\006\012\001\002\000\004\010\016\001\002" +
    "\000\004\002\001\001\002\000\004\002\ufffe\001\002\000" +
    "\004\002\uffff\001\002\000\004\013\017\001\002\000\006" +
    "\011\ufffb\012\ufffb\001\002\000\006\011\021\012\022\001" +
    "\002\000\004\002\ufffd\001\002\000\004\013\023\001\002" +
    "\000\006\011\ufffc\012\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\003\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\003\014\004\012\005\013\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\006\017\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$MyParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$MyParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$MyParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public int errNo = 0;

   public static void main( String[] args )
   {
      try
	  {
		   FileReader file = new FileReader( args[0] );
		   Scanner scanner = new MyLexer( file );
		   MyParser parser = new MyParser( scanner );
		   parser.parse();
           
           if ( parser.errNo == 0 )
		      System.out.println("\u001B[32m" + "Analiza zavrsena. U kodu nema gresaka." );
		   else
		      System.out.println("\u001B[31m" + "Analiza zavrsena. Broj gresaka: " + parser.errNo );
	  }
	  catch( Exception e )
	  {
		   System.out.println(e);
	  }
   }
   
   public void syntax_error(Symbol cur_token)
   {
   	  
   }
   
   public void report_error(String message, Object info)
   {
   	   System.out.print("\u001B[31m" + message );
   }
   
   public int getLine()
   {
   	  return ((MyLexer) getScanner()).getLine();
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$MyParser$actions {
  private final MyParser parser;

  /** Constructor */
  CUP$MyParser$actions(MyParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$MyParser$do_action(
    int                        CUP$MyParser$act_num,
    java_cup.runtime.lr_parser CUP$MyParser$parser,
    java.util.Stack            CUP$MyParser$stack,
    int                        CUP$MyParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$MyParser$result;

      /* select the action based on the action number */
      switch (CUP$MyParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Expression ::= CONST 
            {
              Object RESULT = null;
		
                System.out.println("\u001B[34m" + "Redukcija po smeni 6." );
               
              CUP$MyParser$result = new java_cup.runtime.Symbol(4/*Expression*/, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).right, RESULT);
            }
          return CUP$MyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Expression ::= Expression PLUS CONST 
            {
              Object RESULT = null;
		
                System.out.println("\u001B[34m" + "Redukcija po smeni 5." );
               
              CUP$MyParser$result = new java_cup.runtime.Symbol(4/*Expression*/, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).right, RESULT);
            }
          return CUP$MyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Assignment ::= ID ASSIGN Expression SEMICOLON 
            {
              Object RESULT = null;
		
                System.out.println("\u001B[34m" + "Redukcija po smeni 4." );
               
              CUP$MyParser$result = new java_cup.runtime.Symbol(3/*Assignment*/, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).right, RESULT);
            }
          return CUP$MyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Statement ::= Assignment 
            {
              Object RESULT = null;
		
                System.out.println("\u001B[34m" + "Redukcija po smeni 3.");
              
              CUP$MyParser$result = new java_cup.runtime.Symbol(2/*Statement*/, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).right, RESULT);
            }
          return CUP$MyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Statement ::= WhileStatement 
            {
              Object RESULT = null;
		
                System.out.println("\u001B[34m" + "Redukcija po smeni 2.");
              
              CUP$MyParser$result = new java_cup.runtime.Symbol(2/*Statement*/, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).right, RESULT);
            }
          return CUP$MyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= WhileStatement EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$MyParser$stack.elementAt(CUP$MyParser$top-1)).value;
		RESULT = start_val;
              CUP$MyParser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$MyParser$parser.done_parsing();
          return CUP$MyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // WhileStatement ::= WHILE LPAR ID RPAR Statement 
            {
              Object RESULT = null;
		
                      System.out.println("\u001B[34m" + "Redukcija po smeni 1.");
                   
              CUP$MyParser$result = new java_cup.runtime.Symbol(1/*WhileStatement*/, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-4)).left, ((java_cup.runtime.Symbol)CUP$MyParser$stack.elementAt(CUP$MyParser$top-0)).right, RESULT);
            }
          return CUP$MyParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

