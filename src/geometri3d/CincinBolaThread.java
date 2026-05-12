/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author asus
 */
public class CincinBolaThread implements Runnable {
    private int nomor;
    
    public CincinBolaThread(int nomor) {
        this.nomor = nomor;
    }

    @Override
    public void run() {
        try {
            // Delay random antara 0 - 300 ms agar output tidak berurutan rapi
            Thread.sleep((long)(Math.random() * 300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String threadName = Thread.currentThread().getName();
        
        // rentang: (Math.random() * (Max - Min)) + Min
        double jariJari = (Math.random() * (12 - 2)) + 2;
        double tinggi = (Math.random() * (12 - 2)) + 2;
        CincinBola cincinBola = new CincinBola(jariJari, tinggi);
        double luasPermukaan = cincinBola.hitungLuasPermukaan();
        double volume = cincinBola.hitungVolume();
        
        String output = String.format(
            """
            Thread Cincin Bola #%d (%s)
            Jari-jari: %.2f; Tinggi: %.2f 
            Luas permukaan\t: %.2f 
            Volume\t\t: %.2f 
            ---------------------------------
            """,
            this.nomor, Thread.currentThread().getName(), jariJari, tinggi, luasPermukaan, volume
        );
        
        System.out.print(output);
    }
}
