package geometri3d;

public class CincinBola extends Bola implements Geometri3D, Runnable {
    public double jariJari;
    public double tinggi = 10;
    public double pi; 
    public double volumeCincinBola;
    public double luasPermukaanCincinBola;
    
    public int jumlahThread;
    public int delay;

    public CincinBola(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.tinggi = tinggi;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
        this.jumlahThread = super.jumlahThread;
        this.delay = super.delay;
    }
    
    public CincinBola(double jariJari, double tinggi, int jumlahThread, int delay) {
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.tinggi = tinggi;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
        this.jumlahThread = jumlahThread;
        this.delay = delay;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanCincinBola = 2 * this.pi * this.jariJari * this.tinggi;
        return luasPermukaanCincinBola;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        luasPermukaanCincinBola = 2 * super.PI * jariJari * tinggi;
        return luasPermukaanCincinBola;
    }

    @Override
    public double hitungVolume() {
        volumeCincinBola = (1.0 / 6.0) * this.pi * Math.pow(this.tinggi, 3); 
        return volumeCincinBola;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeCincinBola = (1.0 / 6.0) * super.PI * Math.pow(tinggi, 3); 
        return volumeCincinBola;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < jumlahThread; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                tinggi += i;
                luasPermukaanCincinBola = hitungLuasPermukaan(jariJari, tinggi);
                volumeCincinBola = hitungVolume(jariJari, tinggi);

                String output = String.format(
                    """
                    Thread Cincin Bola #%d (%s)
                    Jari-jari       : %.2f
                    Tinggi          : %.2f 
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------------
                    """,
                    i, threadName, jariJari, tinggi, luasPermukaanCincinBola, volumeCincinBola
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
