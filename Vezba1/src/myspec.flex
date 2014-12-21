// USER CODE AND IMPORT SECTION
import java_cup.runtime.*;

%%
// OPTIONS AND DECLARATIONS SECTIONS

// Class name for lexical analyzer
%class      MyLexer

// Function name for token extraction function, with %type return type
// %implements java_cup.runtime.Scanner
// %function   next_token
// %type       java_cup.runtime.Symbol

// CUP compatibility setting
%cup

// %line directive enables line counting (yyline variable)
%line

// %column directive enables char counter in current line (yycolumn)
%column

%eofval{
    // Once end-of-file kicks in, this is the code to call
    return new Symbol(sym.EOF);
%eofval}

%{
   public int getLine()
   {
      return yyline;
   }
%}

// This directive adds "//comment" state to the state machine
%x  COMMENT

// Macros can be defined to be added in-place where they are needed
letter = [a-zA-Z]
digit  = [0-9]
hexDigit = [0-9a-fA-F]

%%
// LEXICAL RULES SECTION

// Commented sections
\/\/            { yybegin( COMMENT ); }
<COMMENT>\n     { yybegin( YYINITIAL ); }
<COMMENT>.      { ; }

[\t\r\n ]       { ; }


// Separators
\{      { return new Symbol(sym.LBPAR); }
\}      { return new Symbol(sym.RBPAR); }
\(      { return new Symbol(sym.LPAR); }
\)      { return new Symbol(sym.RPAR); }
=       { return new Symbol(sym.ASSIGN); }
;       { return new Symbol(sym.SEMICOLON); }
:       { return new Symbol(sym.COLON); }
,       { return new Symbol(sym.COMMA); }

// Bool values
true    { return new Symbol(sym.BOOLCONST); }
false   { return new Symbol(sym.BOOLCONST); }

// Arithmetic operators
\+      { return new Symbol(sym.PLUS); }
\-      { return new Symbol(sym.MINUS); }
\*      { return new Symbol(sym.ASTER); }
\/      { return new Symbol(sym.FSLASH); }

// Logical operators
&&      { return new Symbol(sym.AND); }
\|\|    { return new Symbol(sym.OR); }

// Relational operators
\<       { return new Symbol(sym.LT); }
\<=      { return new Symbol(sym.LTE); }
==       { return new Symbol(sym.EQ); }
\!=      { return new Symbol(sym.NEQ); }
\>       { return new Symbol(sym.GT); }
\>=      { return new Symbol(sym.GTE); }

// Keywords
"main"  { return new Symbol(sym.MAIN); }
"int"  { return new Symbol(sym.INT); }
"char"  { return new Symbol(sym.CHAR); }
"real"  { return new Symbol(sym.REAL); }
"bool"  { return new Symbol(sym.BOOL); }
"read"  { return new Symbol(sym.READ); }
"write"  { return new Symbol(sym.WRITE); }
"while"  { return new Symbol(sym.WHILE); }


// Identifiers
({letter}|_)({letter}|{digit}|_)*   { return new Symbol(sym.ID, yyline, yytext()); }

// Constants 
\${hexDigit}+                   { return new Symbol(sym.INTCONST, Integer.parseInt(yytext().substring(1), 16)); }
{digit}+                        { return new Symbol(sym.INTCONST, new Integer(yytext())); }
'[^]'                           { return new Symbol(sym.CHARCONST, new Character(yytext().charAt(1))); }
0\.{digit}+(E[\+\-]?{digit}+)?  { return new Symbol(sym.REALCONST, new Double(yytext())); }

// Error symbol
.                               { if (yytext() != null && yytext().length() > 0) 
                                      System.out.println("ERROR: " + yytext()); }
