package geometri2d;

public class TemberengLingkaran extends JuringLingkaran implements Geometri2D {
    public double jariJari;
    public double sudutTembereng = 90;
    public double pi;
    public double luasTemberengLingkaran;
    public double kelilingTemberengLingkaran;
 
    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut); 
        this.jariJari = jariJari;
        this.sudutTembereng = sudut;
        this.pi = super.PI;
        super.hitungLuas(this.jariJari, this.sudutTembereng);
        super.hitungKeliling(this.jariJari, this.sudutTembereng);
    }

    @Override
    public double hitungLuas() {
        luasTemberengLingkaran = super.luasJuringLingkaran
                                 -
                                 (0.5 * this.jariJari * this.jariJari * Math.sin(Math.toRadians(this.sudutTembereng)));
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungLuas(double jariJari, double sudut) {
        luasTemberengLingkaran = super.hitungLuas(jariJari, sudut)
                                 -
                                 (0.5 * Math.pow(jariJari, 2) * Math.sin(Math.toRadians(sudut)));
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungKeliling() {
        kelilingTemberengLingkaran = super.kelilingJuringLingkaran - (2 * this.jariJari)
                                     +
                                     (2 * this.jariJari * Math.sin(Math.toRadians(this.sudutTembereng / 2.0)));
        return kelilingTemberengLingkaran;
    }

    @Override
    public double hitungKeliling(double jariJari, double sudut) {
        kelilingTemberengLingkaran = super.hitungKeliling(jariJari, sudut) - (2 * jariJari)
                                     +
                                     (2 * jariJari * Math.sin(Math.toRadians(sudut / 2.0)));
        return kelilingTemberengLingkaran;
    }
}