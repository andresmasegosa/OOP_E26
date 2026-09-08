# Session 2 — Exercises

Every exercise works in the folder [`E_ChessGame`](E_ChessGame/). The demo
folders `A_` to `D_` are there to read and run, never to edit. Exercises 1, 2
and 3 are the core of the session; do them in order. Exercise 4 is written
work, a design review with almost no code, and exercise 5 is a stretch goal.

The game is five classes, one per file. `ChessPiece` is one piece: its type,
its color, the square it stands on, and `isLegalMove`, the rule for how it
moves. `ChessBoard` is the 8x8 grid, private, with four doors, `placePiece`,
`getPieceAt`, `movePiece` and `print`. `Movements` has the three helpers of
session 1 that check a path, horizontal, vertical and diagonal. `ChessGame` is
a game. It has a board, it knows whose turn it is, its `movePiece` tries a move
and prints what happened, and its `play` reads your keyboard. `Demo` has one
method, `main`, and nothing else.

Two things about names, because they cause confusion. First, all five folders
have a class called `Demo`. They are five different classes, and Java tells
them apart by their package, `session2.E_ChessGame.Demo`,
`session2.A_ClassesAndObjects.Demo` and so on. In this sheet `Demo` always
means the one in `E_ChessGame`, and `Demo.main` is its `main` method. That is
where all the code you write in this session goes, unless an exercise says
otherwise. When one of the demo folders is meant, the folder is named. Second,
methods are written with their class in front. `ChessBoard.movePiece` is the
method `movePiece` of the class `ChessBoard`, in `E_ChessGame/ChessBoard.java`.
`ChessGame.movePiece` is a different method in a different class with the same
name. The game's version takes four numbers and prints a message, the board's
takes a piece and answers true or false.

You need your session 1 notes on the table. Exercises 1 to 3 are session 1's
exercises done again on the new design, and what we want out of them is the
comparison. As in session 1, each exercise ends with a short discussion, first
in pairs and then with the class, and the session closes with a global
reflection. Write your notes as you go. Where a question rests on something
from the book, the chapter and section are given in brackets. The book is
*Java: A Beginner's Guide*, 8th edition, the chapters you read before class.

## Exercise 0 — warm-up: make the code yours

Run the four demos in order, `A_ClassesAndObjects/Demo`,
`B_ReferencesAndAliasing/Demo`, `C_Constructors/Demo` and
`D_Encapsulation/Demo`. Before you run each one, read its `main` and write
down what every `println` will print. Then run it and compare. Where you were
wrong, the explanation is in the class next to that `Demo`, its `ChessPiece`
and, in step D, its `ChessBoard`. Read it until the output makes sense.
Nothing in these four folders is edited.

Then open `E_ChessGame/Demo.java`. Its `main` creates a `ChessGame`, plays a
scripted game of six moves by calling `game.movePiece(...)` six times, and then
calls `game.play()`, which gives you the keyboard.

- Add two moves of your own after the six, one legal and one illegal. A move
  is `game.movePiece(fromRow, fromCol, toRow, toCol)`, the square the piece is
  on and then the square it goes to, in the coordinates printed around the
  board. Rows and columns go from 0 to 7, and row 0 is the top, Black's side.
  Before you run, write down the exact line each of your moves will print.
  The messages are built in `ChessGame.movePiece`; read it if you are not sure
  what it prints when a move is refused.
- Play a full game against a classmate from the keyboard, until one king
  falls. The game tells you on every turn how to type a move, four numbers on
  one line, for example `7 3 4 3`, and if you mistype it says so and asks
  again. That code is `ChessGame.play`. It is not the subject of the session,
  but nothing in it is beyond you.

Discussion. Bring both answered in writing.

1. Open session 1's `E_ChessGame.java` and `ChessGame.java` side by side and
   look at the three methods that exist in both, `printBoard`, `movePiece` and
   `play`. In session 1 all three started with the same parameter,
   `char[][] board`, and `main` had to pass the board on every call,
   `movePiece(board, 7, 3, 4, 3)`. In `ChessGame` the parameter is gone from
   all three. So where does `ChessGame.movePiece` get the board it moves
   pieces on? Find the line of `ChessGame.java` that answers this, and say
   what kind of variable the board is now, a field, a local variable or a
   parameter, and which methods can see it because of that. Then do the same
   for `whiteToMove`. In session 1 it was a local variable declared inside
   `play`, so no other method could read it. Find where it is declared now
   and say who can read it. (Chapter 4, the first sections on classes,
   objects and methods, and the section on `this`.)
