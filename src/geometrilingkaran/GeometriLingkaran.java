package geometrilingkaran;

import geometri3d.CincinBola;
import geometri3d.Kerucut;
import geometri3d.KerucutTerpancung;
import geometri3d.Tabung;
import geometri3d.Bola;
import geometri3d.JuringBola;
import geometri3d.TemberengBola;
import geometri2d.Lingkaran;
import geometri2d.JuringLingkaran;
import geometri2d.TemberengLingkaran;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import ui.MainFrame;


public class GeometriLingkaran {
    
    private static double inputDouble(Scanner sc, String label) {
        try {
            System.out.print(label);
            double inputValue = sc.nextDouble();
            return inputValue;
        } catch (InputMismatchException e) {
            System.out.println("Input harus angka!");
        }
        return 0;
    }
    
    private static int inputInt(Scanner sc, String label) {
        try {
            System.out.print(label);
            int inputValue = sc.nextInt();
            return inputValue;
        } catch (InputMismatchException e) {
            System.out.println("Input harus angka!");
        }
        return 0;
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
        
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        
        System.out.println("Metode output");
        System.out.println("[1] Single-thread");
        System.out.println("[2] Multi-thread");
        int metodeTerpilih = inputInt(scanner, "Pilih metode: ");
        
        if (metodeTerpilih == 2) {
            int jumlahThread = inputInt(scanner, "Input jumlah : ");
            if (jumlahThread > 0) {
                new MainThread().run(jumlahThread);
            }
            return;
        }
        
        System.out.println("\nGeometri Lingkaran");
        System.out.println(" [1] Lingkaran");
        System.out.println(" [2] Kerucut");
        System.out.println(" [3] Kerucut Terpancung");
        System.out.println(" [4] Tabung");
        System.out.println(" [5] Bola");
        System.out.println(" [6] Juring Bola");
        System.out.println(" [7] Tembereng Bola");
        System.out.println(" [8] Cincin Bola");
        System.out.println(" [9] Juring Lingkaran");
        System.out.println("[10] Tembereng Lingkaran");
        int bangunTerpilih = inputInt(scanner, "Pilih bangun: ");
        
        switch (bangunTerpilih) {
            case 1 -> { // Lingkaran
                System.out.print("\n --- Lingkaran (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                
                Lingkaran lingkaran = new Lingkaran(jariJari);
                double luas = lingkaran.hitungLuas();
                double keliling = lingkaran.hitungKeliling();

                String output = String.format(
                    """
                    Luas Lingkaran  : %.2f 
                    Keliling        : %.2f 
                    ---------------------------
                    """,
                    luas, keliling
                );
                System.out.print(output);
            }
            case 2 -> { // Kerucut
                System.out.print("\n --- Kerucut (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                double tinggi = inputDouble(scanner, "Tinggi\t\t: ");
                
                Kerucut kerucut = new Kerucut(jariJari, tinggi);
                double luasPermukaan = kerucut.hitungLuasPermukaan();
                double volume = kerucut.hitungVolume();

                String output = String.format(
                    """
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------
                    """,
                    luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 3 -> { // Kerucut Terpancung
                System.out.print("\n --- Kerucut Terpancung (Single-thread) ---\n");
                double jariJariBawah = inputDouble(scanner, "Jari-jari Bawah\t: ");
                double jariJariAtas = inputDouble(scanner, "Jari-jari Atas\t: ");
                double tinggi = inputDouble(scanner, "Tinggi\t\t: ");

                Kerucut kt = new KerucutTerpancung(jariJariBawah, tinggi, jariJariAtas);
                double luasPermukaan = kt.hitungLuasPermukaan();
                double volume = kt.hitungVolume();

                String output = String.format(
                    """
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------
                    """,
                    luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 4 -> { // Tabung
                System.out.print("\n --- Tabung (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                double tinggi = inputDouble(scanner, "Tinggi\t\t: ");

                Tabung tabung = new Tabung(jariJari, tinggi);
                double luasPermukaan = tabung.hitungLuasPermukaan();
                double volume = tabung.hitungVolume();

                String output = String.format(
                    """
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------
                    """,
                    luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 5 -> { // Bola
                System.out.print("\n --- Bola (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");

                Bola bola = new Bola(jariJari);
                double luasPermukaan = bola.hitungLuasPermukaan();
                double volume = bola.hitungVolume();

                String output = String.format(
                    """
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------
                    """,
                    luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 6 -> { // Juring Bola
                System.out.print("\n --- Juring Bola (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                double tinggi = inputDouble(scanner, "Tinggi\t: ");

                Bola juringBola = new JuringBola(jariJari, tinggi);
                double luasPermukaan = juringBola.hitungLuasPermukaan();
                double volume = juringBola.hitungVolume();

                String output = String.format(
                    """
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------
                    """,
                    luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 7 -> { // Tembereng Bola
                System.out.print("\n --- Tembereng Bola (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                double tinggi = inputDouble(scanner, "Tinggi\t\t: ");
                
                Bola tembereng = new TemberengBola(jariJari, tinggi);
                double luasPermukaan = tembereng.hitungLuasPermukaan();
                double volume = tembereng.hitungVolume();
                
                String output = String.format(
                    """
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------
                    """,
                    luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 8 -> { // Cincin Bola
                System.out.print("\n --- Cincin Bola (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                double tinggi = inputDouble(scanner, "Tinggi\t\t: ");
                
                Bola cincinBola = new CincinBola(jariJari, tinggi);
                double luasPermukaan = cincinBola.hitungLuasPermukaan();
                double volume = cincinBola.hitungVolume();
                
                String output = String.format(
                    """
                    Luas permukaan  : %.2f 
                    Volume          : %.2f 
                    ---------------------------
                    """,
                    luasPermukaan, volume
                );
                System.out.print(output);
            }
            case 9 -> { // Juring Lingkaran
                System.out.print("\n --- Juring Lingkaran (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                double sudut = inputDouble(scanner, "Sudut (Derajat)\t: ");

                JuringLingkaran juringLingkaran = new JuringLingkaran(jariJari, sudut);
                double luas = juringLingkaran.hitungLuas();
                double keliling = juringLingkaran.hitungKeliling();

                String output = String.format(
                    """
                    Luas Juring     : %.2f 
                    Keliling Juring : %.2f 
                    ---------------------------
                    """,
                    luas, keliling
                );
                System.out.print(output);
            }
            case 10 -> { // Tembereng Lingkaran
                System.out.print("\n --- Tembereng Lingkaran (Single-thread) ---\n");
                double jariJari = inputDouble(scanner, "Jari-jari          : ");
                double sudut = inputDouble(scanner,    "Sudut (Derajat)    : ");

                TemberengLingkaran temberengLingkaran = new TemberengLingkaran(jariJari, sudut);
                double luas = temberengLingkaran.hitungLuas();
                double keliling = temberengLingkaran.hitungKeliling();

                String output = String.format(
                    """
                    Luas Tembereng     : %.2f 
                    Keliling Tembereng : %.2f 
                    --------------------------------------------
                    """,
                    luas, keliling
                );
                System.out.print(output);
            }
            default -> System.out.println("Pilihan anda tidak valid");
        }
    }
}