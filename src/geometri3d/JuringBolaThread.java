package geometri3d;

/**
 *
 * @author devio
 */
public class JuringBolaThread implements Runnable{
   private int nomor;
    public JuringBolaThread(int nomor){
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
        double tinggi = (Math.random() * (12-2))+2;
        JuringBola juringBola = new JuringBola(jariJari,tinggi);
        double luasPermukaan = juringBola.hitungLuasPermukaan();
        double volume = juringBola.hitungVolume();
        
        String output = String.format(
            """
            Thread juring bola #%d (%s)
            Jari-jari : %.2f
            Tinggi : %.2f
            Luas Permukaan\t: %.2f
            Volume \t\t: %.2f
            -----------------------------

            """,
            this.nomor, Thread.currentThread().getName(),jariJari,tinggi,luasPermukaan,volume
        
        );
        System.out.print(output);
    }
}
