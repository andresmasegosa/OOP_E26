package session10.solution.A_Strategy;

/**
 * A bank account that holds its interest as a strategy. It gets an
 * InterestStrategy in its constructor, and BankAccount.accrueInterest hands
 * the calculation to it, so the same class serves every kind of account.
 * Exercise A. It holds its fee as a strategy too.
 */
public class BankAccount {

    private double balance;
    private InterestStrategy interestStrategy;
    private AccountFeeStrategy feeStrategy;                 // exercise A

    public BankAccount(double balance, InterestStrategy interestStrategy,
                       AccountFeeStrategy feeStrategy) {    // exercise A
        this.balance = balance;
        this.interestStrategy = interestStrategy;
        this.feeStrategy = feeStrategy;                     // exercise A
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
    }

    public void accrueInterest() {
        this.balance = this.balance + interestStrategy.calculateInterest(this.balance);
    }

    public void applyFee() {                                // exercise A
        this.balance = this.balance - feeStrategy.calculateFee(this.balance);
    }
}
