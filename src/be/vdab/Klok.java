package be.vdab;

import java.time.LocalTime;

public class Klok implements Runnable {

    @Override
    public void run() {
        var verderDoen = true;
        while (verderDoen) {
            System.out.println(LocalTime.now());
        }
    }
}
