package geometri2d;

public class TemberengLingkaranThread implements Runnable {
    private int nomor;

    public TemberengLingkaranThread(int nomor) {
        this.nomor = nomor;
    }

    @Override
    public void run() {
        try {
            // Delay acak antara 0 - 300 ms agar eksekusi thread bervariasi
            Thread.sleep((long)(Math.random() * 300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
            this.nomor, threadName, jariJari, sudut, luas, keliling
        );
        
        System.out.print(output);
    }
}