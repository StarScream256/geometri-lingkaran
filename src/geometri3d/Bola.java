package geometri3d;

import geometri2d.Lingkaran;

public class Bola extends Lingkaran implements Geometri3D {
    private double jariJari;
    private double pi;
    private double volume;
    private double luasPermukaan;
    
    public Bola(int r) {
        super(r);
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
    }
    
    public Bola(double r){
        super(r);
    }
    
    @Override
    public double hitungVolume(){
        volume = (4.0 / 3.0 ) * this.pi * Math.pow(this.jariJari, 3);
        return volume;
    }
    
    @Override
    public double hitungLuasPermukaan(){
        luasPermukaan =  4 * super.hitungLuas();
        return luasPermukaan;
    }
    
}