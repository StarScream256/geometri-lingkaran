package geometri3d;

// import geometri2d.Lingkaran;

public class KerucutThread implements Runnable {
    private int nomor;
    private double jariJari;
    private double tinggi;

    public KerucutThread(int nomor, double jariJari, double tinggi) {
        this.nomor = nomor;
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    public KerucutThread(int nomor) {
        this.nomor = nomor;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random() * 300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (jariJari == 0 && tinggi == 0) {
            jariJari = 4 + Math.random() * 8;
            tinggi = 6 + Math.random() * 12;
        }

        Kerucut kerucut = new Kerucut(jariJari, tinggi);
        double luasPermukaan = kerucut.hitungLuasPermukaan();
        double volume = kerucut.hitungVolume();

        System.out.printf("Thread Kerucut #%d | Jari-jari: %.2f cm | Tinggi: %.2f cm | Luas Permukaan: %.2f cm² | Volume: %.2f cm³%n",
                nomor, jariJari, tinggi, luasPermukaan, volume);
    }
}
