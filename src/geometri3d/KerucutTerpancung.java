package geometri3d;

public class KerucutTerpancung extends Kerucut {
    private double jariJariBawah;
    private double pi;
    private double jariJariAtas;
    private double tinggiKerucutTerpancung;
    private double luasPermukaanKerucutTerpancung;
    private double volumeKerucutTerpancung;
    
    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariBawah = super.getJariJari();
        this.pi = super.getPI();
        this.jariJariAtas = jariJariAtas;
        this.tinggiKerucutTerpancung = tinggi;
    }
 
    public KerucutTerpancung(Kerucut kerucutDasar, double jariJariAtas) {
        super(kerucutDasar.getJariJari(), kerucutDasar.getTinggiKerucut());
        this.jariJariBawah = kerucutDasar.getJariJari(); 
        this.pi = super.getPI();                       
        this.jariJariAtas = jariJariAtas; 
        this.tinggiKerucutTerpancung = kerucutDasar.getTinggiKerucut();
    }
    
    @Override
    public double getGarisPelukis() {
        return Math.sqrt(Math.pow(tinggiKerucutTerpancung, 2) + Math.pow((jariJariBawah - jariJariAtas), 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlasBawah = hitungLuas(); 
        double luasAlasAtas = pi * Math.pow(jariJariAtas, 2);
        double luasSelimut = pi * getGarisPelukis() * (jariJariBawah + jariJariAtas);
        luasPermukaanKerucutTerpancung = luasAlasBawah + luasAlasAtas + luasSelimut;

        return luasPermukaanKerucutTerpancung;
    }
    
    @Override
    public double hitungVolume() {
        volumeKerucutTerpancung = (1.0 / 3.0) * pi * tinggiKerucutTerpancung * 
            (Math.pow(jariJariBawah, 2) + Math.pow(jariJariAtas, 2) + (jariJariBawah * jariJariAtas));
        return volumeKerucutTerpancung;
    }
    
    public double getJariJariAtas() {
        return jariJariAtas;
    }

    public void setJariJariAtas(double jariJariAtas) {
        this.jariJariAtas = jariJariAtas;
    }
    
    public double getJariJariBawah() {
        return super.getJariJari(); 
    }
    
    @Override
    public void setTinggiKerucut(double tinggi) {
        super.setTinggiKerucut(tinggi);
        this.tinggiKerucutTerpancung = tinggi;
    }

    @Override
    public void setJariJari(double jariJariBawah) {
        super.setJariJari(jariJariBawah);
        this.jariJariBawah = jariJariBawah;
    }
    
    public double getLuasPermukaanKerucutTerpancung() {
        return luasPermukaanKerucutTerpancung;
    }

    public double getVolumeKerucutTerpancung() {
        return volumeKerucutTerpancung;
    }
}