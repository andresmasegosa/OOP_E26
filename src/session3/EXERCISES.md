# Session 3 — Exercises

Every exercise works in the folder [`E_ChessGame`](E_ChessGame/). Exercise 3 also asks you
to create a package of your own, and it says where. The demo folders `A_` to `D_` are there to
read and run. A few lines in them are meant to be uncommented or edited to see a compiler error,
and each file says which ones. Exercises 1, 2 and 3 are the core of the session; do them in
order. Exercise 4 is written work, a design review with almost no code, and exercise 5 is a
stretch goal.

The game is eight classes, one per file. `ChessPiece` is abstract. It holds what every piece
has, the type, the color and the square it stands on, and it declares `ChessPiece.isLegalMove`
without a body. `King`, `Queen` and `Rook` extend `ChessPiece`, and each one writes its own
`isLegalMove`. `ChessBoard`, `Movements` and `ChessGame` come from session 2. `ChessBoard` and
`Movements` did not change at all. `ChessGame` changed in one method, `ChessGame.setupPieces`,
which now asks `ChessPiece.fromLetter` for each piece. `Demo` has one method, `main`, and
nothing else.

The naming rules of session 2 still hold. All five folders have a class called `Demo`, and in
this sheet `Demo` always means the one in `E_ChessGame`, with `Demo.main` its `main` method.
That is where the code you write goes, unless an exercise says otherwise. Methods are written
with their class in front, and this matters more than last week. Four classes of the game now
have a method called `isLegalMove`. `ChessPiece.isLegalMove` is the abstract one, and
`Queen.isLegalMove` is the queen's rule, in `E_ChessGame/Queen.java`.

You need your notes from sessions 1 and 2 on the table, and in particular the two cost lines at
the top of session 2's `Demo.main`. Each exercise ends with a short discussion, first in pairs
and then with the class, and the session closes with a global reflection. Write your notes as
you go. Where a question rests on the book, the section is given in brackets. The book is
*Java: A Beginner's Guide*, 8th edition, and this week's chapter is chapter 7.

## Exercise 0 — warm-up: which method runs?

Run the four demos in order, `A_OneClassPerPiece/Demo`, `B_Inheritance/Demo`,
`C_Overriding/Demo` and `D_AbstractClasses/Demo`. Before you run each one, read its `main` and
write down what every `println` will print. For every call to `isLegalMove`, write down as well
the class whose method you expect to run. Then run it and compare. Where you were wrong, the
explanation is in the classes next to that `Demo`.

Each demo folder also has lines to uncomment or change, with the compiler error they produce
written next to them. Do each one, compile, and check that you get that error. Then put the line
back as it was.

- `A_OneClassPerPiece/Demo.java`, the two commented blocks at the end of `main`.
- `B_Inheritance/Queen.java`, the line in `Queen.isLegalMove` that reads the row, and the two
  commented lines in `B_Inheritance/Demo.java`.
- `C_Overriding/King.java`. Run `C_Overriding/Demo` first, then follow the steps in the comment
  at the top of `King.java`. Fix the name as the comment says, and leave it fixed.
- The commented line in `D_AbstractClasses/Demo.java`, and the commented class in
  `D_AbstractClasses/Bishop.java`.

Then open `E_ChessGame/Demo.java`. Its `main` creates a `ChessGame`, plays the scripted game of
six moves and calls `game.play()`. Run it and read the output line by line. Two things in it
differ from session 2. The bishops are missing from the board, and one piece is called by the
wrong name. Write both down. Exercise 1 is about the first and exercise 2 about the second, so
do not fix anything yet.

Discussion. Bring both answered in writing.

