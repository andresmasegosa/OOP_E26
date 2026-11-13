package session10.A_Strategy;

/**
 * Two accounts of the same class, each with its own InterestStrategy. They
 * start with the same balance and earn a different interest.
 */
public class Demo {

    public static void main(String[] args) {
        BankAccount savings = new BankAccount(1000, new SavingsAccountInterest());
        BankAccount checking = new BankAccount(1000, new CheckingAccountInterest());

        savings.accrueInterest();
        checking.accrueInterest();

        System.out.println("Savings: " + savings.getBalance());
        System.out.println("Checking: " + checking.getBalance());

        // --- EXERCISE A --------------------------------------------------
        // See EXERCISES.md. Apply the fee to both accounts here, and print
        // the two balances again.
    }
}
