# Session 5 — Interfaces and object-oriented design: what a class promises

Session 3 ended with two wishes. Session 4 gave you time to work on that design. One was a piece that moves like two pieces, without
copying code, because a class can extend only one class. The other was to play against the
computer instead of against a classmate. One tool grants both.

An interface is a list of methods with no bodies. A class that says it implements one promises
to have them, and the compiler holds it to the promise. That is the whole of what an interface
is, and this session is about what can be built on it. A way of moving that belongs to no piece
in particular, so that a piece can hold two of them. And a player the game has never heard of,
so that the game does not care whether a person or a program is on the other side.


## Before class

1. Read chapter 8 of *Java: A Beginner's Guide* (Herbert Schildt), from "Interfaces" to the end
   of "Variables in Interfaces". The first half of that chapter, on packages, was the reading
   for session 2.

2. Bring your notes from sessions 1 to 4, and above all the three cost lines at the top of
   session 3's `Demo.main` and the two wishes you wrote at the end of it. Exercise 1 adds a
   fourth cost line.

3. Read the two demo folders in order and run each `Demo`. Each folder is one step of the story,
   and we walk the same path together in class. One question per step, to bring answered.

   - [`A_MoveRule`](A_MoveRule/): open `Queen.java` next to session 3's `Queen.java`. Session 3's
     queen has a method with three calls to `Movements` in it. This one has no method at all.
     Where did those three calls go?
   - [`B_Player`](B_Player/): `KeyboardPlayer` and `RandomPlayer` do the same job and share no
     field. What could a common superclass of the two have held?

4. Then read the game, [`C_ChessGame`](C_ChessGame/), starting with the two interfaces,
   `MoveRule` and `Player`, then `ChessPiece` and `Queen`, and last `ChessGame.play`. Run `Demo`.
   Two questions to bring.

   - `ChessGame` never mentions `KeyboardPlayer` or `RandomPlayer`. Find the line that decides
     who plays White.
   - `Movements` does not exist in this session. Session 3's had three static methods. Find
     where each of them went.

Nothing needs to be fixed before class. If something confuses you, write the question down and
bring it.

## In class

- The two wishes from session 3, on the table.
- Step `A_` in live coding, and then exercise A. Step `B_`, and then exercise B.
- The game rebuilt in `C_ChessGame`, and then exercises 1, 2 and 3.

Each folder has its own exercise sheet, [`A_MoveRule/EXERCISES.md`](A_MoveRule/EXERCISES.md),
[`B_Player/EXERCISES.md`](B_Player/EXERCISES.md) and [`C_ChessGame/EXERCISES.md`](C_ChessGame/EXERCISES.md).

## Files

| Folder | What it shows |
|---|---|
| `A_MoveRule/` | a way of moving as an object, and a piece that holds the ones it may use |
| `B_Player/` | an interface and two classes that implement it, sharing no field at all |
| `C_ChessGame/` | the game on two interfaces, played by two `Player` objects; `Demo` starts it |

## What changed from session 3, and what did not

- **`Movements` is gone.** It was the last of session 1's static helper classes, and its own
  javadoc had been asking since session 3 whether rules like those belong in a helper, in the
  pieces or in the board. The answer is none of the three: a way of moving is a thing, so it is a
  class, and the arithmetic lives inside it. The same arithmetic, moved into `rules/StraightLine`
  and `rules/Diagonal`.
- **`ChessBoard` did not change at all.** Open it next to session 3's: apart from the package
  line, not one line differs.
- **`King`, `Queen`, `Rook` and `Bishop` lost their `isLegalMove`.** Each one now says its name,
  its letter and its ways of moving, and holds no method that decides anything.
- **`ChessPiece.isLegalMove` has a body again**, the same body for every piece: ask the rules,
  and one yes is enough. Before it asks them, it refuses a target that holds a piece of the
  mover's own colour. `getLetter` is still abstract, as session 3 left it.
- **`ChessGame` lost the keyboard and gained two players.** `ChessGame.movePiece` is private now,
  so a move can only be made by coming through `ChessGame.takeTurn`, where the turn is checked.
- **The scripted game is gone.** `Demo.main` plays a game between two `RandomPlayer` objects
  instead, and then a game between you and one of them. The machine game is different every run
  and can be long: neither player is trying to win.
- **A game now ends when a king is captured.** There is no check and no checkmate in this game,
  so that is what ending means here. Exercise 3 asks who should detect check.

## Conventions used by the game

- The board, the coordinates and the rules are session 2's. Squares are `(row, col)` from `0` to
  `7`, row 0 is at the top, and the game is mini-chess with kings, queens, rooks and bishops.
- A piece is still an object of a subclass of `ChessPiece`, as in session 3. What changed is that
  it holds its ways of moving instead of writing them out.
- There is no `switch` anywhere in this session, as there is none in session 3. A piece's type
  and its colour are still `String`s that nobody can check, and session 8 is where that ends.
