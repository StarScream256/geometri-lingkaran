/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

public class TemberengBolaThread extends Thread {
    private TemberengBola bola;

    public TemberengBolaThread(TemberengBola b) {
        this.bola = b;
    }

    @Override
    public void run() {
        System.out.println("Volume Tembereng Bola = " + bola.getVolume());
    }
}