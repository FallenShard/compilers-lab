// USER CODE AND IMPORT SECTION

%%
// OPTIONS AND DECLARATIONS SECTIONS

// Class name for lexical analyzer
%class      MyLexer

// Function name for token extraction function, with %type return type
%function   nextToken
%type       MyToken

// %line directive enables line counting (yyline variable)
%line

// %column directive enables char counter in current line (yycolumn)
%column

// %debug enables output of all tokens, %standalone only unknown tokens
%standalone

// Code that gets added to the class (MyLexer class)
%{
    // Add the keyword tables
    MyTable myTable = new MyTable();

    // Add a method to access the keyword
    MyToken getKeyword()
    {
        return new MyToken( myTable.find( yytext() ),
        yytext(), yyline, yycolumn );
    }
%}

%eofval{
    // Once end-of-file kicks in, this is the code to call
    return new MyToken( MySym.EOF, null, yyline, yycolumn);
%eofval}

// This directive adds initial states to the state machine
%state  COMMENT

// Macros can be defined to be added in-place where they are needed
letter = [a-zA-Z]
digit  = [0-9]
hexDigit = [0-9a-fA-F]

%%
// LEXICAL RULES SECTION

// Commented sections
\/\/            { yybegin( COMMENT ); }
<COMMENT>\n     { yybegin( YYINITIAL ); }
// NOT USED <COMMENT>.   { ; }
[\t\n\r ]       { ; }

// Separators
\{      { return new MyToken(MySym.LBPAR,       yytext(), yyline, yycolumn); }
\}      { return new MyToken(MySym.RBPAR,       yytext(), yyline, yycolumn); }
\(      { return new MyToken(MySym.LPAR,        yytext(), yyline, yycolumn); }
\)      { return new MyToken(MySym.RPAR,        yytext(), yyline, yycolumn); }
=       { return new MyToken(MySym.ASSIGN,      yytext(), yyline, yycolumn); }
;       { return new MyToken(MySym.SEMICOLON,   yytext(), yyline, yycolumn); }
:       { return new MyToken(MySym.COLON,       yytext(), yyline, yycolumn); }
,       { return new MyToken(MySym.COMMA,       yytext(), yyline, yycolumn); }

// Bool values
true    { return new MyToken(MySym.TRUE,        yytext(), yyline, yycolumn); }
false   { return new MyToken(MySym.FALSE,       yytext(), yyline, yycolumn); }

// Arithmetic operators
\+      { return new MyToken(MySym.ADD,   yytext(), yyline, yycolumn); }
\-      { return new MyToken(MySym.SUB,   yytext(), yyline, yycolumn); }
\*      { return new MyToken(MySym.MUL,   yytext(), yyline, yycolumn); }
\/      { return new MyToken(MySym.DIV,   yytext(), yyline, yycolumn); }

// Logical operators
&&      { return new MyToken(MySym.AND,   yytext(), yyline, yycolumn); }
\|\|    { return new MyToken(MySym.OR,    yytext(), yyline, yycolumn); }

// Relational operators
\<       { return new MyToken(MySym.LT,  yytext(), yyline, yycolumn); }
\<=      { return new MyToken(MySym.LTE, yytext(), yyline, yycolumn); }
==       { return new MyToken(MySym.EQ,  yytext(), yyline, yycolumn); }
\!=      { return new MyToken(MySym.NEQ, yytext(), yyline, yycolumn); }
\>       { return new MyToken(MySym.GT,  yytext(), yyline, yycolumn); }
\>=      { return new MyToken(MySym.GTE, yytext(), yyline, yycolumn); }

// Key words
{letter}+    { return getKeyword(); }

// Identifiers
{letter}({letter}|{digit}|_)*   { return new MyToken(MySym.ID, yytext(),yyline, yycolumn); }

// Constants
\${hexDigit}+                   { return new MyToken(MySym.CONST, yytext(), yyline, yycolumn); }
{digit}+                        { return new MyToken(MySym.CONST, yytext(), yyline, yycolumn); }
'[^]'                           { return new MyToken(MySym.CONST, yytext(), yyline, yycolumn); }
0\.{digit}+(E[\+\-]?{digit}+)?  { return new MyToken(MySym.CONST, yytext(), yyline, yycolumn); }

// Error symbol
.                               { if (yytext() != null && yytext().length() > 0) 
                                      System.out.println("ERROR: " + yytext()); }
