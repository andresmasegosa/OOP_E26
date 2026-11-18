# Session 11 — Exercises 1 and 2, the game

This is the chess game from session 10. In `Demo`, both players are a `GreedyPlayer`, as before.
The twelve tests in `test/session11/C_ChessGame` should still pass after each exercise. The tips
are there if you need them.

## Exercise 1 — the moves of a piece

`RandomPlayer` does not know which moves its pieces have. It picks squares at random and checks
them with `ChessPiece.isLegalMove`, and after 500 tries it returns `null`. Then the game ends with
`Thanks for playing!` and no winner, which happens in about one game in eight. `GreedyPlayer` uses
`RandomPlayer` when it finds no capture, so it has the same problem. In this exercise you write a
visitor that finds the moves that the rules of a piece allow.

- In the `rules` folder, create an interface `RuleVisitor` with one visit method for each kind of
  rule, `visitStraightLine`, `visitDiagonal` and `visitLeap`. Give `MoveRule` a method `accept`,
  write it in `StraightLine`, `Diagonal` and `Leap`, and give these three classes getters for their
  distances.
- Give `ChessPiece` a method `ChessPiece.acceptRules` that passes a visitor to each of its rules.
- `MoveFinder` is in the `rules` folder, and its method `MoveFinder.addSquare` is written for you.
  Make `MoveFinder` a `RuleVisitor`, and write its three visit methods, so that it finds every move
  that the rules of a piece allow.
- Change `RandomPlayer.chooseMove` so that it collects the moves of all its pieces with a
  `MoveFinder` and picks one of them at random. It returns `null` only when there is no move.
- In `test/session11/C_ChessGame/rules`, write a test class `MoveFinderTest` with two tests.
  `knightInTheCornerHasTwoMoves` checks a knight on (0,0) of an empty board.
  `rookStopsAtThePiecesInItsWay` checks a rook on (4,4) with a piece of its own on (4,6) and an
  enemy piece on (1,4), which has 11 moves.

You are done when the fourteen tests pass and every game of `Demo` ends with a winner.

### Tips

- `MoveFinder.addSquare` returns `false` when the line has to stop. `StraightLine.allows` goes
  along a line square by square in the same way, but between two squares it already knows.
- A `Leap` does not go along a line. It tries its eight jumps.

### Discussion

1. `MoveFinder` could also be a method `findMoves` in `MoveRule`, written in each rule. What would
   each choice cost when the game needs one more operation on the rules, and when it needs one
   more kind of rule?

## Exercise 2 — check

In chess, a player who can take the other king on the next move says check. In this exercise the
game says it for them.

- In the `listeners` folder, write a `GameListener` called `CheckAnnouncer`. After each move, it
  uses a `MoveFinder` on every piece of the player who moved, and prints `Check!` when one of them
  can take the other king.
- In `Demo`, add a `CheckAnnouncer` to the game.

You are done when `Demo` prints `Check!` during the game and the fourteen tests still pass.

### Tips

- `CheckAnnouncer` needs the board. Pass it in the constructor, with `ChessGame.getBoard`.
- For each move that `MoveFinder` finds, `ChessBoard.getPieceAt` gives the piece on its target
  square, if any. Compare its type with `PieceType.KING`.

### Discussion

1. `CheckAnnouncer` uses the pattern of session 10 and the pattern of today. Which one makes it run
   after each move, and which one finds the moves it checks?
