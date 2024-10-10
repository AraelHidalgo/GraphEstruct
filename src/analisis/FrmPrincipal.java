/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis;


import static analisis.Tokens.DIGITO;
import static analisis.Tokens.REMOVER;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

/**
 *
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    
private void analizarLexico() throws IOException {
    int cont = 1;

    // Aquí obtienes el texto del área de texto
    String expr = (String) txtEntrada.getText();
    Lexer lexer = new Lexer(new StringReader(expr)); // Instancias el lexer
    StringBuilder resultado = new StringBuilder("LINEA " + cont + "\t\tSIMBOLO\n"); // Usamos StringBuilder para eficiencia

    boolean dentroCorchetes = false;  // Estado para saber si estamos dentro de corchetes
    boolean despuesDeAsignar = false; // Estado para saber si el siguiente token es un valor tras 'ASIGNAR'

    while (true) {
        Tokens token = lexer.yylex(); // Analizas el siguiente token
        if (token == null) {
            txtResultadoLex.setText(resultado.toString()); // Muestras el resultado en el área de texto
            return;
        }
        
        switch (token) {
            case ERROR:
                resultado.append("Símbolo no definido: ").append(lexer.lexeme).append("\n");
                break;
            case IDENTIFICADOR:
                resultado.append(lexer.lexeme).append(": Es un identificador\n");
                break;
            case CREAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para crear una estructura\n");
                break;
            case ARRAY:
                resultado.append(lexer.lexeme).append(": Es una palabra reservada para crear un array\n");
                break;
            case LISTA:
                resultado.append(lexer.lexeme).append(": Es una palabra reservada para crear una lista\n");
                break;
            case MATRIZ:
                resultado.append(lexer.lexeme).append(": Es una palabra reservada para crear una matriz\n");
                break;
            case ASIGNAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para asignar valores\n");
                break;
            case MODIFICAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para modificar valores\n");
                break;
            case ELIMINAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para eliminar\n");
                break;
            case AGREGAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para agregar\n");
                break;
            case REMOVER:
                resultado.append(lexer.lexeme).append(": Es una instrucción para remover\n");
                break;
            case ULTIMO:
                resultado.append(lexer.lexeme).append(": Es una palabra reservada para la instruccion de remover\n");
                break;
            case DE:
                resultado.append(lexer.lexeme).append(":  Es una palabra reservada para la instruccion de remover\n");
                break;
            case PINTAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para pintar\n");
                break;
            case MOSTRAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para mostrar valores\n");
                break;
            case VACIAR:
                resultado.append(lexer.lexeme).append(": Es una instrucción para vaciar la estructura\n");
                break;
            case COLOR:
                resultado.append(lexer.lexeme).append(": Es un valor de color\n");
                break;
            case A:
                resultado.append(lexer.lexeme).append(": Es la palabra clave 'a'\n");
                break;
            case EN:
                resultado.append(lexer.lexeme).append(": Es la palabra clave 'en'\n");
                break;
            case CORCHETEA:
                resultado.append(lexer.lexeme).append(": Es un corchete abierto '['\n");
                break;
            case CORCHETEC:
                resultado.append(lexer.lexeme).append(": Es un corchete cerrado ']'\n");
                break;
            case FINAL:
                resultado.append(lexer.lexeme).append(": Es un punto y coma ';'\n");
                break;
            case DIGITO:
                resultado.append(lexer.lexeme).append(": Es un valor numerico que puede representar una matriz, un valor o un valor nuevo\n");
                break;
            case ESPACIO:
                resultado.append(lexer.lexeme).append(": Es un espacio\n");
                break;
            case INDICE_MATRIZ:
                resultado.append(lexer.lexeme).append(": Es un índice de matriz\n");
                break;
            default:
                resultado.append("Token no reconocido: ").append(lexer.lexeme).append("\n");
                break;
        }
    }
}

    
    
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEntrada = new javax.swing.JTextField();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultadoLex = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultadoSin = new javax.swing.JTextArea();
        btnAnalizarSin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiarLex = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEntrada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultadoLex.setEditable(false);
        txtResultadoLex.setColumns(20);
        txtResultadoLex.setRows(5);
        txtResultadoLex.setToolTipText("");
        txtResultadoLex.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtResultadoLex);

        jLabel1.setText("Analisis Léxico:");

        jLabel2.setText("Analisis Sintactico:");

        txtResultadoSin.setEditable(false);
        txtResultadoSin.setColumns(20);
        txtResultadoSin.setRows(5);
        txtResultadoSin.setToolTipText("");
        txtResultadoSin.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(txtResultadoSin);

        btnAnalizarSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        jLabel3.setText("Entrada:");

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLimpiarLex, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLimpiarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizar)
                    .addComponent(btnLimpiarLex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnLimpiarSin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
    try {
        analizarLexico();
    } catch (IOException ex) {
        Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
       // TODO add your handling code here:
    String ST = txtEntrada.getText(); // Obtiene el texto de entrada
    Sintax s = new Sintax(new LexerCup(new StringReader(ST))); // Crea el analizador sintáctico con el lexer Cup

    try {
        s.parse(); // Ejecuta el análisis sintáctico
        txtResultadoSin.setText("Análisis realizado correctamente"); // Muestra mensaje si el análisis es exitoso
        txtResultadoSin.setForeground(new Color(25, 111, 61)); // Cambia color a verde para éxito
    } catch (Exception ex) {
        Symbol sym = s.getS(); // Obtiene el símbolo donde ocurrió el error
        txtResultadoSin.setText("Error de sintaxis. Línea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
        txtResultadoSin.setForeground(Color.red); // Cambia color a rojo si hay error
    }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        txtResultadoLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        txtResultadoSin.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtEntrada;
    public javax.swing.JTextArea txtResultadoLex;
    public javax.swing.JTextArea txtResultadoSin;
    // End of variables declaration//GEN-END:variables
}
