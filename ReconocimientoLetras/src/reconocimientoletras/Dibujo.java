/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientoletras;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.PixelGrabber;
import javax.swing.JPanel;

/**
 *
 * @author johnny
 */
public class Dibujo {

    private int X;
    private int Y;
    private Color color = new Color(0, 0, 0);
    private Graphics grafico;
    private JPanel pDibujo;
    private int arriba;
    private int abajo;
    private int izquierda;
    private int derecha;
    protected int pixelMap[][] = new int[140][140];
    private int matriz[][] = new int[7][5];

    public Dibujo(JPanel dib) {
        pDibujo = dib;
        for (int i = 0; i < 140; i++) {
            for (int j = 0; j < 140; j++) {
                pixelMap[i][j] = 0;
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public void obtenerCordenadas(MouseEvent evt) {
        if (!evt.isMetaDown()) {
            X = evt.getX();
            Y = evt.getY();
        }
    }

    public void pintarBordes() {
        grafico.setColor(Color.RED);
        grafico.drawRect(izquierda,
                arriba,
                derecha - izquierda,
                abajo - arriba);
    }

    public void limpiar() {
        for (int i = 0; i < 140; i++) {
            for (int j = 0; j < 140; j++) {
                pixelMap[i][j] = 0;
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public void pintar(MouseEvent evt) {

        if (!evt.isMetaDown()) {
            grafico = (Graphics) ((JPanel) evt.getSource()).getGraphics();
            int x = evt.getX();
            int y = evt.getY();
            grafico.drawLine(X, Y, x, y);
            X = x;
            Y = y;
            if(X<140 && Y<140)
                pixelMap[Y][X] = 1;
        }
    }

    public int[][] analizaGrafico() {
        encuentraBordes(140, 140);
        arriba -= 3;
        abajo += 3;
        izquierda-=3;
        derecha+=3;
        System.err.println("arriba: " + arriba + "  derecha: " + derecha + "  abajo: " + abajo + "  izquierda " + izquierda);
        pintarBordes();
        creaMatriz();
        return matriz;
    }

    private boolean escaneaH(int x) {
        int w = 140;
        for (int i = 0; i < w; i++) {
            if (pixelMap[x][i] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean escaneaV(int y) {
        int h = 140;
        for (int i = 0; i < h; i++) {
            if (pixelMap[i][y] != 0) {
                return false;
            }
        }
        return true;
    }

    private void encuentraBordes(int w, int h) {
        for (int y = 0; y < h; y++) {
            if (!escaneaH(y)) {
                arriba = y;
                break;
            }

        }
        // bottom line
        for (int y = h - 1; y >= 0; y--) {
            if (!escaneaH(y)) {
                abajo = y;
                break;
            }
        }
        // left line
        for (int x = 0; x < w; x++) {
            if (!escaneaV(x)) {
                izquierda = x;
                break;
            }
        }

        // right line
        for (int x = w - 1; x >= 0; x--) {
            if (!escaneaV(x)) {
                derecha = x;
                break;
            }
        }
    }

    public void creaMatriz() {
        int h = abajo - arriba;
        int w = derecha - izquierda;
        int intH = (int) (h / 7);
        int intW = (int) (w / 5);
        int auxIzq;
        System.out.println(intH + " " + intW);
        for (int i = 0; i < 7; i++) {
            auxIzq=izquierda;
            for (int j = 0; j < 5; j++) {
                boolean band = false;
                for (int k = arriba; k < arriba + intH; k++) {
                    for (int l = auxIzq; l < auxIzq + intW; l++) {
                        if (pixelMap[k][l] != 0) {

                            matriz[i][j] = 1;
                            band = true;
                            break;
                        }
                    }

                    
                }
            auxIzq+=intW;
            }
            arriba = arriba + intH;
            
        }
    }
}
