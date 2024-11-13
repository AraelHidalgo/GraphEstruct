/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package analisis;

import java.awt.Color;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java_cup.runtime.Symbol;
import javax.swing.JFrame;

/**
 *
 * @author araelhidalgojuarez
 */
public class Graph extends javax.swing.JFrame {

    private Panel fondo; // Hacer que el panel sea un atributo de la clase
    private HashMap<String, String> instrucciones = new HashMap<>(); // Mismo HashMap compartido

    public Graph() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fondo = new Panel(550, 20); // Inicializar el panel
        this.add(fondo).doLayout();
        fondo.setBounds(20, 90, 550, 550); // Ajustar el tamaño y la posición del panel
//        fondo.pintarMatriz(2, 2, Color.yellow, "ASd");
    }

    private String obtenerIdentificador(String entrada) {
        // Expresión regular para capturar un identificador en diferentes instrucciones
        Pattern pattern = Pattern.compile("(?i)\\bcrear\\s+(array|lista|matriz)\\s+(\\w+)\\s*\\[");
        Matcher matcher = pattern.matcher(entrada);
        if (matcher.find()) {
            return matcher.group(2).trim(); // Devuelve el segundo grupo que coincide (el identificador)
        }
        return ""; // Devuelve una cadena vacía si no se encuentra un identificador
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEntrada = new javax.swing.JLabel();
        BtnEjecutar = new javax.swing.JButton();
        txtEntrada = new javax.swing.JTextField();
        txtResultado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 51));

        jLabelEntrada.setText("Entrada: ");

        BtnEjecutar.setText("EJECUTAR");
        BtnEjecutar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEjecutarActionPerformed(evt);
            }
        });

        txtEntrada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtResultado.setEditable(false);
        txtResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEntrada)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtResultado)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 564, Short.MAX_VALUE)
                .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEjecutarActionPerformed
        String entrada = txtEntrada.getText();
        Sintax parser = new Sintax(new LexerCup(new StringReader(entrada)));

        // Pasa la referencia del HashMap compartido al parser
        parser.setInstrucciones(instrucciones);

        // Pasa la referencia del panel al parser
        parser.setPanel(fondo);

        // Verifica si el identificador ya existe
        String identificador = obtenerIdentificador(entrada);
        System.out.println("Identificadores existentes: " + parser.getInstrucciones().keySet());

        System.out.println("Identificador capturado antes de la verificación: " + identificador);

        // Verifica si el identificador ya existe antes de ejecutar el parseo
        if (instrucciones.containsKey(identificador)) {
            txtResultado.setText("Error: El identificador '" + identificador + "' ya existe.");
            txtResultado.setForeground(Color.red);
            System.out.println("Error: Intento de agregar un identificador ya existente: " + identificador);
            return; // Detiene la ejecución si el identificador ya existe
        }
        parser.analizarEntrada(entrada);
        try {
            System.out.println("Identificadores existentes (antes de parsear): " + instrucciones.keySet());
            Symbol result = parser.parse();
            System.out.println("Identificadores existentes (después de parsear): " + instrucciones.keySet());

            // Obtén el resultado del análisis y muestra el mensaje en txtResultado
            if (result.value != null) {
                txtResultado.setText(result.value.toString());
            } else {
                txtResultado.setText("Instrucciones ejecutadas correctamente");
                txtResultado.setForeground(new Color(25, 111, 61));
            }

            // Aquí puedes agregar lógica para actualizar el panel si es necesario
            fondo.repaint();
        } catch (Exception ex) {
            Symbol sym = parser.getS();
            if (sym != null) {
                txtResultado.setText("Error de sintaxis. Línea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
                txtResultado.setForeground(Color.red); // Color rojo para error
            }
        }
    }//GEN-LAST:event_BtnEjecutarActionPerformed

    private void txtResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResultadoActionPerformed

    private int obtenerTamanoArray(String identificador) {
        // Implementa tu lógica para extraer el tamaño del array a partir del identificador o de la entrada.
        return 10; // Ejemplo, reemplaza con la lógica real
    }

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
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEjecutar;
    private javax.swing.JLabel jLabelEntrada;
    public javax.swing.JTextField txtEntrada;
    public javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
