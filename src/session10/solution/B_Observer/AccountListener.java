package session10.solution.B_Observer;

/**
 * Something that wants to hear about the deposits on a BankAccount.
 * BankAccount.deposit calls AccountListener.balanceChanged on each of its
 * listeners, with the balance before the deposit and the balance after it.
 */
public interface AccountListener {

    void balanceChanged(double oldBalance, double newBalance);
}
