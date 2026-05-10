package geometri3d;

public class KerucutTerpancungThread implements Runnable {
    private double rBawah;
    private double rAtas;
    private double tinggi;
    
    public KerucutTerpancungThread(double rBawah, double rAtas, double tinggi) {
        this.rBawah = rBawah;
        this.rAtas = rAtas;
        this.tinggi = tinggi;
    }

    @Override
    public void run() {
        // Memanggil class logic KerucutTerpancung
        KerucutTerpancung kt = new KerucutTerpancung(this.rBawah, this.tinggi, this.rAtas);
        double luasPermukaan = kt.hitungLuasPermukaan();
        double volume = kt.hitungVolume();
        
        System.out.println(
            "Thread Kerucut Terpancung ID: " + Thread.currentThread().getId() +
            " | R: " + this.rBawah +
            " | r: " + this.rAtas +
            " | t: " + this.tinggi +
            " | Luas: " + String.format("%.2f", luasPermukaan) + 
            " | Volume: " + String.format("%.2f", volume)
        );
    }
}