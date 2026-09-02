# Session 2 — Exercises

Every chess exercise works in the [`E_ChessGame`](E_ChessGame/) folder. The
demo folders `A_` to `D_` are there to read and run, never to edit.
Exercises 1, 2 and 3 are the core of the session; do them in order.
Exercise 4 is written work — a design review with almost no code — and
exercise 5 is a stretch goal.

**You need your session 1 notes on the table.** Exercises 1 to 3 are
session 1's exercises done *again*, on the new design, and their real
product is the comparison. As before: each exercise ends with a short
discussion, first in pairs and then with the class, and the session closes
with a global reflection. Write your notes as you go.

## Exercise 0 — warm-up: make the code yours

Run the four demos, `A_` to `D_`, predicting every printed line before you
run it. Then, in the `main` method of
[`Demo.java`](E_ChessGame/Demo.java), which is where the game is started:

- Add two moves of your own to the scripted game, one legal and one
  illegal. Predict the output before you run.
- Play a full game with a classmate until one king falls.

Discussion:

1. Put session 1's `E_ChessGame` next to `ChessGame`. One parameter
   disappeared from every method. Which one, and where did it go? And
   what happened to `whiteToMove`?
2. `ChessGame` has no `static` method at all; `Demo` is one `static`
   method and nothing else; `Movements` has three `static` methods and
   nothing else. Explain each choice in one sentence. What could `main`
   not do if it were an instance method of `ChessGame`?

## Exercise 1 — wake up the bishops. Again.

Same job as last week: the bishops are on the board and the program does
not know how they move. Teach it — diagonally, any number of squares.

You are done when the move `game.movePiece(7, 5, 5, 3)` in `main`
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
  `setupPieces`: ask the game for its board, and the board for the pieces,
  before the game starts — `game.getBoard().getPieceAt(7, 3)` hands you
  the queen herself — and hold on to what it gives you.
