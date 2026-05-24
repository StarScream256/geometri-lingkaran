
package geometri2d;

public class Lingkaran implements Geometri2D {
    private double jariJari;
    private double luas;
    private double keliling;
    private final double PI = Math.PI;
    
    public Lingkaran() {
        this.jariJari = 0;
    }
    
    public Lingkaran(int jariJari) {
        this.jariJari = jariJari;
    }

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }
    
    public double getPI() {
        return PI;
    }

    @Override
    public double hitungLuas() {
        luas = PI * jariJari * jariJari;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * PI * jariJari;
        return keliling;
    }
}
