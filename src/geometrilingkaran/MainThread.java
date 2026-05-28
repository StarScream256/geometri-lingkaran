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

/**
 *
 * @author asus
 */
public class MainThread {
    public static void main(String[] args) {
        int count = 100;
        count /= 10;
        int delay = 1000;
        
        String[] columns = {
            "Data ke", "(0) Lingkaran", "(1) Juring Lingkaran", "(2) Tembereng Lingkaran", "(3) Kerucut",
            "(4) Kerucut Terpancung", "(5) Tabung", "(6) Bola", "(7) Juring Bola", "(8) Tembereng Bola", "(9) Cincin Bola"
        };
        Object[][] data = new Object[count][columns.length];
        for (int i = 0; i < count; i++) {
            data[i][0] = "Loop #" + (i + 1);
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        
        JFrame frame = new JFrame("Thread Status Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300); // Widened to fit all columns nicely
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        
        Thread lingkaranThread = new Thread(new LingkaranThread(count, delay, model, 1));
        Thread juringLingkaranThread = new Thread(new JuringLingkaranThread(count, delay, model, 2));
        Thread temberengLingkaranThread = new Thread(new TemberengLingkaranThread(count, delay, model, 3));
        Thread kerucutThread = new Thread(new KerucutThread(count, delay, model, 4));
        Thread kerucutTerpancungThread = new Thread(new KerucutTerpancungThread(count, delay, model, 5));
        Thread tabungThread = new Thread(new TabungThread(count, delay, model, 6));
        Thread bolaThread = new Thread(new BolaThread(count, delay, model, 7));
        Thread juringBolaThread = new Thread(new JuringBolaThread(count, delay, model, 8));
        Thread tembrengBolaThread = new Thread(new TemberengBolaThread(count, delay, model, 9));
        Thread cincinBolaThread = new Thread(new CincinBolaThread(count, delay, model, 10));

        Thread[] threads = {lingkaranThread, juringLingkaranThread, temberengLingkaranThread, kerucutThread,
            kerucutTerpancungThread, tabungThread, bolaThread, juringBolaThread, tembrengBolaThread, cincinBolaThread
        };
        
        // interupsi random, setelah detik ke 3, pilih thread random untuk diinterupsi
        Thread randomInterrupt = new Thread(() -> {
           try {
               Thread.sleep(3000);
               int randomIndex = (int) (Math.random() * threads.length);
                Thread targetThread = threads[randomIndex];
                
                System.err.println("\n" + targetThread.getName() + " di interupsi!");
                targetThread.interrupt();
                JOptionPane.showMessageDialog(null, targetThread.getName() + " di interupsi!");
           } catch (InterruptedException e) {}
        });
        randomInterrupt.start();
        
        for (Thread thread : threads) {
            thread.start();
            
            // thread akan berjalan berurutan menunggu thread sebelumnya selesai
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