- One of your references is now a **ghost**: the white queen is captured
  in move 5 of the script. Ask her anyway. What do `getMoveCount()`,
  `getRow()` and `getCol()` say? And what does `game.getBoard().getPieceAt(0, 3)`
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
  game.getBoard().placePiece(4, 4, new ChessPiece('Q'));
  ```

  A second white queen. `placePiece` checked that the square exists and
  is empty — and nothing else. Which invariants survived? Which
  chess-sense rule ("pieces are not created mid-game") did not — and
  which class was supposed to enforce it?
- One more, subtler: in `main`, call `setRow(3)` on a piece you hold. It
  compiles. `setRow` is `protected` — so why does *your* code reach it?
  (Look at the package `Demo` lives in. The full visibility table is
  on the slides; the lesson is that a package is a trust boundary, and
  exercise code living inside the package lives inside the trust.)
- And the door you have been using all along: `getBoard()` hands out the
  board itself, its own doors included. In `main`, move a Black piece
  through it while it is still White's turn:

  ```java
  game.getBoard().movePiece(game.getBoard().getPieceAt(0, 7), 3, 7);
  ```

  It moves. "White moves first" is a rule of this program — which
  class enforces it today, and which class did you just walk around?
  Whose rule *should* it be?

Discussion:

1. In one sentence: what does `private` buy, and what does it *not* buy?
   (Hint: it controls *who* can change state. Does it control whether a
   change *makes sense*?)
2. `placePiece` validates its square and refuses politely, by returning
   `false` — and `setupPieces` never looks at the answer, so a refused
   piece would simply exist off every board and nobody would know. Is a
   `boolean` a loud enough "no"? Keep your answer for session 8, where
   refusals become first-class.

## Exercise 4 — the design review: same tools, other shapes

No new feature this time, and almost no code: five questions about the
design you have spent the session reading. Each one is a choice somebody
made in `E_ChessGame`, and each one could have been made differently.

Work in pairs, and answer every question in five lines. The shape of the
answer matters as much as the answer:

1. **The alternative**, in one sentence.
2. **What it makes better.**
3. **What it makes worse.** No alternative is free; if you cannot name
   the cost, you have not yet understood the design you are attacking.
4. **What you would have to touch** — classes and methods by name, in
   the same currency as the cost-of-change table.
5. **Your verdict**: *change it*, *keep it*, or *not with what I know
   today*.

That last verdict is a real answer and it counts like any other. Some of
these questions have no good answer with this session's tools; noticing
that is the point, and what you found missing goes on this week's wish
list.

One question this exercise does *not* ask: how to make the `switch` in
`isLegalMove` disappear. That one closes the session, and answering it is
the whole of session 3.

### Q1 — should `Movements` be part of `ChessBoard`?

`Movements` holds no state, and each of its three methods takes a
`ChessBoard` as its first parameter. That shape is worth suspecting.
Read one of them as a method of the board instead —
`board.isLegalDiagonalMove(fromRow, fromCol, toRow, toCol, maxDistance)`,
walking the board that is now `this` — and watch a parameter disappear:
the very disappearance exercise 0 asked you to name. What gets simpler,
and what have you just taught the board that it does not know today?

Before you answer "but the board knows nothing about chess", read
`ChessBoard.movePiece` again: it already refuses to capture your own
piece. Is that a rule of boards, or a rule of chess?

### Q2 — `printBoard`: in `ChessGame`, in `ChessBoard`, or in both?

Today it is in both: `ChessBoard.print()` draws the picture, and
`ChessGame.printBoard()` is one line that asks it to. Weigh the three
designs — the drawing only in the game, which then has to walk the
squares itself; only in the board, so that every caller reaches it
through `getBoard()`; and today's pair.

Then the sharp version. The delegation is there so that nobody outside
needs the board — but `getBoard()` is public, and exercise 3 had you use
it. So what does `printBoard` protect today?

### Q3 — whose business is `getSymbol()`?

`'Q'` is not what a queen *is*; it is how a queen is *drawn* on this
particular board. The piece stores its type and color and derives the
letter, and the only code that ever asks is `ChessBoard.print()`. Should
the translation live with the drawing? Write what `print()` would look
like if it did, and say what the piece loses.

### Q4 — two places remember where the queen stands

`ChessBoard` knows what stands on every square. Every `ChessPiece` also
carries its own `row` and `col`. Two copies of one fact, kept in step by
hand inside `placePiece` and `movePiece` — and you have met that before:
it is session 1's parallel `int[8][8]`, in better clothes.

Two alternatives, each worth its five lines:

- **Only the board knows.** The piece loses `row`, `col`, `setRow` and
  `setCol`. What then happens to `isLegalMove`, which reads them?
- **Only the piece knows.** The board stops being a grid of squares and
  becomes an array of pieces you have to search. What does `getPieceAt`
  cost then?

And the question that pays for the exercise: your captured queen from
exercise 2 still claims to stand on (0,3). Does either design make that
ghost impossible — or only harder to notice?

### Q5 — how much does `private` really buy?

`placePiece` is `public`. Make it package-private — drop the modifier
entirely — and compile. Two things happen, and the second one is the
lesson:

- `setupPieces` still compiles: `ChessGame` shares the package.
- **Exercise 3's second-queen attack still compiles too**, because
  `Demo` shares the package as well.

Session 1's sabotage died at the compiler, and yet this door stands open
to every class in `session2.E_ChessGame`. What would have to change for
that attack to stop compiling? Notice that it is not a change of
keyword — so where would `Demo` have to live?

Discussion:

1. Sort your five verdicts into two piles: *taste* (two defensible
   designs, and this program picked one) and *fault* (today's design does
   not survive the argument). Bring one of each to the board.
2. How many verdicts came out "not with what I know today"? Write down
   what you were missing each time. That list is next week's wish list,
   and the global reflection below collects it.
3. Four of these five questions are one question wearing different
   clothes: **who should be responsible for this?** Write that sentence
   down — session 4 opens with it.

## Exercise 5 — the knights, again (stretch goal)

Session 1's stretch goal, on the new design: add the knights, `'N'` and
`'n'`, starting on `(0,1)`, `(0,6)`, `(7,1)` and `(7,6)`. An L-shaped move,
two squares along one axis and one along the other — and the knight jumps,
so there is no path to check at all.

Count the places you touched, and compare with your session 1 notes before
reading on.

You should find *more* places than the bishop needed — and, depending on
your session 1 solution, possibly more than the knight cost you last week.
Look at where they are: `setupPieces`, the movement switch, and **two**
letter translations (`typeFromLetter`, `getSymbol`) where session 1 had
one (`pieceName`).

Discussion:

1. Separate your list: which places are about the knight's *rule*, and
   which are about its *name and letter*? The refactor made the rule
   cheap for existing types (the bishop: one place) — what does it still
   not make cheap?
2. The letter translations exist because a piece type is a `String` that
   the board world writes as a `char`. Would you drop the char
   constructor to save a switch? What would `setupPieces` look like then?
   (Session 8 dissolves this trade-off: a type will become something that
   is neither a char nor a free-form String.)

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
