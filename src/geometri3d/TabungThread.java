/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

/**
 *
 * @author LEGION
 */
public class TabungThread extends Thread {
    private Tabung tabung;

    public TabungThread(Tabung t) {
        this.tabung = t;
    }

    @Override
    public void run() {
        System.out.println(tabung.getVolume());
    }
}
