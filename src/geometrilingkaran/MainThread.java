/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometrilingkaran;

import geometri2d.JuringLingkaran;
import geometri2d.Lingkaran;
import geometri2d.TemberengLingkaran;
import geometri3d.Bola;
import geometri3d.CincinBola;
import geometri3d.JuringBola;
import geometri3d.Kerucut;
import geometri3d.KerucutTerpancung;
import geometri3d.Tabung;
import geometri3d.TemberengBola;

/**
 *
 * @author asus
 */
public class MainThread {
    public static void main(String[] args) {
        int count = 100;
        count /= 10;
        int delay = 1000;
        
        Thread lingkaranThread = new Thread(new Lingkaran(1, count, delay));
        Thread juringLingkaranThread = new Thread(new JuringLingkaran(1, 45, count, delay));
        Thread temberengLingkaranThread = new Thread(new TemberengLingkaran(1, 45, count, delay));
        Thread kerucutThread = new Thread(new Kerucut(10, 20, count, delay));
        Thread kerucutTerpancungThread = new Thread(new KerucutTerpancung(10, 10, 5, count, delay));
        Thread tabungThread = new Thread(new Tabung(5, 5, count, delay));
        Thread bolaThread = new Thread(new Bola(10, count, delay));
        Thread juringBolaThread = new Thread(new JuringBola(10, 5, count, delay));
        Thread tembrengBolaThread = new Thread(new TemberengBola(10, 5, count, delay));
        Thread cincinBolaThread = new Thread(new CincinBola(10, 5, count, delay));

         Thread[] threads = {lingkaranThread, juringLingkaranThread, temberengLingkaranThread, kerucutThread,
             kerucutTerpancungThread, tabungThread, bolaThread, juringBolaThread, tembrengBolaThread, cincinBolaThread
         };
        
        for (Thread thread : threads) {
            thread.start();
        }
        
        // interupsi random, setelah detik ke 1, pilih thread random untuk diinterupsi
        Thread randomInterrupt = new Thread(() -> {
           try {
               Thread.sleep(3000);
               int randomIndex = (int) (Math.random() * threads.length);
                Thread targetThread = threads[randomIndex];
                
                System.err.println("\n" + targetThread.getName() + " di interupsi!");
                targetThread.interrupt();
           } catch (InterruptedException e) {}
        });
        // randomInterrupt.start();
    }
}
