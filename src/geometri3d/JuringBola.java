package geometri3d;

public class JuringBola extends Bola implements Geometri3D, Runnable {
    public double jariJari;
    public double tinggiJuring = 10;
    public double pi; 
    public double luasPermukaanJuringBola;
    public double volumeJuringBola;
    
    public int count;
    public int delay;
        
    public JuringBola(double jariJari, double tinggi){
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.tinggiJuring = tinggi;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
    }
    
    public JuringBola(double jariJari, double tinggi, int count, int delay){
        super(jariJari); 
        this.jariJari = jariJari;
        super.jariJari = jariJari;
        this.tinggiJuring = tinggi;
        this.pi = super.PI;
        super.hitungLuas();
        super.hitungKeliling();
        this.count = count;
        this.delay = delay;
    }
    
    public double hitungJariJariAlas(double jariJari, double tinggi) {
        return Math.sqrt(Math.pow(jariJari, 2) - Math.pow(jariJari - tinggi, 2));
    }
    
    @Override
    public double hitungLuasPermukaan(){
        double jariJariAlas = hitungJariJariAlas(this.jariJari, this.tinggiJuring);
        double luasAlasJuring = super.hitungLuas(jariJariAlas);
        double luasSelimutKubah = super.kelilingLingkaran * this.tinggiJuring;
        luasPermukaanJuringBola = luasAlasJuring + luasSelimutKubah;
        return luasPermukaanJuringBola;
    }
    
    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        double jariJariAlas = hitungJariJariAlas(jariJari, tinggi);
        double luasAlasJuring = super.hitungLuas(jariJariAlas);
        double luasSelimutKubah = super.hitungKeliling(jariJari) * tinggi;
        luasPermukaanJuringBola = luasSelimutKubah + luasAlasJuring;
        return luasPermukaanJuringBola;
    }

    @Override
    public double hitungVolume(){
        volumeJuringBola = (2.0 / 3.0) * super.luasLingkaran * this.tinggiJuring;
        return volumeJuringBola;
    }
    
    public double hitungVolume(double jariJari, double tinggi) {
        volumeJuringBola = (2.0 / 3.0) * super.hitungLuas(jariJari) * tinggi;
        return volumeJuringBola;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i < count; i++) {
                String threadName = Thread.currentThread().getName();
                jariJari += i;
                tinggiJuring += i;
                luasPermukaanJuringBola = hitungLuasPermukaan(jariJari, tinggiJuring);
                volumeJuringBola = hitungVolume(jariJari, tinggiJuring);

                String output = String.format(
                    """
                    Thread juring bola #%d (%s)
                    Jari-jari       : %.2f
                    Tinggi          : %.2f
                    Luas Permukaan  : %.2f
                    Volume          : %.2f
                    -----------------------------
                    """,
                    i, threadName, jariJari, tinggiJuring, luasPermukaanJuringBola, volumeJuringBola
                );
                System.out.print(output);
                Thread.sleep(delay);
            }
                      
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
