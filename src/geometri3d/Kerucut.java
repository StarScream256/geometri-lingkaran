package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran implements Geometri3D {
    private double tinggiKerucut;
    private double luasPermukaanKerucut;
    private double volumeKerucut;
    
    public Kerucut(int jariJari, int tinggi) {
        super(jariJari); 
        this.tinggiKerucut = tinggi;
    }
    
    public Kerucut(double jariJari, double tinggi) {
        super(jariJari); 
        this.tinggiKerucut = tinggi;
    }

    public double getGarisPelukis() {
        return Math.sqrt(Math.pow(getJariJari(), 2) + Math.pow(tinggiKerucut, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasSelimutKerucut = getPHI() * getJariJari() * getGarisPelukis();
        
        return this.luasPermukaanKerucut = hitungLuas() + luasSelimutKerucut;
    }

    @Override
    public double hitungVolume() {
        return this.volumeKerucut = (1.0 / 3.0) * Math.pow(getJariJari(), 2) * getPHI();
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