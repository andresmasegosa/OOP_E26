# Session 11 — Exercise A, a visitor of your own

The exercise is the three numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Write `CountIntegersVisitor.java`, a `NodeVisitor` that counts the numbers in an expression,
   with a method `CountIntegersVisitor.getIntegers` that returns the count. At the end of
   `Demo.main`, use it on the same expression and print `Integers: 3`.
3. Write `SubtractionNode.java` for the symbol `-`, and change the constructor of
   `MathExpression` so that it reads a `-`. Then add a method `visitSubtraction` to `NodeVisitor`.
   `CountOperationsVisitor` counts the subtractions apart from the sums, and returns them from a
   method `CountOperationsVisitor.getSubtractions`. At the end of `Demo.main`, make a
   `MathExpression` for `3 + 2 - 1 + 5 =`, and print the two counts of `CountOperationsVisitor`
   and then the count of `CountIntegersVisitor`.

   You are done when the last three lines `Demo` prints are `Sum operations: 2`,
   `Subtraction operations: 1` and `Integers: 4`.

## Tips

- `SumNode` is the model for `SubtractionNode`.
- When you add `visitSubtraction` to `NodeVisitor`, the compiler marks every class that
  implements `NodeVisitor`. Those are the classes you still have to change.

## Discussion

1. `CountIntegersVisitor` did not change any node class, and `SubtractionNode` changed
   `NodeVisitor` and every visitor. In a calculator, which of the two kinds of change would you
   expect more often?
