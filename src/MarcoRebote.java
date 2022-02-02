//Marco con lámina y botones------------------------------------------------------------------------------

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MarcoRebote extends JFrame {

    public MarcoRebote() {

        
        setBounds(600, 300, 400, 350);

        setTitle("Carrera pelotas");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();

        arranca1 = new JButton("Hilo1");
        arranca1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });
        laminaBotones.add(arranca1);

        arranca2 = new JButton("Hilo2");
        arranca2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });
        laminaBotones.add(arranca2);

        arranca3 = new JButton("Hilo3");
        arranca3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });
        laminaBotones.add(arranca3);

        detener1 = new JButton("Detener1");
        detener1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });
        laminaBotones.add(detener1);

        detener2 = new JButton("Detener2");
        detener2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });
        laminaBotones.add(detener2);

        detener3 = new JButton("Detener3");
        detener3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });
        laminaBotones.add(detener3);

        add(laminaBotones, BorderLayout.SOUTH);
    }

    public void comienza_el_juego(ActionEvent e) {
        Pelota pelota = new Pelota(10,10);
        lamina.add(pelota);
        Runnable r = new PelotaHilos(pelota,lamina);

        if (e.getSource().equals(arranca1)){
            t1 = new Thread(r);
            t1.start();
        }
        if (e.getSource().equals(arranca2)){
            t2 = new Thread(r);
            t2.start();
        }
        if (e.getSource().equals(arranca3)){
            t3 = new Thread(r);
            t3.start();
        }
    }

    public void detener(ActionEvent e){
        if (e.getSource().equals(detener1)) t1.interrupt();
        if (e.getSource().equals(detener2)) t2.interrupt();
        if (e.getSource().equals(detener3)) t3.interrupt();

    }
    Thread t1,t2,t3;
    JButton arranca1, arranca2, arranca3,detener1, detener2, detener3;
    private LaminaPelota lamina;


}