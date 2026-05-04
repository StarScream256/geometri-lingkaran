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
public class Tabung extends Lingkaran {
    private double tinggi;

    public Tabung(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * getJariJari() * (getJariJari() + tinggi);
    }

    @Override
    public double hitungVolume() {
        return Math.PI * getJariJari() * getJariJari() * tinggi;
    }
    
    
}
