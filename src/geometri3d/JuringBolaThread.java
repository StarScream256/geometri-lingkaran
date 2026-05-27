package geometri3d;

/**
 *
 * @author devio
 */
public class JuringBolaThread implements Runnable{
    public int count;
    public int delay = 1000;
    
    public JuringBolaThread() {}
    
    public JuringBolaThread(int count){
        this.count = count;
    }
    
    public JuringBolaThread(int count, int delay){
        this.count = count;
        this.delay = delay;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                double jariJari = (Math.random() * (12 - 2))+2;
                double tinggi = (Math.random() * (12 - 2)) + 2;
                JuringBola juringBola = new JuringBola(jariJari,tinggi);
                double luasPermukaan = juringBola.hitungLuasPermukaan();
                double volume = juringBola.hitungVolume();

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
