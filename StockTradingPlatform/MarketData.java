import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MarketData {
    private Map<String, Stock> availableStocks;
    private Timer priceUpdateTimer;
    
    public MarketData() {
        this.availableStocks = new HashMap<>();
        initializeStocks();
        startPriceUpdates();
    }
    
    private void initializeStocks() {
        // Initialize with popular stocks
        availableStocks.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.00));
        availableStocks.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        availableStocks.put("MSFT", new Stock("MSFT", "Microsoft Corp.", 300.00));
        availableStocks.put("AMZN", new Stock("AMZN", "Amazon.com Inc.", 3200.00));
        availableStocks.put("TSLA", new Stock("TSLA", "Tesla Inc.", 800.00));
        availableStocks.put("META", new Stock("META", "Meta Platforms", 350.00));
        availableStocks.put("NFLX", new Stock("NFLX", "Netflix Inc.", 400.00));
        availableStocks.put("NVDA", new Stock("NVDA", "NVIDIA Corp.", 220.00));
    }
    
    private void startPriceUpdates() {
        priceUpdateTimer = new Timer();
        priceUpdateTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateAllStockPrices();
            }
        }, 0, 5000); // Update every 5 seconds
    }
    
    private void updateAllStockPrices() {
        for (Stock stock : availableStocks.values()) {
            stock.updatePrice();
        }
    }
    
    public Stock getStock(String symbol) {
        return availableStocks.get(symbol.toUpperCase());
    }
    
    public Map<String, Stock> getAllStocks() {
        return new HashMap<>(availableStocks);
    }
    
    public void stopPriceUpdates() {
        if (priceUpdateTimer != null) {
            priceUpdateTimer.cancel();
        }
    }
}
