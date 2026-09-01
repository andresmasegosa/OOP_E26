# Session 2 — Exercises

Every chess exercise works in the [`E_ChessGame`](E_ChessGame/) folder. The
demo folders `A_` to `D_` are there to read and run, never to edit.
Exercises 1, 2 and 3 are the core of the session; do them in order.
Exercise 4 is a stretch goal, and the sheet closes with three problems that
have no chess in them at all.

**You need your session 1 notes on the table.** Exercises 1 to 3 are
session 1's exercises done *again*, on the new design, and their real
product is the comparison. As before: each exercise ends with a short
discussion, first in pairs and then with the class, and the session closes
with a global reflection. Write your notes as you go.

## Exercise 0 — warm-up: make the code yours

Run the four demos, `A_` to `D_`, predicting every printed line before you
run it. Then, in the `main` method of
[`ChessGame.java`](E_ChessGame/ChessGame.java):

- Add two moves of your own to the scripted game, one legal and one
  illegal. Predict the output before you run.
- Play a full game with a classmate until one king falls.

## Exercise 1 — wake up the bishops. Again.

Same job as last week: the bishops are on the board and the program does
not know how they move. Teach it — diagonally, any number of squares.

You are done when the move `movePiece(board, 7, 5, 5, 3)` in `main`
succeeds. Start by deciding where the change belongs; your reading of
`E_ChessGame` should already have given you a suspect.

Then take out your session 1 notes and fill the first two rows of this
table — it is the table we will keep filling until session 3:

| Design | Places touched for the bishop | Of which switches | Did anything warn you? |
|---|---|---|---|
| Session 1, procedural | | | |
| Session 2, classes + encapsulation | | | |
| Session 3, designs A–D | *(coming)* | | |

One more thing. In session 1 you also had to fix `pieceName`, because the
board printed `White ? moves`. Search this design for that second fix.

Discussion:

1. Where did `pieceName`'s switch go? The type of a piece used to be a
   char that had to be *translated* into a name at every use; what is it
   now, and how many copies of the translation survive?
2. Fewer places this time — but did anything *tell* you which places?
   The default branch in `isLegalMove` stayed as silent as session 1's.
   What would you want the compiler to do when a piece type is forgotten?
   Keep the answer: session 3 builds designs where that wish comes true.
3. The switch did not die; it moved into `ChessPiece` and got a home. Is
   that an improvement or just tidier wallpaper? Defend your answer with
   the table.

## Exercise 2 — the counter, and the variable that follows the queen

The chess club again: how many times has each piece moved? In session 1
this cost you a parallel `int[8][8]`, kept in sync by hand, reset on
capture by nobody — and discussion 3 ended in the sentence *"neither the
piece's letter nor its square is a way to hold on to that piece over
time."* This design has what was missing.

- Give `ChessPiece` a private `moveCount`, a getter, and one place where
  it grows. Careful: the piece does not move itself — the board does. The
  board will have to tell the piece, through a door you choose. Choose its
  visibility on purpose, like every other door in the class.
- When a piece moves, print its counter, as in session 1:
  `White Queen has now moved 3 times`.
- Now answer the club's questions, in `main`, *without searching the
  board*: how many times has the white queen moved in the scripted game?
  And each of the two white rooks, separately? You do not need to touch
  `setupBoard`: ask the board for the pieces before the game starts —
  `board.getPieceAt(7, 3)` hands you the queen herself — and hold on to
  what it gives you.
- One of your references is now a **ghost**: the white queen is captured
  in move 5 of the script. Ask her anyway. What do `getMoveCount()`,
  `getRow()` and `getCol()` say? And what does `board.getPieceAt(0, 3)`
  say about who stands there?

Discussion:

1. Compare with your session 1 storage design: which code disappeared —
   the syncing, the reset-on-capture, the searching? What replaced it?
2. Your queen variable stayed correct through `(7,3) → (4,3) → (0,3)`.
   Say in one sentence what a reference gives you that a board coordinate
   never could. (Session 1 promised this sentence a name: it is
   *identity*.)
3. The ghost: the board has forgotten the captured queen, but your
   variable has not, and she still claims to stand on (0,3). Nobody told
   her. Decide what *should* happen to a captured piece's object, write
   it in one sentence, and keep it — deciding who is responsible for
   telling her is session 4's business.

## Exercise 3 — the sabotage, and every other door

The saboteur lines are waiting in `main`, search for `EXERCISE 3`.

- Uncomment the sabotage and compile. Copy the compiler's answer into
  your notes, next to your one-sentence answer from session 1, exercise 4.
  You wrote *"which parts should be able to write on the board"* — the
  word `private` is that sentence, enforced.
- The array is locked. Now audit the rest: list every `public` and every
  `protected` member of `ChessBoard` and `ChessPiece`, and for each one
  ask: can it break the board's invariants — real squares, one piece per
  square, board and pieces agreeing on positions?
