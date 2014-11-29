// USER CODE AND IMPORT SECTION

%%
// OPTIONS AND DECLARATIONS SECTIONS

// Class name for lexical analyzer
%class      MPLexer

// Function name for token extraction function, with %type return type
%function   next_token
%type       Yytoken

// %line directive enables line counting (yyline variable)
%line

// %column directive enables char counter in current line (yycolumn)
%column

// %debug enables output of all tokens, %standalone only unknown tokens
%standalone

// Code that gets added to the class (MPLexer class)
%{
    // Add the keyword tables
    KWTable kwTable = new KWTable();

    // Add a method to access the keyword
    Yytoken getKW()
    {
        return new Yytoken( kwTable.find( yytext() ),
        yytext(), yyline, yycolumn );
    }
%}

%eofval{
    // Once end-of-file kicks in, this is the code to call
    return new Yytoken( sym.EOF, null, yyline, yycolumn);
%eofval}

// This directive adds initial states to the state machine
%state  COMMENT

// Macros can be defined to be added in-place where they are needed
slovo = [a-zA-Z]
cifra = [0-9]

%%
// LEXICAL RULES SECTION

// Commented sections
\(\*            { yybegin( COMMENT ); }
<COMMENT>\*\)   { yybegin( YYINITIAL ); }
<COMMENT>.      { ; }
[\t\n\r ]       { ; }

// Parentheses 
\(      { return new Yytoken( sym.LEFTPAR,  yytext(), yyline, yycolumn ); }
\)      { return new Yytoken( sym.RIGHTPAR, yytext(), yyline, yycolumn ); }

// Operators
\+      { return new Yytoken( sym.PLUS, yytext(), yyline, yycolumn ); }
\*      { return new Yytoken( sym.MUL,  yytext(), yyline, yycolumn ); }

// Separators
;       { return new Yytoken( sym.DOTCOMMA, yytext(), yyline, yycolumn ); }
,       { return new Yytoken( sym.COMMA,    yytext(), yyline, yycolumn ); }
\.      { return new Yytoken( sym.DOT,      yytext(), yyline, yycolumn ); }
:=      { return new Yytoken( sym.ASSIGN,   yytext(), yyline, yycolumn ); }

// Key words
{slovo}+    { return getKW(); }

// Identifiers
{slovo}({slovo}|{cifra})*   { return new Yytoken(sym.ID, yytext(),yyline, yycolumn ); }

// Constants
{cifra}+                    { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
'[^]'                       { return new Yytoken( sym.CONST,yytext(), yyline, yycolumn ); }
// Error symbol
.                           { if (yytext() != null && yytext().length() > 0) 
                                  System.out.println( "ERROR: " + yytext() ); }
