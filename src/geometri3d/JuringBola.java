package geometri3d;

public class JuringBola extends Bola {
    private double pi;
    private double jariJari;
    private double tinggiJuring = 10;
    private double volume;
    private double luasPermukaan;
        
    public JuringBola(){
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
    }
    
    public JuringBola(double r, double tinggiJuring){
        super(r);
        this.jariJari = super.getJariJari();
        this.pi = super.getPI();
        this.tinggiJuring = tinggiJuring;
    }
    
    //A adalah jari-jari alas juring
    public double hitungA(){
        double r = this.jariJari;
        return Math.sqrt(Math.pow(r, 2) - Math.pow(r - tinggiJuring, 2));
    }
    @Override
    public double hitungVolume(){
        double r = this.jariJari;
        volume = (2.0/3.0) * this.pi * super.hitungLuas() * tinggiJuring;
        return volume;
    }
    
    @Override
    public double hitungLuasPermukaan(){
        double a = hitungA();
        double r = this.jariJari;
        luasPermukaan = (2* this.pi *r * tinggiJuring) + (this.pi * a * a);
        return luasPermukaan;
    }
    
    public double getTinggiJuring() {
        return tinggiJuring;
    }
    public void setTinggiJuring(double tinggiJuring) {
        this.tinggiJuring = tinggiJuring;
    }
}
