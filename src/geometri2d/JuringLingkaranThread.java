package geometri2d;

public class JuringLingkaranThread implements Runnable {
    public int count;
    public int delay = 1000;
    
    public JuringLingkaranThread() {}
    
    public JuringLingkaranThread(int count) {
        this.count = count;
    }
    
    public JuringLingkaranThread(int count, int delay) {
        this.count = count;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                // rentang: (Math.random() * (Max - Min)) + Min
                double jariJari = (Math.random() * (12 - 2)) + 2; 
                double sudut = (Math.random() * (360 - 10)) + 10;
                JuringLingkaran juring = new JuringLingkaran(jariJari, sudut);
                double luas = juring.hitungLuas();
                double keliling = juring.hitungKeliling();

                String output = String.format(
                    """
                    Thread Juring Lingkaran #%d (%s)
                    Jari-jari      : %.2f; 
                    Tinggi         : %.2f 
                    Luas Permukaan : %.2f 
                    Volume         : %.2f 
                    ---------------------------------
                    """,
                    i, threadName, jariJari, sudut, luas, keliling
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {}
    }
}