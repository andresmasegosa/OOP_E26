# Session 3 — Inheritance and abstract classes: a class for every piece

Last week the game was rebuilt on classes, and one `switch` survived, the one in
`ChessPiece.isLegalMove`. It had a case for every type of piece and a `default` that stayed
silent when a piece was forgotten. You ended the session with a wish, that forgetting a type of
piece should be a compile-time error. This session grants it.

The tools are called inheritance and abstract classes. The game is the same one, with the same
board and the same rules. What changes is that a king, a queen and a rook are now objects of
different classes. They share everything a piece has, and each one keeps its own rule.

## Before class

1. Read chapter 7 of *Java: A Beginner's Guide* (Herbert Schildt), the whole chapter. It is
   the chapter on inheritance. Its last sections, on abstract classes and on `final`, are used in
   this session too.

2. Bring your notes from sessions 1 and 2, and above all the two cost lines at the top of
   session 2's `Demo.main` and the wish you wrote at the end of session 2. Exercise 1 adds a
   third line.

3. Read the demo folders in order, `A_` to `D_`. Run each `Demo` and read the classes next to
   it. Each folder is one step of the story, and we walk the same path together in class. One
   question per step, to bring answered.

   - [`A_OneClassPerPiece`](A_OneClassPerPiece/): every piece has its own class and there is no
     `switch`. Why can the board not hold the pieces?
   - [`B_Inheritance`](B_Inheritance/): in which order do the constructor lines appear, and why
     in that order?
   - [`C_Overriding`](C_Overriding/): the king never moves. What is wrong in `King.java`, and
     why did nothing warn you?
   - [`D_AbstractClasses`](D_AbstractClasses/): compare `ChessPiece.java` with the one in
     `C_Overriding`. What changed?

4. Then read the game, [`E_ChessGame`](E_ChessGame/), starting with `ChessPiece`, then `King`,
   `Queen` and `Rook`, and last `ChessGame.setupPieces`. `ChessBoard` and `Movements` are
   session 2's, and you know them already. Run `Demo` and play. Two questions to bring.

   - Where is it decided whether a queen's move is legal, and how does your answer differ from
     last week's?
   - The output of `Demo` has two things wrong with it, on purpose. Find them and write them
     down, and do not fix them. Exercises 1 and 2 are about them.

Nothing needs to be fixed before class. If something confuses you, write the question down and
bring it.

## In class

- The wish from session 2, on the table.
- Live coding of the path `A_` to `D_`, and the game rebuilt in `E_ChessGame`.
- Exercises, in [EXERCISES.md](EXERCISES.md).

## Files

| Folder | What it shows |
|---|---|
| `A_OneClassPerPiece/` | a class per type of piece and no switch, and the board that cannot hold them |
| `B_Inheritance/` | `extends` and `super`, and what a subclass inherits and what it does not |
| `C_Overriding/` | overriding and `@Override`, and the board asking every piece the same question |
| `D_AbstractClasses/` | an abstract class and an abstract method, and the two compiler errors that make them useful |
| `E_ChessGame/` | the game, with `ChessPiece` abstract and a subclass each for the king, the queen and the rook; `Demo` starts it |

## Conventions used by the game

- The board, the coordinates and the rules are session 2's. Squares are `(row, col)` from `0`
  to `7`, row 0 is at the top, and the game is mini-chess with kings, queens, rooks and bishops.
- A piece is an object of a subclass of `ChessPiece`. The letters survive in two places,
  `ChessPiece.fromLetter`, which turns `'Q'` into a white `Queen`, and the picture of the board.
- The scripted game in `Demo.main` is session 2's with one move changed. Move 3 sent a rook onto
  its own bishop, and there are no bishops yet, so here the other rook goes onto its own king.
