package session10.solution.A_Strategy;

/** The interest of a checking account, which is almost nothing. */
public class CheckingAccountInterest implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        return balance * 0.000001;
    }
}
