package ui;

import java.util.Locale;
import java.util.Scanner;

import geometri2d.Lingkaran;
import geometri2d.JuringLingkaran;
import geometri2d.TemberengLingkaran;
import geometri3d.Tabung;
import geometri3d.Kerucut;
import geometri3d.KerucutTerpancung;
import geometri3d.Bola;
import geometri3d.JuringBola;
import geometri3d.TemberengBola;
import geometri3d.CincinBola;

public class PewarisanTeks {

    private static double inputDoubleValid(Scanner sc, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = sc.next().trim().replace(",", "."); 
            
            try {
                double nilai = Double.parseDouble(input);
                if (nilai <= 0) {
                    System.out.println("[ERROR] Angka harus lebih besar dari 0! Silakan coba lagi.");
                    continue;
                }
                if (nilai > 10000) {
                    System.out.println("[ERROR] Angka terlalu besar! Maksimal adalah 10.000. Silakan coba lagi.");
                    continue;
                }
                return nilai; 
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input tidak valid! Harus berupa angka numerik.");
            }
        }
    }

    private static int inputIntValid(Scanner sc, String pesan, int min, int max) {
        while (true) {
            System.out.print(pesan);
            try {
                int nilai = Integer.parseInt(sc.next().trim());
                if (nilai < min || nilai > max) {
                    System.out.printf("[ERROR] Pilihan harus di antara [%d - %d]!\n", min, max);
                    continue;
                }
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Pilihan menu harus berupa angka bulat!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("====== Input Jari-jari Lingkaran ======");
        double jariJari = inputDoubleValid(scanner, "Jari-jari Lingkaran : ");

        Lingkaran lingkaran = new Lingkaran(jariJari);
        System.out.printf("Luas Lingkaran      : %.2f\n", lingkaran.hitungLuas());
        System.out.printf("Keliling Lingkaran  : %.2f\n", lingkaran.hitungKeliling());
        System.out.println("--------------------------------------------\n");

        System.out.println("=== Pilihan Geometri ===");
        System.out.println("--- Benda Geometri ---");
        System.out.println("[1] Juring Lingkaran");
        System.out.println("[2] Tembereng Lingkaran");
        System.out.println("[3] Tabung");
        System.out.println("[4] Kerucut");
        System.out.println("[5] Kerucut Terpancung");
        System.out.println("[6] Bola");
        System.out.println("[7] Juring Bola");
        System.out.println("[8] Tembereng Bola");
        System.out.println("[9] Cincin Bola");
        int pilihanGeometri = inputIntValid(scanner, "Pilih nomor Geometri : ", 1, 9);

        System.out.println("\nKonfigurasi Jari-Jari");
        System.out.println("[1] Gunakan Pewarisan");
        System.out.println("[2] Input Jari-jari baru");
        int pilihanJarijari = inputIntValid(scanner, "Pilih opsi : ", 1, 2);

        double jariJariBaru = lingkaran.jariJari; 
        boolean isOverloading = (pilihanJarijari == 2);

        if (isOverloading) {
            jariJariBaru = inputDoubleValid(scanner, "Masukkan Jari-jari Baru : ");
        }

        System.out.println("\n========== Kalkulasi Akhir ==========");
        
        switch (pilihanGeometri) {
            case 1 -> { // Juring Lingkaran
                double sudut = inputDoubleValid(scanner, "Masukkan Sudut Juring : ");
                JuringLingkaran juring = new JuringLingkaran(jariJariBaru, sudut);
                
                double luas = isOverloading ? juring.hitungLuas(jariJariBaru, sudut) : juring.hitungLuas();
                double keliling = isOverloading ? juring.hitungKeliling(jariJariBaru, sudut) : juring.hitungKeliling();
                
                String output = String.format(
                        """
                        Luas                  : %.2f 
                        Keliling              : %.2f 
                        ---------------------------------
                        """,
                        luas, keliling
                );
                System.out.print(output);
            }
            case 2 -> { // Tembereng Lingkaran
                double sudut = inputDoubleValid(scanner, "Masukkan Sudut Tembereng : ");
                TemberengLingkaran tembereng = new TemberengLingkaran(jariJariBaru, sudut);
                
                double luas = isOverloading ? tembereng.hitungLuas(jariJariBaru, sudut) : tembereng.hitungLuas();
                double keliling = isOverloading ? tembereng.hitungKeliling(jariJariBaru, sudut) : tembereng.hitungKeliling();
                
                String output = String.format(
                        """
                        Luas                     : %.2f 
                        Keliling                 : %.2f 
                        ------------------------------------
                        """,
                        luas, keliling
                );
                System.out.print(output);
            }
            case 3 -> { // Tabung
                double tinggi = inputDoubleValid(scanner, "Masukkan Tinggi Tabung : ");
                Tabung tabung = new Tabung(jariJariBaru, tinggi);
                
                double luasPermukaan = isOverloading ? tabung.hitungLuasPermukaan(jariJariBaru, tinggi) : tabung.hitungLuasPermukaan();
                double volume = isOverloading ? tabung.hitungVolume(jariJariBaru, tinggi) : tabung.hitungVolume();
                
                String output = String.format(
                        """
                        Luas Permukaan         : %.2f 
                        Volume                 : %.2f 
                        ----------------------------------
                        """,
                        luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 4 -> { // Kerucut
                double tinggi = inputDoubleValid(scanner, "Masukkan Tinggi Kerucut : ");
                Kerucut kerucut = new Kerucut(jariJariBaru, tinggi);
                
                double luasPermukaan = isOverloading ? kerucut.hitungLuasPermukaan(jariJariBaru, tinggi) : kerucut.hitungLuasPermukaan();
                double volume = isOverloading ? kerucut.hitungVolume(jariJariBaru, tinggi) : kerucut.hitungVolume();
                
                String output = String.format(
                        """
                        Luas Permukaan          : %.2f 
                        Volume                  : %.2f 
                        -----------------------------------
                        """,
                        luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 5 -> { // Kerucut Terpancung
                double tinggi = inputDoubleValid(scanner, "Masukkan Tinggi         : ");
                double jariJariAtas;
                while (true) {
                    jariJariAtas = inputDoubleValid(scanner, "Masukkan Jari-jari Atas : ");
                    if (jariJariBaru <= jariJariAtas) {
                        System.out.printf("[ERROR LOGIKA] Jari-jari bawah (%.2f) HARUS lebih besar dari Jari-jari atas (%.2f)!\n", jariJariBaru, jariJariAtas);
                        System.out.println("Silakan masukkan kembali angka Jari-jari Atas yang valid.");
                    } else {
                        break; 
                    }
                }
                
                KerucutTerpancung kt = new KerucutTerpancung(jariJariBaru,tinggi, jariJariAtas);
                
                double luasPermukaan = isOverloading ? kt.hitungLuasPermukaan(jariJariBaru, tinggi, jariJariAtas) : kt.hitungLuasPermukaan();
                double volume = isOverloading ? kt.hitungVolume(jariJariBaru, tinggi, jariJariAtas) : kt.hitungVolume();
                
                String output = String.format(
                        """
                        Luas Permukaan          : %.2f 
                        Volume                  : %.2f 
                        -----------------------------------
                        """,
                        luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 6 -> { // Bola
                Bola bola = new Bola(jariJariBaru);
                
                double luasPermukaan = isOverloading ? bola.hitungLuasPermukaan(jariJariBaru) : bola.hitungLuasPermukaan();
                double volume = isOverloading ? bola.hitungVolume(jariJariBaru) : bola.hitungVolume();
                
                String output = String.format(
                        """
                        Luas Permukaan  : %.2f 
                        Volume          : %.2f 
                        --------------------------------
                        """,
                        luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 7 -> { // Juring Bola
                double tinggi = inputDoubleValid(scanner, "Masukkan Tinggi Juring : ");
                JuringBola jb = new JuringBola(jariJariBaru, tinggi);
                
                double luasPermukaan = isOverloading ? jb.hitungLuasPermukaan(jariJariBaru, tinggi) : jb.hitungLuasPermukaan();
                double volume = isOverloading ? jb.hitungVolume(jariJariBaru, tinggi) : jb.hitungVolume();
                
                String output = String.format(
                        """
                        Luas Permukaan         : %.2f 
                        Volume                 : %.2f 
                        ----------------------------------
                        """,
                        luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 8 -> { // Tembereng Bola
                double tinggi = inputDoubleValid(scanner, "Masukkan Tinggi Tembereng : ");
                TemberengBola tb = new TemberengBola(jariJariBaru, tinggi);
                
                double luasPermukaan = isOverloading ? tb.hitungLuasPermukaan(jariJariBaru, tinggi) : tb.hitungLuasPermukaan();
                double volume = isOverloading ? tb.hitungVolume(jariJariBaru, tinggi) : tb.hitungVolume();
                
                String output = String.format(
                        """
                        Luas Permukaan            : %.2f 
                        Volume                    : %.2f 
                        -------------------------------------
                        """,
                        luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 9 -> { // Cincin Bola
                double tinggi = inputDoubleValid(scanner, "Masukkan Tinggi Cincin : ");
                CincinBola cb = new CincinBola(jariJariBaru, tinggi);
                
                double luasPermukaan = isOverloading ? cb.hitungLuasPermukaan(jariJariBaru, tinggi) : cb.hitungLuasPermukaan();
                double volume = isOverloading ? cb.hitungVolume(jariJariBaru, tinggi) : cb.hitungVolume();
                
                String output = String.format(
                        """
                        Luas Permukaan         : %.2f 
                        Volume                 : %.2f 
                        ----------------------------------
                        """,
                        luasPermukaan, volume
                );
                System.out.print(output);
            }   
            default -> System.out.println("Pilihan Bangun Tidak Valid!");
        }
        scanner.close();
    }
}