package geometrilingkaran;

import geometri3d.*;
import geometri2d.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.MainFrame;

public class GeometriLingkaran {
    public static Scanner scanner;
    public static int jumlahThread;
    
    public static double inputDouble(String label) {
        try {
            System.out.print(label);
            double inputValue = scanner.nextDouble();
            if (inputValue <= 0) {
                System.out.println("Input angka harus lebih besar dari 0");
            }
            return inputValue;
        } catch (InputMismatchException e) {
            System.out.println("Input harus angka!");
            scanner.next();
        }
        return 0;
    }
    
    public static int inputInt(String label) {
        try {
            System.out.print(label);
            int inputValue = scanner.nextInt();
            if (inputValue <= 0) {
                System.out.println("Input angka harus lebih besar dari 0");
            }
            return inputValue;
        } catch (InputMismatchException e) {
            System.out.println("Input harus angka!");
            scanner.next();
        }
        return 0;
    }
    
    public static String format2DOutput(double luas, double keliling) {
        String output = String.format(
            """
            Luas Lingkaran  : %.2f 
            Keliling        : %.2f 
            ---------------------------
            """,
            luas, keliling
        );
        return output;
    }
    
    public static String format3DOutput(double luasPermukaan, double volume) {
        String output = String.format(
            """
            Luas Permukaan  : %.2f 
            Volume          : %.2f 
            ---------------------------
            """,
            luasPermukaan, volume
        );
        return output;
    }
    