2. A `static` method belongs to the class and runs without any object of that
   class existing. It has no `this`, so it cannot read fields or call instance
   methods unless it holds an object in a variable. An instance method belongs
   to an object and works on that object's fields. Now look at three classes.
   `ChessGame` has no static method at all. `Demo` has one method, `main`, and
   it is static. `Movements` has three methods, all static. Explain each
   choice in one sentence. Which object do the methods work on, or why is
   there none? Then suppose `main` were an instance method of `ChessGame`.
   Which object would it be called on, who would have created that object,
   and why does that rule it out as the place where the program starts?
   (Chapter 6, "Understanding Static", including the restrictions on static
   methods listed there.)

## Exercise 1 — wake up the bishops. Again.

Same job as session 1's exercise 1. The bishops are on the board and the
program does not know how they move. Teach it. A bishop moves diagonally, any
number of squares, and never through another piece.

In session 1 the rule of each piece was one `case` of the `switch` in the
static method `isLegalMove`. Here the rule is still a `switch`, but it has
moved. It is now `ChessPiece.isLegalMove(board, toRow, toCol)`, in
`E_ChessGame/ChessPiece.java`, and it switches on the piece's own field
`type`. The helpers the cases call are in `Movements`, with the same names as
last week. Start by reading that `switch` and its `default` branch.

You are done when the sixth move of the scripted game in `Demo.main`,
`game.movePiece(7, 5, 5, 3)`, succeeds and the program prints
`White Bishop moves (7,5) -> (5,3)` instead of the `Illegal move` line.

In session 1 there was a second fix. Once the bishop moved, the message said
`White ? moves`, and you had to teach `pieceName`, the switch that turned a
letter into a name. Look for that second fix in this design. Where does the
name in the message come from now? Read how `ChessGame.movePiece` builds its
message and what `ChessPiece.getType()` returns. Write down what you find. Is
there a second fix or not, and why?

Then write down what the change cost you, as a comment at the top of
`Demo.main`:

```java
// Cost of the bishop, session 2:
//   places touched: ...   of which switches: ...   did anything warn me: ...
```

Places touched is the number of methods you edited. Of which switches, how
many of them were a `switch` that had to learn about bishops. Did anything
warn me, whether the program told you where to look, a compiler error or a
warning, or you found the places by reading. Add the same two lines for
session 1, from your session 1 notes. Keep both. Session 3 adds a third, and
the three together are the argument of this course.

Discussion:

1. Where did `pieceName`'s switch go? In session 1 the type of a piece was a
   `char`, `'Q'` or `'q'`, and every time the program needed a name it had to
   translate that char in `pieceName`. What is the type of a piece now? Look
   at the field `type` in `ChessPiece` and at what `getType()` returns.
   Translation still happens, in two methods of `ChessPiece`.
   `typeFromLetter` turns a letter into a type name when a piece is created
   with `new ChessPiece('Q')`, and `getSymbol` turns the type back into a
   letter when the board is drawn. Say when each one runs. Did the bishop fix
   need either of them?
2. Fewer places this time. But did anything tell you which places? The
   `default` branch of `ChessPiece.isLegalMove` is as silent as session 1's.
   A forgotten piece type returns `false` and that is all. What would you
   want the compiler to do when a piece type is forgotten? Keep the answer.
   Session 3 builds designs where that happens.
3. The switch did not die, it moved, from a static method that was handed the
   board and four numbers to an instance method of `ChessPiece` that knows its
   own type and its own square. Is that an improvement or only tidier? Defend
   your answer with the cost lines in your comment.

## Exercise 2 — the counter, and the variable that follows the queen

The chess club again: how many times has each piece moved? In session 1 this
cost you a parallel `int[8][8]` that you kept in sync by hand and that nobody
reset on capture, and discussion 3 ended in the sentence "neither the piece's
letter nor its square is a way to hold on to that piece over time". This
design has what was missing. A piece is an object, and a variable can hold a
reference to it. (Chapter 4, "Reference Variables and Assignment".)

Four steps.

