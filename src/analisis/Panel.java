package analisis;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private Color colorfondo = Color.gray; // Color de fondo predeterminado
    private int tammax, tam, cant;
    private Color[][] colores; // Matriz de colores para cada celda
    private String[][] valores; // Matriz de valores para cada celda

    public Panel(int tammax, int cant) {
        this.tammax = tammax;
        this.cant = cant;
        this.tam = tammax / cant;

        // Inicializar las matrices de color y valores
        colores = new Color[cant][cant];
        valores = new String[cant][cant];

        // Rellenar la matriz de colores con el color de fondo por defecto
        for (int i = 0; i < cant; i++) {
            for (int j = 0; j < cant; j++) {
                colores[i][j] = colorfondo;
                valores[i][j] = ""; // Sin valor inicial
            }
        }
    }

    @Override
    public void paint(Graphics pintor) {
        super.paint(pintor);
        
        for (int i = 0; i < cant; i++) {
            for (int j = 0; j < cant; j++) {
                // Dibujar cada celda con su color específico
                pintor.setColor(colores[i][j]);
                pintor.fillRect(i * tam, j * tam, tam - 1, tam - 1);

                // Dibujar el valor en el centro de la celda, si existe
                if (!valores[i][j].isEmpty()) {
                    pintor.setColor(Color.BLACK); // Color del texto
                    pintor.drawString(valores[i][j], i * tam + tam / 4, j * tam + tam / 2);
                }
            }
        }
    }

    // Método para cambiar el color de una celda específica
    public void cambiarColorCelda(int x, int y, Color color) {
        if (x >= 0 && x < cant && y >= 0 && y < cant) {
            colores[x][y] = color;
            repaint(); // Llamada para repintar el panel con los nuevos colores
        }
    }

    // Método para asignar un valor a una celda específica
    public void asignarValorCelda(int x, int y, String valor) {
        if (x >= 0 && x < cant && y >= 0 && y < cant) {
            valores[x][y] = valor;
            repaint(); // Llamada para repintar el panel con los nuevos valores
        }
    }

    // Método para vaciar una celda específica (restablecer su color y valor)
    public void vaciarCelda(int x, int y) {
        if (x >= 0 && x < cant && y >= 0 && y < cant) {
            colores[x][y] = colorfondo;
            valores[x][y] = "";
            repaint();
        }
    }

    // Método para vaciar todas las celdas (restablecer todos los colores y valores)
    public void vaciarPanel() {
        for (int i = 0; i < cant; i++) {
            for (int j = 0; j < cant; j++) {
                colores[i][j] = colorfondo;
                valores[i][j] = "";
            }
        }
        repaint();
    }
}
