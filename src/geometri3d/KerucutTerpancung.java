package geometri3d;

public class KerucutTerpancung extends Kerucut {
    private double jariJariBawah;
    private double phi;
    private double jariJariAtas;
    private double luasPermukaanKerucutTerpancung;
    private double volumeKerucutTerpancung;
    
    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariBawah = super.getJariJari();
        this.phi = super.getPHI();
        this.jariJariAtas = jariJariAtas;
    }
 
    public KerucutTerpancung(Kerucut kerucutDasar, double jariJariAtas) {
        super(kerucutDasar.getJariJari(), kerucutDasar.getTinggiKerucut());
        this.jariJariBawah = kerucutDasar.getJariJari(); 
        this.phi = super.getPHI();                       
        this.jariJariAtas = jariJariAtas;               
    }
    
    @Override
    public double getGarisPelukis() {
        return Math.sqrt(Math.pow(super.getTinggiKerucut(), 2) + Math.pow((jariJariBawah - jariJariAtas), 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlasBawah = hitungLuas(); 
        double luasAlasAtas = phi * Math.pow(jariJariAtas, 2);
        double luasSelimut = phi * getGarisPelukis() * (jariJariBawah + jariJariAtas);
        
        return this.luasPermukaanKerucutTerpancung = luasAlasBawah + luasAlasAtas + luasSelimut;
    }
    
    @Override
    public double hitungVolume() {
        
        return this.volumeKerucutTerpancung = (1.0 / 3.0) * phi * super.getTinggiKerucut() * 
            (Math.pow(jariJariBawah, 2) + Math.pow(jariJariAtas, 2) + (jariJariBawah * jariJariAtas));
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
    }

    @Override
    public void setJariJari(double jariJariBawah) {
        super.setJariJari(jariJariBawah);
    }
    
    public double getLuasPermukaanKerucutTerpancung() {
        return luasPermukaanKerucutTerpancung;
    }

    public double getVolumeKerucutTerpancung() {
        return volumeKerucutTerpancung;
    }
}