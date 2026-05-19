package geometri3d;

public class KerucutTerpancung extends Kerucut {
    private double jariJariAtas;
    private double luasPermukaanKerucutTerpancung;
    private double volumeKerucutTerpancung;
    
    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariAtas = jariJariAtas;
    }
 
    @Override
    public double getGarisPelukis() {
        double jariJariBawah = getJariJari();
        return Math.sqrt(Math.pow(getTinggiKerucut(), 2) + Math.pow((jariJariBawah - jariJariAtas), 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double jariJariBawah = getJariJari();
        
        double luasAlasBawah = hitungLuas(); 
        double luasAlasAtas = getPHI() * Math.pow(jariJariAtas, 2);
        double luasSelimut = getPHI() * getGarisPelukis() * (jariJariBawah + jariJariAtas);
        
        return this.luasPermukaanKerucutTerpancung = luasAlasBawah + luasAlasAtas + luasSelimut;
    }
    
    @Override
    public double hitungVolume() {
        double jariJariBawah = getJariJari();
        
        return this.volumeKerucutTerpancung = (1.0 / 3.0) * getPHI() * getTinggiKerucut() * 
                (Math.pow(jariJariBawah, 2) + Math.pow(jariJariAtas, 2) + (jariJariBawah * jariJariAtas));
    }
    
    public double getJariJariAtas() {
        return jariJariAtas;
    }

    public void setJariJariAtas(double jariJariAtas) {
        this.jariJariAtas = jariJariAtas;
    }
    
    public double getJariJariBawah() {
        return getJariJari(); 
    }
    
    public double getLuasPermukaanKerucutTerpancung() {
        return luasPermukaanKerucutTerpancung;
    }

    public double getVolumeKerucutTerpancung() {
        return volumeKerucutTerpancung;
    }
}