package session10.solution.A_Strategy;

/**
 * How much interest an account earns on its balance. BankAccount.accrueInterest
 * asks its InterestStrategy, and does not know which one it holds.
 */
public interface InterestStrategy {

    double calculateInterest(double balance);
}
