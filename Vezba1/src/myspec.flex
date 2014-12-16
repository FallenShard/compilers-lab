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

[\t\n\r ]       { ; }

// Separators
\{      { return new Symbol(MySym.LBPAR); }
\}      { return new Symbol(MySym.RBPAR); }
\(      { return new Symbol(sym.LPAR); }
\)      { return new Symbol(sym.RPAR); }
=       { return new Symbol(sym.ASSIGN); }
;       { return new Symbol(sym.SEMICOLON); }
:       { return new Symbol(MySym.COLON); }
,       { return new Symbol(MySym.COMMA); }

// Bool values
true    { return new Symbol(sym.CONST); }
false   { return new Symbol(sym.CONST); }

// Arithmetic operators
\+      { return new Symbol(sym.PLUS); }
\-      { return new Symbol(MySym.MINUS); }
\*      { return new Symbol(MySym.ASTER); }
\/      { return new Symbol(MySym.FSLASH); }

// Logical operators
&&      { return new Symbol(MySym.AND); }
\|\|    { return new Symbol(MySym.OR); }

// Relational operators
\<       { return new Symbol(MySym.LT); }
\<=      { return new Symbol(MySym.LTE); }
==       { return new Symbol(MySym.EQ); }
\!=      { return new Symbol(MySym.NEQ); }
\>       { return new Symbol(MySym.GT); }
\>=      { return new Symbol(MySym.GTE); }

// Key words
"while"  { return new Symbol(sym.WHILE); }

// Identifiers
({letter}|_)({letter}|{digit}|_)*   { return new Symbol(sym.ID); }

// Constants
\${hexDigit}+                   { return new Symbol(sym.CONST); }
{digit}+                        { return new Symbol(sym.CONST); }
'[^]'                           { return new Symbol(sym.CONST); }
0\.{digit}+(E[\+\-]?{digit}+)?  { return new Symbol(sym.CONST); }

// Error symbol
.                               { if (yytext() != null && yytext().length() > 0) 
                                      System.out.println("ERROR: " + yytext()); }
