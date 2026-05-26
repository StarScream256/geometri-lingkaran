package geometri3d;

public class CincinBolaTorus extends Bola implements Geometri3D {
    public double jariJariMinor = 7; 
    public double jariJariMajor = 14; 
    public double pi; 
    public double luasPermukaanCincinBolaTorus;
    public double volumeCincinBolaTorus;

    public CincinBolaTorus(double jariJariMinor, double jariJariMajor) {
        super(jariJariMinor); 
        this.jariJariMinor = jariJariMinor;
        this.jariJariMajor = jariJariMajor;
        this.pi = super.pi; 
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanCincinBolaTorus = 4 * Math.pow(this.pi, 2) * this.jariJariMajor * this.jariJariMinor;
        return luasPermukaanCincinBolaTorus;
    }

    public double hitungLuasPermukaan(double jariJariMinor, double jariJariMajor) {
        luasPermukaanCincinBolaTorus = 4 * Math.pow(super.pi, 2) * jariJariMajor * jariJariMinor;
        return luasPermukaanCincinBolaTorus;
    }

    @Override
    public double hitungVolume() {
        volumeCincinBolaTorus = 2 * Math.pow(this.pi, 2) * this.jariJariMajor * Math.pow(this.jariJariMinor, 2);
        return volumeCincinBolaTorus;
    }

    public double hitungVolume(double jariJariMinor, double jariJariMajor) {
        volumeCincinBolaTorus = 2 * Math.pow(super.pi, 2) * jariJariMajor * Math.pow(jariJariMinor, 2);
        return volumeCincinBolaTorus;
    }
}