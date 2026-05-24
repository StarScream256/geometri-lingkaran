package geometri3d;

public class JuringBola extends Bola {
    private double tinggiJuring;
    private double volume;
    private double luasPermukaan;
        
    public JuringBola(int r, int tinggiJuring){
        super(r);
        this.tinggiJuring = tinggiJuring;
    }
    
    public JuringBola(double r, double tinggiJuring){
        super(r);
        this.tinggiJuring = tinggiJuring;
    }
    //A adalah jari-jari alas juring
    public double hitungA(){
        double r = getJariJari();
        return Math.sqrt(Math.pow(r,2) - Math.pow(r-tinggiJuring,2));
    }
    @Override
    public double hitungVolume(){
        double r = getJariJari();
        volume = (2.0/3.0) * Math.PI * super.hitungLuas() * tinggiJuring;
        return volume;
    }
    
    @Override
    public double hitungLuasPermukaan(){
        double a = hitungA();
        double r = getJariJari();
        luasPermukaan = (2* Math.PI *r * tinggiJuring) + (Math.PI * a * a);
        return luasPermukaan;
    }
    
    public double getTinggiJuring() {
        return tinggiJuring;
    }
    public void setTinggiJuring(double tinggiJuring) {
        this.tinggiJuring = tinggiJuring;
    }
}
