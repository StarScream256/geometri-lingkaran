package geometri2d;

public class Lingkaran implements Geometri2D, Runnable {
    public double jariJari = 7;
    public double luas;
    public double keliling;
    public final double PI = Math.PI;
    
    // attribut multi-thread
    public int count;
    public int delay = 1000;
    
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
        luas = PI * this.jariJari * this.jariJari;
        return luas;
    }
    
    public double hitungLuas(double jariJari) {
        luas = PI * jariJari * jariJari;
        return luas;
    }
    
    @Override
    public double hitungKeliling() {
        keliling = 2 * PI * this.jariJari;
        return keliling;
    }
    
    public double hitungKeliling(double jariJari) {
        keliling = 2 * PI * jariJari;
        return keliling;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                luas = hitungLuas(jariJari);
                keliling = hitungKeliling(jariJari);

                String output = String.format(
                    """
                    Thread Lingkaran #%d (%s)
                    Jari-jari : %.2f
                    Luas      : %.2f
                    Keliling  : %.2f
                    -----------------------------
                    """,
                    i, threadName, jariJari, luas, keliling
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
