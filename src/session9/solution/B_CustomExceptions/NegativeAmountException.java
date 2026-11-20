package session9.solution.B_CustomExceptions;

/**
 * Thrown by BankAccount.withdraw for an amount of zero or less.
 */
public class NegativeAmountException extends RuntimeException {

    public NegativeAmountException() {
    }
}
