package geometri2d;

public class JuringLingkaranThread implements Runnable {
    private int nomor;
    
    public JuringLingkaranThread(int nomor) {
        this.nomor = nomor;
    }

    @Override
    public void run() {
        try {
            // Delay random antara 0 - 300 ms agar output tidak berurutan rapi
            Thread.sleep((long)(Math.random() * 300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
            this.nomor, threadName, jariJari, sudut, luas, keliling
        );
        
        System.out.print(output);
    }
}