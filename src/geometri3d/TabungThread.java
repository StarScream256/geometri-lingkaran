/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

// multithreading
// implements Runnable
public class TabungThread implements Runnable {
    public int nomor;

    // constructor
    public TabungThread() {}
    
    public TabungThread(int nomor) {
        this.nomor = nomor;
    }

    // overriding method run()
    @Override
    public void run() {
        try {
            // Delay random antara 0 - 300 ms agar output tidak berurutan rapi
            Thread.sleep((long)(Math.random() * 300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String threadName = Thread.currentThread().getName();
        
        double r = (Math.random() * 10) + 1;
        double t = (Math.random() * 10) + 1;
        Tabung tabung = new Tabung(r, t);
        double luasPermukaan = tabung.hitungLuasPermukaan();
        double volume = tabung.hitungVolume();
        
        
        // Output Text Block
        String output = String.format(
            """
            Thread Tabung #%d (%s)
            Jari-jari      : %.2f
            Tinggi         : %.2f
            Luas Permukaan : %.2f
            Volume         : %.2f
            ------------------------
            """,
            this.nomor, threadName, r, t, luasPermukaan, volume
        );
        
        System.out.print(output);
    }
}