/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

public class TemberengBolaThread implements Runnable {
    public int count;
    public int delay = 1000;
    
    public TemberengBolaThread() {}

    public TemberengBolaThread(int count) {
        this.count = count;
    }
    
    public TemberengBolaThread(int count, int delay) {
        this.count = count;
        this.delay = delay;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i < count; i++) {
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
                    i, threadName, jariJari, tinggi, luasPermukaan, volume

                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}