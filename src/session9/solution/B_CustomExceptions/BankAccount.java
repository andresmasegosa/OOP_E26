package session9.solution.B_CustomExceptions;

/**
 * A bank account with a balance in whole kroner. BankAccount.withdraw throws
 * an exception of its own for each reason to refuse an amount, so the caller
 * can catch each reason on its own.
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
            throw new NegativeAmountException();
        }
        if (amount > balance) {
            int deficit = amount - balance;
            throw new InsufficientFundsException(deficit);
        }
        balance = balance - amount;
    }

    public void deposit(int amount) {
        if (amount > 100_000) {                 // exercise B
            throw new LargeDepositException(amount);
        }
        balance = balance + amount;
    }
}
