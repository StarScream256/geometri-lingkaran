/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author LEGION
 */
public class TemberengBola extends Bola {
    private double pi;
    private double jariJari;
    private double tinggi = 10;
    private double luasPermukaan;
    private double volume;
    
    public TemberengBola() {
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
    }

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari);
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
        this.tinggi = tinggi;
    }
    
    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * this.pi * this.jariJari * tinggi;
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        volume = (1.0/3.0) * this.pi * tinggi * tinggi * (3 * this.jariJari - tinggi);
        return volume;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}