package geometri2d;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TemberengLingkaranThread implements Runnable {
    public int jumlahThread;
    public int delay = 1000;
    
    public DefaultTableModel model;
    public int columnIndex;

    public TemberengLingkaranThread() {}
    
    public TemberengLingkaranThread(int count) {
        this.jumlahThread = count;
    }
    
    public TemberengLingkaranThread(int jumlahThread, int delay, DefaultTableModel model, int columnIndex) {
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
                double sudut = (Math.random() * (179 - 10)) + 10; 
                TemberengLingkaran tembereng = new TemberengLingkaran(jariJari, sudut);
                double luas = tembereng.hitungLuas();
                double keliling = tembereng.hitungKeliling();
                
                if (model != null) {
                    final int currentRow = i;
                    SwingUtilities.invokeLater(() -> {
                        model.setValueAt("✅", currentRow, columnIndex);
                    });
                }

                String output = String.format(
                    """
                    Thread Tembereng Lingkaran #%d (%s)
                    Jari-jari          : %.2f
                    Sudut Tembereng    : %.2f
                    Luas Tembereng     : %.2f 
                    Keliling Tembereng : %.2f 
                    ------------------------------------
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