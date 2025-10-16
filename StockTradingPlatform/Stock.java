import java.io.Serializable;
import java.util.Random;

public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    private String symbol;
    private String companyName;
    private double currentPrice;
    private double previousPrice;
    private Random random;

    public Stock(String symbol, String companyName, double initialPrice) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentPrice = initialPrice;
        this.previousPrice = initialPrice;
        this.random = new Random();
    }

    public void updatePrice() {
        previousPrice = currentPrice;
        double changePercent = (random.nextDouble() - 0.5) * 0.1;
        currentPrice = currentPrice * (1 + changePercent);
        currentPrice = Math.round(currentPrice * 100.0) / 100.0;
    }

    public double getCurrentPrice() { return currentPrice; }
    public String getSymbol() { return symbol; }
    public String getCompanyName() { return companyName; }
}
