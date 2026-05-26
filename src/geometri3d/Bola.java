package geometri3d;

import geometri2d.Lingkaran;

public class Bola extends Lingkaran implements Geometri3D {
    public double jariJari = 7;
    public double pi; 
    public double volumeBola;
    public double luasPermukaanBola;
    
    public Bola(double jariJari) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.pi = super.PI; 
    }
    
    @Override
    public double hitungVolume() {
        volumeBola = (4.0 / 3.0) * this.pi * Math.pow(this.jariJari, 3);
        return volumeBola;
    }
    
    public double hitungVolume(double jariJari) {
        volumeBola = (4.0 / 3.0) * super.PI * Math.pow(jariJari, 3);
        return volumeBola;
    }
    
    @Override
    public double hitungLuasPermukaan() {
       luasPermukaanBola = 4 * super.hitungLuas();
        return luasPermukaanBola;
    }
    
    public double hitungLuasPermukaan(double jariJari) {
        luasPermukaanBola = 4 * super.hitungLuas(jariJari);
        return luasPermukaanBola;
    }
}
