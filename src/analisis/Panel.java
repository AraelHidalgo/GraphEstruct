
package analisis;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

    Color colorfondo=Color.gray;
    int tammax, tam, cant;
    
    
    public Panel (int tammax, int cant){
        this.tammax=tammax;
        this.cant=cant;
        this.tam=tammax/cant;
    }
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorfondo);
        for (int i = 0; i < cant; i++) {
            for (int j = 0; j < cant; j++) {
                pintor.fillRect(i*tam, j*tam, tam-1, tam-1);
            }
        }
        
    }
}
