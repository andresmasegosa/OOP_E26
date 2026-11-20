package session9.solution.B_CustomExceptions;

/**
 * Exercise B. Thrown by BankAccount.deposit for an amount over 100 000. It
 * holds the amount, as InsufficientFundsException holds the deficit.
 */
public class LargeDepositException extends RuntimeException {

    private int amount;

    public LargeDepositException(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