    public static void jalankanMultithread() {
        jumlahThread = jumlahThread / 10;
        int delay = 1000;
        
        String[] columns = {
            "Iterasi data", "(0) Lingkaran", "(1) Juring Lingkaran", "(2) Tembereng Lingkaran", "(3) Kerucut",
            "(4) Kerucut Terpancung", "(5) Tabung", "(6) Bola", "(7) Juring Bola", "(8) Tembereng Bola", "(9) Cincin Bola"
        };
        
        Object[][] data = new Object[jumlahThread][columns.length];
        for (int i = 0; i < jumlahThread; i++) {
            data[i][0] = (i + 1);
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        
        JFrame frame = new JFrame("Thread Status Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 300);
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        
        Thread lingkaranThread = new Thread(new LingkaranThread(jumlahThread, delay, model, 1));
        Thread juringLingkaranThread = new Thread(new JuringLingkaranThread(jumlahThread, delay, model, 2));
        Thread temberengLingkaranThread = new Thread(new TemberengLingkaranThread(jumlahThread, delay, model, 3));
        Thread kerucutThread = new Thread(new KerucutThread(jumlahThread, delay, model, 4));
        Thread kerucutTerpancungThread = new Thread(new KerucutTerpancungThread(jumlahThread, delay, model, 5));
        Thread tabungThread = new Thread(new TabungThread(jumlahThread, delay, model, 6));
        Thread bolaThread = new Thread(new BolaThread(jumlahThread, delay, model, 7));
        Thread juringBolaThread = new Thread(new JuringBolaThread(jumlahThread, delay, model, 8));
        Thread tembrengBolaThread = new Thread(new TemberengBolaThread(jumlahThread, delay, model, 9));
        Thread cincinBolaThread = new Thread(new CincinBolaThread(jumlahThread, delay, model, 10));

        Thread[] threads = {
            lingkaranThread, juringLingkaranThread, temberengLingkaranThread, kerucutThread,
            kerucutTerpancungThread, tabungThread, bolaThread, juringBolaThread, 
            tembrengBolaThread, cincinBolaThread
        };
        
        // interrupt random BERULANG (3 kali)
        Thread randomInterrupt = new Thread(() -> {
            try {
                // Interrupt ke-1 setelah 3 detik
                Thread.sleep(3000);
                int idx1 = (int) (Math.random() * threads.length);
                System.err.println("\n[INTERRUPT-1] " + threads[idx1].getName() + " di interupsi!");
                threads[idx1].interrupt();
                JOptionPane.showMessageDialog(null, "[INTERRUPT-1] " + threads[idx1].getName() + " akan di interupsi!");

                // Interrupt ke-2 1 detik kemudian
                Thread.sleep(1000);
                int idx2 = (int) (Math.random() * threads.length);
                System.err.println("\n[INTERRUPT-2] " + threads[idx2].getName() + " di interupsi!");
                threads[idx2].interrupt();
                JOptionPane.showMessageDialog(null, "[INTERRUPT-2] " + threads[idx2].getName() + " akan di interupsi!");

                // Interrupt ke-3 1 detik kemudian
                Thread.sleep(1000);
                int idx3 = (int) (Math.random() * threads.length);
                System.err.println("\n[INTERRUPT-3] " + threads[idx3].getName() + " di interupsi!");
                threads[idx3].interrupt();
                JOptionPane.showMessageDialog(null, "[INTERRUPT-3] " + threads[idx3].getName() + " akan di interupsi!");

            } catch (InterruptedException e) {}
        });
        randomInterrupt.start();
        
        // start semua thread (paralel)
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        
        System.out.println("Metode output");
        System.out.println("[1] Single-thread");
        System.out.println("[2] Multi-thread");
        int pilihanMetode = inputInt("Pilih metode: ");
        
        if (pilihanMetode == 2) {
            jumlahThread = inputInt("Input jumlah thread : ");
            if (jumlahThread > 0) {
                jalankanMultithread();
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
        int pilihanBangun = inputInt("Pilih bangun: ");
        
        switch (pilihanBangun) {
            case 1 -> { // Lingkaran
                System.out.print("\n --- Lingkaran (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                
                Lingkaran lingkaran = new Lingkaran(jariJari);
                double luas = lingkaran.hitungLuas();
                double keliling = lingkaran.hitungKeliling();
                System.out.println(format2DOutput(luas, keliling));
            }
            case 2 -> { // Kerucut
                System.out.print("\n --- Kerucut (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                double tinggi = inputDouble("Tinggi\t\t: ");
                
                Kerucut kerucut = new Kerucut(jariJari, tinggi);
                double luasPermukaan = kerucut.hitungLuasPermukaan();
                double volume = kerucut.hitungVolume();
                System.out.print(format3DOutput(luasPermukaan, volume));
            }
            case 3 -> { // Kerucut Terpancung
                System.out.print("\n --- Kerucut Terpancung (Single-thread) ---\n");
                double jariJariBawah = inputDouble("Jari-jari Bawah\t: ");
                double jariJariAtas = inputDouble("Jari-jari Atas\t: ");
                double tinggi = inputDouble("Tinggi\t\t: ");

                Kerucut kt = new KerucutTerpancung(jariJariBawah, tinggi, jariJariAtas);
                double luasPermukaan = kt.hitungLuasPermukaan();
                double volume = kt.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 4 -> { // Tabung
                System.out.print("\n --- Tabung (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                double tinggi = inputDouble("Tinggi\t\t: ");

                Tabung tabung = new Tabung(jariJari, tinggi);
                double luasPermukaan = tabung.hitungLuasPermukaan();
                double volume = tabung.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 5 -> { // Bola
                System.out.print("\n --- Bola (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");

                Bola bola = new Bola(jariJari);
                double luasPermukaan = bola.hitungLuasPermukaan();
                double volume = bola.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 6 -> { // Juring Bola
                System.out.print("\n --- Juring Bola (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                double tinggi = inputDouble("Tinggi\t: ");

                Bola juringBola = new JuringBola(jariJari, tinggi);
                double luasPermukaan = juringBola.hitungLuasPermukaan();
                double volume = juringBola.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 7 -> { // Tembereng Bola
                System.out.print("\n --- Tembereng Bola (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                double tinggi = inputDouble("Tinggi\t\t: ");
                
                Bola tembereng = new TemberengBola(jariJari, tinggi);
                double luasPermukaan = tembereng.hitungLuasPermukaan();
                double volume = tembereng.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 8 -> { // Cincin Bola
                System.out.print("\n --- Cincin Bola (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                double tinggi = inputDouble("Tinggi\t\t: ");
                
                Bola cincinBola = new CincinBola(jariJari, tinggi);
                double luasPermukaan = cincinBola.hitungLuasPermukaan();
                double volume = cincinBola.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 9 -> { // Juring Lingkaran
                System.out.print("\n --- Juring Lingkaran (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                double sudut = inputDouble("Sudut (Derajat)\t: ");

                JuringLingkaran juringLingkaran = new JuringLingkaran(jariJari, sudut);
                double luas = juringLingkaran.hitungLuas();
                double keliling = juringLingkaran.hitungKeliling();
                System.out.println(format2DOutput(luas, keliling));
            }
            case 10 -> { // Tembereng Lingkaran
                System.out.print("\n --- Tembereng Lingkaran (Single-thread) ---\n");
                double jariJari = inputDouble("Jari-jari\t: ");
                double sudut = inputDouble("Sudut (Derajat)\t: ");

                TemberengLingkaran temberengLingkaran = new TemberengLingkaran(jariJari, sudut);
                double luas = temberengLingkaran.hitungLuas();
                double keliling = temberengLingkaran.hitungKeliling();
                System.out.println(format2DOutput(luas, keliling));
            }
            default -> System.out.println("Pilihan anda tidak valid");
        }
    }
}