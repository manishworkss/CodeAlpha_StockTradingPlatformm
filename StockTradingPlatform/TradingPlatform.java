import java.util.*;

public class TradingPlatform {
    private Map<String, Stock> market;
    private Portfolio portfolio;
    private Scanner scanner;
    private String portfolioFile;

    public TradingPlatform(String portfolioFile) {
        this.market = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.portfolioFile = portfolioFile;
        this.portfolio = PortfolioIO.loadPortfolio(portfolioFile);
        initializeMarket();
    }

    private void initializeMarket() {
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.00));
        market.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        market.put("MSFT", new Stock("MSFT", "Microsoft Corp.", 300.00));
        market.put("TSLA", new Stock("TSLA", "Tesla Inc.", 800.00));
    }

    public void start() {
        while (true) {
            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: viewMarket(); break;
                case 2: buyStock(); break;
                case 3: sellStock(); break;
                case 4: viewPortfolio(); break;
                case 5: PortfolioIO.savePortfolio(portfolio, portfolioFile); System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void viewMarket() {
        System.out.println("\nMarket Data:");
        for (Stock stock : market.values()) {
            stock.updatePrice();
            System.out.printf("%s (%s): $%.2f\n", stock.getCompanyName(), stock.getSymbol(), stock.getCurrentPrice());
        }
    }

    private void buyStock() {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine().toUpperCase();
        Stock stock = market.get(symbol);
        if (stock == null) {
            System.out.println("Stock not found!");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        portfolio.addStock(symbol, qty);
        PortfolioIO.savePortfolio(portfolio, portfolioFile);
        System.out.println("Bought " + qty + " shares of " + symbol);
    }

    private void sellStock() {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine().toUpperCase();
        int owned = portfolio.getStockQuantity(symbol);
        if (owned == 0) {
            System.out.println("You don't own this stock!");
            return;
        }
        System.out.print("Enter quantity to sell: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        if (portfolio.removeStock(symbol, qty)) {
            PortfolioIO.savePortfolio(portfolio, portfolioFile);
            System.out.println("Sold " + qty + " shares of " + symbol);
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    private void viewPortfolio() {
        portfolio.updateTotalValue(market);
        System.out.println("\nYour Portfolio:");
        for (Map.Entry<String, Integer> entry : portfolio.getHoldings().entrySet()) {
            String symbol = entry.getKey();
            int qty = entry.getValue();
            Stock stock = market.get(symbol);
            if (stock != null) {
                System.out.printf("%s: %d shares @ $%.2f\n", symbol, qty, stock.getCurrentPrice());
            }
        }
        System.out.printf("Total Value: $%.2f\n", portfolio.getTotalValue());
    }

    public static void main(String[] args) {
        TradingPlatform app = new TradingPlatform("portfolio.ser");
        app.start();
    }
}
