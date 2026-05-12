/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geometrilingkaran;

import geometri3d.CincinBola;
import geometri3d.CincinBolaThread;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.SwingUtilities;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
                    // TODO: isi kode
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    // TODO: isi kode
                }
            }
            case 2 -> { // Kerucut
                System.out.print("\n --- Kerucut ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    // TODO: isi kode
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    // TODO: isi kode
                }
            }
            case 3 -> { // Kerucut Terpancung
                System.out.print("\n --- Kerucut Terpancung ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    // TODO: isi kode
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    // TODO: isi kode
                }
            }
            case 4 -> { // Tabung
                System.out.print("\n --- Tabung ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    // TODO: isi kode
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    // TODO: isi kode
                }
            }
            case 5 -> { // Bola
                System.out.print("\n --- Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    // TODO: isi kode
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    // TODO: isi kode
                }
            }
            case 6 -> { // Juring Bola
                System.out.print("\n --- Juring Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    // TODO: isi kode
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    // TODO: isi kode
                }
            }
            case 7 -> { // Tembereng Bola
                System.out.print("\n --- Cincin Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    // TODO: isi kode
                } else { // Multi-thread
                    System.out.print("(Multi-thread) ---\n");
                    // TODO: isi kode
                }
            }
            case 8 -> { // Cincin Bola
                System.out.print("\n --- Cincin Bola ");
                if (metodeTerpilih == 1) { // Single-thread
                    System.out.print("(Single-thread) ---\n");
                    double jariJari = inputDouble(scanner, "Jari-jari\t: ");
                    double tinggi = inputDouble(scanner, "Tinggi\t\t: ");
                    
                    CincinBola cincinBola = new CincinBola(jariJari, tinggi);
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
