/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientoletras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author johnny
 */
public class Dibujo {
    private int X;
    private int Y;
    private Color color = new Color(0,0,0);

    public Dibujo() {
    }
    
    public void obtenerCordenadas(MouseEvent evt)
    {
        if(!evt.isMetaDown())
        {
            X=evt.getX();
            Y=evt.getY();
        }
    }
    public void pintar(MouseEvent evt)
    {
        if(!evt.isMetaDown())
        {
            Graphics2D g= (Graphics2D) ((JPanel)evt.getSource()).getGraphics();
            g.setStroke(new BasicStroke(1));
            int x=evt.getX();
            int y=evt.getY();
            g.drawLine(X, Y, x, y);
            g.dispose();
            X=x;
            Y=y;
        }
    }
}
