
//Movimiento de la pelota-----------------------------------------------------------------------------------------

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;

class Pelota extends Observable {

    //posición de la pelota:
    int positionX=0;
    int positionY=0;

    //tamaño de la pelota:
    private static final int TAMX = 30;
    private static final int TAMY = 15;

    public Pelota(int positionX,int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void mueve_pelota(Rectangle2D limites) {
        if(positionX<300){
            //la pelota avanza:
            positionX+=generarAleatorio(1,4);
        }
        this.setChanged();
        this.notifyObservers(positionX);
        this.clearChanged();
    }

    //creamos la pelota:
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(positionX, positionY, TAMX, TAMY);
    }

    //Generació del moviment de forma aleatoria
    public static int generarAleatorio(int minimo, int maximo){
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
}