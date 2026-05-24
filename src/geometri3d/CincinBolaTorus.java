/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author asus
 */
public class CincinBolaTorus extends Bola implements Geometri3D {
    private double pi;
    private double jariJariMinor;
    private double jariJariMajor = 10;
    private double luasPermukaan;
    private double volume;
    
    public CincinBolaTorus() {
        this.jariJariMinor = super.getJariJari();
        this.pi = super.getPI();
    }
    
    public CincinBolaTorus(double jariJariMinor, double jariJariMajor) {
        super(jariJariMinor);
        this.jariJariMinor = super.getJariJari();
        this.pi = super.getPI();
        this.jariJariMajor = jariJariMajor;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = (2 * this.pi * this.jariJariMinor) * (2 * this.pi * this.jariJariMajor);
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        volume = (this.pi * Math.pow(this.jariJariMinor, 2)) * (2 * this.jariJariMinor * this.jariJariMajor);
        return volume;
    }

    public double getJariJariMajor() {
        return jariJariMajor;
    }

    public void setJariJariMajor(double jariJariMajor) {
        this.jariJariMajor = jariJariMajor;
    }
}
