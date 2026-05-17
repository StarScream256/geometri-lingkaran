package geometri3d;

public class KerucutTerpancung extends Kerucut {
    private double jariJariAtas;

    public KerucutTerpancung(int jariJariBawah, int tinggi, int jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariAtas = jariJariAtas;
    }
    
    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariAtas = jariJariAtas;
    }
 
    @Override
    public double getGarisPelukis() {
        double jariJariBawah = getJariJari();
        double selisihJariJari = jariJariBawah - jariJariAtas;
        double tinggi = getTinggi();
        
        return Math.sqrt(Math.pow(tinggi, 2) + Math.pow(selisihJariJari, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double jariJariBawah = getJariJari();
        double garisPelukis = getGarisPelukis();
        
        double luasAlasBawah = hitungLuas(); 
        double luasAlasAtas = Math.PI * Math.pow(jariJariAtas, 2);
        double luasSelimut = Math.PI * garisPelukis * (jariJariBawah + jariJariAtas);
        
        return luasAlasBawah + luasAlasAtas + luasSelimut;
    }
    
    @Override
    public double hitungVolume() {
        double jariJariBawah = getJariJari();
        double tinggi = getTinggi();
        
        return (1.0 / 3.0) * Math.PI * tinggi * (Math.pow(jariJariBawah, 2) + Math.pow(jariJariAtas, 2) + (jariJariBawah * jariJariAtas));
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
}