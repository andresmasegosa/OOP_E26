# Session 8 — Exercise A, a first test

The exercise is the three numbered steps. The tips are there if you need them.

1. Read `test/session8/A_FirstTest/BankAccountTest.java` and, before you run it, write down which
   of its three tests pass.
2. In `BankAccountTest`, write the test `withdraw01`. It opens an account with 100, withdraws 25
   and checks with `assertEquals` that `BankAccount.getBalance` answers 75.

   You are done when the four tests of `BankAccountTest` are green.
3. Change 75 to 76 in `withdraw01`, run the tests again and read the message of the red test.
   Then put 75 back.

## Tips

- To run the tests, click the green arrow next to `public class BankAccountTest`.
- `assertEquals` takes the value you expect first and the value you got second.

## Discussion

1. `BankAccountTest` has no `main` method. Who calls `BankAccountTest.isOverdrawn01`?
