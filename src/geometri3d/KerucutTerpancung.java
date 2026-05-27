package geometri3d;

public class KerucutTerpancung extends Kerucut {
    public double jariJariBawah;
    public double jariJariAtas = 3;
    public double tinggiKerucutTerpancung = 10;
    public double pi; 
    public double luasPermukaanKerucutTerpancung;
    public double volumeKerucutTerpancung;
    
    public int count;
    public int delay;
    
    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariBawah = jariJariBawah;
        super.jariJari = jariJariBawah;
        this.tinggiKerucutTerpancung = tinggi;
        this.jariJariAtas = jariJariAtas;
        this.pi = super.PI; 
        super.hitungLuas();
        super.hitungKeliling();
    }

    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas, int count, int delay) {
        super(jariJariBawah, tinggi); 
        this.jariJariBawah = jariJariBawah;
        super.jariJari = jariJariBawah;
        this.tinggiKerucutTerpancung = tinggi;
        this.jariJariAtas = jariJariAtas;
        this.pi = super.PI; 
        super.hitungLuas();
        super.hitungKeliling();
        this.count = count;
        this.delay = delay;
    }
    
    public double hitungGarisPelukis(double jariJariBawah, double jariJariAtas, double tinggi) {
        return Math.sqrt(Math.pow(tinggi, 2) + Math.pow((jariJariBawah - jariJariAtas), 2));
    }
    
    @Override
    public double hitungLuasPermukaan() {
        double garisPelukis = hitungGarisPelukis(this.jariJariBawah, this.jariJariAtas, this.tinggiKerucutTerpancung);
        double luasAlasBawah = super.luasLingkaran; 
        double luasAlasAtas = this.pi * Math.pow(this.jariJariAtas, 2);
        double luasSelimut = this.pi * garisPelukis * (this.jariJariBawah + this.jariJariAtas);
        luasPermukaanKerucutTerpancung = luasAlasBawah + luasAlasAtas + luasSelimut;
        return luasPermukaanKerucutTerpancung;
    }

    public double hitungLuasPermukaan(double jariJariBawah, double tinggi, double jariJariAtas) {
        double garisPelukis = hitungGarisPelukis(jariJariBawah, jariJariAtas, tinggi);
        double luasAlasBawah = super.hitungLuas(jariJariBawah); 
        double luasAlasAtas = super.PI * Math.pow(jariJariAtas, 2); 
        double luasSelimut = super.PI * garisPelukis * (jariJariBawah + jariJariAtas);
        luasPermukaanKerucutTerpancung = luasAlasBawah + luasAlasAtas + luasSelimut;
        return luasPermukaanKerucutTerpancung;
    }

    @Override
    public double hitungVolume() {
        volumeKerucutTerpancung = (1.0 / 3.0) * this.pi * this.tinggiKerucutTerpancung * 
                (Math.pow(this.jariJariBawah, 2) + Math.pow(this.jariJariAtas, 2) + 
                (this.jariJariBawah * this.jariJariAtas));
        return volumeKerucutTerpancung;
    }

    public double hitungVolume(double jariJariBawah, double tinggi, double jariJariAtas) {
        volumeKerucutTerpancung = (1.0 / 3.0) * super.PI * tinggi * (Math.pow(jariJariBawah, 2) + 
                Math.pow(jariJariAtas, 2) + (jariJariBawah * jariJariAtas));
        return volumeKerucutTerpancung;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJariBawah += i;
                jariJariAtas += i;
                tinggiKerucut += i;
                luasPermukaanKerucut = hitungLuasPermukaan(jariJariBawah, i, jariJariAtas);
                volumeKerucut = hitungVolume(jariJariBawah, i, jariJariAtas);

                String output = String.format(
                    """
                    Thread Kerucut Terpancung #%d (%s)
                    Jari Bawah     : %.2f; 
                    Jari Atas      : %.2f; 
                    Tinggi         : %.2f
                    Luas Permukaan : %.2f
                    Volume         : %.2f
                    -----------------------------------
                    """,
                    i, threadName, jariJariBawah, jariJariAtas, tinggiKerucut, luasPermukaanKerucut, volumeKerucutTerpancung    
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}