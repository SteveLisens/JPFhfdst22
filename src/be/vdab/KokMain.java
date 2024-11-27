package be.vdab;

public class KokMain {
    public static void main(String[] args) {
        var stapel = new Stapel();
        var thread1 = Thread.startVirtualThread(new Kok(stapel));
        var thread2 = Thread.startVirtualThread(new Kok(stapel));
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        System.out.println(stapel.getAantalPannenkoeken());
    }
}
