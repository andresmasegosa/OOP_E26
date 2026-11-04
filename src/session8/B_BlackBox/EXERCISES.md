# Session 8 — Exercise B, testing a method from its Javadoc

The exercise is the three numbered steps. The tips are there if you need them.

1. Read `test/session8/B_BlackBox/BankAccountTest.java` and, before you run it, write down the
   balance of `account` when `BankAccountTest.isOverdrawn02` starts.
2. This is the Javadoc of `BankAccount.deposit`, the comment above the method that says what it
   does:

   ```java
   /**
    * Adds amount to the balance. The amount is zero or more.
    */
   public void deposit(int amount)
   ```

   Do not open `BankAccount.java` yet. In `BankAccountTest`, write two tests of `deposit`, each
   with a different amount, that check what this Javadoc promises.

   You are done when at least one of your tests is red.
3. Now open `src/session8/B_BlackBox/BankAccount.java`, read the body of `BankAccount.deposit`,
   fix the mistake and run the tests again.

   You are done when every test of `BankAccountTest` is green.

## Tips

- Each test starts from the account that `BankAccountTest.setUp` builds, with 100.

## Discussion

1. Which test of `deposit` would have passed even with the mistake in it?
