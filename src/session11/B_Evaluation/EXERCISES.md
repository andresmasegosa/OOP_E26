# Session 11 — Exercise B, the value of an expression

The code in this folder is that of `A_Visitor`, with the symbol `-` that exercise A adds. The
exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print and the value
   of each of the two expressions.
2. Write `EvaluateVisitor.java`, a `NodeVisitor` that works out the value of an expression from
   left to right, with a method `EvaluateVisitor.getResult` that returns the value. At the end of
   `Demo.main`, print each of the two expressions again, followed by its value.

   You are done when the last two lines `Demo` prints are `3 + 2 - 1 + 5 = 9` and
   `10 - 4 - 3 = 3`.

## Tips

- `EvaluateVisitor` needs a field that says whether the next number is added or subtracted.
  `EvaluateVisitor.visitSum` and `EvaluateVisitor.visitSubtraction` set it, and
  `EvaluateVisitor.visitInteger` uses it.
- Use a new `EvaluateVisitor` for each expression.

## Discussion

1. `EvaluateVisitor.visitInteger` calls `node.getValue()` without a cast. Why does it not need one?
