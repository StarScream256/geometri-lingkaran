package geometri2d;

public class JuringLingkaran extends Lingkaran {
    private double jariJari;
    private double phi;
    private double sudutJuring; 
    private double luasJuringLingkaran;
    private double kelilingJuringLingkaran;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudutJuring = sudut;
        this.jariJari = super.getJariJari();
        this.phi = super.getPI();
    }

    @Override
    public double hitungLuas() {
        luasJuringLingkaran = (sudutJuring / 360.0) * super.hitungLuas();
        return luasJuringLingkaran;
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = (sudutJuring / 360.0) * (2 * phi * jariJari);
        kelilingJuringLingkaran = panjangBusur + (2 * jariJari);
        return kelilingJuringLingkaran;
    }

    public double getSudut() {
        return sudutJuring;
    }

    public void setSudut(double sudut) {
        this.sudutJuring = sudut;
    }

    public double getLuasJuringLingkaran() {
        return luasJuringLingkaran;
    }

    public double getKelilingJuringLingkaran() {
        return kelilingJuringLingkaran;
    }
}