# Session 3 — Inheritance and abstract classes: a class for every piece

Last week the game was rebuilt on classes, and the rules of the pieces still lived in one
`switch`, the one in `ChessPiece.isLegalMove`, with a case for every type of piece and a
`default` that stayed silent when a piece was forgotten. You ended the session with a wish, that forgetting a type of
piece should be a compile-time error. This session grants it for the rule of
each piece.

The tools are called inheritance and abstract classes. The game is the same one, with the same
board and the same rules. What changes is that a king, a queen and a rook are now objects of
different classes. They share everything a piece has, and each one keeps its own rule.

## Before class

1. Read chapter 7 of *Java: A Beginner's Guide* (Herbert Schildt), the whole chapter. It is
   the chapter on inheritance. Its section on abstract classes, near the end, is used in
   this session too.

2. Bring your notes from sessions 1 and 2, and above all the two cost lines at the top of
   session 2's `Demo.main` and the wish you wrote at the end of session 2. Exercise 1 adds a
   third line.

3. Read the demo folders in order, `A_` to `C_`. Run each `Demo` and read the classes next to
   it. Each folder is one step of the story, and we walk the same path together in class. A
   question or two per step, to bring answered.

   - [`A_OneClassPerPiece`](A_OneClassPerPiece/): every piece has its own class and there is no
     `switch`. Why can the board not hold the pieces?
   - [`B_Inheritance`](B_Inheritance/): in which order do the constructor lines appear, and why
     in that order? And in the loop at the end of `Demo`, which class's `isLegalMove` runs on
     each square, and how does Java decide?
   - [`C_AbstractClasses`](C_AbstractClasses/): compare `ChessPiece.java` with the one in
     `B_Inheritance`. What changed?

4. Then read the game, [`E_ChessGame`](E_ChessGame/), starting with `ChessPiece`, then `King`,
   `Queen` and `Rook`, and last `ChessGame.setupPieces`. `ChessBoard` and `Movements` are
   session 2's, and you know them already. Run `Demo` and play. Two questions to bring.

   - Where is it decided whether a queen's move is legal, and how does your answer differ from
     last week's?
   - The bishops are missing from the board, on purpose. Before you read exercise 1, write
     down why you think they are.

Nothing needs to be fixed before class. If something confuses you, write the question down and
bring it.

## In class

- The wish from session 2, on the table.
- Live coding of the path `A_` to `C_`, and the game rebuilt in `E_ChessGame`.
- Exercises, in [EXERCISES.md](EXERCISES.md).

## Files

| Folder | What it shows |
|---|---|
| `A_OneClassPerPiece/` | a class per type of piece and no switch, and the board that cannot hold them |
| `B_Inheritance/` | `extends` and `super`, what a subclass inherits and what it does not, and overriding, where the board asks every piece the same question |
| `C_AbstractClasses/` | an abstract class and an abstract method, and the two compiler errors that make them useful |
| `E_ChessGame/` | the game, with `ChessPiece` abstract and a subclass each for the king, the queen and the rook; `Demo` starts it |

## Conventions used by the game

- The board, the coordinates and the rules are session 2's. Squares are `(row, col)` from `0`
  to `7`, row 0 is at the top, and the game is mini-chess with kings, queens, rooks and, once exercise 1 is done, bishops,
  and knights once exercise 2 adds them.
- `ChessPiece`'s fields are `private`, as in session 2, so `Queen.isLegalMove` reads the square
  through `ChessPiece.getRow` and `ChessPiece.getCol`. The demo folders `B_` and `C_` declare the
  same fields `protected`, so that their `Queen.isLegalMove` can read `row` and `col` directly.
  Both compile. The game keeps session 2's choice.
- A piece is an object of a subclass of `ChessPiece`, created by name, as in `new Queen("White")`.
  Each piece also answers with the letter it is drawn with, `ChessPiece.getLetter`. The only
  letters written anywhere else are the legend under the board, in `ChessBoard.print`.
- The scripted game in `Demo.main` is session 2's with one move changed and one added. Move 3
  sent a rook onto its own bishop, and there are no bishops yet, so here the black king goes onto
  its own queen, refused for the same reason. The seventh move sends a bishop straight up from
  `(7,2)`. It is refused today because the square is empty, and it stays refused once exercise 1
  is done, because no bishop moves that way.
