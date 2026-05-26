/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometrilingkaran;

import geometri2d.JuringLingkaranThread;
import geometri2d.LingkaranThread;
import geometri2d.TemberengLingkaranThread;
import geometri3d.BolaThread;
import geometri3d.CincinBolaThread;
import geometri3d.JuringBolaThread;
import geometri3d.KerucutTerpancungThread;
import geometri3d.KerucutThread;
import geometri3d.TabungThread;
import geometri3d.TemberengBolaThread;

/**
 *
 * @author asus
 */
public class MainThread {
    public static void main(String[] args) {
        int count = 100;
        count /= 10;
        int delay = 1000;
        
        Thread lingkaranThread = new Thread(new LingkaranThread(count, delay));
        Thread juringLingkaranThread = new Thread(new JuringLingkaranThread(count, delay));
        Thread temberengLingkaranThread = new Thread(new TemberengLingkaranThread(count, delay));
        Thread kerucutThread = new Thread(new KerucutThread());
        Thread kerucutTerpancungThread = new Thread(new KerucutTerpancungThread());
        Thread tabungThread = new Thread(new TabungThread());
        Thread bolaThread = new Thread(new BolaThread());
        Thread juringBolaThread = new Thread(new JuringBolaThread());
        Thread tembrengBolaThread = new Thread(new TemberengBolaThread());
        Thread cincinBolaThread = new Thread(new CincinBolaThread());

        //Thread[] threads = {lingkaranThread, juringLingkaranThread, temberengLingkaranThread, kerucutThread,
        //    kerucutTerpancungThread, tabungThread, bolaThread, juringBolaThread, tembrengBolaThread, cincinBolaThread
        // };
        Thread[] threads = {lingkaranThread, juringLingkaranThread, temberengLingkaranThread};
        
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
        randomInterrupt.start();
    }
}