1. `ChessBoard.movePiece` asks the piece `piece.isLegalMove(this, toRow, toCol)`. The variable
   `piece` has the type `ChessPiece`, and `ChessPiece.isLegalMove` has no body. So which code
   runs when the scripted game moves the white queen, in its first move? Say how Java decides,
   and when it decides, while compiling or while the program runs. (Chapter 7, "Method
   Overriding" and "Overridden Methods Support Polymorphism".)
2. Open `session2/E_ChessGame/ChessBoard.java` and `session3/E_ChessGame/ChessBoard.java` side
   by side. Apart from the package line and two comments, they are the same file. In session 2
   every piece was a `ChessPiece`, and now a piece is a `King`, a `Queen` or a `Rook`, and the
   board did not change a line. Why did it not have to? Find the line of `ChessBoard.movePiece`
   that would have had to change if the board had asked a piece what type it is.

## Exercise 1 — wake up the bishops. A third time.

Same job as in sessions 1 and 2. A bishop moves diagonally, any number of squares, and never
through another piece. This time the bishops are not even on the board, and that comes from the
design. In session 2 a bishop was a `ChessPiece` whose type no `case` knew. Here `ChessPiece` is
abstract, so a bishop has to be an object of some subclass, and there is no `Bishop` class yet.
This design does not let a piece exist without its rule.

Work in this order.

- Create `E_ChessGame/Bishop.java` with an empty class, only the package line and
  `public class Bishop extends ChessPiece { }`, and compile. Copy the error into your notes. It
  is the wish you wrote at the end of session 2, answered by the compiler. (Chapter 7, "Using
  Abstract Classes".)
- Write `Bishop.isLegalMove`, with `@Override` above it. `Queen.isLegalMove` and
  `Rook.isLegalMove` show the shape, and `Movements` has the helper you need. Compile again.
  There is a new error, about a constructor. Copy it too, and write the constructor that fixes
  it, the way `Rook` does it. (Chapter 7, "Constructors and Inheritance" and "Using super to
  Call Superclass Constructors".)
- Put the bishops back on the board. Teach `ChessPiece.fromLetter` the letter `B`, and place the
  four bishops in `ChessGame.setupPieces`, on `(0,2)`, `(0,5)`, `(7,2)` and `(7,5)`, the squares
  they had in session 2.

You are done when the sixth move of the scripted game in `Demo.main`,
`game.movePiece(7, 5, 5, 3)`, succeeds and the program prints `White Bishop moves (7,5) -> (5,3)`
instead of the `Illegal move` line.

Then write down what the change cost you. Copy your two cost lines from the top of session 2's
`Demo.main` to the top of this `Demo.main`, and add a third.

```java
// Cost of the bishop, session 3:
//   places touched: ...   of which switches: ...   did anything warn me: ...
```

Count as you did last week. Places touched is the number of methods you edited, and a new class
counts as one place. Of which switches is how many of them were a `switch` that had to learn
about bishops. For did anything warn me, say for which places the compiler told you and for
which it did not.

Discussion:

1. Put the three lines next to each other. Did the number of places go down this time? If it
   went up, look for the reason in your session 2 notes. When you started exercise 1 of
   session 2, which parts of the bishop were already written, and which part was missing?
2. Before you added the new `case`, what did `ChessPiece.fromLetter('b')` return? The compiler
   warned you about the rule. Did anything warn you about the letter? Keep the answer for
   exercise 4.
3. Session 2 also had a stretch goal that added a type of piece the program did not have at
   all, the knight. Is this bishop more like session 2's bishop or like session 2's knight?

## Exercise 2 — the queen who says she is a king

Your notes from exercise 0 name a piece that is called by the wrong name. Find out why. Start
from the output. The messages are built in `ChessGame.movePiece` from `ChessPiece.getType()`,
and the board draws the letters it gets from `ChessPiece.getSymbol()`. Follow the type back to
where it is set. The mistake is one word, and it is also a mistake that the material of an
earlier year of this course really had.

- Fix the word, run `Demo`, and check that the board and the messages are right again.

The one-word fix does not end the exercise. The mistake was possible because this design stores
one fact twice. The class of the object says what the piece is, the String `type` says it again,
and nothing makes the two agree. Question Q4 of session 2's design review was about a fact
stored in two places, the square of a piece. This is the same problem, and this time you have
the tool to remove it.

- Remove the String. `ChessPiece` loses the field `type`, and its constructor loses that
  parameter. Each subclass says for itself what it is.
- Remove the `switch` in `ChessPiece.getSymbol` as well. Each subclass knows its own letter. The
  rule that black pieces print in lowercase is the same for every piece, so decide where that
  rule lives, and write it only once.
- Let the compiler watch the name and the letter the way it watches the rule. What every
  subclass has to provide is declared `abstract` in `ChessPiece`, and the compiler will then find
  every class that is missing something.

You are done when `ChessPiece` has no field `type` and no `switch` in `getSymbol`, every
subclass gives its own name and letter, the scripted game prints the right names, and the board
draws `Q` and `q` for the queens.

Discussion:

1. How many places did the fix touch, and how many places will it save the next time a type of
   piece is added? Write both numbers down. Exercise 5 lets you check the second one.
2. Which of your new methods are `abstract`, and which did you keep in `ChessPiece` with a body?
   Why? A method with a body in `ChessPiece` that calls an abstract method is a shape you will
   see again. Did you end up with one?
3. `ChessPiece.fromLetter` still has a `switch`. Why can it not go the same way as the one in
   `getSymbol`?

## Exercise 3 — the saboteur is a subclass now

In session 1 the saboteur wrote straight onto the array. In session 2 the compiler stopped that,
and you audited every door of `ChessBoard` and `ChessPiece`. Inheritance opens a door that was
not on your list, because anyone can write a subclass.

Create a new package next to `E_ChessGame`, called `cheats`. In IntelliJ that is a new package
`session3.cheats`, the folder `src/session3/cheats`. Classes there live outside the package
`session3.E_ChessGame`, so they are not trusted the way `Demo` is. (Chapter 8, "Packages and
Member Access" and "Understanding Protected Members", from last week's reading.)

- In `session3.cheats`, write a class `CheatingRook` that extends `Rook` and overrides
  `isLegalMove` so that it always returns `true`. It needs an `import` for each class of
  `E_ChessGame` it uses.
- In `Demo.main`, where the comment `EXERCISE 3` is, put a white `CheatingRook` on the empty
  square `(4,4)` with `game.getBoard().placePiece(...)`, and then move it with
  `game.movePiece(4, 4, 0, 0)`. Run, and write down what happens.
- Stop it without touching `CheatingRook.java`. Find the word you can add to `Rook.java` so that
  `CheatingRook` no longer compiles, and copy the compiler's message. The word works in two
  different places of `Rook.java`. Try both, and copy both messages. (Chapter 7, "Using final".)

The second attack does not override anything. It calls.

- In `session3.cheats`, write a class `CheatingKing` that extends `King` and adds one public
  method, `teleport(int row, int col)`, which calls `setRow(row)` and `setCol(col)`. It
  compiles, because both methods are `protected` and `CheatingKing` is a subclass.
- In `Demo.main`, replace the rook of the first attack with a white `CheatingKing` on `(4,4)`,
  call `teleport(0, 7)` on it, then `game.movePiece(4, 4, 1, 7)`, and print the board with
  `game.printBoard()`. Look at the squares `(4,4)`, `(1,7)` and `(0,7)`. Which invariant of the
  board broke? The three invariants are written at the top of `ChessBoard.java`. Then read
  `ChessBoard.movePiece` and find the line that trusted the piece.
- `final` cannot stop this attack. Find what does. Change the visibility of `ChessPiece.setRow`
  and `ChessPiece.setCol` so that `ChessBoard` can still call them and `CheatingKing` cannot,
  and copy the compiler's message. Is it the message you expected? (Chapter 8, "Packages and
  Member Access", Table 8-1.)

When you are done, comment out or delete the two cheating classes and the lines you added to
`Demo.main`, so that the project compiles again.

Discussion:

1. `final` stopped the first attack and not the second. Say in one sentence what `final`
   forbids, and what it does not forbid. Then say in one sentence what `protected` opens, and to
   whom.
2. `CheatingRook` extended `Rook`, and you made that impossible. Could a saboteur extend
   `ChessPiece` directly instead? Try it in `session3.cheats` if you want. What in
   `ChessPiece.java` would you have to change to stop that? Look at its constructor.
3. Before you changed the visibility, add a second method to `CheatingKing` that takes a
   `ChessPiece` as a parameter and calls `setRow` on it, and compile. `CheatingKing` is a
   subclass and `setRow` was `protected`. The compiler's answer surprises most people. Explain
   it in one sentence.

## Exercise 4 — the design review

No new feature this time, and almost no code. Three questions about choices in this session's
design. Work in pairs, and answer each question in five lines, in the same shape as in
session 2.

1. The alternative, in one sentence.
2. What it makes better.
3. What it makes worse. If you cannot name the cost, you have not understood the design you are
   attacking.
4. What you would have to touch, classes and methods by name.
5. Your verdict. Change it, keep it, or not with what I know today.

### Q1 — should `ChessPiece.isLegalMove` have a body?

The demo folders `C_Overriding` and `D_AbstractClasses` are the two designs. In `C_Overriding`,
`ChessPiece.isLegalMove` answers `false` unless a subclass overrides it. In `D_AbstractClasses`
it is abstract, and the game uses that one. Is there any piece, in chess or in a variant you can
imagine, for which a default answer would be the right one? And what does a default cost the
next person who adds a type of piece?

### Q2 — should `Queen` extend `Rook`?

A queen moves like a rook, and diagonally as well. With `Queen extends Rook`, `Queen.isLegalMove`
could call `super.isLegalMove(board, toRow, toCol)` for the straight lines and add only the
diagonals. (Chapter 7, "Using super to Access Superclass Members".) Weigh it. The sentence "a
queen is a rook" becomes true in the program. Where would that be false in chess? Think of every
place where the program holds a `Rook`. And what happens to your fix of exercise 3?

### Q3 — where should letters be turned into pieces?

After exercise 2, `ChessPiece.fromLetter` holds the only `switch` on the type of a piece left in
the game. It lives in `ChessPiece`, so the superclass has to know every one of its subclasses.
Weigh the alternatives. It stays in `ChessPiece`. It moves to `ChessGame`, next to
`ChessGame.setupPieces`, its only caller. Or it disappears, and `ChessGame.setupPieces` writes
`new Rook("Black")` directly. What does each one cost the next time a type of piece is added?
Which of them can the compiler check?

Discussion:

1. Q2 ends in a wish. A queen moves like a rook and like a bishop, and a class can extend only
   one class. Write down, in one sentence, what you would want the language to let you do.
   Session 4 starts from that sentence.
2. Which verdicts came out "not with what I know today"? Write down what was missing each time.

## Exercise 5 — the knights and the Amazon (stretch goal)

Add the knights, `'N'` for White and `'n'` for Black, on `(0,1)`, `(0,6)`, `(7,1)` and `(7,6)`.
A knight moves in an L, two squares along one axis and one along the other, and it jumps, so
there is no path to check.

Write the cost line of the knight under the bishop's. If you did session 2's stretch goal,
compare it with the knight's line from then. Which places did the compiler find for you this
time, now that exercise 2 is done?

Then the Amazon, a piece from chess variants that moves like a queen and like a knight. Write
`Amazon extends Queen`, and in `Amazon.isLegalMove` call `super.isLegalMove(board, toRow, toCol)`
for the queen's part. You need the knight's L a second time. Do not copy it. Find a place where
`Knight` and `Amazon` can both use it. You do not have to put an Amazon in the game. Try her on a
`ChessBoard` of her own, in `Demo.main`, before the scripted game.

Discussion:

1. Where did you put the L so that both classes use it? Is there a better place?
2. A Chancellor moves like a rook and like a knight. Should it extend `Rook` or `Knight`? Keep
   the answer next to the wish of exercise 4.

## Global reflection — three cost lines

All notes on the table, those of sessions 1 and 2 included.

1. Read the three cost lines of the bishop aloud, and the knight's if you have it. Where did the
   compiler start to help, and which places did it still not find?
2. Session 2's wish was that forgetting a type of piece should be a compile-time error. Mark what
   this session granted and what it did not. Where does the program still say `default:` and
   stay silent?
3. Write two wishes for next week, one sentence each. The first is about a piece that moves like
   two pieces without copying code. The second is about the game. What would have to change in
   `ChessGame` so that you could play against the computer instead of a classmate? Bring both
   sentences to session 4.
