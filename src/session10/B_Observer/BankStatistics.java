package session10.B_Observer;

/**
 * A listener that adds up the money in every account it listens to. It finds
 * each deposit from the two balances that BankAccount.deposit passes on.
 */
public class BankStatistics implements AccountListener {

    private double totalBankBalance;

    public BankStatistics() {
        this.totalBankBalance = 0;
    }

    @Override
    public void balanceChanged(double oldBalance, double newBalance) {
        double difference = newBalance - oldBalance;
        totalBankBalance += difference;
    }

    public double getTotalBankBalance() {
        return totalBankBalance;
    }
}
