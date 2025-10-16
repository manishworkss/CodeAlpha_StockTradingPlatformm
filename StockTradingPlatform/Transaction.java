import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionId;
    private String stockSymbol;
    private TransactionType type;
    private int quantity;
    private double pricePerShare;
    private double totalAmount;
    private LocalDateTime timestamp;
    
    public enum TransactionType {
        BUY, SELL
    }
    
    public Transaction(String stockSymbol, TransactionType type, 
                      int quantity, double pricePerShare) {
        this.transactionId = generateTransactionId();
        this.stockSymbol = stockSymbol;
        this.type = type;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
        this.totalAmount = quantity * pricePerShare;
        this.timestamp = LocalDateTime.now();
    }
    
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }
    
    // Getters
    public String getTransactionId() { return transactionId; }
    public String getStockSymbol() { return stockSymbol; }
    public TransactionType getType() { return type; }
    public int getQuantity() { return quantity; }
    public double getPricePerShare() { return pricePerShare; }
    public double getTotalAmount() { return totalAmount; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s %d shares of %s at $%.2f (Total: $%.2f)",
                timestamp.format(formatter), type, quantity, 
                stockSymbol, pricePerShare, totalAmount);
    }
}
