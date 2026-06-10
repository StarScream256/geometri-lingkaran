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
        luasPermukaanTabung = (2 * super.luasLingkaran)
                               +
                              (2 * super.PI * this.jariJari * this.tinggi);
        return luasPermukaanTabung;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        luasPermukaanTabung = (2 * super.hitungLuas(jariJari))
                               +
                              (2 * super.PI * jariJari * tinggi);
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
