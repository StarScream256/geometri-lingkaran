
package geometri3d;

import geometri2d.Lingkaran;

public class Bola extends Lingkaran {
    
    public Bola(double r){
        super(r);
    }
    
    @Override
    public double hitungVolume(){
        return(4.0 / 3.0 )* Math.PI * Math.pow(getJariJari(), 3);
    }
    
    @Override
    public double hitungLuasPermukaan(){
        return 4 * Math.PI * Math.pow(getJariJari(), 2);
    }
    
}
