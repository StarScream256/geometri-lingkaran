/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

// multithreading
public class TemberengBolaThread implements Runnable {
    public int nomor;
    
    public TemberengBolaThread() {}

    // constructor
    public TemberengBolaThread(int nomor) {
        this.nomor = nomor;
    }

    // overriding
    @Override
    public void run(){
        try{
            //Delay random antara 0-300 ms agar output tidak berurutan rapi
            Thread.sleep((long)(Math.random()*300));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        String threadName = Thread.currentThread().getName();
        
        double jariJari = (Math.random() * (12-2))+2;
        double tinggi = (Math.random() * (12-2))+2;
        TemberengBola temberengBola = new TemberengBola(jariJari, tinggi);
        double luasPermukaan = temberengBola.hitungLuasPermukaan();
        double volume = temberengBola.hitungVolume();
        
        String output = String.format(
            """
            Thread tembereng bola #%d (%s)
            Jari-jari       : %.2f
            Tinggi          : %.2f
            Luas Permukaan  : %.2f
            Volume          : %.2f
            -----------------------------

            """,
            this.nomor, threadName, jariJari, tinggi, luasPermukaan, volume
        
        );
        System.out.print(output);
    }
}