/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyekpboanisa;

/**
 *
 * @author Lenovo
 */
public abstract  class Geometri2D extends BendaGeometri{
    protected String nama;
    public Geometri2D(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
}
