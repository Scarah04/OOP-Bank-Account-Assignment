public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double monthlyFee;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit, double monthlyFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: Amount must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.printf("Withdrawal rejected for Current Account %s: Transaction of $%.2f exceeds overdraft limit of $%.2f. Current Balance: $%.2f%n",
                    accountNumber, amount, overdraftLimit, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrew $%.2f from Current Account %s. New Balance: $%.2f%n", amount, accountNumber, balance);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;
        System.out.printf("End of Month [Current %s]: Deducted maintenance fee of $%.2f. New Balance: $%.2f%n",
                accountNumber, monthlyFee, balance);
    }
}