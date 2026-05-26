package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran implements Geometri3D {
    public double jariJari = 7;
    public double tinggiKerucut = 10;
    public double pi;
    public double luasPermukaanKerucut;
    public double volumeKerucut;
    
    public Kerucut(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggiKerucut = tinggi;
        this.pi = super.PI;
    }

    private double hitungGarisPelukis(double jariJari, double tinggi) {
        return Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggi, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double selimutKerucut = hitungGarisPelukis(this.jariJari, this.tinggiKerucut);
        double luasAlas = super.hitungLuas(); 
        double luasSelimut =  this.pi * this.jariJari * selimutKerucut;
        luasPermukaanKerucut = luasAlas + luasSelimut;
        return luasPermukaanKerucut;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        double selimutKerucut = hitungGarisPelukis(jariJari, tinggi);
        double luasAlas = super.hitungLuas(jariJari); 
        double luasSelimut =  super.PI * jariJari * selimutKerucut;
        luasPermukaanKerucut = luasAlas + luasSelimut;
        return luasPermukaanKerucut;
    }

    @Override
    public double hitungVolume() {
        volumeKerucut = (1.0 / 3.0) * super.hitungLuas() * this.tinggiKerucut;
        return volumeKerucut;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeKerucut = (1.0 / 3.0) * super.hitungLuas(jariJari) * tinggi;
        return volumeKerucut;
    }
}