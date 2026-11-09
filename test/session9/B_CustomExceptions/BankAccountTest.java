package session9.B_CustomExceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Step B. assertThrows runs the code written after () -> and checks that it
 * throws an exception of the class named first. It answers that exception,
 * so a test can ask it what it holds.
 */
public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(100);
    }

    @Test
    public void withdraw01() {
        account.withdraw(10);
        assertEquals(90, account.getBalance());
    }

    @Test
    public void withdrawNegativeAmount() {
        assertThrows(NegativeAmountException.class, () -> account.withdraw(-10));
        assertEquals(100, account.getBalance());
    }

    @Test
    public void withdrawTooMuch() {
        InsufficientFundsException e =
                assertThrows(InsufficientFundsException.class, () -> account.withdraw(1000));
        assertEquals(900, e.getDeficit());
        assertEquals(100, account.getBalance());
    }

    // --- EXERCISE B --------------------------------------------------
    // Write the test largeDeposit here. See src/session9/B_CustomExceptions/EXERCISES.md.
}
