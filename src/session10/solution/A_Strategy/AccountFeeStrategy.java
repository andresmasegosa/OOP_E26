package session10.solution.A_Strategy;

/**
 * Exercise A. The yearly fee of an account. BankAccount.applyFee asks its
 * AccountFeeStrategy, as BankAccount.accrueInterest asks its InterestStrategy.
 */
public interface AccountFeeStrategy {

    double calculateFee(double balance);
}
