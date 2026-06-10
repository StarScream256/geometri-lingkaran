package geometri3d;

public class KerucutTerpancung extends Kerucut {
    public double jariJariBawah;
    public double jariJariAtas = 3;
    public double tinggiKerucutTerpancung = 10;
    public double pi; 
    public double luasPermukaanKerucutTerpancung;
    public double volumeKerucutTerpancung;
    
    public KerucutTerpancung(double jariJariBawah, double tinggi, double jariJariAtas) {
        super(jariJariBawah, tinggi); 
        this.jariJariBawah = jariJariBawah;
        this.tinggiKerucutTerpancung = tinggi;
        this.jariJariAtas = jariJariAtas;
        this.pi = super.PI; 
        super.hitungLuasPermukaan(this.jariJariBawah, this.tinggiKerucutTerpancung);
        super.hitungVolume(this.jariJariBawah, this.tinggiKerucutTerpancung);
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanKerucutTerpancung = super.luasLingkaran
                                         +
                                         super.PI * Math.pow(this.jariJariAtas, 2)
                                         +
                                         super.PI * Math.sqrt(Math.pow(this.tinggiKerucutTerpancung, 2) + Math.pow((this.jariJariBawah - this.jariJariAtas), 2)) 
                                         * 
                                         (this.jariJariBawah + this.jariJariAtas);        
        return luasPermukaanKerucutTerpancung;
    }

    public double hitungLuasPermukaan(double jariJariBawah, double tinggi, double jariJariAtas) {
        luasPermukaanKerucutTerpancung = super.hitungLuas(jariJariBawah)
                                         +
                                         super.PI * Math.pow(jariJariAtas, 2)
                                         +
                                         super.PI * Math.sqrt(Math.pow(tinggi, 2) + Math.pow((jariJariBawah - jariJariAtas), 2))
                                         * 
                                         (jariJariBawah + jariJariAtas);
        return luasPermukaanKerucutTerpancung;
    }

    @Override
    public double hitungVolume() {
        volumeKerucutTerpancung = (1.0 / 3.0) * super.PI * this.tinggiKerucutTerpancung 
                                  * 
                                  (Math.pow(this.jariJariBawah, 2) + Math.pow(this.jariJariAtas, 2) 
                                  + 
                                  (this.jariJariBawah * this.jariJariAtas));
        return volumeKerucutTerpancung;
    }

    public double hitungVolume(double jariJariBawah, double tinggi, double jariJariAtas) {
        volumeKerucutTerpancung = (1.0 / 3.0) * super.PI * tinggi 
                                  * 
                                  (Math.pow(jariJariBawah, 2) 
                                  + 
                                  Math.pow(jariJariAtas, 2) + (jariJariBawah * jariJariAtas));
        return volumeKerucutTerpancung;
    }
}