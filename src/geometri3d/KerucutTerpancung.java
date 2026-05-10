package geometri3d;

public class KerucutTerpancung extends Kerucut {
    private double jariJariAtas;

    public KerucutTerpancung(double rBawah, double tinggi, double rAtas) {
        super(rBawah, tinggi); // rBawah dan tinggi dikelola oleh bapaknya (Kerucut)
        this.jariJariAtas = rAtas;
    }

    // Overriding Garis Pelukis untuk versi terpancung
    @Override
    public double getGarisPelukis() {
        double selisihR = getJariJari() - jariJariAtas;
        return Math.sqrt(Math.pow(getTinggi(), 2) + Math.pow(selisihR, 2));
    }

    @Override
    public double hitungVolume() {
        // Rumus: 1/3 * PI * t * (R^2 + r^2 + (R*r))
        double rBawah = getJariJari();
        return (1.0 / 3.0) * Math.PI * getTinggi() * (Math.pow(rBawah, 2) + Math.pow(jariJariAtas, 2) + (rBawah * jariJariAtas));
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlasBawah = hitungLuas(); // Memanggil PI * rBawah^2 dari Lingkaran
        double luasAlasAtas = Math.PI * Math.pow(jariJariAtas, 2);
        double luasSelimut = Math.PI * getGarisPelukis() * (getJariJari() + jariJariAtas);
        
        return luasAlasBawah + luasAlasAtas + luasSelimut;
    }
}