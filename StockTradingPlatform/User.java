import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private String password;
    private double balance;
    private Portfolio portfolio;
    private Map<String,Transaction> transactionHistory;
    
    public User(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
        this.portfolio = new Portfolio();
        this.transactionHistory = new HashMap<>();
    }
    
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
    
    public boolean canAfford(double amount) {
        return balance >= amount;
    }
    
    public void debitBalance(double amount) {
        if (canAfford(amount)) {
            balance -= amount;
        }
    }
    
    public void creditBalance(double amount) {
        balance += amount;
    }
    
    public void addTransaction(Transaction transaction) {
        transactionHistory.put(
            transaction.getTransactionId(), 
            transaction
        );
    }
    
    // Getters and setters
    public String getUsername() { return username; }
    public double getBalance() { return balance; }
    public Portfolio getPortfolio() { return portfolio; }
    public Map<String, Transaction> getTransactionHistory() { 
        return new HashMap<>(transactionHistory); 
    }
}
