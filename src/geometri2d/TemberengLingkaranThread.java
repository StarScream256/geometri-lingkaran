package geometri2d;

public class TemberengLingkaranThread implements Runnable {
    public int count;
    public int delay = 1000;

    public TemberengLingkaranThread() {}
    
    public TemberengLingkaranThread(int count) {
        this.count = count;
    }
    
    public TemberengLingkaranThread(int count, int delay) {
        this.count = count;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                double jariJari = (Math.random() * (12 - 2)) + 2; 
                double sudut = (Math.random() * (179 - 10)) + 10; 
                TemberengLingkaran tembereng = new TemberengLingkaran(jariJari, sudut);
                double luas = tembereng.hitungLuas();
                double keliling = tembereng.hitungKeliling();

                String output = String.format(
                    """
                    Thread Tembereng Lingkaran #%d (%s)
                    Jari-jari          : %.2f
                    Sudut Tembereng    : %.2f
                    Luas Tembereng     : %.2f 
                    Keliling Tembereng : %.2f 
                    ------------------------------------
                    """,
                    i, threadName, jariJari, sudut, luas, keliling
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {}
    }
}