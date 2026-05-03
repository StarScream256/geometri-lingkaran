
package geometri3d;

public class Bola extends BendaGeometri {
    private double r;
    
    public Bola(double r){
        this.r = r;
    }
    
    public double getJariJari(){
        return r;
    }
    
    @Override
    public double hitungVolume(){
        return(4.0 / 3.0 )* Math.PI * Math.pow(r,3);
    }
    
    @Override
    public double hitungLuasPermukaan(){
        return 4 * Math.PI * Math.pow(r,2);
    }
    
}
