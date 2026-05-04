/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri2d;

import geometri2d.BendaGeometri;

/**
 *
 * @author Lenovo
 */
public abstract  class Geometri2D implements BendaGeometri{
    protected String nama;
    
    public Geometri2D(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }

    @Override
    public double hitungLuas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double hitungKeliling() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double hitungVolume() {
        return 0;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 0;
    }
    
    
}
