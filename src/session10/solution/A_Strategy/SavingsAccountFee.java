package session10.solution.A_Strategy;

/** Exercise A. The fee of a savings account, a fixed 100 kr a year. */
public class SavingsAccountFee implements AccountFeeStrategy {

    @Override
    public double calculateFee(double balance) {
        return 100;
    }
}
