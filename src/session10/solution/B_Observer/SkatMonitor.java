package session10.solution.B_Observer;

/**
 * Exercise B. A listener that warns the tax authority, SKAT, about a single
 * deposit of more than 1 000 000 kr. It finds the deposit from the two
 * balances, as BankStatistics does.
 */
public class SkatMonitor implements AccountListener {

    @Override
    public void balanceChanged(double oldBalance, double newBalance) {
        double deposit = newBalance - oldBalance;
        if (deposit > 1_000_000) {
            System.out.println("SKAT alert: a deposit of " + deposit + " kr.");
        }
    }
}
