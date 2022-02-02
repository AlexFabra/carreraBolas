import java.awt.*;

class PelotaHilos implements Runnable{
    public PelotaHilos(Pelota _pelota, Component _component){
        pelota =  _pelota;
        component = _component;
    }

    public void run(){
//        for (int i = 1; i <= 3000; i++) {
        while (!Thread.interrupted()){
            pelota.mueve_pelota(component.getBounds());

            component.paint(component.getGraphics());


            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    private Pelota pelota;
    private Component component;
}


