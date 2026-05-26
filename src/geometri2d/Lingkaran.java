package geometri2d;

public class Lingkaran implements Geometri2D {
    public double jariJari = 7;
    public double luas;
    public double keliling;
    public final double PI = Math.PI;
    
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        luas = PI * this.jariJari * this.jariJari;
        return luas;
    }
    
    public double hitungLuas(double jariJari) {
        luas = PI * jariJari * jariJari;
        return luas;
    }
    
    @Override
    public double hitungKeliling() {
        keliling = 2 * PI * this.jariJari;
        return keliling;
    }
    
    public double hitungKeliling(double jariJari) {
        keliling = 2 * PI * jariJari;
        return keliling;
    }
}