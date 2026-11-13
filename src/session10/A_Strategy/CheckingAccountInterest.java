package session10.A_Strategy;

/** The interest of a checking account, which is almost nothing. */
public class CheckingAccountInterest implements InterestStrategy {

    @Override
    public double getInterest(double balance) {
        return balance * 0.000001;
    }
}
