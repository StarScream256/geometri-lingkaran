/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

// inheritance / generalization
// TemberengBola adalah turunan dari Bola
public class TemberengBola extends Bola {

    // encapsulation
    private double tinggi;
    private double luasPermukaan;
    private double volume;

    // constructor
    public TemberengBola(double r, double tinggi) {

        // inheritance
        // memanggil constructor superclass
        super(r);

        this.tinggi = tinggi;
    }

    // overriding
    @Override
    public double hitungLuasPermukaan() {

        luasPermukaan =
                2 * Math.PI * getJariJari() * tinggi;

        return luasPermukaan;
    }

    // overriding
    @Override
    public double hitungVolume() {

        double bagian1 =
                tinggi * tinggi;

        double bagian2 =
                (3 * getJariJari() - tinggi);

        volume =
                (1.0 / 3.0)
                * Math.PI
                * bagian1
                * bagian2;

        return volume;
    }

    // overloading
    // method sama tetapi parameter berbeda
    public double hitungVolume(double r, double t) {

        double bagian1 =
                t * t;

        double bagian2 =
                (3 * r - t);

        volume =
                (1.0 / 3.0)
                * Math.PI
                * bagian1
                * bagian2;

        return volume;
    }

    // getter setter
    // encapsulation
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double getVolume() {
        return volume;
    }
}