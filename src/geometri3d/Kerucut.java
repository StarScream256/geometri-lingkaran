package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran implements Geometri3D, Runnable  {
    public Thread t; 
    public double jariJari;
    public double pi;
    public double tinggiKerucut = 10;
    public double luasPermukaanKerucut;
    public double volumeKerucut;
    
    public Kerucut() {
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
    }
    
    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
        this.tinggiKerucut = tinggi;
    }

    public double getGarisPelukis() {
        double garisPelukis = Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggiKerucut, 2));
        return garisPelukis;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasSelimutKerucut = pi * jariJari * getGarisPelukis();
        luasPermukaanKerucut = super.hitungLuas() + luasSelimutKerucut;
        return luasPermukaanKerucut;
    }

    @Override
    public double hitungVolume() {
        volumeKerucut = (1.0 / 3.0) * pi * Math.pow(jariJari, 2) * tinggiKerucut;
        return volumeKerucut;
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