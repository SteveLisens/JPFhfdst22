package be.vdab;
import java.util.Random;

public class GemiddeldeRekenaarMain {
    public static void main(String[] args) {
        double[] numbers = new double[1_000_000];
        var random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextDouble();
        }

        GemiddeldeRekenaar rekenaar1 = new GemiddeldeRekenaar(numbers, 0, 500_000);
        GemiddeldeRekenaar rekenaar2 = new GemiddeldeRekenaar(numbers, 500_000, 1_000_000);

        var thread1 = Thread.ofVirtual().unstarted(rekenaar1);
        var thread2 = Thread.ofVirtual().unstarted(rekenaar2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }

        double avg1 = rekenaar1.getGemiddelde();
        double avg2 = rekenaar2.getGemiddelde();

        double overallAverage = (avg1 + avg2) / 2;

        System.out.println("Gemiddelde van de eerste 500.000 getallen: " + avg1);
        System.out.println("Gemiddelde van de laatste 500.000 getallen: " + avg2);
        System.out.println("Gemiddelde van de 1.000.000 getallen: " + overallAverage);
    }
}