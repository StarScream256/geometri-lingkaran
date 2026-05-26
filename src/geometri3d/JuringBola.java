package geometri3d;

public class JuringBola extends Bola {
    public double jariJari = 7;
    public double tinggiJuring = 10;
    public double pi; 
    public double luasPermukaanJuringBola;
    public double volumeJuringBola;
        
    public JuringBola(double jariJari, double tinggi){
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggiJuring = tinggi;
        this.pi = super.pi;
    }
    
    private double hitungJariJariAlas(double jariJari, double tinggi) {
        return Math.sqrt(Math.pow(jariJari, 2) - Math.pow(jariJari - tinggi, 2));
    }
    
    @Override
    public double hitungLuasPermukaan(){
        double jariJariAlas = hitungJariJariAlas(this.jariJari, this.tinggiJuring);
        double luasAlasJuring = super.hitungLuas(jariJariAlas);
        double luasSelimutKubah = super.hitungKeliling() * this.tinggiJuring;
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
        volumeJuringBola = (2.0 / 3.0) * super.hitungLuas() * this.tinggiJuring;
        return volumeJuringBola;
    }
    
    public double hitungVolume(double jariJari, double tinggi) {
        volumeJuringBola = (2.0 / 3.0) *super.hitungLuas(jariJari) * tinggi;
        return volumeJuringBola;
    }
}
