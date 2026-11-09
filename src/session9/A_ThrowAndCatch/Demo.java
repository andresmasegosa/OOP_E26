package session9.A_ThrowAndCatch;

/**
 * Step A. BankAccount.withdraw throws an IllegalArgumentException when it
 * refuses an amount. A throw stops the method at once, and the program goes
 * on in the catch block that handles the exception.
 */
public class Demo {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        System.out.println("Balance: " + account.getBalance());

        try {
            account.withdraw(30);
            System.out.println("Withdrew 30");
            account.withdraw(500);
            System.out.println("Withdrew 500");
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        System.out.println("Balance: " + account.getBalance());

        // --- EXERCISE A --------------------------------------------------
        // Deposit -50 here, inside a try. See EXERCISES.md.
    }
}
