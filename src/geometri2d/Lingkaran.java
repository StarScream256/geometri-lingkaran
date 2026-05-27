package geometri2d;

public class Lingkaran implements Geometri2D {
    public double jariJari = 7;
    public double luasLingkaran;
    public double kelilingLingkaran;
    public final double PI = Math.PI;
    
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        luasLingkaran = PI * this.jariJari * this.jariJari;
        return luasLingkaran;
    }
    
    public double hitungLuas(double jariJari) {
        luasLingkaran = PI * jariJari * jariJari;
        return luasLingkaran;
    }
    
    @Override
    public double hitungKeliling() {
        kelilingLingkaran = 2 * PI * this.jariJari;
        return kelilingLingkaran;
    }
    
    public double hitungKeliling(double jariJari) {
        kelilingLingkaran = 2 * PI * jariJari;
        return kelilingLingkaran;
    }
}
