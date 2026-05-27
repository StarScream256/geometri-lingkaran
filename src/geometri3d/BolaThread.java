package geometri3d;

/**
 *
 * @author devio
 */
public class BolaThread implements Runnable {
    public int count;
    public int delay = 1000; 
    
    public BolaThread() {}
    
    public BolaThread(int count){
        this.count = count;
    }
    
    public BolaThread(int count, int delay){
        this.count = count;
        this.delay = delay;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                double jariJari = (Math.random() * (12 - 2)) + 2;
                Bola bola = new Bola(jariJari);
                double luasPermukaan = bola.hitungLuasPermukaan();
                double volume = bola.hitungVolume();

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
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
