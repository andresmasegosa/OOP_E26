package session10.solution.A_Strategy;

/**
 * Two accounts of the same class, each with its own InterestStrategy. They
 * start with the same balance and earn a different interest. Exercise A. Each
 * holds an AccountFeeStrategy too, and pays its fee at the end.
 */
public class Demo {

    public static void main(String[] args) {
        BankAccount savings = new BankAccount(1000, new SavingsAccountInterest(),
                new SavingsAccountFee());                       // exercise A
        BankAccount checking = new BankAccount(1000, new CheckingAccountInterest(),
                new CheckingAccountFee());                      // exercise A

        savings.accrueInterest();
        checking.accrueInterest();

        System.out.println("Savings: " + savings.getBalance());
        System.out.println("Checking: " + checking.getBalance());

        // --- EXERCISE A, solved --------------------------------------------
        savings.applyFee();
        checking.applyFee();

        System.out.println("Savings: " + savings.getBalance());
        System.out.println("Checking: " + checking.getBalance());
    }
}
