package geometri3d;

public class KerucutTerpancungThread implements Runnable {
    private int nomor;

    public KerucutTerpancungThread(int nomor) {
        this.nomor = nomor;
    }

    @Override
    public void run() {
        try {
            // Delay random antara 0 - 300 ms agar output tidak berurutan rapi
            Thread.sleep((long) (Math.random() * 300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String threadName = Thread.currentThread().getName();

        // Jari-jari Bawah : Rentang 7.0 - 12.0
        double jariJariBawah = (Math.random() * (12 - 7)) + 7;
        // Jari-jari Atas : Rentang 2.0 - 6.0 
        double jariJariAtas = (Math.random() * (6 - 2)) + 2;
        // Tinggi : Rentang 5.0 - 10.0
        double tinggi = (Math.random() * (10 - 5)) + 5;

        KerucutTerpancung kt = new KerucutTerpancung(jariJariBawah, tinggi, jariJariAtas);
        double luasPermukaan = kt.hitungLuasPermukaan();
        double volume = kt.hitungVolume();

        // Output Text Block
        String output = String.format(
            """
            Thread Kerucut Terpancung #%d (%s)
            Jari Bawah: %.2f; Jari Atas: %.2f; Tinggi: %.2f
            Luas permukaan\t: %.2f
            Volume\t\t: %.2f
            ---------------------------------
            """,
            this.nomor, threadName, jariJariBawah, jariJariAtas, tinggi, luasPermukaan, volume
        );

        System.out.print(output);
    }
}