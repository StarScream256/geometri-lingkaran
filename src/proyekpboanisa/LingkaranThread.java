/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyekpboanisa;

/**
 *
 * @author Lenovo
 */
public class LingkaranThread extends Thread {
    private Lingkaran lingkaran;
    private double hasil;
    private String tipe; // "luas" atau "keliling"

    public LingkaranThread(Lingkaran lingkaran, String tipe) {
        this.lingkaran = lingkaran;
        this.tipe = tipe;
    }

    @Override
    public void run() {
        if (tipe.equals("luas")) {
            hasil = lingkaran.hitungLuas();
        } else {
            hasil = lingkaran.hitungKeliling();
        }
    }

    public double getHasil() {
        return hasil;
    }
}