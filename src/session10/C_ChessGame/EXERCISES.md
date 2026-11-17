# Session 10 — Exercises 1 and 2, the game

This is the chess game from session 9. In `Demo`, both players are now a `GreedyPlayer`, so both
of them capture pieces. The eleven tests in `test/session10/C_ChessGame` should still pass after
each exercise. The tips are there if you need them.

## Exercise 1 — `MoveRule` as a strategy

Since session 5, every piece has a list of `MoveRule` objects, and `ChessPiece.isLegalMove` checks
whether one of these rules allows the move. This is the Strategy pattern, although we did not call
it that in session 5. In this exercise you look at this code as an example of the pattern, and then
you extend it with a new kind of move.

### Part 1 — the pattern in the existing code

- Read `ChessPiece.java` and the classes in the `rules` folder. Write down the role that each of
  them has in the Strategy pattern. Slide 12 shows these roles for `A_Strategy`.
- Compare the game's code with `BankAccount` and `InterestStrategy` in `A_Strategy`, and write
  down the differences.

You do not need to write any code in this part.

### Part 2 — a new move rule

`StraightLine` and `Diagonal` have the distance as a parameter, so the same class can be used by
different pieces. The rook uses `new StraightLine(7)` and the king uses `new StraightLine(1)`.
`LShape` has no parameter. It only checks the knight's jump, two squares in one direction and one
square in the other. Some chess variants have pieces that jump in the same way, but with other
distances. The camel, for example, moves three squares in one direction and one in the other.

- Replace `LShape` with a new rule `Leap` that works for any jump of this kind. Use it for the
  knight and for the centaur.
- In `test/session10/C_ChessGame/rules`, write a test class `LeapTest` with a test
  `camelLeapsThreeAndOne` that checks the camel's move on an empty board.

You are done when `LShape.java` is deleted, `ChessPiece.java` has not changed, the twelve tests
pass and `Demo` still plays a game to the end.

### Tips

- `StraightLine` is an example of a rule with a parameter.
- `CentaurTest.centaurJumpsLikeAKnight` tests only one of the knight's jumps, two rows and one
  column. A jump of one row and two columns is also a knight's jump.

### Discussion

1. `BankAccount` gets its strategy from outside, in its constructor. A piece gets its rules from
   its own subclass, through `ChessPiece.addRule`. What are the advantages and disadvantages of
   each way?

## Exercise 2 — game statistics with listeners

At the moment, `ChessGame` prints each move, but no other class is told about the moves. In this
exercise you use the Observer pattern to change this, and you write two listeners that keep
statistics about the game.

- Create a folder `listeners` with an interface `GameListener`. Then change `ChessGame` so that it
  notifies its listeners after each move.
- Write a listener `CaptureCounter` that counts how many pieces each player has captured. At the
  end of the game, `Demo` prints the two numbers, for example `Captures: WHITE 6, BLACK 8`.
- Write a listener `Scoreboard` that keeps a score for each player. When a player captures a
  piece, the player gets as many points as the piece is worth (`PieceType.getValue`). Capturing
  the king ends the game, so the king gives no points. After each capture, except the capture of
  the king, `Scoreboard` prints the score, for example `Score: WHITE 9, BLACK 0`.

You are done when `Demo` prints the score lines during the game and the `Captures:` line at the
end. The two numbers in the `Captures:` line add up to the number of pieces in the `Captured:`
line, and the twelve tests still pass.

### Tips

- Use `B_Observer` as an example.
- Both listeners need to know which piece moved and which piece was captured, if any.

### Discussion

1. Which classes did you change to add `Scoreboard`? Which classes would you change to add a third
   statistic, for example the longest series of moves without a capture?
