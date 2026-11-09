package session9.A_ThrowAndCatch;

/**
 * A bank account with a balance in whole kroner. BankAccount.withdraw refuses
 * an amount it cannot take by throwing an IllegalArgumentException, with a
 * message that says why.
 */
public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            String msg = "Amount must be positive.";
            throw new IllegalArgumentException(msg);
        }
        if (amount > balance) {
            String msg = "Amount must not exceed balance.";
            throw new IllegalArgumentException(msg);
        }
        balance = balance - amount;
    }

    public void deposit(int amount) {
        balance = balance + amount;
    }
}
