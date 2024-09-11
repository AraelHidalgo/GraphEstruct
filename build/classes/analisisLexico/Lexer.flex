package codigo;

import static codigo.Tokens.*;

%%
%class Lexer
%unicode
%type Tokens
%{
    public String lexeme;
%}

// Definiciones de patrones regulares
L = [a-zA-Z_]
D = [0-9]
COMA = ","
CREAR = "Crear"
ARRAY = "array"
MOSTRAR = "Mostrar"
MODIFICAR = "Modificar"
PINTAR= "pintar"
ASIGNAR = "Asignar"
ELIMINAR = "Eliminar"
EN = "en"
COLOR = "color"
VACIAR = "vaciar"
A = "a"
IDENTIFICADOR = {L}({L}|{D})*
CORCHETEA = "["
CORCHETEC = "]"
ESPACIO = [ ]
INDICE = {D}
VALOR = {D}
NUEVOVALOR = {D}
INDICEMATRIZ = {D}{COMA}{D}
FINAL = ";"
1
%%

// Definiciones de reglas para reconocer los lexemas
{ESPACIO} { /* Ignorar espacios en blanco */ }
{CREAR}{ESPACIO}{ARRAY}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICE}{CORCHETEC}{FINAL} {
    lexeme = yytext();
    return new Symbol(sym.CREAR_ARRAY);
}
{CREAR}{ESPACIO}{ARRAY}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICEMATRIZ}{CORCHETEC}{FINAL} { 
    lexeme = yytext(); 
    return new Symbol(sym.CREAR_MATRIZ); 
}
{CREAR}{ESPACIO}{LISTA}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICE}{CORCHETEC}{FINAL} {
    lexeme = yytext();
    return new Symbol(sym.CREAR_LISTA);
}
{ASIGNAR}{ESPACIO}{VALOR}{ESPACIO}{A}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICE}{CORCHETEC}{FINAL} {
    lexeme = yytext();
    return new Symbol(sym.ASIGNAR);
}
{MODIFICAR}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICE}{CORCHETEC}{ESPACIO}{A}{ESPACIO}{NUEVOVALOR} {
    lexeme = yytext();
    return new Symbol(sym.MODIFICAR)
}
{MODIFICAR}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICEMATRIZ}{CORCHETEC}{ESPACIO}{A}{ESPACIO}{NUEVOVALOR} {
    lexeme = yytext();
    return new Symbol(sym.MODIFICAR_MATRIZ)
}
{ELIMINAR}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICE}{CORCHETEC}{FINAL}{
    lexeme = yytext();
    return new Symbol(sym.ELIMINAR)
}
{ELIMINAR}{ESPACIO}{IDENTIFICADOR}{CORCHETEA}{INDICEMATRIZ}{CORCHETEC}{FINAL}{
    lexeme = yytext();
    return new Symbol(sym.ELIMINAR_MATRIZ)
}
{MOSTRAR}{ESPACIO}{IDENTIFICADOR}{FINAL}{
    lexeme = yytext();
    return new Symbol(sym.MOSTRAR);
}
{PINTAR}{ESPACIO}{COLOR}{ESPACIO}{EN}{ESPACIO}{IDENTIFICADOR}{CORCHETEA }{INDICE}{CORCHETEC}{FINAL} { 
    lexeme = yytext(); 
    return new Symbol(sym.PINTAR);
}
{VACIAR}{ESPACIO}{IDENTIFICADOR}{FINAL} { 
    lexeme = yytext(); 
    return new Symbol(sym.VACIAR);
}
