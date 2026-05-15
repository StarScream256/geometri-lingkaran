package geometri3d;

/**
 *
 * @author devio
 */
public class BolaThread implements Runnable {
    private int nomor;
    public BolaThread(int nomor){
        this.nomor = nomor;
    }
    
    @Override
    public void run(){
        try{
            //Delay random antara 0-300 ms agar output tidak berurutan rapi
            Thread.sleep((long)(Math.random()*300));
                      
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        double jariJari = (Math.random() * (12-2))+2;
        Bola bola = new Bola(jariJari);
        double luasPermukaan = bola.hitungLuasPermukaan();
        double volume = bola.hitungVolume();
        
        String output = String.format(
            """
            Thread bola #%d (%s)
            Jari-jari : %.2f
            Luas Permukaan\t: %.2f
            Volume \t\t: %.2f
            -----------------------------

            """,
            this.nomor, Thread.currentThread().getName(),jariJari,luasPermukaan,volume
        
        );
        System.out.print(output);
    }
}
