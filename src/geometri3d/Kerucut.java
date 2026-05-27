package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran implements Geometri3D, Runnable {
    public double jariJari;
    public double tinggiKerucut = 10;
    public double pi;
    public double luasPermukaanKerucut;
    public double volumeKerucut;
    
    public int count;
    public int delay;
    
    public Kerucut(double jariJari, double tinggi) {
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.tinggiKerucut = tinggi;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
    }
    
    public Kerucut(double jariJari, double tinggi, int count, int delay) {
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.tinggiKerucut = tinggi;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
        this.count = count;
        this.delay = delay;
    }

    public double hitungGarisPelukis(double jariJari, double tinggi) {
        return Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggi, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        double selimutKerucut = hitungGarisPelukis(this.jariJari, this.tinggiKerucut);
        double luasAlas = super.luasLingkaran; 
        double luasSelimut =  this.pi * this.jariJari * selimutKerucut;
        luasPermukaanKerucut = luasAlas + luasSelimut;
        return luasPermukaanKerucut;
    }

    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        double selimutKerucut = hitungGarisPelukis(jariJari, tinggi);
        double luasAlas = super.hitungLuas(jariJari); 
        double luasSelimut =  super.PI * jariJari * selimutKerucut;
        luasPermukaanKerucut = luasAlas + luasSelimut;
        return luasPermukaanKerucut;
    }

    @Override
    public double hitungVolume() {
        volumeKerucut = (1.0 / 3.0) * super.luasLingkaran * this.tinggiKerucut;
        return volumeKerucut;
    }

    public double hitungVolume(double jariJari, double tinggi) {
        volumeKerucut = (1.0 / 3.0) * super.hitungLuas(jariJari) * tinggi;
        return volumeKerucut;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i; 
                tinggiKerucut += i;
                luasPermukaanKerucut = hitungLuasPermukaan(jariJari, tinggiKerucut);
                volumeKerucut = hitungVolume(jariJari, tinggiKerucut);

                String output = String.format(
                    """
                    Thread Kerucut #%d (%s)
                    Jari-jari      : %.2f; 
                    Tinggi         : %.2f 
                    Luas Permukaan : %.2f 
                    Volume         : %.2f 
                    ------------------------
                    """,
                    i, threadName, jariJari, tinggiKerucut, luasPermukaanKerucut, volumeKerucut
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
