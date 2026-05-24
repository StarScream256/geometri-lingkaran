/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

import geometri2d.Lingkaran;

/**
 *
 * @author LEGION
 */
public class Tabung extends Lingkaran implements Geometri3D {
    private double pi;
    private double jariJari;
    private double tinggi;
    private double luasPermukaan;
    private double volume;
    
    public Tabung(int r, int tinggi) {
        super(r);
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
        this.tinggi = tinggi;
    }

    public Tabung(double r, double tinggi) {
        super(r);
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * this.pi * this.jariJari * (this.jariJari + tinggi);
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        volume = this.pi * this.jariJari * this.jariJari * tinggi;
        return volume;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}