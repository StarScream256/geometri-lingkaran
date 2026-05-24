/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author asus
 */
public class CincinBola extends Bola implements Geometri3D {
    private double pi;
    private double jariJari;
    private double tinggi;
    private double volume;
    private double luasPermukaan;
    
    public CincinBola(int jariJari, int tinggi) {
        super(jariJari);
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
        this.tinggi = tinggi;
    }
    
    public CincinBola(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * this.pi * this.jariJari * this.tinggi;
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        volume = (1.0 / 6.0) * this.pi * Math.pow(this.tinggi, 3); 
        return volume;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}
