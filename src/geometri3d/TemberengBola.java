/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

public class TemberengBola extends Bola {

    private double tinggi;
    private double luasPermukaan;
    private double volume;

    public TemberengBola(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {

        luasPermukaan =
                2 * Math.PI * getJariJari() * tinggi;

        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {

        volume =
                (1.0 / 3.0) * Math.PI
                * tinggi * tinggi
                * (3 * getJariJari() - tinggi);

        return volume;
    }

    // OVERLOADING
    public double hitungVolume(double r, double t) {

        return (1.0 / 3.0)
                * Math.PI
                * t * t
                * (3 * r - t);
    }

    // Getter Setter
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