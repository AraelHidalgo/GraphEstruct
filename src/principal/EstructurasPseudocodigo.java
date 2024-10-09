package principal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EstructurasPseudocodigo {
    
    public static void main(String[] args) throws Exception {
        String ruta1 = "/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Lexer.flex";
        String ruta2 = "/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/LexerCup.flex";
        String [] rutaS = {"-parser", "Sintax", "/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/sym.java");
        if (Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/sym.java"), 
                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/sym.java")
        );
         Path rutaSin = Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Sintax.java");
        if (Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/Sintax.java"), 
                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Sintax.java")
        );
    }
}

