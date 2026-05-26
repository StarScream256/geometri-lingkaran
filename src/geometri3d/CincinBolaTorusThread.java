/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author asus
 */
public class CincinBolaTorusThread implements Runnable {
    public int nomor;
    
    public CincinBolaTorusThread(int nomor) {
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
        double jariJariMinor = (Math.random() * (12 - 2)) + 2;
        double jariJariMajor = (Math.random() * (12 - 2)) + 2;
        CincinBolaTorus cincinBolaTorus = new CincinBolaTorus(jariJariMinor, jariJariMajor);
        double luasPermukaan = cincinBolaTorus.hitungLuasPermukaan();
        double volume = cincinBolaTorus.hitungVolume();
        
        String output = String.format(
            """
            Thread Cincin Bola Torus #%d (%s)
            Jari-jari minor : %.2f
            Jari-jari major : %.2f 
            Luas permukaan  : %.2f 
            Volume          : %.2f 
            ---------------------------------
            """,
            this.nomor, threadName, jariJariMinor, jariJariMajor, luasPermukaan, volume
        );
        
        System.out.print(output);
    }   
}
