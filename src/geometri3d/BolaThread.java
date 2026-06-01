package geometri3d;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devio
 */
public class BolaThread implements Runnable {
    public int jumlahThread;
    public int delay = 1000;
    
    public DefaultTableModel model;
    public int columnIndex;
    
    public BolaThread() {}
    
    public BolaThread(int count){
        this.jumlahThread = count;
    }
    
    public BolaThread(int jumlahThread, int delay, DefaultTableModel model, int columnIndex){
        this.jumlahThread = jumlahThread;
        this.delay = delay;
        this.model = model;
        this.columnIndex = columnIndex;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i < jumlahThread; i++) {
                String threadName = Thread.currentThread().getName();
                double jariJari = (Math.random() * (12 - 2)) + 2;
                Bola bola = new Bola(jariJari);
                double luasPermukaan = bola.hitungLuasPermukaan();
                double volume = bola.hitungVolume();
                
                if (model != null) {
                    final int currentRow = i;
                    SwingUtilities.invokeLater(() -> {
                        model.setValueAt("✅", currentRow, columnIndex);
                    });
                }

                String output = String.format(
                    """
                    Thread bola #%d (%s)
                    Jari-jari       : %.2f
                    Luas Permukaan  : %.2f
                    Volume          : %.2f
                    -----------------------------
                    """,
                    i, threadName, jariJari, luasPermukaan, volume
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
