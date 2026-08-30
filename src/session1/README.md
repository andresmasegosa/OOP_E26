# Session 1 — Intro to Java, through chess

This course grows **one program** — a chess game — session after session. Today you
meet its first version: a chess game written with no object-oriented programming at
all, only the basics of the Java language. It works. The interesting question, which
will keep us busy all semester, is what it costs to make it grow.

## Before class

1. **Get the tools running.** Install IntelliJ IDEA (Community Edition is enough) and a
   recent JDK (21 or newer). Open this project, run `A_HelloChess`, and check you see a
   board printed.

   > **TODO (Andrés):** link to the Moodle install instructions.

2. **Familiarize yourself with basic Java syntax.** You should arrive knowing, at
   reading level: variables and types (`int`, `char`, `boolean`, `String`), `if`/`else`,
   `switch`, `for` and `while` loops, arrays, and what a (static) method is.

   > **TODO (Andrés):** confirm the E26 literature and chapters. In E25 this was
   > *Java: A Beginner's Guide* (Schildt), chapters 1–3.

3. **Read the chess game: [`E_ChessGame.java`](E_ChessGame.java).** Read it from top to
   bottom — it is one file, and you do not need to understand every line. Then run it
   and play a game (against yourself counts). While reading, try to answer these three
   questions and bring your answers to class:

   - Where in the program is it decided whether a queen's move is legal?
   - How does the program know whether a piece belongs to White or to Black?
   - Try to move a bishop. What happens — and can you find out *why*?

Nothing needs to be fixed before class. Confusion is fine; write your questions down.

## In class

- Course introduction, and how this course works: the same chess program, rebuilt with
  better tools every week.
- Live-coding of the basics, files `A_` to `D_`, landing on `E_ChessGame`.
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

- The board is a `char[8][8]`. `'.'` is an empty square.
- Uppercase = White (`'K'`, `'Q'`, `'R'`, `'B'`), lowercase = Black (`'k'`, `'q'`, `'r'`, `'b'`).
- A square is `(row, col)`, both `0..7`; row 0 is printed at the top (Black's side).
- Mini-chess rules: no pawns, no knights, no check, no castling. Capture by moving onto
  an enemy piece.
