/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import java.io.File;

/**
 *
 * @author araelhidalgojuarez
 */
public class EstructurasPseudocodigo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = "/Users/araelhidalgojuarez/NetBeansProjects/EstructurasPseudocodigo/src/Codigo/Lexer.flex";
        generarLexer(ruta);
        
    }
    
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
}