- Your list contains one wide-open door. Add this line at the end of the
  scripted game and run:

  ```java
  new ChessPiece(board, 'Q', 4, 4);
  ```

  A second white queen, and every check passed politely. Which invariants
  survived? Which chess-sense rule ("pieces are not created mid-game")
  did not — and which class was supposed to enforce it?
- One more, subtler: in `main`, call `setRow(3)` on a piece you hold. It
  compiles. `setRow` is `protected` — so why does *your* code reach it?
  (Look at the package `ChessGame` lives in. The full visibility table is
  on the slides; the lesson is that a package is a trust boundary, and
  exercise code living inside the package lives inside the trust.)

Discussion:

1. In one sentence: what does `private` buy, and what does it *not* buy?
   (Hint: it controls *who* can change state. Does it control whether a
   change *makes sense*?)
2. `placePiece` validates its square and refuses politely, by returning
   `false` — and the constructor that called it ignores the answer, so a
   refused piece simply exists off every board. Is a `boolean` a loud
   enough "no"? Keep your answer for session 8, where refusals become
   first-class.

## Exercise 4 — the knights, again (stretch goal)

Session 1's stretch goal, on the new design: add the knights, `'N'` and
`'n'`, starting on `(0,1)`, `(0,6)`, `(7,1)` and `(7,6)`. An L-shaped move,
two squares along one axis and one along the other — and the knight jumps,
so there is no path to check at all.

Count the places you touched, and compare with your session 1 notes before
reading on.

You should find *more* places than the bishop needed — and, depending on
your session 1 solution, possibly more than the knight cost you last week.
Look at where they are: `setupBoard`, the movement switch, and **two**
letter translations (`typeFromLetter`, `getSymbol`) where session 1 had
one (`pieceName`).

Discussion:

1. Separate your list: which places are about the knight's *rule*, and
   which are about its *name and letter*? The refactor made the rule
   cheap for existing types (the bishop: one place) — what does it still
   not make cheap?
2. The letter translations exist because a piece type is a `String` that
   the board world writes as a `char`. Would you drop the char
   constructor to save a switch? What would `setupBoard` look like then?
   (Session 8 dissolves this trade-off: a type will become something that
   is neither a char nor a free-form String.)

## Three problems with no chess in them

Same tools, different world — this is the part that looks most like the
exam. Create the classes in packages of your own under `session2`, for
example `session2.transfer`. No scaffolding this time: you write the whole
file.

### Problem 1 — the bank account

A `BankAccount` has an owner's name and a balance, which starts at 0 when
the account is opened. Money comes in through `deposit(amount)` and leaves
through `withdraw(amount)`. House rules: a deposit must be positive, and a
withdrawal must be positive and never leave the balance below 0. Illegal
requests change nothing.

Write the class so that **no code anywhere in the program can break the
rules**, and prove it with a `main` that attacks: a negative deposit, an
overdraw, and a direct write to the balance (that last attack should not
even compile — keep it as a comment with the error message next to it).

Check yourself: after `deposit(500)`, `withdraw(200)`, `deposit(-100)`,
`withdraw(400)`, the balance prints `300`.

### Problem 2 — two notes that share a name

A music app and a to-do app collide in one program. Write a `Note` class
for music (a pitch like `"A4"`, a duration in beats) and a `Note` class
for tasks (a text, a done flag) — same class name, two different packages.
Then write one `main`, in a third package, that creates and prints one of
each. You will need an `import` for one of them and a fully-qualified name
for the other; write one line of comment explaining why the same trick
cannot work for both.

### Problem 3 — the playlist

A `Song` has a title, an artist and a duration in seconds; all fixed at
birth, readable, never writable. A `Playlist` has a name and up to 100
songs (an array and a count — we meet real collections in session 6), an
`add(Song song)` method, a `totalSeconds()` and a `longestSong()`.

Then the aliasing question: create ONE `Song` and add it to TWO playlists.
How many Song objects exist? Prove your answer from `main` with `==`, and
explain it with the word *reference*.

## Global reflection — the wish list, revisited

All notes on the table, session 1's included.

1. Read out your session 1 wish list. Which wishes did this session grant?
   Mark each one: *data and rules in one place* — which construct did
   that? *Nobody writes the board behind the rules' back* — which
   keyword? *The compiler tells me when a piece is forgotten* — granted
   or still open?
2. The cost table has two filled rows. Read them aloud: what got cheaper,
   what did not move at all? Where exactly does the program still say
   `default:` and stay silent?
3. Write the wish for next week in one sentence: what should a *design*
   do so that forgetting a piece type is a compile-time error, not a
   quiet `false`? Bring the sentence to session 3 — building four
   competing answers to it is the whole session.
