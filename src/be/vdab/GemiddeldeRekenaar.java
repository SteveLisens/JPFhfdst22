package be.vdab;

public class GemiddeldeRekenaar implements Runnable {

    private final double[] getallen;
    private final int start;
    private final int stop;
    private double gemiddelde;

    public GemiddeldeRekenaar(double[] getallen, int start, int stop) {
        this.getallen = getallen;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {
        double sum = 0;
        for (int i = start; i < stop; i++) {
            sum += getallen[i];
        }
        gemiddelde = sum / (stop - start);
    }

    public double getGemiddelde() {
        return gemiddelde;
    }
}