1. Give `ChessPiece` a private field `moveCount`, starting at 0, a public
   getter `getMoveCount()`, and one method through which the counter grows by
   one. Only one place in the whole program calls that method. Careful, the
   piece does not move itself, `ChessBoard.movePiece` moves it. The board is
   the only class that knows when a move has really been made, so the board
   tells the piece, by calling your method right after moving it. Your method
   is a new door of `ChessPiece`, so choose its visibility on purpose,
   `public`, `protected` or package-private, like every other door in the
   class. Look at how `setRow` and `setCol` are declared and why, decide
   whether the counter deserves anything different, and write your reason in
   a comment next to it. (Chapter 6, "Controlling Access to Class Members",
   and chapter 8, "Packages and Member Access".)
2. When a move is made, print the mover's counter as session 1 did,
   `White Queen has now moved 3 times`. The place is `ChessGame.movePiece`,
   after the board has said yes, where the `moves` and `captures` lines are
   built.
3. Answer the club without searching the board. In `Demo.main`, before the
   scripted game, ask the game for its board and the board for a piece.
   `game.getBoard()` returns the `ChessBoard`, and its `getPieceAt(row, col)`
   returns the piece on that square, so

   ```java
   ChessPiece whiteQueen = game.getBoard().getPieceAt(7, 3);
   ```

   gives you the white queen herself, not a copy. Do the same for the two
   white rooks, on `(7,0)` and `(7,7)`, in two variables of their own. After
   the scripted game, print the three answers from those variables. How many
   times has the white queen moved, and each of the two rooks? Do not search
   the board, and do not touch `ChessGame.setupPieces`.
4. One of your three references now points at a piece that is no longer on
   the board. The white queen is captured on move 5 of the script,
   `game.movePiece(0, 4, 0, 3)`, when the black king takes her on `(0,3)`.
   Ask her anyway, after the script. What do `getMoveCount()`, `getRow()` and
   `getCol()` say? Then ask the board who is on `(0,3)`,
   `game.getBoard().getPieceAt(0, 3)`, and print that piece's color and type.
   Write the four answers in your notes.

Discussion:

1. Compare with your session 1 storage design. Which code is gone, the
   syncing of the parallel array inside `movePiece`, the reset on capture,
   the search for the queen? What replaced each of them?
2. Your `whiteQueen` variable stayed correct through `(7,3)`, `(4,3)` and
   `(0,3)`, while `game.getBoard().getPieceAt(7, 3)` stopped being the queen
   the moment she moved. Say in one sentence what a reference gives you that
   a board coordinate cannot. Session 1 promised this sentence a name. The
   name is identity.
3. The board has forgotten the captured queen, your variable has not, and she
   still says she is on `(0,3)`. Nobody told her. Decide what should happen
   to the object of a captured piece, write it in one sentence and keep it.
   Who should tell her, the board, the game or the piece, is session 4's
   business.

## Exercise 3 — the sabotage, and every other door

Session 1's exercise 4 put a second white queen on the board with one line,
`board[4][4] = 'Q'`, and nothing stopped it. The same attack is waiting for
you in `Demo.main`, commented out; search the file for `EXERCISE 3`. Five
steps follow. Each one is a door of one class, and each time the question is
whether that door protects the board.

1. Uncomment the sabotage line,
   `game.getBoard().pieces[4][4] = new ChessPiece('Q');`, and compile. It
   does not compile. Copy the compiler's message into your notes, next to
   your one-sentence answer from session 1, exercise 4. You wrote which parts
   should be able to write on the board. The word `private` in front of
   `pieces` in `ChessBoard` is that sentence, enforced by the compiler.
   (Chapter 6, "Controlling Access to Class Members".) Comment the line out
   again.
2. The array is locked. Now audit the rest. List every `public` and every
   `protected` member of `ChessBoard` and of `ChessPiece`, constructors and
   methods. There are no public fields left. It is a short list, read off the
   two files. For each one ask whether code that calls it can break one of
   the board's invariants. The invariants are the three facts written at the
   top of `ChessBoard.java`. Pieces stand on real squares, there is one piece
   per square, and a piece and the board agree on where the piece stands.
   Answer yes or no, with a reason.
3. Your list has `ChessBoard.placePiece`, public. Add this line at the end of
   the scripted game, before `game.play()`, and run:

   ```java
   game.getBoard().placePiece(4, 4, new ChessPiece('Q'));
   ```

   A second white queen, and no complaint. `placePiece` checked that the
   square exists and is empty, and nothing else. Which of the three
   invariants survived? Which rule of chess sense (pieces are not created in
   the middle of a game) did not, and which class should have enforced it,
   the board, the game or the piece?
