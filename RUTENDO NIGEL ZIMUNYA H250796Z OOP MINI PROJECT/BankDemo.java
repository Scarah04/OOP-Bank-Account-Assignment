import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA-101", 500.00, 100.00, 0.05));
        accounts.add(new CurrentAccount("CA-201", 200.00, 300.00, 15.00));

        System.out.println("=== INITIAL STATEMENTS ===");
        for (Account acc : accounts) {
            System.out.printf("Account: %s | Balance: $%.2f%n", acc.getAccountNumber(), acc.getBalance());
        }

        System.out.println("\n=== DEMONSTRATING WITHDRAWAL EDGE CASES ===");
        System.out.println("-- Attempting withdrawal on Savings Account --");
        accounts.get(0).withdraw(450.00); 

        System.out.println("\n-- Attempting withdrawal on Current Account --");
        accounts.get(1).withdraw(350.00); 

        System.out.println("\n=== POLYMORPHIC LOOP: WITHDRAWALS & END OF MONTH ===");
        for (Account acc : accounts) {
            System.out.println("\nProcessing Account: " + acc.getAccountNumber());
            acc.withdraw(20.00);
            
            acc.endOfMonth();
        }
    }
}