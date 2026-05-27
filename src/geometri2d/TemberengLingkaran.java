package geometri2d;

public class TemberengLingkaran extends JuringLingkaran implements Runnable {
    public double jariJari = 7;
    public double sudutTembereng = 90;
    public double pi;
    public double luasTemberengLingkaran;
    public double kelilingTemberengLingkaran;
    
    public int count;
    public int delay;
 
    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.sudutTembereng = sudut;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
    }
    
    public TemberengLingkaran(double jariJari, double sudut, int count, int delay) {
        super(jariJari, sudut); 
        this.jariJari = jariJari;
        this.sudutTembereng = sudut;
        this.pi = super.pi;
        this.count = count;
        this.delay = delay;
    }

    @Override
    public double hitungLuas() {
        double luasJuring = super.luasJuringLingkaran; 
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
        double panjangBusur = super.kelilingJuringLingkaran - (2 * this.jariJari);
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
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                sudutJuring += i;
                luasTemberengLingkaran = hitungLuas(jariJari, sudutJuring);
                kelilingTemberengLingkaran = hitungKeliling(jariJari, sudutJuring);

                String output = String.format(
                    """
                    Thread Tembereng Lingkaran #%d (%s)
                    Jari-jari          : %.2f
                    Sudut Tembereng    : %.2f
                    Luas Tembereng     : %.2f 
                    Keliling Tembereng : %.2f 
                    ------------------------------------
                    """,
                    i, threadName, jariJari, sudutJuring, luasLingkaran, kelilingLingkaran
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
