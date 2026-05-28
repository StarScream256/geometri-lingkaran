package geometri3d;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class KerucutThread implements Runnable {
    public int jumlahThread;
    public int delay = 1000;
    
    public DefaultTableModel model;
    public int columnIndex;
    
    public KerucutThread() {}
    
    public KerucutThread(int count) {
        this.jumlahThread = count;
    }
    
    public KerucutThread(int jumlahThread, int delay, DefaultTableModel model, int columnIndex) {
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
                double jariJari = (Math.random() * (12 - 2)) + 2; 
                double tinggi = (Math.random() * (12 - 2)) + 2;
                Kerucut kerucut = new Kerucut(jariJari, tinggi);
                kerucut.hitungLuasPermukaan(); 
                kerucut.hitungVolume();
                double luasPermukaan = kerucut.luasPermukaanKerucut;
                double volume = kerucut.volumeKerucut;
                
                final int currentRow = i;
                SwingUtilities.invokeLater(() -> {
                    model.setValueAt("✅", currentRow, columnIndex);
                });

                String output = String.format(
                    """
                    Thread Kerucut #%d (%s)
                    Jari-jari      : %.2f; 
                    Tinggi         : %.2f 
                    Luas Permukaan : %.2f 
                    Volume         : %.2f 
                    ------------------------
                    """,
                    i, threadName, jariJari, tinggi, luasPermukaan, volume
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
