package geometri3d;

public class TemberengBola extends Bola {
    public double jariJari = 7;
    public double tinggiTembereng = 10;
    public double pi; 
    public double luasPermukaanTemberengBola;
    public double volumeTemberengBola;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggiTembereng = tinggi;
        this.pi = super.pi; 
    }

    private double hitungJariJariAlas(double jariJari, double tinggi) {
        return Math.sqrt(Math.pow(jariJari, 2) - Math.pow(jariJari - tinggi, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double jariJariAlas = hitungJariJariAlas(this.jariJari, this.tinggiTembereng);
        double luasAlasTembereng = super.hitungLuas(jariJariAlas);
        double luasKubahMelengkung = super.hitungKeliling() * this.tinggiTembereng;   
        luasPermukaanTemberengBola = luasAlasTembereng + luasKubahMelengkung;
        return luasPermukaanTemberengBola;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        double jariJariAlas = hitungJariJariAlas(jariJari, tinggi);
        double luasAlasTembereng = super.hitungLuas(jariJariAlas);
        double luasKubahMelengkung = super.hitungKeliling(jariJari) * tinggi;
        this.luasPermukaanTemberengBola = luasAlasTembereng + luasKubahMelengkung;
        return this.luasPermukaanTemberengBola;
    }

    @Override
    public double hitungVolume() {
        volumeTemberengBola = (1.0 / 3.0) * this.pi * Math.pow(this.tinggiTembereng, 2) * 
                ((3 * this.jariJari) - this.tinggiTembereng);
        return volumeTemberengBola;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeTemberengBola = (1.0 / 3.0) * super.pi * Math.pow(tinggi, 2) * ((3 * jariJari) - tinggi);
        return volumeTemberengBola;
    }
}