import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();

        while (true) {
            System.out.println("\nPersonal Finance Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Total Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Is this income? (true/false): ");
                    boolean isIncome = scanner.nextBoolean();
                    manager.addTransaction(amount, category, isIncome);
                    System.out.println("Transaction added successfully.");
                    break;
                case 2:
                    System.out.println("\nAll Transactions:");
                    manager.viewTransactions();
                    break;
                case 3:
                    System.out.println("Total Balance: " + manager.getTotalBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
