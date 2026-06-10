package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran implements Geometri3D {
    public double jariJari;
    public double tinggiKerucut = 10;
    public double pi;
    public double luasPermukaanKerucut;
    public double volumeKerucut;
    
    public Kerucut(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggiKerucut = tinggi;
        this.pi = super.PI;
        super.hitungLuas(this.jariJari);
        super.hitungKeliling(this.jariJari);
    }
    
    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanKerucut = super.luasLingkaran
                               +
                               super.PI * this.jariJari 
                               * 
                               Math.sqrt(Math.pow(this.jariJari, 2) + Math.pow(this.tinggiKerucut, 2));
        return luasPermukaanKerucut;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        luasPermukaanKerucut = super.hitungLuas(jariJari)
                               +
                               super.PI * jariJari 
                               * 
                               Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggi, 2));;
        return luasPermukaanKerucut;
    }

    @Override
    public double hitungVolume() {
        volumeKerucut = (1.0 / 3.0) * super.luasLingkaran * this.tinggiKerucut;
        return volumeKerucut;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeKerucut = (1.0 / 3.0) * super.hitungLuas(jariJari) * tinggi;
        return volumeKerucut;
    }
}