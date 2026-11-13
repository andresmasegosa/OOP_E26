# Session 10 — Exercise B, a listener of your own

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Write `SkatMonitor.java`, an `AccountListener` that warns SKAT, the Danish tax authority,
   about a large deposit. When a single deposit is more than 1 000 000 kr,
   `SkatMonitor.notify` prints `SKAT alert: a deposit of 1500000.0 kr.`, with the amount of that
   deposit. At the end of `Demo.main`, make a third account with two listeners, the
   `BankStatistics` that `Demo.main` already has and a new `SkatMonitor`. Deposit 500 000, then
   1 500 000, then 50 000, and print the total bank balance again.

   You are done when the last two lines `Demo` prints are
   `SKAT alert: a deposit of 1500000.0 kr.` and `Total Bank Balance: 2054000.0`.

## Tips

- `AccountListener.notify` gets the two balances, not the deposit. `BankStatistics.notify` finds
  the deposit from them.
- `BankAccount` does not change. It already calls every listener it has.

## Discussion

1. `BankAccount.deposit` does not know that `SkatMonitor` exists. How would `BankAccount` look if
   it had to call `BankStatistics` and `SkatMonitor` itself? What would a third kind of listener
   cost then?
