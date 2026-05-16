/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri2d;

import geometri2d.Lingkaran;

/**
 *
 * @author Lenovo
 */
public class LingkaranThread implements Runnable {

    private int nomor;

    public LingkaranThread(int nomor) {
        this.nomor = nomor;
    }

    @Override
    public void run() {

        try {

            // Delay random 0 - 300 ms
            Thread.sleep((long)(Math.random() * 300));

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        // Random jari-jari 2 - 12
        double jariJari = (Math.random() * (12 - 2)) + 2;

        // Object lingkaran
        Lingkaran lingkaran = new Lingkaran(jariJari);

        // Hitung
        double luas = lingkaran.hitungLuas();
        double keliling = lingkaran.hitungKeliling();

        // Output
        String output = String.format(
            """
            Thread Lingkaran #%d (%s)
            Jari-jari : %.2f
            Luas      : %.2f
            Keliling  : %.2f
            -----------------------------

            """,

            this.nomor,
            Thread.currentThread().getName(),
            jariJari,
            luas,
            keliling
        );

        System.out.print(output);
    }
}