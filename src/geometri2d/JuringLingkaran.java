package geometri2d;

public class JuringLingkaran extends Lingkaran {
    public double jariJari = 7; 
    public double sudutJuring = 90;
    public double pi;
    public double luasJuringLingkaran;
    public double kelilingJuringLingkaran;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.sudutJuring = sudut;
        this.pi = super.PI;
    }

    @Override
    public double hitungLuas() {
        luasJuringLingkaran = (this.sudutJuring / 360.0) * super.hitungLuas();
        return luasJuringLingkaran;
    }

    public double hitungLuas(double jariJari, double sudut) {
        luasJuringLingkaran = (sudut / 360.0) * super.hitungLuas(jariJari);
        return luasJuringLingkaran;
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = (this.sudutJuring / 360.0) * super.hitungKeliling();
        kelilingJuringLingkaran = panjangBusur + (2 * this.jariJari);
        return kelilingJuringLingkaran;
    }

    public double hitungKeliling(double jariJari, double sudut) {
        double panjangBusur = (sudut / 360.0) * super.hitungKeliling(jariJari);
        kelilingJuringLingkaran = panjangBusur + (2 * jariJari);
        return kelilingJuringLingkaran;
    }
}