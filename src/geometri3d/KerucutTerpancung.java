package geometri3d;

public class KerucutTerpancung extends Kerucut {
    protected double jariJariAtas;
    protected double tinggi;
    private double volume;
    private double luasPermukaan;

    public KerucutTerpancung(double tinggi, double jariJariAtas, double jariJariBawah) {
        super(jariJariBawah); // jari jari bawah / besar r1
        this.jariJariAtas = jariJariAtas; // jari - jari alas kecil r2
        this.tinggi = tinggi;
    }
       
    // overloaded constructor
    public KerucutTerpancung(int tinggi, int jariJariAtas, int jariJariBawah) {
        super(jariJariBawah); // jari jari bawah / besar r1
        this.jariJariAtas = jariJariAtas; // jari - jari alas kecil r2
        this.tinggi = tinggi;
    }

    public double hitungVolume() throws IllegalArgumentException {
        try {
            if (tinggi <= 0 || jariJariAtas <= 0 || super.jariJari <= 0) {
                throw new IllegalArgumentException("Panjang tinggi, jari-jari bawah, dan jari-jari atas harus lebih besar dari 0");
            }
            volume = (1.0 / 3.0) * super.pi * tinggi * (super.jariJari * super.jariJari + jariJariAtas * jariJariAtas + super.jariJari * jariJariAtas);
            return volume;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung volume kerucut terpancung: " + e.getMessage());
            throw e;
        }
          
    }
       
    // overloaded method
    public double hitungVolume(double tinggi, double jariJariAtas, double jariJariBawah) throws IllegalArgumentException {
        try {
            if (tinggi <= 0 || jariJariAtas <= 0 || super.jariJari <= 0) {
                throw new IllegalArgumentException("Panjang tinggi, jari-jari bawah, dan jari-jari atas harus lebih besar dari 0");
            }
            volume = (1.0 / 3.0) * super.pi * tinggi * (super.jariJari * super.jariJari + jariJariAtas * jariJariAtas + super.jariJari * jariJariAtas);
            return volume;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung volume kerucut terpancung: " + e.getMessage());
            throw e;
        }
    }

    public double hitungLuasPermukaan() throws IllegalArgumentException {
        try {
            if (tinggi <= 0 || jariJariAtas <= 0 || super.jariJari <= 0) {
                throw new IllegalArgumentException("Panjang tinggi, jari-jari bawah, dan jari-jari atas harus lebih besar dari 0");
            }
            double garisPelukis = Math.sqrt(Math.pow(tinggi, 2) + Math.pow((super.jariJari - jariJariAtas), 2));

//             luasPermukaan = (super.pi * super.jariJari * garisPelukis) + (super.pi * (Math.pow(super.jariJari, 2)));
            luasPermukaan = (super.pi * (super.jariJari + jariJariAtas) * garisPelukis) + (super.pi * Math.pow(super.jariJari, 2));
            return luasPermukaan;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung luas permukaan kerucut terpancung: " + e.getMessage());
            throw e;
        }
    }
       
    // overloaded method
    public double hitungLuasPermukaan(double tinggi, double jariJariAtas, double jariJariBawah) throws IllegalArgumentException {
        try {
            if (tinggi <= 0 || jariJariAtas <= 0 || super.jariJari <= 0) {
                throw new IllegalArgumentException("Panjang tinggi, jari-jari bawah, dan jari-jari atas harus lebih besar dari 0");
            }
            double garisPelukis = Math.sqrt(Math.pow(tinggi, 2) + Math.pow((super.jariJari - jariJariAtas), 2));

//            luasPermukaan = (super.pi * super.jariJari * garisPelukis) + (super.pi * (Math.pow(super.jariJari, 2)));
            luasPermukaan = (super.pi * (super.jariJari + jariJariAtas) * garisPelukis) + (super.pi * Math.pow(super.jariJari, 2));
            return luasPermukaan;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung luas permukaan kerucut terpancung: " + e.getMessage());
            throw e;
        }
    }
}
