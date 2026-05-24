/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

public class TemberengBola extends Bola {

    private double tinggi;

    public TemberengBola(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * getJariJari() * tinggi;
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * Math.PI * tinggi * tinggi
                * (3 * getJariJari() - tinggi);
    }

    // OVERLOADING
    public double hitungVolume(double r, double t) {
        return (1.0 / 3.0) * Math.PI * t * t * (3 * r - t);
    }

    // Getter Setter
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}