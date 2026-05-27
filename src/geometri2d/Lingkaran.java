package geometri2d;

public class Lingkaran implements Geometri2D, Runnable {
    public double jariJari = 7;
    public double luasLingkaran;
    public double kelilingLingkaran;
    public final double PI = Math.PI;
    
    // attribut multi-thread
    public int count;
    public int delay;
    
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }
    
    // constructor multi-thread
    public Lingkaran(double jariJari, int count, int delay) {
        this.jariJari = jariJari;
        this.count = count;
        this.delay = delay;
    }

    @Override
    public double hitungLuas() {
        luasLingkaran = PI * this.jariJari * this.jariJari;
        return luasLingkaran;
    }
    
    public double hitungLuas(double jariJari) {
        luasLingkaran = PI * jariJari * jariJari;
        return luasLingkaran;
    }
    
    @Override
    public double hitungKeliling() {
        kelilingLingkaran = 2 * PI * this.jariJari;
        return kelilingLingkaran;
    }
    
    public double hitungKeliling(double jariJari) {
        kelilingLingkaran = 2 * PI * jariJari;
        return kelilingLingkaran;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                luasLingkaran = hitungLuas(jariJari);
                kelilingLingkaran = hitungKeliling(jariJari);

                String output = String.format(
                    """
                    Thread Lingkaran #%d (%s)
                    Jari-jari : %.2f
                    Luas      : %.2f
                    Keliling  : %.2f
                    -----------------------------
                    """,
                    i, threadName, jariJari, luasLingkaran, kelilingLingkaran
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
