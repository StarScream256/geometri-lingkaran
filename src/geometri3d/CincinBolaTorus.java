/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author asus
 */
public class CincinBolaTorus extends Bola {
    private double jariJariMajor;
    
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
        double luasPermukaan = (2 * Math.PI * getJariJari()) * (2 * Math.PI * this.jariJariMajor);
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        double volume = (Math.PI * Math.pow(getJariJari(), 2)) * (2 * getJariJari() * this.jariJariMajor);
        return volume;
    }

    public double getJariJariMajor() {
        return jariJariMajor;
    }

    public void setJariJariMajor(double jariJariMajor) {
        this.jariJariMajor = jariJariMajor;
    }
    
    
}
