package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran implements Geometri3D {
    private double jariJari;
    private double phi;
    private double tinggiKerucut;
    private double luasPermukaanKerucut;
    private double volumeKerucut;
    
    public Kerucut(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = super.getJariJari();
        this.phi = super.getPHI();
        this.tinggiKerucut = tinggi;
    }

    public double getGarisPelukis() {
        return Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggiKerucut, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasSelimutKerucut = phi * jariJari * getGarisPelukis();
        return this.luasPermukaanKerucut = super.hitungLuas() + luasSelimutKerucut;
    }

    @Override
    public double hitungVolume() {
        return this.volumeKerucut = (1.0 / 3.0) * phi * Math.pow(jariJari, 2) * tinggiKerucut;
    }
    
    public double getTinggiKerucut() {
        return tinggiKerucut;
    }

    public void setTinggiKerucut(double tinggiKerucut) {
        this.tinggiKerucut = tinggiKerucut;
    }
    
    public double getLuasPermukaanKerucut() {
        return luasPermukaanKerucut;
    }

    public double getVolumeKerucut() {
        return volumeKerucut;
    }
}