package session9.B_CustomExceptions;

/**
 * Thrown by BankAccount.withdraw when the balance is too small. An exception
 * is an object, so it can hold data. This one holds the deficit, how much
 * the account is short.
 */
public class InsufficientFundsException extends RuntimeException {

    private int deficit;

    public InsufficientFundsException(int deficit) {
        this.deficit = deficit;
    }

    public int getDeficit() {
        return deficit;
    }
}
