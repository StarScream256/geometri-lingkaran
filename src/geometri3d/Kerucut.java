package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran {
    private double tinggi;

    public Kerucut(double r, double tinggi) {
        super(r); // Mengirim r ke constructor Lingkaran
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    // Garis pelukis (s) dibutuhkan untuk Luas Permukaan
    public double getGarisPelukis() {
        return Math.sqrt(Math.pow(getJariJari(), 2) + Math.pow(tinggi, 2));
    }

    @Override
    public double hitungVolume() {
        // Rumus: 1/3 * Luas Alas * Tinggi
        return (1.0 / 3.0) * hitungLuas() * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Rumus: Luas Alas + Luas Selimut (PI * r * s)
        return hitungLuas() + (Math.PI * getJariJari() * getGarisPelukis());
    }
}