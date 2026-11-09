package session9.B_CustomExceptions;

/**
 * Step B. A try can have one catch block for each kind of exception. Java
 * runs the first catch block whose class matches the exception thrown, and
 * then goes on after the last one.
 */
public class Demo {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        int[] amounts = {-10, 1000, 30};

        for (int amount : amounts) {
            try {
                account.withdraw(amount);
                System.out.println("Withdrew " + amount);
            } catch (NegativeAmountException e) {
                System.out.println("Amount cannot be negative!");
            } catch (InsufficientFundsException e) {
                System.out.println("You are short: " + e.getDeficit());
            }
        }

        System.out.println("Balance: " + account.getBalance());

        // --- EXERCISE B --------------------------------------------------
        // Deposit 250 000 here, inside a try. See EXERCISES.md.
    }
}
