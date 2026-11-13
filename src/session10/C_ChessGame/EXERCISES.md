# Session 10 — Exercises 1 and 2, the game

The game is the one from session 9. Its eleven tests are in `test/session10/C_ChessGame`, and
they stay green after each exercise. Each exercise is its numbered steps. The tips are there if
you need them.

## Exercise 1 — the win rule as a strategy

1. In the `rules` folder, write `WinRule.java`, an interface with two methods.
   `WinRule.wins(ChessPiece piece, ChessPiece captured)` answers whether the move that `piece` has
   just made wins the game. `captured` is the piece it took, or null when it took nothing.
   `WinRule.reason()` answers the words that `ChessGame.play` prints between `wins: ` and the full
   stop.
2. In `rules`, write `KingCapture.java`, a `WinRule` that wins when the captured piece is a king,
   with the reason `the other king is off the board`. Give `ChessGame` a `WinRule` in its
   constructor, after the two players. After each move, `ChessGame.movePiece` asks it whether the
   move wins. `ChessGame.play` prints its reason. In `Demo`, the game gets a `new KingCapture()`.
3. In `test/session10/C_ChessGame/rules`, write `KingCaptureTest` with the test
   `winsOnlyWhenAKingIsCaptured`. A white rook that captures a black king wins. One that captures a
   black knight does not, and neither does one that captures nothing.
4. In `rules`, write `FirstCapture.java`, a `WinRule` in which the first capture wins, with the
   reason `it made the first capture`. Run `Demo` once with a `new FirstCapture()`, and then put
   `new KingCapture()` back.

   You are done when the twelve tests are green, the run with `FirstCapture` ended after the
   first capture with a line such as `WHITE wins: it made the first capture.`, and `Demo` again
   prints a line such as `WHITE wins: the other king is off the board.`

### Tips

- `InterestStrategy` in `A_Strategy` is the model. `ChessGame` holds its `WinRule` as `BankAccount`
  holds its `InterestStrategy`.
- `test/session10/C_ChessGame/rules` does not exist yet. In IntelliJ, right-click
  `test/session10/C_ChessGame` and choose New, then Package, so that the test is in the package of
  `KingCapture`, `session10.C_ChessGame.rules`.
- A test of `KingCapture` needs no board and no game. Make the pieces with `new`, as
  `ChessPieceTest` does.

### Discussion

1. Before this exercise, the game already had two strategies. Which are they, and which class hands
   its work to each?

## Exercise 2 — the moves as events

1. In a new folder `listeners`, write `GameListener.java`, an interface with one method,
   `void moveMade(ChessPiece piece, Move move, ChessPiece captured)`. `captured` is the piece the
   move took, or null.
2. Give `ChessGame` a list of listeners and a method `ChessGame.addListener`. After each move,
   `ChessGame.movePiece` calls `GameListener.moveMade` on every listener, instead of printing the
   move itself.
3. In `listeners`, write `MovePrinter.java`, a `GameListener` that prints the two kinds of line
   that `ChessGame.movePiece` printed, one for a move and one for a capture. In `Demo`, add a
   `MovePrinter` to the game.
4. In `listeners`, write `MoveCounter.java`, a `GameListener` that counts the moves and answers the
   count with `MoveCounter.getMoves`. In `Demo`, add one to the game, and after `ChessGame.play`
   print `The game took 3 moves.` with its count.

   You are done when `Demo` prints every move as before, then the winner and the captured pieces,
   then a line such as `The game took 3 moves.`, `ChessGame.movePiece` prints no move itself, and
   the twelve tests are green.

### Tips

- `B_Observer` is the model. `ChessGame` keeps its listeners as `BankAccount` does.
- The two `System.out.println` calls of `ChessGame.movePiece` that print a move and a capture can
  move into `MovePrinter.moveMade`. There the piece taken is `captured`, and its square is
  `move.getToRow()` and `move.getToCol()`.
- A `ChessPiece` prints as its colour and its type, and a `Move` prints as `(7,3) -> (4,3)`.
- `Demo` keeps the `MoveCounter` in a variable, to ask it for the count after the game.

### Discussion

1. Before this exercise, which class would you have changed to count the moves? Which class did you
   change in step 4?
