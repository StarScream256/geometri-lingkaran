package geometri3d;

public class KerucutTerpancung extends Kerucut {
    public double jariJariBawah = 7;
    public double jariJariAtas = 3;
    public double tinggiKerucutTerpancung = 10;
    public double pi; 
    public double luasPermukaanKerucutTerpancung;
    public double volumeKerucutTerpancung;
    
    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariBawah = jariJariBawah;
        this.tinggiKerucutTerpancung = tinggi;
        this.jariJariAtas = jariJariAtas;
        this.pi = super.pi; 
    }

    private double hitungGarisPelukis(double jariJariBawah, double jariJariAtas, double tinggi) {
        return Math.sqrt(Math.pow(tinggi, 2) + Math.pow((jariJariBawah - jariJariAtas), 2));
    }
    
    @Override
    public double hitungLuasPermukaan() {
        double s = hitungGarisPelukis(this.jariJariBawah, this.jariJariAtas, this.tinggiKerucutTerpancung);
        double luasAlasBawah = super.hitungLuas(); 
        double luasAlasAtas = this.pi * Math.pow(this.jariJariAtas, 2);
        double luasSelimut = this.pi * s * (this.jariJariBawah + this.jariJariAtas);
        luasPermukaanKerucutTerpancung = luasAlasBawah + luasAlasAtas + luasSelimut;
        return luasPermukaanKerucutTerpancung;
    }

    public double hitungLuasPermukaan(double jariJariBawah, double tinggi, double jariJariAtas) {
        double garisPelukis = hitungGarisPelukis(jariJariBawah, jariJariAtas, tinggi);
        double luasAlasBawah = super.hitungLuas(jariJariBawah); 
        double luasAlasAtas = super.pi * Math.pow(jariJariAtas, 2); 
        double luasSelimut = super.pi * garisPelukis * (jariJariBawah + jariJariAtas);
        luasPermukaanKerucutTerpancung = luasAlasBawah + luasAlasAtas + luasSelimut;
        return luasPermukaanKerucutTerpancung;
    }

    @Override
    public double hitungVolume() {
        volumeKerucutTerpancung = (1.0 / 3.0) * this.pi * this.tinggiKerucutTerpancung * 
                (Math.pow(this.jariJariBawah, 2) + Math.pow(this.jariJariAtas, 2) + 
                (this.jariJariBawah * this.jariJariAtas));
        return volumeKerucutTerpancung;
    }

    public double hitungVolume(double jariJariBawah, double tinggi, double jariJariAtas) {
        volumeKerucutTerpancung = (1.0 / 3.0) * super.pi * tinggi * (Math.pow(jariJariBawah, 2) + 
                Math.pow(jariJariAtas, 2) + (jariJariBawah * jariJariAtas));
        return volumeKerucutTerpancung;
    }
}