4. `ChessPiece.setRow` is `protected`, and its comment says only the board
   should call it. In `Demo.main`, call `setRow(3)` on a piece you hold, the
   `whiteQueen` of exercise 2 or any piece `getPieceAt` gives you, and print
   its `getRow()`. It compiles and runs. Why does your code reach a
   `protected` method? Look at the first line of `Demo.java` and of
   `ChessPiece.java`. Both say `package session2.E_ChessGame`. A protected
   member is open to every class in the same package, not only to the board.
   (Chapter 8, "Packages and Member Access", Table 8-1, and "Understanding
   Protected Members".) A package is a trust boundary, and your exercise code
   lives inside it.
5. `ChessGame.getBoard()` hands out the board itself, with all its doors.
   Move a Black piece through it while it is still White's turn:

   ```java
   game.getBoard().movePiece(game.getBoard().getPieceAt(0, 7), 3, 7);
   ```

   It moves. The black rook goes from `(0,7)` to `(3,7)`. White moves first
   is a rule of this program. Find where it is enforced, the field
   `whiteToMove` of `ChessGame`, checked in `takeTurn`, the helper that
   `play` calls for every move you type, and say which class you just walked
   around. Whose rule should it be?

Discussion:

1. In one sentence, what does `private` buy and what does it not buy? It
   controls who can change the state of an object. Does it control whether a
   change makes sense?
2. `ChessBoard.placePiece` checks its square and refuses by returning
   `false`, and `ChessGame.setupPieces`, which calls it twelve times, never
   looks at the answer. A refused piece would exist off every board and
   nobody would know. Is a `boolean` a loud enough no? Keep your answer for
   session 8, where refusals get a mechanism of their own.

## Exercise 4 — the design review: same tools, other shapes

No new feature this time, and almost no code. Five questions about the design
you have spent the session reading. Each one is a choice somebody made in
`E_ChessGame`, and each one could have been made differently.

Work in pairs, and answer every question in five lines, in this shape:

1. The alternative, in one sentence.
2. What it makes better.
3. What it makes worse. No alternative is free. If you cannot name the cost,
   you have not understood the design you are attacking.
4. What you would have to touch, classes and methods by name, counted the way
   you counted in the cost lines of exercise 1.
5. Your verdict. Change it, keep it, or not with what I know today.

The last verdict is a real answer and it counts like any other. Some of these
questions have no good answer with this session's tools, and noticing that is
the point. What you found missing goes on this week's wish list.

One question this exercise does not ask is how to make the `switch` in
`ChessPiece.isLegalMove` disappear. That one closes the session, and answering
it is the whole of session 3.

### Q1 — should `Movements` be part of `ChessBoard`?

`Movements` holds no state, and each of its three methods takes a `ChessBoard`
as its first parameter. Read one of them as if it were a method of the board,
`board.isLegalDiagonalMove(fromRow, fromCol, toRow, toCol, maxDistance)`. The
board it walks is now `this`, and a parameter disappears, the same one
exercise 0 asked you about. What gets simpler, and what have you taught the
board that it does not know today?

Before you answer that the board knows nothing about chess, read
`ChessBoard.movePiece` again. It already refuses to capture your own piece, in
the check `target.isWhite() == piece.isWhite()`. Is that a rule of boards or a
rule of chess?

### Q2 — `printBoard`: in `ChessGame`, in `ChessBoard`, or in both?

Today it is in both. `ChessBoard.print()` draws the picture, and
`ChessGame.printBoard()` is one line that asks it to. Weigh the three designs.
The drawing only in the game, which then has to walk the squares itself
through `getPieceAt`. Only in the board, so that every caller reaches it
through `getBoard()`. And today's pair.

Then the harder version. The delegation is there so that nobody outside needs
the board. But `ChessGame.getBoard()` is public, and exercise 3 had you use
it. So what does `printBoard` protect today?

### Q3 — whose business is `getSymbol()`?

`'Q'` is not what a queen is, it is how a queen is drawn on this particular
board. `ChessPiece` stores its type and color and derives the letter in
`getSymbol()`, and the only code that ever asks for it is `ChessBoard.print()`.
Should the translation live with the drawing, in the board? Write what
`print()` would look like if it did, and say what the piece loses.

### Q4 — two places remember where the queen stands

`ChessBoard` knows what stands on every square, `pieces[row][col]`. Every
`ChessPiece` also carries its own `row` and `col`. Two copies of one fact,
kept in step by hand inside `ChessBoard.placePiece` and `ChessBoard.movePiece`.
You have met that before. It is session 1's parallel `int[8][8]` again.

Two alternatives, each worth its five lines.

- Only the board knows. The piece loses `row`, `col`, `setRow` and `setCol`.
  What happens then to `ChessPiece.isLegalMove`, which reads `row` and `col`
  to know where the piece starts from? Compare with session 1's signature,
  `isLegalMove(board, fromRow, fromCol, toRow, toCol)`.
- Only the piece knows. The board stops being a grid of squares and becomes a
  collection of pieces that you have to search. What does
  `ChessBoard.getPieceAt` cost then?

And one more question. Your captured queen from exercise 2 still says she is
on `(0,3)`. Does either design make that impossible, or only harder to notice?

### Q5 — how much does `private` really buy?

`ChessBoard.placePiece` is `public`. Make it package-private, that is, drop
the modifier so that the declaration starts with `boolean placePiece`, and
compile. A member with no modifier is visible inside its package and nowhere
else. (Chapter 8, "Packages and Member Access".) Two things happen, and the
second one is the lesson. `ChessGame.setupPieces` still compiles, because
`ChessGame` shares the package. And exercise 3's second-queen attack still
compiles too, because `Demo` shares the package as well.

Session 1's sabotage was stopped by the compiler, and this door is open to
every class in `session2.E_ChessGame`. What would have to change for that
attack to stop compiling? It is not a keyword. So where would `Demo` have to
live?

Discussion:

1. Sort your five verdicts into two piles, taste (two defensible designs, and
   this program picked one) and fault (today's design does not survive the
   argument). Bring one of each to the board.
2. How many verdicts came out "not with what I know today"? Write down what
   you were missing each time. That list is next week's wish list, and the
   global reflection below collects it.
3. Four of these five questions are really the same question, who should be
   responsible for this. Write that sentence down. Session 4 opens with it.

## Exercise 5 — the knights, again (stretch goal)

Session 1's stretch goal, on the new design. Add the knights, `'N'` for White
and `'n'` for Black, starting on `(0,1)`, `(0,6)`, `(7,1)` and `(7,6)`. A
knight moves in an L, two squares along one axis and one along the other, and
it jumps, so there is no path to check. No helper in `Movements` fits, and the
rule goes straight into its `case`.

The places to visit, by name. `ChessGame.setupPieces`, where the initial
position is built. The `switch` in `ChessPiece.isLegalMove`, for the rule. The
two letter translations in `ChessPiece`, `typeFromLetter`, so that
`new ChessPiece('N')` produces a Knight and not a `?`, and `getSymbol`, so that
the board draws an `N`. The legend printed by `ChessBoard.print` can name the
knight too.

Write the cost line for the knight under the bishop's, in your comment in
`Demo.main`, and compare with your session 1 notes before reading on.

You should find more places than the bishop needed, and, depending on your
session 1 solution, possibly more than the knight cost you last week. Look at
where they are. Session 1 had one letter translation, `pieceName`. This design
has two.

Discussion:

1. Split your list. Which places are about the knight's rule, and which about
   its name and letter? The refactor made the rule cheap for a type the
   program already knew; the bishop cost one place. What does it still not
   make cheap?
2. The letter translations exist because a piece type is a `String` while the
   board writes pieces as a `char`. Would you drop the char constructor,
   `ChessPiece(char letter)`, to save a switch? What would
   `ChessGame.setupPieces` look like then? Session 8 dissolves this trade-off,
   with a type that is neither a char nor a free String.

## Global reflection — the wish list, revisited

All notes on the table, session 1's included.

1. Read out your session 1 wish list. Which wishes did this session grant?
   Mark each one. Data and rules in one place, which construct did that?
   Nobody writes the board behind the rules' back, which keyword? The
   compiler tells me when a piece is forgotten, granted or still open?
2. Read the two cost lines in your comment aloud, session 1's and session
   2's. What got cheaper, and what did not move at all? Where exactly does
   the program still say `default:` and stay silent?
3. Write the wish for next week in one sentence. What should a design do so
   that forgetting a piece type is a compile-time error and not a quiet
   `false`? Bring the sentence to session 3. Building four competing answers
   to it is the whole session.
