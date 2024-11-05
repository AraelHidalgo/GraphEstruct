package principal;

import analisis.FramePrincipal;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EstructurasPseudocodigo {

//    public static void main(String[] args) throws Exception {
//        String ruta1 = "/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Lexer.flex";
//        String ruta2 = "/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/LexerCup.flex";
//        String [] rutaS = {"-parser", "Sintax", "/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Sintax.cup"};
//        generar(ruta1, ruta2, rutaS);
//    }
//
//    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
//        File archivo;
//        archivo = new File(ruta1);
//        JFlex.Main.generate(archivo);
//        archivo = new File(ruta2);
//        JFlex.Main.generate(archivo);
//        java_cup.Main.main(rutaS);
//        
//        Path rutaSym = Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/sym.java");
//        if (Files.exists(rutaSym)){
//            Files.delete(rutaSym);
//        }
//        Files.move(
//                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/sym.java"), 
//                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/sym.java")
//        );
//         Path rutaSin = Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Sintax.java");
//        if (Files.exists(rutaSin)){
//            Files.delete(rutaSin);
//        }
//        Files.move(
//                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/Sintax.java"), 
//                Paths.get("/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Sintax.java")
//        );
//    }
    public static void main(String[] args) {
        try {
            // Configurando el Look and Feel Nimbus antes de inicializar el FramePrincipal
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new FramePrincipal().setVisible(true);
        });
    }

}
