/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri3d;

// multithreading
// implements Runnable sesuai materi PBO
public class TabungThread implements Runnable {

    // encapsulation
    private Tabung tabung;

    // constructor
    public TabungThread(Tabung tabung) {
        this.tabung = tabung;
    }

    // overriding method run()
    @Override
    public void run() {

        // proses thread
        double volume = tabung.hitungVolume();

        // output console
        System.out.println(
                "Volume Tabung : " + volume
        );
    }
}