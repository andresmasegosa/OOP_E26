package session10.A_Strategy;

/** The interest of a savings account, 5 % of the balance. */
public class SavingsAccountInterest implements InterestStrategy {

    @Override
    public double getInterest(double balance) {
        return balance * 0.05;
    }
}
