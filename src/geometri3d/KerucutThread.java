package geometri3d;

public class KerucutThread implements Runnable {
    public int count;
    public int delay = 1000;
    
    public KerucutThread() {}
    
    public KerucutThread(int count) {
        this.count = count;
    }
    
    public KerucutThread(int count, int delay) {
        this.count = count;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                double jariJari = (Math.random() * (12 - 2)) + 2; 
                double tinggi = (Math.random() * (12 - 2)) + 2;
                Kerucut kerucut = new Kerucut(jariJari, tinggi);
                double luasPermukaan = kerucut.luasPermukaanKerucut;
                double volume = kerucut.volumeKerucut;

                String output = String.format(
                    """
                    Thread Kerucut #%d (%s)
                    Jari-jari      : %.2f; 
                    Tinggi         : %.2f 
                    Luas Permukaan : %.2f 
                    Volume         : %.2f 
                    ------------------------
                    """,
                    i, threadName, jariJari, tinggi, luasPermukaan, volume
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
