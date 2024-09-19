package analisisLexico;

import static analisisLexico.Tokens.*;

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
LISTA= "lista"
MATRIZ = "matriz"
MOSTRAR = "Mostrar"
MODIFICAR = "Modificar"
PINTAR= "Pintar"
ASIGNAR = "Asignar"
ELIMINAR = "Eliminar"
AGREGAR = "Agregar"
REMOVER = "Remover"
EN = "en"
COLOR = "color"
VACIAR = "Vaciar"
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
%%

// Definiciones de reglas para reconocer los lexemas
{ESPACIO} { /* Ignorar espacios en blanco */ }
//Palabras clave
{CREAR} {
    lexeme = yytext();
    return CREAR;
}
{ASIGNAR} {
    lexeme = yytext();
    return ASIGNAR;
}
{MODIFICAR} {
    lexeme = yytext();
    return MODIFICAR;
}
{ELIMINAR} {
    lexeme = yytext();
    return ELIMINAR;
}
{AGREGAR} {
    lexeme = yytext();
    return AGREGAR;
}
{REMOVER} {
    lexeme = yytext();
    return REMOVER;
}
{PINTAR} {
    lexeme = yytext();
    return PINTAR;
}
{MOSTRAR} {
    lexeme = yytext();
    return MOSTRAR;
}
{VACIAR} {
    lexeme = yytext();
    return VACIAR;
}
{VALOR} | {NUEVOVALOR} | {INDICE} {
    lexeme = yytext();
    return DIGITO;
}
{COLOR} {
    lexeme = yytext();
    return COLOR;
}
{A} {
    lexeme = yytext();
    return A;
}
{EN} {
    lexeme = yytext();
    return EN;
}
{ARRAY} {
    lexeme = yytext();
    return ARRAY;
}
{LISTA} {
    lexeme = yytext();
    return LISTA;
}
{MATRIZ} {
    lexeme = yytext();
    return MATRIZ;
}
//Indetificadores
{IDENTIFICADOR} {
    lexeme = yytext();
    return IDENTIFICADOR;
}
//Simbolos y digitos
{CORCHETEA} {
    lexeme = yytext();
    return CORCHETEA;
}
{CORCHETEC} {
    lexeme = yytext();
    return CORCHETEC;
}
{FINAL} {
    lexeme = yytext();
    return FINAL;
}
{INDICEMATRIZ} {
    lexeme = yytext();
    return INDICE_MATRIZ;
}
 . {return ERROR;}
