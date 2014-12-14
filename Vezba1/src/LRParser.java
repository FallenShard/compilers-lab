//
//import java.io.IOException;
//import java.util.Stack;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author FallenShard
// */
//public class LRParser
//{
//    Stack<Integer> m_stack = new Stack<>();
//    Stack<String> m_strStack = new Stack<>();
//    String next = null;
//    MyLexer m_lexer = null;
//    
//    boolean recognized = false;
//    boolean error = false;
//    
//    private int[][] m_table;
//    
//    private Rule[] rules;
//    
//    public class Rule
//    {
//        public int length;
//        public int leftSym;
//    }
//    
//    public static void main(String argv[])
//    {
//        if (argv.length == 0)
//        {
//            System.out.println("Usage : java MyLexer <inputfile>");
//        }
//        else 
//        {
//            for (int i = 0; i < argv.length; i++)
//            {
//                MyLexer scanner = null;
//                try
//                {
//                  scanner = new MyLexer( new java.io.FileReader(argv[i]) );
//
//                  LRParser parser = new LRParser(scanner);
//                  if (parser.analyze())
//                      System.out.println("SUCCESS!");
//                  else
//                      System.out.println("FAIL");
//
//                }
//                catch (java.io.FileNotFoundException e)
//                {
//                  System.out.println("File not found : \""+argv[i]+"\"");
//                }
//                catch (java.io.IOException e)
//                {
//                  System.out.println("IO error scanning file \""+argv[i]+"\"");
//                  System.out.println(e);
//                }
//                catch (Exception e)
//                {
//                  System.out.println("Unexpected exception:");
//                  e.printStackTrace();
//                }
//        }
//    }
//  }
//    
//    
//    public LRParser(MyLexer lexer)
//    {
//        m_lexer = lexer;
//        
//        // Init rules
//        rules = new Rule[7];
//        for (int i = 0; i < rules.length; i++)
//            rules[i] = new Rule();
//        
//        rules[1].length = 5;
//        rules[1].leftSym = WS;
//        
//        rules[2].length = 1;
//        rules[2].leftSym = ST;
//        
//        rules[3].length = 1;
//        rules[3].leftSym = ST;
//        
//        rules[4].length = 4;
//        rules[4].leftSym = AS;
//        
//        rules[5].length = 3;
//        rules[5].leftSym = EX;
//        
//        rules[6].length = 1;
//        rules[6].leftSym = EX;
//        
//        // Init syntax table
//        m_table = new int[NO_OF_CLOSURES][TOTAL_SYMBOLS];
//        for (int i = 0; i < NO_OF_CLOSURES; i++)
//            for (int j = 0; j < TOTAL_SYMBOLS; j++)
//                m_table[i][j] = ERR;
//        
//        m_table[S0][MySym.WHILE] = S + 2;
//        m_table[S0][WS] = G + 1;
//        
//        m_table[S1][MySym.EOF] = ACC;
//        
//        m_table[S2][MySym.LPAR] = S + 3;
//        
//        m_table[S3][MySym.ID] = S + 4;
//        
//        m_table[S4][MySym.RPAR] = S + 5;
//        
//        m_table[S5][MySym.WHILE] = S + 2;
//        m_table[S5][MySym.ID] = S + 9;
//        m_table[S5][WS] = G + 7;
//        m_table[S5][ST] = G + 6;
//        m_table[S5][AS] = G + 8;
//        
//        m_table[S6][MySym.RPAR] = R + 1;
//        m_table[S6][MySym.EOF] = R + 1;
//        
//        m_table[S7][MySym.RPAR] = R + 2;
//        m_table[S7][MySym.SEMICOLON] = R + 2;
//        m_table[S7][MySym.EOF] = R + 2;
//        
//        m_table[S8][MySym.RPAR] = R + 3;
//        m_table[S8][MySym.SEMICOLON] = R + 3;
//        m_table[S8][MySym.EOF] = R + 3;
//        
//        m_table[S9][MySym.ASSIGN] = S + 10;
//        
//        m_table[S10][MySym.CONST] = S + 15;
//        m_table[S10][EX] = G + 11;
//        
//        m_table[S11][MySym.SEMICOLON] = S + 12;
//        m_table[S11][MySym.PLUS] = S + 13;
//        
//        m_table[S12][MySym.RPAR] = R + 4;
//        m_table[S12][MySym.SEMICOLON] = R + 4;
//        m_table[S12][MySym.EOF] = R + 4;
//        
//        m_table[S13][MySym.CONST] = S + 14;
//
//        m_table[S14][MySym.SEMICOLON] = R + 5;
//        m_table[S14][MySym.PLUS] = R + 5;
//        
//        m_table[S15][MySym.SEMICOLON] = R + 6;
//        m_table[S15][MySym.PLUS] = R + 6;
//    }
//    
//    public boolean analyze() throws IOException
//    {
//        m_stack.clear();
//        m_stack.push(S0);
//        m_strStack.clear();
//        m_strStack.push("State " + S0);
//        recognized = false;
//        error = false;
//    
//        MyToken token = m_lexer.nextToken();
//        
//        do
//        {
//            int terminal = token.m_index;
//            int action = action(m_stack.peek(), terminal);
//            String topStr = m_strStack.peek();
//            System.out.println("topStr: " + topStr + " (" + action + ")");
//
//            switch (action)
//            {
//                case ACC:
//                {
//                    recognized = true;
//                    break;
//                }
//                case ERR:
//                {
//                    error = true;
//                    break;
//                }
//            }
//            
//            if (action >= R)
//            {
//                //m_stack.pop();
//                //m_strStack.pop();
//                for (int i = 0; i < 2 * rules[action - R].length; i++)
//                {
//                    m_stack.pop();
//                    m_strStack.pop();
//                }
//                    
//                int top = m_stack.peek();
//                m_stack.push(rules[action - R].leftSym);
//                m_stack.push(m_table[top][rules[action - R].leftSym] - 1500);
//                m_strStack.push("NONTERM: " + rules[action - R].leftSym);
//                m_strStack.push("STATE: " + (m_table[top][rules[action - R].leftSym] - 1500));
//                
//                int z = 5;
//            }
//            else if (action >= S)
//            {
//                m_stack.push(token.m_index);
//                m_stack.push(action - S);
//                m_strStack.push(token.m_text);
//                m_strStack.push("State " + (action - S));
//                
//                token = m_lexer.nextToken();
//            }
//
//        } while (!(recognized || error));
//        
//        return recognized;
//    }
//    
//    public int action(int state, int terminal)
//    {
//        return m_table[state][terminal];
//    }
//    
//    public static final int ERR = -1;
//    public static final int ACC =  1;
//    public static final int S = 500;
//    public static final int R = 1000;
//    public static final int G = 1500;
//
//    public static final int S0 = 0;
//    public static final int S1 = 1;
//    public static final int S2 = 2;
//    public static final int S3 = 3;
//    public static final int S4 = 4;
//    public static final int S5 = 5;
//    public static final int S6 = 6;
//    public static final int S7 = 7;
//    public static final int S8 = 8;
//    public static final int S9 = 9;
//    public static final int S10 = 10;
//    public static final int S11 = 11;
//    public static final int S12 = 12;
//    public static final int S13 = 13;
//    public static final int S14 = 14;
//    public static final int S15 = 15;
//    
//    public static final int NO_OF_CLOSURES = 16;
//
//    public static final int WS = 9;
//    public static final int ST = 10;
//    public static final int AS = 11;
//    public static final int EX = 12;
//    
//    public static final int TOTAL_SYMBOLS = 13;
//}
