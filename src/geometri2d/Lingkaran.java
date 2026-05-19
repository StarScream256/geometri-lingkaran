/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri2d;
/**
 *
 * @author Lenovo
 */
public class Lingkaran implements Geometri2D {
    private double jariJari;
    private static final double PHI = Math.PI;

    public Lingkaran() {
        this.jariJari = 0;
    }
    
    public Lingkaran(int jariJari) {
        this.jariJari = jariJari;
    }

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }
    
    public static double getPHI() {
        return PHI;
    }

    @Override
    public double hitungLuas() {
        return PHI * jariJari * jariJari;
    }

    @Override
    public double hitungKeliling() {
        return 2 * PHI * jariJari;
    }
}
