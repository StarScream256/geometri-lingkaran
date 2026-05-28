package geometri3d;

public class CincinBola extends Bola implements Geometri3D {
    public double jariJari;
    public double tinggi = 10;
    public double pi; 
    public double volumeCincinBola;
    public double luasPermukaanCincinBola;

    public CincinBola(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggi = tinggi;
        this.pi = super.PI;
        super.hitungLuasPermukaan(this.jariJari);
        super.hitungVolume(this.jariJari);
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanCincinBola = 2 * this.pi * this.jariJari * this.tinggi;
        return luasPermukaanCincinBola;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        luasPermukaanCincinBola = 2 * super.PI * jariJari * tinggi;
        return luasPermukaanCincinBola;
    }

    @Override
    public double hitungVolume() {
        volumeCincinBola = (1.0 / 6.0) * this.pi * Math.pow(this.tinggi, 3); 
        return volumeCincinBola;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeCincinBola = (1.0 / 6.0) * super.PI * Math.pow(tinggi, 3); 
        return volumeCincinBola;
    }
}
