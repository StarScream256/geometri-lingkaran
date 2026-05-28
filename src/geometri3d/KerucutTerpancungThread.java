package geometri3d;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class KerucutTerpancungThread implements Runnable {
    public int jumlahThread;
    public int delay = 1000;
    
    public DefaultTableModel model;
    public int columnIndex;
    
    public KerucutTerpancungThread() {}

    public KerucutTerpancungThread(int count) {
        this.jumlahThread = count;
    }
    
    public KerucutTerpancungThread(int jumlahThread, int delay, DefaultTableModel model, int columnIndex) {
        this.jumlahThread = jumlahThread;
        this.delay = delay;
        this.model = model;
        this.columnIndex = columnIndex;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < jumlahThread; i++) {
                String threadName = Thread.currentThread().getName();
                double jariJariBawah = (Math.random() * (12 - 7)) + 7;
                double jariJariAtas = (Math.random() * (6 - 2)) + 2;
                double tinggi = (Math.random() * (10 - 5)) + 5;
                KerucutTerpancung kt = new KerucutTerpancung(jariJariBawah, tinggi, jariJariAtas);
                double luasPermukaan = kt.hitungLuasPermukaan();
                double volume = kt.hitungVolume();
                
                final int currentRow = i;
                SwingUtilities.invokeLater(() -> {
                    model.setValueAt("✅", currentRow, columnIndex);
                });

                String output = String.format(
                    """
                    Thread Kerucut Terpancung #%d (%s)
                    Jari Bawah     : %.2f; 
                    Jari Atas      : %.2f; 
                    Tinggi         : %.2f
                    Luas Permukaan : %.2f
                    Volume         : %.2f
                    -----------------------------------
                    """,
                    i, threadName, jariJariBawah, jariJariAtas, tinggi, luasPermukaan, volume
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}