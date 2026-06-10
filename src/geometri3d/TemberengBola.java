package geometri3d;

public class TemberengBola extends Bola implements Geometri3D {
    public double jariJari;
    public double tinggiTembereng = 10;
    public double pi; 
    public double luasPermukaanTemberengBola;
    public double volumeTemberengBola;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggiTembereng = tinggi;
        this.pi = super.PI; 
        super.hitungLuasPermukaan(this.jariJari);
        super.hitungVolume(this.jariJari);
    }

    @Override
    public double hitungLuasPermukaan() { 
        luasPermukaanTemberengBola = super.PI * (4 * this.jariJari * this.tinggiTembereng 
                                     - 
                                     this.tinggiTembereng * this.tinggiTembereng);
        return luasPermukaanTemberengBola;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        this.luasPermukaanTemberengBola = super.PI * (4 * jariJari * tinggi - tinggi * tinggi);
        return this.luasPermukaanTemberengBola;
    }

    @Override
    public double hitungVolume() {
        volumeTemberengBola = (1.0 / 3.0) * this.pi * Math.pow(this.tinggiTembereng, 2) 
                               * ((3 * this.jariJari) - this.tinggiTembereng);
        return volumeTemberengBola;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeTemberengBola = (1.0 / 3.0) * super.PI * Math.pow(tinggi, 2) * ((3 * jariJari) - tinggi);
        return volumeTemberengBola;
    }
}