package geometri2d;

public class TemberengLingkaran extends JuringLingkaran {
    public double jariJari = 7;
    public double sudutTembereng = 90;
    public double pi;
    public double luasTemberengLingkaran;
    public double kelilingTemberengLingkaran;
 
    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut); 
        this.jariJari = jariJari;
        this.sudutTembereng = sudut;
        this.pi = super.pi;
    }

    @Override
    public double hitungLuas() {
        double luasJuring = super.hitungLuas(); 
        double luasSegitiga = 0.5 * this.jariJari * this.jariJari * Math.sin(Math.toRadians(this.sudutTembereng));
        luasTemberengLingkaran = luasJuring - luasSegitiga;
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungLuas(double jariJari, double sudut) {
        double luasJuring = super.hitungLuas(jariJari, sudut);
        double luasSegitiga = 0.5 * Math.pow(jariJari, 2) * Math.sin(Math.toRadians(sudut));
        luasTemberengLingkaran = luasJuring - luasSegitiga;
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = super.hitungKeliling() - (2 * this.jariJari);
        double panjangTaliBusur = 2 * this.jariJari * Math.sin(Math.toRadians(this.sudutTembereng / 2.0));
        kelilingTemberengLingkaran = panjangBusur + panjangTaliBusur;
        return kelilingTemberengLingkaran;
    }

    @Override
    public double hitungKeliling(double jariJari, double sudut) {
        double panjangBusur = super.hitungKeliling(jariJari, sudut) - (2 * jariJari);
        double panjangTaliBusur = 2 * jariJari * Math.sin(Math.toRadians(sudut / 2.0));
        kelilingTemberengLingkaran = panjangBusur + panjangTaliBusur;
        return kelilingTemberengLingkaran;
    }
}