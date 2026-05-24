package geometri3d;

import geometri2d.Lingkaran;

public class Bola extends Lingkaran implements Geometri3D {
    private double volume;
    private double luasPermukaan;
    public Bola(int r) {
        super(r);
    }
    
    public Bola(double r){
        super(r);
    }
    
    @Override
    public double hitungVolume(){
        volume = (4.0 / 3.0 ) * Math.PI * Math.pow(getJariJari(), 3);
        return volume;
    }
    
    @Override
    public double hitungLuasPermukaan(){
        luasPermukaan =  4 * super.hitungLuas();
        return luasPermukaan;
    }
    
}