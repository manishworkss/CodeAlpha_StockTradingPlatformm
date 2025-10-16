import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Portfolio implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> holdings; // Stock symbol -> quantity
    private double totalValue;

    public Portfolio() {
        this.holdings = new HashMap<>();
        this.totalValue = 0.0;
    }

    public void addStock(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    public boolean removeStock(String symbol, int quantity) {
        int currentQuantity = holdings.getOrDefault(symbol, 0);
        if (currentQuantity >= quantity) {
            int newQuantity = currentQuantity - quantity;
            if (newQuantity == 0) {
                holdings.remove(symbol);
            } else {
                holdings.put(symbol, newQuantity);
            }
            return true;
        }
        return false;
    }

    public int getStockQuantity(String symbol) {
        return holdings.getOrDefault(symbol, 0);
    }

    public void updateTotalValue(Map<String, Stock> availableStocks) {
        totalValue = 0.0;
        for (Map.Entry<String, Integer> holding : holdings.entrySet()) {
            String symbol = holding.getKey();
            int quantity = holding.getValue();
            if (availableStocks.containsKey(symbol)) {
                double currentPrice = availableStocks.get(symbol).getCurrentPrice();
                totalValue += currentPrice * quantity;
            }
        }
    }

    public Map<String, Integer> getHoldings() {
        return new HashMap<>(holdings);
    }

    public double getTotalValue() { return totalValue; }

    public boolean isEmpty() {
        return holdings.isEmpty();
    }
}
