package session8.B_BlackBox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Step B. The tests of step A, with the account built in one place.
 * JUnit calls a method marked @BeforeEach before every test, so
 * BankAccountTest.setUp gives each test an account of its own.
 */
public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(100);
    }

    @Test
    public void withdraw01() {
        account.withdraw(25);
        assertEquals(75, account.getBalance());
    }

    @Test
    public void isOverdrawn01() {
        account.withdraw(500_000);
        assertTrue(account.isOverdrawn());
    }

    @Test
    public void isOverdrawn02() {
        account.withdraw(25);
        assertFalse(account.isOverdrawn());
    }

    // --- EXERCISE B --------------------------------------------------
    // Write your tests of BankAccount.deposit here. See
    // src/session8/B_BlackBox/EXERCISES.md.
}
