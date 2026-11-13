package session10.B_Observer;

/**
 * Something that wants to hear about the deposits on a BankAccount.
 * BankAccount.deposit calls AccountListener.notify on each of its listeners,
 * with the balance after the deposit and the balance before it.
 */
public interface AccountListener {

    void notify(double newBalance, double oldBalance);
}
