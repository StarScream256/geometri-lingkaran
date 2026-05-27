package geometri2d;

public class JuringLingkaran extends Lingkaran implements Runnable {
    public double jariJari = 7; 
    public double sudutJuring = 90;
    public double pi;
    public double luasJuringLingkaran;
    public double kelilingJuringLingkaran;
    
    public int count;
    public int delay;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.sudutJuring = sudut;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
    }
    
    public JuringLingkaran(double jariJari, double sudut, int count, int delay) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.sudutJuring = sudut;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
        this.count = count;
        this.delay = delay;
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
        double panjangBusur = (this.sudutJuring / 360.0) * super.kelilingLingkaran;
        kelilingJuringLingkaran = panjangBusur + (2 * this.jariJari);
        return kelilingJuringLingkaran;
    }

    public double hitungKeliling(double jariJari, double sudut) {
        double panjangBusur = (sudut / 360.0) * super.hitungKeliling(jariJari);
        kelilingJuringLingkaran = panjangBusur + (2 * jariJari);
        return kelilingJuringLingkaran;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                sudutJuring += i;
                luasJuringLingkaran = hitungLuas(jariJari, sudutJuring);
                kelilingJuringLingkaran = hitungKeliling(jariJari, sudutJuring);

                String output = String.format(
                    """
                    Thread Juring Lingkaran #%d (%s)
                    Jari-jari      : %.2f; 
                    Tinggi         : %.2f 
                    Luas Permukaan : %.2f 
                    Volume         : %.2f 
                    ---------------------------------
                    """,
                    i, threadName, jariJari, sudutJuring, luasJuringLingkaran, kelilingJuringLingkaran
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
