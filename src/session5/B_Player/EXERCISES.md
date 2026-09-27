# Session 5 — Exercise B, a player that looks for captures

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` line by line, and before you run it, write down what you expect it to print.
   The three moves change on every run, so predict what will be true of every one of them.
2. Write `players/CapturePlayer.java`, a player that plays like `RandomPlayer` but takes an enemy
   piece whenever it finds one to take.
   - It extends `RandomPlayer`.
   - `CapturePlayer.chooseMove` asks `RandomPlayer` for a move, up to 100 times, and answers with
     the first one whose target square holds an enemy piece. If none of them does, it answers
     with the last move it got. If `RandomPlayer` answers `null`, so does it.
   - In `Demo.main`, `white` becomes a `CapturePlayer` instead of a `RandomPlayer`.

   You are done when every move the demo prints ends on `(4,0)`, the square of the black rook.
   Keep the class, because exercise 2 builds on it.

## Tips

- `super.chooseMove(board, color)` is `RandomPlayer`'s answer. (Chapter 7, "Using super to Access
  Superclass Members".)
- `super.chooseMove` can answer `null`. Check that before you look at the target.
- The target of a move is at `Move.getToRow()` and `Move.getToCol()`, and `ChessBoard.getPieceAt`
  tells you what stands there. It is never one of your own pieces, because
  `ChessPiece.isLegalMove` refuses that.
- `Demo` needs an `import` line for your class, next to the one for `RandomPlayer`.

## Discussion

1. `CapturePlayer` never says `implements Player`, and `Demo.main` still keeps it in a `Player`
   variable. Say why that compiles.
