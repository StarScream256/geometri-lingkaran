package geometri2d;

public class TemberengLingkaran extends JuringLingkaran {
    private double jariJari;
    private double pi;
    private double sudutTembereng;
    private double luasTemberengLingkaran;
    private double kelilingTemberengLingkaran;
    
    public TemberengLingkaran() {
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
    }
    
    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
        this.sudutTembereng = sudut;
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
    }

    public TemberengLingkaran(JuringLingkaran juringDasar) {
        super(juringDasar.getJariJari(), juringDasar.getSudut());
        this.sudutTembereng = juringDasar.getSudut();
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
    }
    
    @Override
    public double hitungLuas() {
        double luasSegitiga = 0.5 * Math.pow(jariJari, 2) * Math.sin(Math.toRadians(sudutTembereng));
        luasTemberengLingkaran = super.hitungLuas() - luasSegitiga;
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = super.hitungKeliling() - (2 * jariJari);
        double panjangTaliBusur = 2 * jariJari * Math.sin(sudutTembereng / 2.0);
        kelilingTemberengLingkaran = panjangBusur + panjangTaliBusur;
        return kelilingTemberengLingkaran;
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