# Session 2 — Introduction to OOP: the same game, made of objects

Last week you played a chess game that works, and you paid the bill for
growing it three times: hunting scattered switches, keeping a parallel array
in sync, and watching a saboteur write on the board with nobody to stop it.
Your final reflection ended in a wish list. This session grants most of it.

The tools are called classes, objects and encapsulation. The game is the
same one — same board, same rules, same missing bishops. What changes is
where things live: everything the program knows about a piece moves into the
piece, and the board stops being writable by anyone who feels like it.

## Before class

1. Read, in *Java: A Beginner's Guide* (Herbert Schildt): chapter 4
   (classes, objects and methods) and chapter 6 (a closer look at methods
   and classes — constructors, overloading, access control). From chapter 8,
   read only the part about packages; the interfaces part belongs to
   session 3. If arrays still feel shaky, chapter 5 covers them — session 1
   already leaned on them.

2. **Bring your session 1 notes.** The cost counts from exercises 1 to 3,
   your one-sentence answers, and your wish list. This session's exercises
   reuse them line by line, and the session makes much less sense without
   them.

3. Read the demo folders in order, `A_` to `D_`. Run each `Demo` and read
   the classes next to it: each folder is one step of the story, and we walk
   the same path together in class. One question per step, to bring
   answered:

   - [`A_ClassesAndObjects`](A_ClassesAndObjects/): where do the queen's
     name and color live now? Where did they live in session 1?
   - [`B_ReferencesAndAliasing`](B_ReferencesAndAliasing/): after
     `sameQueen.moveCount = sameQueen.moveCount + 1`, what does
     `queen.moveCount` hold, and why?
   - [`C_Constructors`](C_Constructors/): what happens on
     `new ChessPiece()` with no arguments — and why is that good news?
   - [`D_Encapsulation`](D_Encapsulation/): uncomment the two attack lines
     in `Demo`, compile, and read both error messages out loud.

4. Then read the game itself, [`E_ChessGame`](E_ChessGame/), in this order:
   `ChessPiece`, `ChessBoard`, `Movements`, `ChessGame`. Run it and play.
   Three questions to bring:

   - Where is it decided whether a queen's move is legal — and how does
     your answer differ from last week's?
   - Who can write on the board's array now? List every way in.
   - The bishops still do not move. Before touching any code: how many
     places do you *expect* to change this time?

Nothing needs to be fixed before class. If something confuses you, write the
question down and bring it.

## In class

- Your session 1 wish list, on the table: which wishes this session grants.
- Live coding of the path `A_` to `D_`, ending in the rebuilt `E_ChessGame`.
- Exercises: see [EXERCISES.md](EXERCISES.md).

## Files

| Folder | What it shows |
|---|---|
| `A_ClassesAndObjects/` | the first class: fields, methods, objects, the dot |
| `B_ReferencesAndAliasing/` | what a variable really holds; aliasing, `==`, the heap |
| `C_Constructors/` | born whole: constructors, overloading, `this` |
| `D_Encapsulation/` | `private`, getters, doors that refuse: the sabotage dies |
| `E_ChessGame/` | the whole game rebuilt: `ChessPiece` + `ChessBoard` + `Movements` + `ChessGame` |

## Conventions used by the game

- The board, the coordinates and the rules are exactly session 1's: `(row,
  col)` from `0` to `7`, row 0 on top, mini-chess with kings, queens, rooks
  and bishops.
- A piece is now an **object**. The letters (`'Q'`, `'q'`, …) survive only
  as what a piece prints on the board — see `ChessPiece.getSymbol()`.
- Run `ChessGame` and it behaves exactly like session 1's `E_ChessGame`,
  message for message. That is the point: same game, different bones.
