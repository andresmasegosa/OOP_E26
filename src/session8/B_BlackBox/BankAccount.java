package session8.B_BlackBox;

/**
 * The bank account of step A, with one more method, BankAccount.deposit.
 */
public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }

    /**
     * Adds amount to the balance. The amount is zero or more.
     */
    public void deposit(int amount) {
        this.balance = amount;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }
}
