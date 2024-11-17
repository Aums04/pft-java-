import java.io.*;
import java.util.LinkedList;

public class FinanceManager {
    private LinkedList<Transaction> transactions;
    private static final String FILE_NAME = "transactions.txt";

    public FinanceManager() {
        transactions = new LinkedList<>();
        loadTransactionsFromFile();
    }

    public void addTransaction(double amount, String category, boolean isIncome) {
        Transaction transaction = new Transaction(amount, category, isIncome);
        transactions.add(transaction);
        saveTransactionToFile(transaction);
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public double getTotalBalance() {
        double balance = 0.0;
        for (Transaction transaction : transactions) {
            balance += transaction.isIncome() ? transaction.getAmount() : -transaction.getAmount();
        }
        return balance;
    }

    private void saveTransactionToFile(Transaction transaction) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(transaction.getAmount() + "," + transaction.getCategory() + "," + transaction.isIncome() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    private void loadTransactionsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                boolean isIncome = Boolean.parseBoolean(parts[2]);
                transactions.add(new Transaction(amount, category, isIncome));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous transactions found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading transactions: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing transaction data. Check file format.");
        }
    }
}
