/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

public class TemberengBolaThread implements Runnable {

    private int nomor;

    public TemberengBolaThread(int nomor) {
        this.nomor = nomor;
    }

    @Override
    public void run() {

        try {
            Thread.sleep((long)(Math.random() * 300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double r = (Math.random() * (12 - 2)) + 2;
        double t = (Math.random() * (12 - 2)) + 2;

        TemberengBola bola = new TemberengBola(r, t);

        double luasPermukaan = bola.hitungLuasPermukaan();
        double volume = bola.hitungVolume();

        String output = String.format(
            """
            Thread Tembereng Bola #%d (%s)
            Jari-jari : %.2f
            Tinggi    : %.2f
            Luas Permukaan : %.2f
            Volume    : %.2f
            -----------------------------
            """,
            nomor,
            Thread.currentThread().getName(),
            r,
            t,
            luasPermukaan,
            volume
        );

        System.out.print(output);
    }
}