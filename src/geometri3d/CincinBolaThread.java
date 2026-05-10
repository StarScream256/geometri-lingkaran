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
    private double jariJari;
    private double tinggi;
    
    public CincinBolaThread(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    @Override
    public void run() {
        CincinBola cincinBola = new CincinBola(this.jariJari, this.tinggi);
        double luasPermukaan = cincinBola.hitungLuasPermukaan();
        double volume = cincinBola.hitungVolume();
        
        System.out.println(
            "Thread + " + Thread.currentThread().getId() +
            " ;jari-jari = " + this.jariJari +
            " ;tinggi = " + this.tinggi +
            " ;luas permukaan = " + luasPermukaan + 
            " ;volume = " + volume
        );
    }
    
    
}
