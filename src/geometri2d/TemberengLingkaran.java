package geometri2d;

public class TemberengLingkaran extends JuringLingkaran {
    private double luasTemberengLingkaran;
    private double kelilingTemberengLingkaran;
    
    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
    }

    public TemberengLingkaran(JuringLingkaran juringDasar) {
        super(juringDasar.getJariJari(), juringDasar.getSudut());
    }
    
    @Override
    public double hitungLuas() {
        double luasSegitiga = 0.5 * Math.pow(super.getJariJari(), 2) * Math.sin(getSudut());
        
        return this.luasTemberengLingkaran = super.hitungLuas() - luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = super.hitungKeliling() - (2 * super.getJariJari());
        double panjangTaliBusur = 2 * super.getJariJari() * Math.sin(getSudut() / 2.0);

        return this.kelilingTemberengLingkaran = panjangBusur + panjangTaliBusur;
    }
    
    @Override
    public void setSudut(double sudut) {
        super.setSudut(sudut); 
    }
    
    public double getLuasTemberengLingkaran() {
        return luasTemberengLingkaran;
    }

    public double getKelilingTemberengLingkaran() {
        return kelilingTemberengLingkaran;
    }
}