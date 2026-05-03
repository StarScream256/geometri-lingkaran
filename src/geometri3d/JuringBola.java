
package geometri3d;

public class JuringBola extends Bola {
    private double tinggiJuring;
    
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
        return (2.0/3.0) * Math.PI * Math.pow(r,2) * tinggiJuring;
    }
    
    @Override
    public double hitungLuasPermukaan(){
        double a = hitungA();
        double r = getJariJari();
        return (2* Math.PI *r * tinggiJuring) + (Math.PI * r * a);
    }
}
