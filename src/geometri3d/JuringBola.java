package geometri3d;

public class JuringBola extends Bola implements Geometri3D {
    public double jariJari;
    public double tinggiJuring = 10;
    public double pi; 
    public double luasPermukaanJuringBola;
    public double volumeJuringBola;
        
    public JuringBola(double jariJari, double tinggi){
        super(jariJari); 
        this.jariJari = jariJari;
        this.tinggiJuring = tinggi;
        this.pi = super.PI;
        super.hitungLuasPermukaan(this.jariJari);
        super.hitungVolume(this.jariJari);
    }
    
    @Override
    public double hitungLuasPermukaan(){
        luasPermukaanJuringBola = (2 * super.PI * this.jariJari * this.tinggiJuring)
                                  +
                                  (super.PI * this.jariJari * Math.sqrt(2 * this.jariJari * this.tinggiJuring - Math.pow(this.tinggiJuring, 2)));   
        return luasPermukaanJuringBola;
    }
    
    public double hitungLuasPermukaan(double jariJari, double tinggi) {
        luasPermukaanJuringBola = (2 * super.PI * jariJari * tinggi)
                                  +
                                  (super.PI * jariJari * Math.sqrt(2 * jariJari * tinggi - Math.pow(tinggi, 2))); 
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
}
