package geometri3d;

public class KerucutThread implements Runnable {
    private int nomor;
    
    public KerucutThread(int nomor) {
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
        double tinggi = (Math.random() * (12 - 2)) + 2;
        
        Kerucut kerucut = new Kerucut(jariJari, tinggi);
        double luasPermukaan = kerucut.luasPermukaanKerucut;
        double volume = kerucut.volumeKerucut;

        // Output Text Block
        String output = String.format(
            """
            Thread Kerucut #%d (%s)
            Jari-jari      : %.2f; 
            Tinggi         : %.2f 
            Luas Permukaan : %.2f 
            Volume         : %.2f 
            ------------------------
            """,
            this.nomor, threadName, jariJari, tinggi, luasPermukaan, volume
        );
        
        System.out.print(output);
    }
}