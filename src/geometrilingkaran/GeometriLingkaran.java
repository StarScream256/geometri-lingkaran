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
    public Scanner scanner;
    public int jumlahThread;
    
    public Lingkaran lingkaran;
    public JuringLingkaran juringLingkaran;
    public TemberengLingkaran temberengLingkaran;
    public Kerucut kerucut;
    public Kerucut kerucutTerpancung;
    public Tabung tabung;
    public Bola bola;
    public Bola juringBola;
    public Bola temberengBola;
    public Bola cincinBola;
    
    public double jariJari;
    public double jariJariAtas;
    public double tinggi;
    public double sudut;
    
    public double luas;
    public double keliling;
    public double luasPermukaan;
    public double volume;
    
    public int delay = 1000;
    public String[] tableColumns;
    public Object[][] tableData;
    public DefaultTableModel tableModel;
    public JTable table;
    public JFrame frame;
    
    public Thread lingkaranThread;
    public Thread juringLingkaranThread;
    public Thread temberengLingkaranThread;
    public Thread kerucutThread;
    public Thread kerucutTerpancungThread;
    public Thread tabungThread;
    public Thread bolaThread;
    public Thread juringBolaThread;
    public Thread tembrengBolaThread;
    public Thread cincinBolaThread;
    public Thread[] threads;
    public Thread randomInterrupt;
    
    public double inputDouble;
    public int inputInt;
    public String output;
    
    
    public GeometriLingkaran() {}
    
    public static double isValidPositive(double value) throws NegativeNumberException {
        if (value <= 0) {
            throw new NegativeNumberException("Input angka harus lebih besar dari 0");
        }
        return value;
    }
    
    public static int isValidPositive(int value) throws NegativeNumberException {
        if (value <= 0) {
            throw new NegativeNumberException("Input angka harus lebih besar dari 0");
        }
        return value;
    }
    
    public double inputDouble(String label) {
        while(true) {
            try {
                System.out.print(label);
                inputDouble = isValidPositive(scanner.nextDouble());
                return inputDouble;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka!");
                scanner.next();
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public int inputInt(String label) {
        while(true) {
            try {
                System.out.print(label);
                inputInt = isValidPositive(scanner.nextInt());
                return inputInt;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka!");
                scanner.next();
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public String format2DOutput(double luas, double keliling) {
        output = String.format(
            """
            Luas Lingkaran  : %.2f 
            Keliling        : %.2f 
            ---------------------------
            """,
            luas, keliling
        );
        return output;
    }
    
    public String format3DOutput(double luasPermukaan, double volume) {
        output = String.format(
            """
            Luas Permukaan  : %.2f 
            Volume          : %.2f 
            ---------------------------
            """,
            luasPermukaan, volume
        );
        return output;
    }
    
    public void runMultithread() {
        jumlahThread = jumlahThread / 10;
        
        tableColumns = new String[] {
            "Iterasi data", "(0) Lingkaran", "(1) Juring Lingkaran", "(2) Tembereng Lingkaran", "(3) Kerucut",
            "(4) Kerucut Terpancung", "(5) Tabung", "(6) Bola", "(7) Juring Bola", "(8) Tembereng Bola", "(9) Cincin Bola"
        };
        
        tableData = new Object[jumlahThread][tableColumns.length];
        for (int i = 0; i < jumlahThread; i++) {
            tableData[i][0] = (i + 1);
        }
        
        tableModel = new DefaultTableModel(tableData, tableColumns);
        table = new JTable(tableModel);
        
        frame = new JFrame("Thread Status Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 300);
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        
        lingkaranThread = new Thread(new LingkaranThread(jumlahThread, delay, tableModel, 1));
        juringLingkaranThread = new Thread(new JuringLingkaranThread(jumlahThread, delay, tableModel, 2));
        temberengLingkaranThread = new Thread(new TemberengLingkaranThread(jumlahThread, delay, tableModel, 3));
        kerucutThread = new Thread(new KerucutThread(jumlahThread, delay, tableModel, 4));
        kerucutTerpancungThread = new Thread(new KerucutTerpancungThread(jumlahThread, delay, tableModel, 5));
        tabungThread = new Thread(new TabungThread(jumlahThread, delay, tableModel, 6));
        bolaThread = new Thread(new BolaThread(jumlahThread, delay, tableModel, 7));
        juringBolaThread = new Thread(new JuringBolaThread(jumlahThread, delay, tableModel, 8));
        tembrengBolaThread = new Thread(new TemberengBolaThread(jumlahThread, delay, tableModel, 9));
        cincinBolaThread = new Thread(new CincinBolaThread(jumlahThread, delay, tableModel, 10));

        threads = new Thread[] {
            lingkaranThread, juringLingkaranThread, temberengLingkaranThread, kerucutThread,
            kerucutTerpancungThread, tabungThread, bolaThread, juringBolaThread, 
            tembrengBolaThread, cincinBolaThread
        };
        
        // interrupt random BERULANG (3 kali)
        randomInterrupt = new Thread(() -> {
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

    public void start() {
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
                runMultithread();
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
                jariJari = inputDouble("Jari-jari\t: ");
                
                lingkaran = new Lingkaran(jariJari);
                luas = lingkaran.hitungLuas();
                keliling = lingkaran.hitungKeliling();
                System.out.println(format2DOutput(luas, keliling));
            }
            case 2 -> { // Kerucut
                System.out.print("\n --- Kerucut (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");
                tinggi = inputDouble("Tinggi\t\t: ");
                
                kerucut = new Kerucut(jariJari, tinggi);
                luasPermukaan = kerucut.hitungLuasPermukaan();
                volume = kerucut.hitungVolume();
                System.out.print(format3DOutput(luasPermukaan, volume));
            }
            case 3 -> { // Kerucut Terpancung
                System.out.print("\n --- Kerucut Terpancung (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari Bawah\t: ");
                jariJariAtas = inputDouble("Jari-jari Atas\t: ");
                tinggi = inputDouble("Tinggi\t\t: ");

                kerucutTerpancung = new KerucutTerpancung(jariJari, tinggi, jariJariAtas);
                luasPermukaan = kerucutTerpancung.hitungLuasPermukaan();
                volume = kerucutTerpancung.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 4 -> { // Tabung
                System.out.print("\n --- Tabung (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");
                tinggi = inputDouble("Tinggi\t\t: ");

                tabung = new Tabung(jariJari, tinggi);
                luasPermukaan = tabung.hitungLuasPermukaan();
                volume = tabung.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 5 -> { // Bola
                System.out.print("\n --- Bola (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");

                bola = new Bola(jariJari);
                luasPermukaan = bola.hitungLuasPermukaan();
                volume = bola.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 6 -> { // Juring Bola
                System.out.print("\n --- Juring Bola (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");
                tinggi = inputDouble("Tinggi\t: ");

                juringBola = new JuringBola(jariJari, tinggi);
                luasPermukaan = juringBola.hitungLuasPermukaan();
                volume = juringBola.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 7 -> { // Tembereng Bola
                System.out.print("\n --- Tembereng Bola (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");
                tinggi = inputDouble("Tinggi\t\t: ");
                
                temberengBola = new TemberengBola(jariJari, tinggi);
                luasPermukaan = temberengBola.hitungLuasPermukaan();
                volume = temberengBola.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 8 -> { // Cincin Bola
                System.out.print("\n --- Cincin Bola (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");
                tinggi = inputDouble("Tinggi\t\t: ");
                
                cincinBola = new CincinBola(jariJari, tinggi);
                luasPermukaan = cincinBola.hitungLuasPermukaan();
                volume = cincinBola.hitungVolume();
                System.out.println(format3DOutput(luasPermukaan, volume));
            }
            case 9 -> { // Juring Lingkaran
                System.out.print("\n --- Juring Lingkaran (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");
                sudut = inputDouble("Sudut (Derajat)\t: ");

                juringLingkaran = new JuringLingkaran(jariJari, sudut);
                luas = juringLingkaran.hitungLuas();
                keliling = juringLingkaran.hitungKeliling();
                System.out.println(format2DOutput(luas, keliling));
            }
            case 10 -> { // Tembereng Lingkaran
                System.out.print("\n --- Tembereng Lingkaran (Single-thread) ---\n");
                jariJari = inputDouble("Jari-jari\t: ");
                sudut = inputDouble("Sudut (Derajat)\t: ");

                temberengLingkaran = new TemberengLingkaran(jariJari, sudut);
                luas = temberengLingkaran.hitungLuas();
                keliling = temberengLingkaran.hitungKeliling();
                System.out.println(format2DOutput(luas, keliling));
            }
            default -> System.out.println("Pilihan anda tidak valid");
        }
    }
    
    public static void main(String[] args) {
        GeometriLingkaran main = new GeometriLingkaran();
        main.start();
    }
}