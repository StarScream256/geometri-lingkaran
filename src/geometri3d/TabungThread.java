/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

public class TabungThread implements Runnable {
    public int count;
    public int delay = 1000;

    public TabungThread() {}
    
    public TabungThread(int count) {
        this.count = count;
    }
    
    public TabungThread(int count, int delay) {
        this.count = count;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                double r = (Math.random() * 10) + 1;
                double t = (Math.random() * 10) + 1;
                Tabung tabung = new Tabung(r, t);
                double luasPermukaan = tabung.hitungLuasPermukaan();
                double volume = tabung.hitungVolume();

                String output = String.format(
                    """
                    Thread Tabung #%d (%s)
                    Jari-jari      : %.2f
                    Tinggi         : %.2f
                    Luas Permukaan : %.2f
                    Volume         : %.2f
                    ------------------------
                    """,
                    i, threadName, r, t, luasPermukaan, volume
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}