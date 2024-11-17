public class Transaction {
    private double amount;
    private String category;
    private boolean isIncome;

    public Transaction(double amount, String category, boolean isIncome) {
        this.amount = amount;
        this.category = category;
        this.isIncome = isIncome;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public boolean isIncome() {
        return isIncome;
    }

    @Override
    public String toString() {
        return (isIncome ? "Income: " : "Expense: ") + "Amount: " + amount + ", Category: " + category;
    }
}
