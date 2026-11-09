# Session 9 — Exercises 1, 2 and 3, the game

The game is the one from session 8, with the centaur. Its ten tests are in
`test/session9/D_ChessGame`, and they stay green after each exercise. Each exercise is its
numbered steps. The tips are there if you need them.

## Exercise 1 — the colour as an enum

1. Write `Color.java`, an enum with the values `WHITE` and `BLACK`. Use it for the colour of a
   piece instead of a `String`, so that a white rook is `new Rook(Color.WHITE)`. The pieces,
   `Player.chooseMove` and the four players, `ChessGame` and the tests change with it.

   You are done when the ten tests are green and `Demo` prints a line such as
   `WHITE wins: the other king is off the board.`

### Tips

- Change the constructor of `ChessPiece`, `ChessPiece.isWhite` and `Player.chooseMove` first.
  IntelliJ then marks in red each line that still passes a `String`.
- In the `players` folder, import `Color` from `session9.D_ChessGame`, not `java.awt.Color`.

### Discussion

1. In session 8, `new Rook("white")` made a black rook. What happens to that line now?

## Exercise 2 — the type as an enum

1. Write `PieceType.java`, an enum with the values `KING`, `QUEEN`, `ROOK`, `BISHOP`, `KNIGHT` and
   `CENTAUR`. Each value holds the number that `GreedyPlayer.valueOf` gives that type today, as
   each `Planet` holds its position.
2. Use it for the type of a piece instead of a `String`, so that `ChessPiece.getType` answers a
   `PieceType`. `ChessGame` looks for the king with `PieceType.KING`, and `GreedyPlayer` asks the
   type for its number. `GreedyPlayer.valueOf` goes away.

   You are done when the ten tests are green and `Demo` still prints the winner.

### Discussion

1. Before this exercise, what was a new kind of piece worth to `GreedyPlayer` if nobody changed
   `GreedyPlayer.valueOf`? Can that happen now?

## Exercise 3 — an illegal move as an exception

1. Write `IllegalMoveException.java`, an exception that extends `RuntimeException`. Its
   constructor takes a message and passes it on with `super(message)`.
2. Make `ChessBoard.movePiece` throw it wherever it now answers false, with a message that says
   why. `ChessBoard.movePiece` then answers nothing, so it is `void`. `ChessGame.movePiece`
   catches the exception, prints `Illegal move: ` followed by its message, and answers false, as
   before.
3. In `ChessBoardTest`, write the test `movePieceRefusesAnIllegalMove`. A white rook on (4, 4)
   of an empty board may not move to (6, 6). The test checks with `assertThrows` that
   `ChessBoard.movePiece` throws an `IllegalMoveException`, and that `ChessBoard.getPieceAt(4, 4)`
   still answers the rook.

   You are done when the eleven tests are green and `Demo` still prints the winner.

### Tips

- `Demo` never tries an illegal move. To see your message, put `new KeyboardPlayer()` for White
  in `Demo` and type `7 0 7 1`. Then put `new GreedyPlayer()` back.

### Discussion

1. `RandomPlayer` asks `ChessPiece.isLegalMove` about many squares before it finds a move. Why
   does `ChessPiece.isLegalMove` still answer false for an illegal move, and not throw an
   `IllegalMoveException`?
