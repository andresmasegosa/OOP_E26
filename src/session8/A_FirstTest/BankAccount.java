package session8.A_FirstTest;

/**
 * A bank account with a balance in whole kroner. A withdrawal may take the
 * balance below zero, and then the account is overdrawn.
 */
public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }
}
