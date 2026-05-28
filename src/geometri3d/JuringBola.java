package geometri3d;

public class JuringBola extends Bola implements Geometri3D {
    public double jariJari;
    public double tinggiJuring = 10;
    public double pi; 
    public double luasPermukaanJuringBola;
    public double volumeJuringBola;
        
    public JuringBola(double jariJari, double tinggi){
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggiJuring = tinggi;
        this.pi = super.PI;
        super.hitungLuasPermukaan(this.jariJari);
        super.hitungVolume(this.jariJari);
    }
    
    public double hitungJariJariAlas(double jariJari, double tinggi) {
        return Math.sqrt(Math.pow(jariJari, 2) - Math.pow(jariJari - tinggi, 2));
    }
    
    @Override
    public double hitungLuasPermukaan(){
        double jariJariAlas = hitungJariJariAlas(this.jariJari, this.tinggiJuring);
        double luasAlasJuring = super.hitungLuas(jariJariAlas);
        double luasSelimutKubah = super.kelilingLingkaran * this.tinggiJuring;
        luasPermukaanJuringBola = luasAlasJuring + luasSelimutKubah;
        return luasPermukaanJuringBola;
    }
    
    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        double jariJariAlas = hitungJariJariAlas(jariJari, tinggi);
        double luasAlasJuring = super.hitungLuas(jariJariAlas);
        double luasSelimutKubah = super.hitungKeliling(jariJari) * tinggi;
        luasPermukaanJuringBola = luasSelimutKubah + luasAlasJuring;
        return luasPermukaanJuringBola;
    }

    @Override
    public double hitungVolume(){
        volumeJuringBola = (2.0 / 3.0) * super.luasLingkaran * this.tinggiJuring;
        return volumeJuringBola;
    }
    
    public double hitungVolume(double jariJari, double tinggi) {
        volumeJuringBola = (2.0 / 3.0) * super.hitungLuas(jariJari) * tinggi;
        return volumeJuringBola;
    }
}
