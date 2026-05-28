package geometri3d;

import geometri2d.Lingkaran;

public class Tabung extends Lingkaran implements Geometri3D {
    public double jariJari;
    public double tinggi = 10;
    public double pi; 
    public double luasPermukaanTabung;
    public double volumeTabung;

    public Tabung(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggi = tinggi;
        this.pi = super.PI;
        super.hitungLuas(this.jariJari);
        super.hitungKeliling(this.jariJari);
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.luasLingkaran; 
        double luasSelimut = 2 * this.pi * this.jariJari * this.tinggi;
        luasPermukaanTabung = (2 * luasAlas) + luasSelimut;
        return luasPermukaanTabung;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        double luasAlas = super.hitungLuas(jariJari); 
        double luasSelimut = 2 * super.PI * jariJari * tinggi;
        luasPermukaanTabung = (2 * luasAlas) + luasSelimut;
        return luasPermukaanTabung;
    }

    @Override
    public double hitungVolume() {
        volumeTabung = super.luasLingkaran * this.tinggi;
        return volumeTabung;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeTabung = super.hitungLuas(jariJari) * tinggi;
        return volumeTabung;
    }
}
