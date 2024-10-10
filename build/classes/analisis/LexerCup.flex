package analisis;

import java_cup.runtime.Symbol;
%%
%class LexerCup
%unicode
%type java_cup.runtime.symbol
%cup
%full
%line
%char

// Definiciones de patrones regulares
L = [a-zA-Z_]
D = [0-9]
COMA = ","
CREAR = "Crear"
ARRAY = "array"
LISTA = "lista"
MATRIZ = "matriz"
MOSTRAR = "Mostrar"
MODIFICAR = "Modificar"
PINTAR = "Pintar"
ASIGNAR = "Asignar"
ELIMINAR = "Eliminar"
AGREGAR = "Agregar"
REMOVER = "Remover"
ULTIMO = "ultimo"
DE = "de"
EN = "en"
COLOR = "rojo" | "verde" | "azul"
VACIAR = "Vaciar"
A = "a"
IDENTIFICADOR = {L}({L}|{D})*
CORCHETEA = "["
CORCHETEC = "]"
ESPACIO = " "
DIGITO = {D}
INDICEMATRIZ = {D}{COMA}{D}
FINAL = ";"

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

//Palabras clave
{ESPACIO} {
    return new Symbol(sym.ESPACIO, yychar, yyline, yytext());
}
{CREAR} {
    return new Symbol(sym.CREAR, yychar, yyline, yytext());
}
{ASIGNAR} {
    return new Symbol(sym.ASIGNAR, yychar, yyline, yytext());
}
{MODIFICAR} {
    return new Symbol(sym.MODIFICAR, yychar, yyline, yytext());
}
{ELIMINAR} {
    return new Symbol(sym.ELIMINAR, yychar, yyline, yytext());
}
{AGREGAR} {
    return new Symbol(sym.AGREGAR, yychar, yyline, yytext());
}
{REMOVER} {
    return new Symbol(sym.REMOVER, yychar, yyline, yytext());
}
{ULTIMO} {
    return new Symbol(sym.ULTIMO, yychar, yyline, yytext());
}
{DE} {
    return new Symbol(sym.DE, yychar, yyline, yytext());
}
{PINTAR} {
    return new Symbol(sym.PINTAR, yychar, yyline, yytext());
}
{MOSTRAR} {
    return new Symbol(sym.MOSTRAR, yychar, yyline, yytext());
}
{VACIAR} {
    return new Symbol(sym.VACIAR, yychar, yyline, yytext());
}
{DIGITO} {
    return new Symbol(sym.DIGITO, yychar, yyline, yytext());
}
{COLOR} {
    return new Symbol(sym.COLOR, yychar, yyline, yytext());
}
{A} {
    return new Symbol(sym.A, yychar, yyline, yytext());
}
{EN} {
    return new Symbol(sym.EN, yychar, yyline, yytext());
}
{ARRAY} {
    return new Symbol(sym.ARRAY, yychar, yyline, yytext());
}
{LISTA} {
    return new Symbol(sym.LISTA, yychar, yyline, yytext());
}
{MATRIZ} {
    return new Symbol(sym.MATRIZ, yychar, yyline, yytext());
}
//Indetificadores
{IDENTIFICADOR} {
    return new Symbol(sym.IDENTIFICADOR, yychar, yyline, yytext());
}
//Simbolos y digitos
{CORCHETEA} {
    return new Symbol(sym.CORCHETEA, yychar, yyline, yytext());
}
{CORCHETEC} {
    return new Symbol(sym.CORCHETEC, yychar, yyline, yytext());
}
{FINAL} {
    return new Symbol(sym.FINAL, yychar, yyline, yytext());
}
{INDICEMATRIZ} {
    return new Symbol(sym.INDICE_MATRIZ, yychar, yyline, yytext());
}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
