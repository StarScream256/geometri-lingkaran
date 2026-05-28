/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri2d;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class LingkaranThread implements Runnable {
    public int count;
    public int delay = 1000;
    
    public DefaultTableModel model;
    public int columnIndex;
    
    public LingkaranThread() {}

    public LingkaranThread(int count) {
        this.count = count;
    }
    
    public LingkaranThread(int count, int delay, DefaultTableModel model, int columnIndex) {
        this.count = count;
        this.delay = delay;
        this.model = model;
        this.columnIndex = columnIndex;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                double jariJari = (Math.random() * (12 - 2)) + 2;
                Lingkaran lingkaran = new Lingkaran(jariJari);
                double luas = lingkaran.hitungLuas();
                double keliling = lingkaran.hitungKeliling();
                
                final int currentRow = i;
                SwingUtilities.invokeLater(() -> {
                    model.setValueAt("✅", currentRow, columnIndex);
                });

                String output = String.format(
                    """
                    Thread Lingkaran #%d (%s)
                    Jari-jari : %.2f
                    Luas      : %.2f
                    Keliling  : %.2f
                    -----------------------------
                    """,
                    i, threadName, jariJari, luas, keliling
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}