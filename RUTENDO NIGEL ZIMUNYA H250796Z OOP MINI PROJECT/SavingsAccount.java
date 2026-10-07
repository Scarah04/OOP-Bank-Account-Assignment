public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate; // e.g., 0.05 for 5%

    public SavingsAccount(String accountNumber, double balance, double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: Amount must be positive.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.printf("Withdrawal rejected for Savings Account %s: Transaction of $%.2f would violate minimum balance of $%.2f. Current Balance: $%.2f%n",
                    accountNumber, amount, minimumBalance, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrew $%.2f from Savings Account %s. New Balance: $%.2f%n", amount, accountNumber, balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("End of Month [Savings %s]: Applied interest of $%.2f. New Balance: $%.2f%n",
                accountNumber, interest, balance);
    }
}