/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geometrilingkaran;

import geometri3d.CincinBola;
import geometri3d.CincinBolaThread;
import geometri3d.Kerucut;
import geometri3d.KerucutThread;
import geometri3d.KerucutTerpancung;
import geometri3d.KerucutTerpancungThread;
import geometri3d.Tabung;
import geometri3d.TabungThread;
import geometri3d.Bola;
import geometri3d.BolaThread;
import geometri3d.JuringBola;
import geometri3d.JuringBolaThread;
import geometri3d.TemberengBola;
import geometri3d.TemberengBolaThread;
import java.util.Locale;
import java.util.Scanner;
import geometri2d.Lingkaran;
import geometri2d.LingkaranThread;
import ui.MainFrame;

/**
 *
 * @author asus
 */
public class GeometriLingkaran {
    
    private static double inputDouble(Scanner sc, String pesan) {
        System.out.print(pesan);
        return sc.nextDouble();
    }
    
    private static int inputInt(Scanner sc, String pesan) {
        System.out.print(pesan);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
        Scanner scanner = new Scanner(System.in);
        // locale diatur ke US, input double pakai titik (.) Contoh: 8.3
        scanner.useLocale(Locale.US);
        
        System.out.println("Geometri Lingkaran");
        System.out.println("[1] Lingkaran");
        System.out.println("[2] Kerucut");
        System.out.println("[3] Kerucut Terpancung");
        System.out.println("[4] Tabung");
        System.out.println("[5] Bola");
        System.out.println("[6] Juring Bola");
        System.out.println("[7] Tembereng Bola");
        System.out.println("[8] Cincin Bola");
        int bangunTerpilih = inputInt(scanner, "Piih bangun: ");
        
        System.out.println("Metode output");
        System.out.println("[1] Single-thread");
        System.out.println("[2] Multi-thread");
        int metodeTerpilih = inputInt(scanner, "Pilih metode: ");
        
        int jumlahThread = 1;
        if (metodeTerpilih == 2) {
            jumlahThread = inputInt(scanner, "Input jumlah thread: ");
        }
        
        switch (bangunTerpilih) {
            case 1 -> { // Lingkaran
                System.out.print("\n --- Lingkaran ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                    
                    Lingkaran lingkaran = new Lingkaran();
                    double luasLingkaran = lingkaran.hitungLuas();
                    double KelilingLingkaran = lingkaran.hitungKeliling();

                    String output = String.format(
                        """
                        Luas Lingkaran\t: %.2f 
                        Keliling \t\t: %.2f 
                        ---------------------------
                        """,
                        luasLingkaran, KelilingLingkaran
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                     for (int i = 0; i < jumlahThread; i++) {
                    LingkaranThread runnable = new LingkaranThread(i +1);
                    Thread thread = new Thread(runnable);
                    thread.start();
                     }
                }
            }
            case 2 -> { // Kerucut
                System.out.print("\n --- Kerucut ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                    double tinggi = inputDouble(scanner, "Tinggi\t\t: ");

                    Kerucut kerucut = new Kerucut(jariJari, tinggi);
                    double luasPermukaan = kerucut.hitungLuasPermukaan();
                    double volume = kerucut.hitungVolume();

                    String output = String.format(
                        """
                        Luas permukaan\t: %.2f 
                        Volume\t\t: %.2f 
                        ---------------------------
                        """,
                        luasPermukaan, volume
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    for (int i = 0; i < jumlahThread; i++) {
                        KerucutThread runnable = new KerucutThread(i + 1); 
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                }
            }
            case 3 -> { // Kerucut Terpancung
                System.out.print("\n --- Kerucut Terpancung ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJariBawah = inputDouble(scanner, "Jari-jari Bawah\t: ");
                    double jariJariAtas = inputDouble(scanner, "Jari-jari Atas\t: ");
                    double tinggi = inputDouble(scanner, "Tinggi\t\t: ");

                    Kerucut kt = new KerucutTerpancung(jariJariBawah, tinggi, jariJariAtas);
                    double luasPermukaan = kt.hitungLuasPermukaan();
                    double volume = kt.hitungVolume();

                    String output = String.format(
                        """
                        Luas permukaan\t: %.2f 
                        Volume\t\t: %.2f 
                        ---------------------------
                        """,
                        luasPermukaan, volume
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    for (int i = 0; i < jumlahThread; i++) {
                        KerucutTerpancungThread runnable = new KerucutTerpancungThread(i + 1); 
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                }
            }
            case 4 -> { // Tabung
                System.out.print("\n --- Tabung ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                    double tinggi = inputDouble(scanner, "Tinggi\t\t: ");

                    Tabung tabung = new Tabung(jariJari, tinggi);
                    double luasPermukaan = tabung.hitungLuasPermukaan();
                    double volume = tabung.hitungVolume();

                    String output = String.format(
                        """
                        Luas permukaan\t: %.2f 
                        Volume\t\t: %.2f 
                        ---------------------------
                        """,
                        luasPermukaan, volume
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    for (int i = 0; i < jumlahThread; i++) {
                        TabungThread runnable = new TabungThread(i + 1); 
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                }
            }
            case 5 -> { // Bola
                System.out.print("\n --- Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");

                    Bola bola = new Bola(jariJari);
                    double luasPermukaan = bola.hitungLuasPermukaan();
                    double volume = bola.hitungVolume();

                    String output = String.format(
                        """
                        Luas permukaan\t: %.2f 
                        Volume\t\t: %.2f 
                        ---------------------------
                        """,
                        luasPermukaan, volume
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    for (int i = 0; i < jumlahThread; i++) {
                        BolaThread runnable = new BolaThread(i + 1); 
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                }
            }
            case 6 -> { // Juring Bola
                System.out.print("\n --- Juring Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                    double tinggi = inputDouble(scanner, "Tinggi\t: ");

                    Bola juringBola = new JuringBola(jariJari,tinggi);
                    double luasPermukaan = juringBola.hitungLuasPermukaan();
                    double volume = juringBola.hitungVolume();

                    String output = String.format(
                        """
                        Luas permukaan\t: %.2f 
                        Volume\t\t: %.2f 
                        ---------------------------
                        """,
                        luasPermukaan, volume
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    for (int i = 0; i < jumlahThread; i++) {
                        JuringBolaThread runnable = new JuringBolaThread(i + 1); 
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                }
            }
            case 7 -> { // Tembereng Bola
                System.out.print("\n --- Tembereng Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                    double tinggi = inputDouble(scanner, "Tinggi\t\t: ");
                    
                    Bola tembereng = new TemberengBola(jariJari, tinggi);
                    double luasPermukaan = tembereng.hitungLuasPermukaan();
                    double volume = tembereng.hitungVolume();
                    
                    String output = String.format(
                        """
                        Luas permukaan\t: %.2f 
                        Volume\t\t: %.2f 
                        ---------------------------
                        """,
                        luasPermukaan, volume
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    for (int i = 0; i < jumlahThread; i++) {
                        TemberengBolaThread runnable = new TemberengBolaThread(i + 1); 
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                }
            }
            case 8 -> { // Cincin Bola
                System.out.print("\n --- Cincin Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                    double tinggi = inputDouble(scanner, "Tinggi\t\t: ");
                    
                    Bola cincinBola = new CincinBola(jariJari, tinggi);
                    double luasPermukaan = cincinBola.hitungLuasPermukaan();
                    double volume = cincinBola.hitungVolume();
                    
                    String output = String.format(
                        """
                        Luas permukaan\t: %.2f 
                        Volume\t\t: %.2f 
                        ---------------------------
                        """,
                        luasPermukaan, volume
                    );
                    System.out.print(output);
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    for (int i = 0; i < jumlahThread; i++) {
                        CincinBolaThread runnable = new CincinBolaThread(i);
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                }
            }
            default -> System.out.println("Pilihan anda tidak valid");
        }
    }
}
