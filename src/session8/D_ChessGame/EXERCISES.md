# Session 8 — Exercises 1, 2 and 3, the game

The game is the one from session 7. Each exercise is its numbered steps. The tips are there if
you need them.

## Exercise 1 — testing how a piece moves

1. In `test/session8/D_ChessGame/ChessPieceTest.java`, write three more tests of
   `ChessPiece.isLegalMove` for a white rook on (4, 4).
   - It may not move diagonally, to (6, 6).
   - It may not jump over a black knight on (4, 2) to reach (4, 0).
   - It may not move onto a white knight on (4, 2).

   You are done when the four tests of `ChessPieceTest` are green.

### Discussion

1. None of these tests calls `ChessGame.play`. Why would a test of `play` be hard to write?

## Exercise 2 — testing the board

1. Write `ChessBoardTest.java` in `test/session8/D_ChessGame`, with three tests of `ChessBoard`.
   - `ChessBoard.placePiece` answers false for a square that is taken, and the first piece stays.
   - After `ChessBoard.movePiece`, the square the piece left is empty.
   - After a capture, the square holds the piece that captured.

   You are done when the three tests of `ChessBoardTest` are green.

### Tips

- `assertNull` checks that `ChessBoard.getPieceAt` answers null for an empty square.

### Discussion

1. `ChessBoard.print` has no test. What would it have to do differently for a test to check it?

## Exercise 3 — a centaur, test first

The centaur moves like a king or like a knight. Write it using test-driven development, as in
exercise C. In each step, first write the test and run it to see it fail. Then write just enough
code to make it pass. The centaur does not need to be added to the game.

1. Write `CentaurTest.java` in `test/session8/D_ChessGame`, with the test
   `centaurMovesOneSquareAlongARow`. A white centaur on (4, 4) of an empty board may move to (4, 5)
   and not to (4, 6). Then write `Centaur.java` in `src/session8/D_ChessGame`. It is a piece with
   one rule, drawn with the letter C.
2. Write the test `centaurMovesOneSquareDiagonally`. The centaur on (4, 4) may move to (5, 5)
   and not to (6, 6). Then add the rule that makes it pass.
3. Write the test `centaurJumpsLikeAKnight`. The centaur on (4, 4) may move to (6, 5). Then add
   the rule that makes it pass.

   You are done when the three tests of `CentaurTest` pass, and each rule of `Centaur` was added
   after the test that asks for it.

### Tips

- Between them, `King.java` and `Knight.java` have every rule the centaur needs.
- If the compiler says that `StraightLine` cannot be converted to `MoveRule`, the import names the
  `rules` of another session. Import them from `session8.D_ChessGame.rules`, as `Knight` does.

### Discussion

1. Step 1 checks that the centaur may not move to (4, 6). Which mistake does that check catch?
