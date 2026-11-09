# Session 9 — Exercise A, throwing and catching an exception

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Make `BankAccount.deposit` refuse a negative amount. It throws an `IllegalArgumentException`
   with the message `Cannot deposit a negative amount.` Then, at the end of `Demo.main`, deposit
   -50 inside a `try`, print the message in its `catch` as the first `catch` does, and print the
   balance again.

   You are done when the last two lines `Demo` prints are
   `Something went wrong: Cannot deposit a negative amount.` and `Balance: 70`.

## Tips

- `e.getMessage()` answers the message the exception was made with.
- A deposit of 0 is not negative, so `BankAccount.deposit` takes it.

## Discussion

1. `BankAccount.withdraw` could print its message and return, instead of throwing. What would
   `Demo` print then for the withdrawal of 500?
