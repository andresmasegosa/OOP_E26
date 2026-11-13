# Session 10 — Exercise A, a second strategy

The exercise is the three numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Write `AccountFeeStrategy.java`, an interface with the method
   `double calculateFee(double balance)`. Then write two classes that implement it.
   `SavingsAccountFee` answers a fee of 100 kr, and `CheckingAccountFee` a fee of 200 kr.
3. Give `BankAccount` an `AccountFeeStrategy` in its constructor, after the `InterestStrategy`,
   and a method `BankAccount.applyFee` that takes the fee from the balance. In `Demo.main`, the
   savings account gets a `SavingsAccountFee` and the checking account a `CheckingAccountFee`.
   At the end of `Demo.main`, apply the fee to both accounts and print the two balances again,
   as the first two lines are printed.

   You are done when the last two lines `Demo` prints are `Savings: 950.0` and
   `Checking: 800.001`.

## Tips

- `InterestStrategy` and `SavingsAccountInterest` are the model for the interface and its two
  classes. A fixed fee does not use the balance, and that is fine.
- `BankAccount.applyFee` asks its strategy, as `BankAccount.accrueInterest` does. It never asks
  which kind of account it is.

## Discussion

1. The bank adds a youth account, with 7 % interest. What do you have to change in `BankAccount`
   to add it?
