package session10.solution.A_Strategy;

/** Exercise A. The fee of a checking account, a fixed 200 kr a year. */
public class CheckingAccountFee implements AccountFeeStrategy {

    @Override
    public double calculateFee(double balance) {
        return 200;
    }
}
