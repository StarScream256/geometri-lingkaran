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
    private double tinggi;

    public TemberengBola(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    public double getVolume() {
        return (1.0/3.0) * Math.PI * tinggi * tinggi * (3 * getJariJari() - tinggi);
    }
}
