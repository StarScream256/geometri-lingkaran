/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

// multithreading
public class TemberengBolaThread implements Runnable {

    // encapsulation
    private TemberengBola temberengBola;

    // constructor
    public TemberengBolaThread(TemberengBola temberengBola) {

        this.temberengBola = temberengBola;
    }

    // overriding
    @Override
    public void run() {

        // proses thread
        double volume =
                temberengBola.hitungVolume();

        // output console
        System.out.println(
                "Volume Tembereng Bola : " + volume
        );
    }
}