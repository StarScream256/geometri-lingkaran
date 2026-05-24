/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

import geometri2d.Lingkaran;

public class Tabung extends Lingkaran implements Geometri3D {

    private double tinggi;
    private double luasPermukaan;
    private double volume;

    public Tabung(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {

        luasPermukaan =
                2 * Math.PI * getJariJari()
                * (getJariJari() + tinggi);

        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {

        volume =
                Math.PI * getJariJari()
                * getJariJari()
                * tinggi;

        return volume;
    }

    // OVERLOADING
    public double hitungVolume(double r, double t) {
        return Math.PI * r * r * t;
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