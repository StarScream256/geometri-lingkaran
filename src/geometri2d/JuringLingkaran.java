package geometri2d;

public class JuringLingkaran extends Lingkaran implements Geometri2D {
    public double jariJari; 
    public double sudutJuring = 90;
    public double pi;
    public double luasJuringLingkaran;
    public double kelilingJuringLingkaran;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.sudutJuring = sudut;
        this.pi = super.PI;
        super.hitungLuas(this.jariJari);
        super.hitungKeliling(this.jariJari);
    }

    @Override
    public double hitungLuas() {
        luasJuringLingkaran = (this.sudutJuring / 360.0) * super.luasLingkaran;
        return luasJuringLingkaran;
    }

    public double hitungLuas(double jariJari, double sudut) {
        luasJuringLingkaran = (sudut / 360.0) * super.hitungLuas(jariJari);
        return luasJuringLingkaran;
    }

    @Override
    public double hitungKeliling() {
        kelilingJuringLingkaran = (this.sudutJuring / 360.0) * super.kelilingLingkaran + (2 * this.jariJari);
        return kelilingJuringLingkaran;
    }

    public double hitungKeliling(double jariJari, double sudut) {
        kelilingJuringLingkaran = (sudut / 360.0) * super.hitungKeliling(jariJari) + (2 * jariJari);
        return kelilingJuringLingkaran;
    }
}