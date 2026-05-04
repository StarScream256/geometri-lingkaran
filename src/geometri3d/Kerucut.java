package geometri3d;

import geometri2d.Lingkaran;

public class Kerucut extends Lingkaran {
  // Atribut khusus untuk Kerucut
  protected double tinggiKerucut;
  private double volumeKerucut;
  private double luasPermukaanKerucut;

  // Constructor untuk Kerucut
  public Kerucut(double jariJari, double tinggiKerucut) {
    super(jariJari);
    this.tinggiKerucut = tinggiKerucut;
  }
  
  // Constructor untuk Kerucut overloading
  public Kerucut(int jariJari, int tinggiKerucut) {
    super(jariJari);
    this.tinggiKerucut = tinggiKerucut;
  }
  
  // Constructor untuk Kerucut overloading
  public Kerucut(double jariJari) {
    super(jariJari);
    this.tinggiKerucut = tinggiKerucut;
  }
  
  // Constructor untuk Kerucut overloading
  public Kerucut(int jariJari) {
    super(jariJari);
    this.tinggiKerucut = tinggiKerucut;
  }


  // Implementasi metode hitungVolume() untuk Kerucut
  @Override
  public double hitungVolume() throws IllegalArgumentException {
        try {
            if (tinggiKerucut <= 0) {
                throw new IllegalArgumentException("Tinggi kerucut harus lebih besar dari 0");
            }
            // Volume Kerucut = 1/3 * luas Lingkaran * tinggi Kerucut
            volumeKerucut = (1.0 / 3.0) * super.hitungLuas() * tinggiKerucut;
            return volumeKerucut;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung volume: " + e.getMessage());
            throw e; 
        }
    }
  
    public double hitungVolume(int tinggiKerucut) throws IllegalArgumentException {
        try {
            if (tinggiKerucut <= 0) {
                throw new IllegalArgumentException("Tinggi kerucut harus lebih besar dari 0");
            }
            // Volume Kerucut = 1/3 * luas Lingkaran * tinggi Kerucut
            volumeKerucut = (1.0 / 3.0) * super.hitungLuas() * tinggiKerucut;
            return volumeKerucut;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung volume (overloaded): " + e.getMessage());
            throw e; // Melempar ulang exception untuk ditangani oleh pemanggil
        }
    }

    // Implementasi metode hitungLuasPermukaan() untuk Kerucut
    @Override
    public double hitungLuasPermukaan() throws IllegalArgumentException {
        try {
            if (tinggiKerucut <= 0) {
                throw new IllegalArgumentException("Tinggi kerucut harus lebih besar dari 0");
            }
            // Luas Permukaan Kerucut = luas alas + luas selimut
            luasPermukaanKerucut = super.hitungLuas() + (super.pi * jariJari * Math.sqrt(Math.pow(tinggiKerucut, 2) + Math.pow(jariJari, 2)));
            return luasPermukaanKerucut;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung luas permukaan: " + e.getMessage());
            throw e; // Melempar ulang exception untuk ditangani oleh pemanggil
        }
    }
  
    public double hitungLuasPermukaan(int tinggiKerucut) throws IllegalArgumentException {
        try {
            if (tinggiKerucut <= 0) {
                throw new IllegalArgumentException("Tinggi kerucut harus lebih besar dari 0");
            }
            // Luas Permukaan Kerucut = luas alas + luas selimut
            luasPermukaanKerucut = super.hitungLuas() + (super.pi * jariJari * Math.sqrt(Math.pow(tinggiKerucut, 2) + Math.pow(jariJari, 2)));
            return luasPermukaanKerucut;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat menghitung luas permukaan (overloaded): " + e.getMessage());
            throw e; // Melempar ulang exception untuk ditangani oleh pemanggil
        }
    }
    
  public double getLuasPermukaanKerucut(){
    return luasPermukaanKerucut;
  }

}
