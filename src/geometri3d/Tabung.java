/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author LEGION
 */
public class Tabung {
    private double r;
    private double tinggi;

    public Tabung(double r, double tinggi) {
        this.r = r;
        this.tinggi = tinggi;
    }

    public double getVolume() {
        return Math.PI * r * r * tinggi;
    }
}
