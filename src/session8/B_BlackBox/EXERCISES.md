# Session 8 — Exercise B, testing a method from its Javadoc

The exercise is the three numbered steps. The tips are there if you need them.

1. Read `test/session8/B_BlackBox/BankAccountTest.java` and, before you run it, write down the
   balance of `account` when `BankAccountTest.isOverdrawn02` starts.
2. Read the Javadoc of `BankAccount.deposit`, and not its body. In `BankAccountTest`, write two
   tests of `deposit`, each with a different amount, that check what the Javadoc promises.

   You are done when at least one of your tests is red.
3. Now read the body of `BankAccount.deposit`, fix the mistake and run the tests again.

   You are done when every test of `BankAccountTest` is green.

## Tips

- Each test starts from the account that `BankAccountTest.setUp` builds, with 100.

## Discussion

1. Which test of `deposit` would have passed even with the mistake in it?
