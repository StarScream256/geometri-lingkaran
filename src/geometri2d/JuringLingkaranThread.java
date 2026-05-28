package geometri2d;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class JuringLingkaranThread implements Runnable {
    public int jumlahThread;
    public int delay = 1000;
    
    public DefaultTableModel model;
    public int columnIndex;
    
    public JuringLingkaranThread() {}
    
    public JuringLingkaranThread(int count) {
        this.jumlahThread = count;
    }
    
    public JuringLingkaranThread(int jumlahThread, int delay, DefaultTableModel model, int columnIndex) {
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
                // rentang: (Math.random() * (Max - Min)) + Min
                double jariJari = (Math.random() * (12 - 2)) + 2; 
                double sudut = (Math.random() * (360 - 10)) + 10;
                JuringLingkaran juring = new JuringLingkaran(jariJari, sudut);
                double luas = juring.hitungLuas();
                double keliling = juring.hitungKeliling();
                
                final int currentRow = i;
                SwingUtilities.invokeLater(() -> {
                    model.setValueAt("✅", currentRow, columnIndex);
                });

                String output = String.format(
                    """
                    Thread Juring Lingkaran #%d (%s)
                    Jari-jari      : %.2f; 
                    Tinggi         : %.2f 
                    Luas Permukaan : %.2f 
                    Volume         : %.2f 
                    ---------------------------------
                    """,
                    i, threadName, jariJari, sudut, luas, keliling
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}