package be.vdab;

import java.util.Scanner;

public class KlokMain {
    public static void main(String[] args) {
        var klok = new Klok();
        var thread = new Thread(klok);
        thread.setDaemon(true);
        thread.start();
        var scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
