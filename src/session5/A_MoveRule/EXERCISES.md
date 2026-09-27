# Session 5 — Exercise A, the knight's rule

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` line by line, and before you run it, write down what you expect it to print.
   Predict how many rules each piece holds, and whether each move it asks about is allowed.
2. Write the two classes this folder is missing, the knight's rule and the knight.
   - `rules/LShape.java` is a way of moving, so it implements `MoveRule`, like `StraightLine` and
     `Diagonal`. `LShape.allows` answers `true` when the move is the knight's L, two squares
     along one axis and one along the other, and `false` for any other move.
   - `Knight.java` is a piece, so it extends `ChessPiece`, like `Queen`, `Rook` and `Bishop`. Its
     type is `"Knight"`, it holds one `LShape`, and it is drawn with the letter `N`.

   You are done when both classes compile and a knight answers `true` for an L and `false` for
   any other move.

## Tips

- `LShape.java` needs the same `import` line for `ChessBoard` as `StraightLine.java`. If you start
  from an empty `public class LShape implements MoveRule { }` and compile, the error names the
  method you have to write. (Chapter 8, "Implementing Interfaces".)
- A knight jumps, so `LShape.allows` never looks at the board.
- `Knight` is a copy of `Bishop.java` with another name, the rule `LShape` and the letter `N`.
- To try it, place a white knight on `(7,1)` at the end of `Demo.main` and print what
  `ChessPiece.isLegalMove` answers for `(5,2)` and `(5,1)`. You should see `true` and then
  `false`. If you comment out the `addRule` line in `Knight`, it still compiles, and the knight
  never moves.

## Discussion

1. Session 3's `Movements` had three static methods. Say where each of them is now, by class name,
   and say in one sentence what a rule object has that a static method did not.
