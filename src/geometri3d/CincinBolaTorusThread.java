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
    private double jariJariMinor;
    private double jariJariMajor;
    
    public CincinBolaTorusThread(double jariJariMinor, double jariJariMajor) {
        this.jariJariMinor = jariJariMinor;
        this.jariJariMajor = jariJariMajor;
    }

    @Override
    public void run() {
        CincinBola cincinBola = new CincinBola(this.jariJariMinor, this.jariJariMajor);
        double luasPermukaan = cincinBola.hitungLuasPermukaan();
        double volume = cincinBola.hitungVolume();
        
        System.out.println(
            "Thread + " + Thread.currentThread().getId() +
            " ;jari-jari minor = " + this.jariJariMinor +
            " ;jari-jari major = " + this.jariJariMajor +
            " ;luas permukaan = " + luasPermukaan + 
            " ;volume = " + volume
        );
    }
    
    
}
