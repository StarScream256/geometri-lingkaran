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
    private double jariJariMajor;
    private double luasPermukaan;
    private double volume;
    
    public CincinBolaTorus(int jariJariMinor, int jariJariMajor) {
        super(jariJariMinor);
        this.jariJariMajor = jariJariMajor;
    }
    
    public CincinBolaTorus(double jariJariMinor, double jariJariMajor) {
        super(jariJariMinor);
        this.jariJariMajor = jariJariMajor;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = (2 * super.getPHI() * super.getJariJari()) * (2 * Math.PI * this.jariJariMajor);
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        volume = (super.getPHI() * Math.pow(super.getJariJari(), 2)) * (2 * super.getJariJari() * this.jariJariMajor);
        return volume;
    }

    public double getJariJariMajor() {
        return jariJariMajor;
    }

    public void setJariJariMajor(double jariJariMajor) {
        this.jariJariMajor = jariJariMajor;
    }
}
