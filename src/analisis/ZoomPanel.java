package analisis;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ZoomPanel extends JFrame {

    private List<int[]> celdas; // Lista de celdas del identificador
    private Color colorZoom; // Color de las celdas
    private int cellSize = 90; // Tamaño ampliado de cada celda

    public ZoomPanel(String identificador, List<int[]> celdas, Color colorZoom) {
        this.celdas = celdas;
        this.colorZoom = colorZoom;

        // Encuentra las filas y columnas mínimas y máximas para evitar espacio en blanco
        int minRow = Integer.MAX_VALUE, maxRow = 0;
        int minCol = Integer.MAX_VALUE, maxCol = 0;
        for (int[] celda : celdas) {
            minRow = Math.min(minRow, celda[0]);
            maxRow = Math.max(maxRow, celda[0]);
            minCol = Math.min(minCol, celda[1]);
            maxCol = Math.max(maxCol, celda[1]);
        }

        // Calcula el tamaño necesario basado en las posiciones mínimas y máximas
        int width = (maxCol - minCol + 1) * cellSize;
        int height = (maxRow - minRow + 1) * cellSize;

        // Configura la ventana y el panel de dibujo
        setTitle("Zoom de celdas para identificador: " + identificador);
        setSize(height, width);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Agrega el panel que hará el dibujo
        ZoomCellPanel panel = new ZoomCellPanel(minRow, minCol);
        panel.setPreferredSize(new Dimension(height, width));
        add(panel);
        pack(); // Ajusta el tamaño del JFrame al tamaño preferido
    }

    // Clase interna para representar las celdas ampliadas
    private class ZoomCellPanel extends JPanel {

        private int minRow, minCol;

        public ZoomCellPanel(int minRow, int minCol) {
            this.minRow = minRow;
            this.minCol = minCol;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Dibuja cada celda en la posición correcta según sus coordenadas relativas
            for (int[] celda : celdas) {
                int row = celda[0] - minRow; // Esto representa la fila
                int col = celda[1] - minCol; // Esto representa la columna

                int x = row * cellSize; // La posición x se basa en la columna
                int y = col * cellSize; // La posición y se basa en la fila

                g.setColor(colorZoom);
                g.fillRect(x, y, cellSize, cellSize);

                // Opcional: dibujar bordes para cada celda
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellSize, cellSize);
                System.out.println("Dibujando celda en: (" + row + ", " + col + ") -> (" + x + ", " + y + ")");
            }
        }
    }
}

