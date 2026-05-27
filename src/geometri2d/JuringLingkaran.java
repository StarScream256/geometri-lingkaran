package geometri2d;

public class JuringLingkaran extends Lingkaran implements Runnable {
    public double jariJari = 7; 
    public double sudutJuring = 90;
    public double pi;
    public double luasJuringLingkaran;
    public double kelilingJuringLingkaran;
    
    public int count;
    public int delay = 1000;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.sudutJuring = sudut;
        this.pi = super.PI;
    }
    
    public JuringLingkaran(double jariJari, double sudut, int count, int delay) {
        super(jariJari); 
        this.jariJari = jariJari;
        this.sudutJuring = sudut;
        this.pi = super.PI;
        this.count = count;
        this.delay = delay;
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
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                sudutJuring += i;
                luas = hitungLuas(jariJari, sudutJuring);
                keliling = hitungKeliling(jariJari, sudutJuring);

                String output = String.format(
                    """
                    Thread Juring Lingkaran #%d (%s)
                    Jari-jari      : %.2f; 
                    Tinggi         : %.2f 
                    Luas Permukaan : %.2f 
                    Volume         : %.2f 
                    ---------------------------------
                    """,
                    i, threadName, jariJari, sudutJuring, luas, keliling
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}