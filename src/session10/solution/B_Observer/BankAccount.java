package session10.solution.B_Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * A bank account that tells its listeners about every deposit. It keeps them
 * in a list, and BankAccount.addListener adds one. It does not know what its
 * listeners do with the news.
 */
public class BankAccount {

    private double balance;
    private List<AccountListener> listeners = new ArrayList<>();

    public void addListener(AccountListener listener) {
        listeners.add(listener);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        double oldBalance = this.balance;
        this.balance = this.balance + amount;
        for (AccountListener listener : this.listeners) {
            listener.balanceChanged(oldBalance, this.balance);
        }
    }
}
