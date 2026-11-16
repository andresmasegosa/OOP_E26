package session10.A_Strategy;

/** The interest of a savings account, 5 % of the balance. */
public class SavingsAccountInterest implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        return balance * 0.05;
    }
}
