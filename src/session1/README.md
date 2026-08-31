# Session 1 — Intro to Java, through chess

In this course we build one program, a chess game, and we keep rebuilding it
session after session. Today you meet its first version, written with no
object-oriented programming at all, only the basics of the Java language. It
works. What it costs to make it grow is a different matter, and that question
will keep us busy the whole semester.

## Before class

1. Get the tools running. Install IntelliJ IDEA (the Community Edition is
   enough) and a recent JDK, version 21 or newer. Open this project, run
   `A_HelloChess`, and check that a board gets printed.

   > **TODO (Andrés):** link to the Moodle install instructions.

2. Arrive knowing basic Java syntax, at reading level: variables and types
   (`int`, `char`, `boolean`, `String`), `if`/`else`, `switch`, `for` and
   `while` loops, arrays, and what a (static) method is.

   > **TODO (Andrés):** confirm the E26 literature and chapters. In E25 this was
   > *Java: A Beginner's Guide* (Schildt), chapters 1–3.

3. Read the chess game in [`E_ChessGame.java`](E_ChessGame.java), from top to
   bottom. It is one file, and you do not need to understand every line. Then
   run it and play a game (against yourself counts). While you read, try to
   answer these three questions and bring your answers to class:

   - Where in the program is it decided whether a queen's move is legal?
   - How does the program know whether a piece belongs to White or to Black?
   - Try to move a bishop. What happens, and can you find out why?

Nothing needs to be fixed before class. If parts of the code confuse you, that
is expected. Write your questions down and bring them too.

## In class

- Introduction to the course, and how it works: the same chess program,
  rebuilt with better tools every week.
- Live coding of the basics, files `A_` to `D_`, ending in `E_ChessGame`.
- Exercises: see [EXERCISES.md](EXERCISES.md).

## Files

| File | What it shows |
|---|---|
| `A_HelloChess.java` | `main`, `System.out.println`, a first variable |
| `B_BoardBasics.java` | variables and types, `char`, the board as a 2D array, `if` |
| `C_PrintingTheBoard.java` | `for` loops, nested loops, printing the board |
| `D_CheckingMoves.java` | static methods, parameters and return values, `switch` |
| `E_ChessGame.java` | the complete game: everything above, plus `while` and `Scanner` |

## Conventions used by the game

- The board is a `char[8][8]`, where `'.'` is an empty square.
- Uppercase means White (`'K'`, `'Q'`, `'R'`, `'B'`) and lowercase means Black
  (`'k'`, `'q'`, `'r'`, `'b'`).
- A square is `(row, col)`, both from `0` to `7`. Row 0 is printed at the top,
  on Black's side.
- The game is mini-chess: no pawns, no knights, no check, no castling. You
  capture by moving onto an enemy piece.
