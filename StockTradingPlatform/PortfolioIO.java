import java.io.*;

public class PortfolioIO {
    public static void savePortfolio(Portfolio portfolio, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(portfolio);
            System.out.println("Portfolio saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Portfolio loadPortfolio(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Portfolio) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If file not found, return new portfolio
            return new Portfolio();
        }
    }
}
