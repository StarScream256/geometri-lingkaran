package geometri3d;

import geometri2d.Lingkaran;

public class Bola extends Lingkaran implements Geometri3D, Runnable {
    public double jariJari;
    public double pi; 
    public double volumeBola;
    public double luasPermukaanBola;
    
    public int jumlahThread;
    public int delay;
    
    public Bola(double jariJari) {
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.pi = super.PI; 
        super.hitungLuas();
        super.hitungKeliling();
        this.jumlahThread = super.jumlahThread;
        this.delay = super.delay;
    }
    
    public Bola(double jariJari, int jumlahThread, int delay) {
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.pi = super.PI; 
        super.hitungLuas();
        super.hitungKeliling();
        this.jumlahThread = jumlahThread;
        this.delay = delay;
    }
    
    @Override
    public double hitungVolume() {
        volumeBola = (4.0 / 3.0) * this.pi * Math.pow(this.jariJari, 3);
        return volumeBola;
    }
    
    public double hitungVolume(double jariJari) {
        volumeBola = (4.0 / 3.0) * super.PI * Math.pow(jariJari, 3);
        return volumeBola;
    }
    
    @Override
    public double hitungLuasPermukaan() {
       luasPermukaanBola = 4 * super.luasLingkaran;
        return luasPermukaanBola;
    }
    
    public double hitungLuasPermukaan(double jariJari) {
        luasPermukaanBola = 4 * super.hitungLuas(jariJari);
        return luasPermukaanBola;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i < jumlahThread; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                luasPermukaanBola = hitungLuasPermukaan(jariJari);
                volumeBola = hitungVolume(jariJari);

                String output = String.format(
                    """
                    Thread bola #%d (%s)
                    Jari-jari       : %.2f
                    Luas Permukaan  : %.2f
                    Volume          : %.2f
                    -----------------------------
                    """,
                    i, threadName, jariJari, luasPermukaanBola, volumeBola
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
