package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran implements Geometri3D {
    private double tinggi;

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari); 
        this.tinggi = tinggi;
    }

    public double getGarisPelukis() {
        return Math.sqrt(Math.pow(getJariJari(), 2) + Math.pow(tinggi, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        return hitungLuas() + (Math.PI * getJariJari() * getGarisPelukis());
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    
}