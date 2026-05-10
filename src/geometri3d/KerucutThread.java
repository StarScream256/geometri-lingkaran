package geometri3d;

public class KerucutThread implements Runnable {
    private double jariJari;
    private double tinggi;
    
    public KerucutThread(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    @Override
    public void run() {
        // Memanggil class logic Kerucut
        Kerucut kerucut = new Kerucut(this.jariJari, this.tinggi);
        double luasPermukaan = kerucut.hitungLuasPermukaan();
        double volume = kerucut.hitungVolume();
        
        // Menampilkan hasil di Console (untuk bukti Thread berjalan)
        System.out.println(
            "Thread Kerucut ID: " + Thread.currentThread().getId() +
            " | r: " + this.jariJari +
            " | t: " + this.tinggi +
            " | Luas: " + String.format("%.2f", luasPermukaan) + 
            " | Volume: " + String.format("%.2f", volume)
        );
    }
}