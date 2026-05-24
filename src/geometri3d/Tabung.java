/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

import geometri2d.Lingkaran;

// inheritance / generalization
// Tabung adalah turunan dari Lingkaran
public class Tabung extends Lingkaran implements Geometri3D {

    // encapsulation
    private double tinggi;
    private double luasPermukaan;
    private double volume;

    // constructor
    public Tabung(double r, double tinggi) {

        // inheritance
        // memanggil constructor superclass
        super(r);

        this.tinggi = tinggi;
    }

    // overriding
    @Override
    public double hitungLuasPermukaan() {

        // whole-part
        // tabung terdiri dari alas dan selimut

        double luasAlas =
                Math.PI * getJariJari() * getJariJari();

        double luasSelimut =
                2 * Math.PI * getJariJari() * tinggi;

        luasPermukaan =
                (2 * luasAlas) + luasSelimut;

        return luasPermukaan;
    }

    // overriding
    @Override
    public double hitungVolume() {

        double luasAlas =
                Math.PI * getJariJari() * getJariJari();

        volume = luasAlas * tinggi;

        return volume;
    }

    // overloading
    // nama method sama tetapi parameter berbeda
    public double hitungVolume(double r, double t) {

        double luasAlas =
                Math.PI * r * r;

        volume = luasAlas * t;

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