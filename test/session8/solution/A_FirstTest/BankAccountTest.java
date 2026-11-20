package session8.solution.A_FirstTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Step A. A test is a method marked @Test. It builds an object, calls a method
 * on it and checks the answer with an assertion. JUnit runs every @Test method
 * on its own, and shows it green when it passes and red when it fails.
 */
public class BankAccountTest {

    @Test
    public void openAccount() {
        BankAccount account = new BankAccount(100);
        assertNotNull(account);
    }

    @Test
    public void isOverdrawn01() {
        BankAccount account = new BankAccount(100);
        account.withdraw(500_000);
        assertTrue(account.isOverdrawn());
    }

    @Test
    public void isOverdrawn02() {
        BankAccount account = new BankAccount(100);
        account.withdraw(25);
        assertFalse(account.isOverdrawn());
    }

    @Test
    public void withdraw01() {                       // exercise A
        BankAccount account = new BankAccount(100);
        account.withdraw(25);
        assertEquals(75, account.getBalance());
    }
}
