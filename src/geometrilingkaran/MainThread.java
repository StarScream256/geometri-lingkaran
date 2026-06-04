/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometrilingkaran;

import geometri2d.JuringLingkaranThread;
import geometri2d.LingkaranThread;
import geometri2d.TemberengLingkaranThread;
import geometri3d.BolaThread;
import geometri3d.CincinBolaThread;
import geometri3d.JuringBolaThread;
import geometri3d.KerucutTerpancungThread;
import geometri3d.KerucutThread;
import geometri3d.TabungThread;
import geometri3d.TemberengBolaThread;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainThread {
    
    public void run(int jumlahThread) {
        jumlahThread /= 10;
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
                JOptionPane.showMessageDialog(null, "[INTERRUPT-1] " + threads[idx1].getName() + " di interupsi!");

                // Interrupt ke-2 1 detik kemudian
                Thread.sleep(1000);
                int idx2 = (int) (Math.random() * threads.length);
                System.err.println("\n[INTERRUPT-2] " + threads[idx2].getName() + " di interupsi!");
                threads[idx2].interrupt();
                JOptionPane.showMessageDialog(null, "[INTERRUPT-2] " + threads[idx2].getName() + " di interupsi!");

                // Interrupt ke-3 1 detik kemudian
                Thread.sleep(1000);
                int idx3 = (int) (Math.random() * threads.length);
                System.err.println("\n[INTERRUPT-3] " + threads[idx3].getName() + " di interupsi!");
                threads[idx3].interrupt();
                JOptionPane.showMessageDialog(null, "[INTERRUPT-3] " + threads[idx3].getName() + " di interupsi!");

            } catch (InterruptedException e) {}
        });
        randomInterrupt.start();
        
        // start semua thread (paralel)
        for (Thread thread : threads) {
            thread.start();
        }
    }
            
    public static void main(String[] args) {
        new MainThread().run(100);
    }
}