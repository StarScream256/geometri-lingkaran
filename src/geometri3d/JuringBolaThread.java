package geometri3d;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devio
 */
public class JuringBolaThread implements Runnable{
    public int jumlahThread;
    public int delay = 1000;
    
    public DefaultTableModel model;
    public int columnIndex;
    
    public JuringBolaThread() {}
    
    public JuringBolaThread(int count){
        this.jumlahThread = count;
    }
    
    public JuringBolaThread(int jumlahThread, int delay, DefaultTableModel model, int columnIndex){
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
                double jariJari = (Math.random() * (12 - 2))+2;
                double tinggi = (Math.random() * (12 - 2)) + 2;
                JuringBola juringBola = new JuringBola(jariJari,tinggi);
                double luasPermukaan = juringBola.hitungLuasPermukaan();
                double volume = juringBola.hitungVolume();
                
                if (model != null) {
                    final int currentRow = i;
                    SwingUtilities.invokeLater(() -> {
                        model.setValueAt("✅", currentRow, columnIndex);
                    });
                }

                String output = String.format(
                    """
                    Thread juring bola #%d (%s)
                    Jari-jari       : %.2f
                    Tinggi          : %.2f
                    Luas Permukaan  : %.2f
                    Volume          : %.2f
                    -----------------------------
                    """,
                    i, threadName, jariJari, tinggi, luasPermukaan, volume
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
                      
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
