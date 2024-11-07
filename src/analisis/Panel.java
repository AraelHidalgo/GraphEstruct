package analisis;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private Color colorfondo = Color.gray; // Color de fondo predeterminado
    private int tammax, tam, cant;
    private Color[][] colores; // Matriz de colores para cada celda
    private String[][] valores; // Matriz de valores para cada celda
    private HashMap<String, List<int[]>> celdasPorIdentificador = new HashMap<>();

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

    public Color generarColorAleatorio() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        return new Color(red, green, blue);
    }

public void vaciarCeldasPorIdentificador(String identificador) {
    System.out.println("Intentando vaciar celdas para el identificador: " + identificador);
    if (celdasPorIdentificador.containsKey(identificador)) {
        List<int[]> celdas = celdasPorIdentificador.get(identificador);
        System.out.println("Celdas a vaciar: " + celdas);
        for (int[] celda : celdas) {
            int x = celda[0];
            int y = celda[1];
            colores[x][y] = colorfondo;
            valores[x][y] = "";
        }
        repaint();
        System.out.println("Celdas asociadas al identificador '" + identificador + "' vaciadas.");
    } else {
        System.out.println("Error: No se encontraron celdas asociadas al identificador '" + identificador + "'.");
    }
}


    public void llenarCeldasAleatoriasSecuencialesMultiDireccion(int cantidad, Color color, String identificador) {
        // Generar una posición inicial aleatoria
        List<int[]> celdas = new ArrayList<>();
        int startX = (int) (Math.random() * cant);
        int startY = (int) (Math.random() * cant);
        int celdasColoreadas = 0;

        // Direcciones de movimiento: derecha, abajo, izquierda, arriba
        int[][] direcciones = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direccionActual = 0; // Comienza moviéndose a la derecha

        int x = startX;
        int y = startY;

        while (celdasColoreadas < cantidad) {
            // Verifica que la celda actual esté dentro de los límites y no esté coloreada
            if (x >= 0 && x < cant && y >= 0 && y < cant && colores[x][y] == colorfondo) {
                cambiarColorCelda(x, y, color);
                celdas.add(new int[]{x, y});
                celdasColoreadas++;
            }

            // Avanzar a la siguiente celda en la dirección actual
            int nuevoX = x + direcciones[direccionActual][0];
            int nuevoY = y + direcciones[direccionActual][1];

            // Verificar si la nueva posición está fuera de los límites o ya está coloreada
            if (nuevoX < 0 || nuevoX >= cant || nuevoY < 0 || nuevoY >= cant || colores[nuevoX][nuevoY] != colorfondo) {
                // Cambiar la dirección (girar a la siguiente dirección en el orden)
                int intentos = 0;
                while ((nuevoX < 0 || nuevoX >= cant || nuevoY < 0 || nuevoY >= cant || colores[nuevoX][nuevoY] != colorfondo) && intentos < 4) {
                    direccionActual = (direccionActual + 1) % 4; // Cambiar dirección
                    nuevoX = x + direcciones[direccionActual][0];
                    nuevoY = y + direcciones[direccionActual][1];
                    intentos++;
                }

                // Si después de intentar todas las direcciones no se encuentra una celda disponible, salir del bucle
                if (intentos == 4) {
                    break;
                }
            }

            // Mover a la nueva posición
            x = nuevoX;
            y = nuevoY;
        }

        // Llama al método del parser para almacenar las celdas con el identificador
        Sintax parser = new Sintax(); // Debes usar la instancia de parser real que esté en tu flujo de trabajo
        parser.agregarCeldasPorIdentificador(identificador, celdas);
        celdasPorIdentificador.put(identificador, celdas);

        repaint(); // Asegúrate de repintar el panel después de hacer cambios
    }

    public void llenarCeldasAleatoriasSecuenciales(int cantidad, Color color) {
        // Generar una posición inicial aleatoria
        int startX = (int) (Math.random() * cant);
        int startY = (int) (Math.random() * cant);
        int celdasColoreadas = 0;
        int x = startX;
        int y = startY;

        while (celdasColoreadas < cantidad) {
            if (colores[x][y] == colorfondo) { // Verifica que la celda esté en el color de fondo
                cambiarColorCelda(x, y, color);
                celdasColoreadas++;
            }

            // Avanzar a la siguiente celda
            y++;
            if (y >= cant) { // Si se pasa del final de la fila, reinicia la columna y avanza a la siguiente fila
                y = 0;
                x++;
                if (x >= cant) { // Si se pasa del final del panel, vuelve al inicio
                    x = 0;
                }
            }

            // Si se llegó al inicio aleatorio después de colorear, salir del bucle para evitar un bucle infinito
            if (x == startX && y == startY) {
                break;
            }
        }
        repaint(); // Asegúrate de repintar el panel después de hacer cambios
    }

    public void llenarCeldasSecuenciales(int cantidad, Color color) {
        int celdasColoreadas = 0;

        // Comienza desde la primera celda y avanza de forma secuencial
        outerLoop:
        for (int i = 0; i < cant; i++) {
            for (int j = 0; j < cant; j++) {
                if (colores[i][j] == colorfondo) { // Verifica que la celda esté en el color de fondo
                    cambiarColorCelda(i, j, color);
                    celdasColoreadas++;
                    if (celdasColoreadas >= cantidad) {
                        break outerLoop; // Termina cuando se han pintado la cantidad requerida de celdas
                    }
                }
            }
        }
        repaint(); // Repinta el panel para mostrar los cambios
    }

public void llenarCeldasAleatorias(int cantidad, Color color, String identificador) {
    // Lista para almacenar las posiciones de las celdas coloreadas
    List<int[]> celdas = new ArrayList<>();
    
    for (int i = 0; i < cantidad; i++) {
        int x = (int) (Math.random() * cant);
        int y = (int) (Math.random() * cant);
        
        // Verifica que la celda no esté coloreada antes de cambiar su color
        if (colores[x][y] == colorfondo) {
            cambiarColorCelda(x, y, color);
            celdas.add(new int[]{x, y}); // Guarda la posición de la celda
        } else {
            // Si la celda ya está coloreada, intenta encontrar una nueva posición
            i--; // Decrementa i para asegurar que se coloreen la cantidad deseada de celdas
        }
    }

    // Almacena las celdas con el identificador en el HashMap
    celdasPorIdentificador.put(identificador, celdas);

    repaint(); // Asegúrate de repintar el panel después de hacer cambios
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
