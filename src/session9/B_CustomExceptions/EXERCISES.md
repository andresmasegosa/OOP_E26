# Session 9 — Exercise B, an exception of your own

The exercise is the three numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Write `LargeDepositException.java`, an exception that extends `RuntimeException`. It holds an
   amount and answers it with `LargeDepositException.getAmount`. `BankAccount.deposit` throws it
   for an amount over 100 000, and then the balance does not change. At the end of `Demo.main`,
   deposit 250 000 inside a `try`, and print `You must justify the origin of 250000 kr.` in its
   `catch`.
3. In `test/session9/B_CustomExceptions/BankAccountTest.java`, write the test `largeDeposit`. It
   checks with `assertThrows` that a deposit of 250 000 throws a `LargeDepositException` that
   holds 250 000, and that the balance is still 100.

   You are done when `Demo` prints that line, and the four tests of `BankAccountTest` are green.

## Tips

- `InsufficientFundsException` holds the deficit in the same way.
- `BankAccountTest.withdrawTooMuch` keeps the exception that `assertThrows` answers, and asks it
  for the deficit.

## Discussion

1. Why does `Demo` have a `catch` block for each exception, and not a single
   `catch (RuntimeException e)`? (Chapter 9, "Catching Subclass Exceptions".)
