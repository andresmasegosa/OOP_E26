# Session 3 — Exercises

The code you write in exercises 1 and 2 goes in the folder [`E_ChessGame`](E_ChessGame/). The
demo folders `A_` to `C_` are there to read and run. Exercise 0 takes you through them, and
exercise 3 asks about two of them. A few lines in them are commented out so that you can
uncomment one and see a compiler error, and each file says which ones. Exercises 1 and 3 are the core of
the session. Exercise 2 is a stretch goal. Leave at least forty minutes for exercise 3, and skip
exercise 2 if you have to.

The game is eight classes, one per file. `ChessPiece` is abstract. It holds what every piece
has, the type, the color and the square it stands on, and it declares two methods without a
body, `ChessPiece.isLegalMove` and `ChessPiece.getLetter`. `King`, `Queen` and `Rook` extend
`ChessPiece`, and each one writes its own rule and its own letter. `ChessBoard`, `Movements` and `ChessGame` come from session 2. `ChessBoard` and
`Movements` did not change a line of code. `ChessGame` changed in one method, `ChessGame.setupPieces`,
which now creates each piece directly, `new Rook("Black")` and so on. `Demo` has one method, `main`, and
nothing else.

The naming rules of session 2 still hold. All four folders have a class called `Demo`, and in
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

Run the three demos in order, `A_OneClassPerPiece/Demo`, `B_Inheritance/Demo` and
`C_AbstractClasses/Demo`. Before you run each one, read its `main` and
write down what every `println` will print. For every call to `isLegalMove`, write down as well
the class whose method you expect to run. Then run it and compare. Where you were wrong, the
explanation is in the classes next to that `Demo`.

Each demo folder also has commented lines to uncomment, with the compiler error they produce
written next to them. Do each one, compile, and check that you get that error. Then put the line
back as it was.

- `A_OneClassPerPiece/Demo.java`, the two commented blocks at the end of `main`.
- The commented line in `B_Inheritance/Demo.java`.
- The commented line in `C_AbstractClasses/Demo.java`, and the commented class in
  `C_AbstractClasses/Bishop.java`.

Then open `E_ChessGame/Demo.java`. Its `main` creates a `ChessGame`, plays the scripted game of
seven moves and calls `game.play()`. Run it and read the output line by line. Three things in it
differ from session 2. The bishops are missing from the board. Move 3 of the script is a
different move, because it used to need a bishop. And there is a seventh move, a bishop going
straight up from `(7,2)`, which is refused today because that square is empty. Write down why
you think the bishops are missing, and do not fix it yet. Exercise 1 is about it.

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
  There is a second error, and it names a different method. `ChessPiece` declares two abstract
  methods, not one. Write that one too, the way `Rook` does it, and compile again.
- Now there is a third error, about a constructor. Copy it and write the constructor that fixes
  it, again the way `Rook` does it. (Chapter 7, "Constructors and Inheritance" and "Using super
  to Call Superclass Constructors".) Three errors, one after the other, and each one names
  exactly what is missing.
- Put the bishops back on the board. Place the four in `ChessGame.setupPieces`, on `(0,2)`,
  `(0,5)`, `(7,2)` and `(7,5)`, the squares they had in session 2.

You are done when the sixth move of the scripted game in `Demo.main`,
`game.movePiece(7, 5, 5, 3)`, succeeds and the program prints `White Bishop moves (7,5) -> (5,3)`
instead of the `Illegal move` line, and the seventh move, `game.movePiece(7, 2, 5, 2)`, a bishop
going straight up, still prints an `Illegal move` line. A rule that says yes to every square
passes the sixth move too. The seventh is there to catch it.

Then write down what the change cost you. Copy your two cost lines from the top of session 2's
`Demo.main` to the top of this `Demo.main`, and add a third.

```java
// Cost of the bishop, session 3:
//   places touched: ...   of which switches: ...   did anything warn me: ...
```

The line has three entries. Fill them in like this.

- Places touched is the number of methods you edited, plus one for every new class. Last week a
  place was a method you edited and nothing more, because nothing new was created. This week the
  bishop is a class of her own, so the rule gains that clause. Today `ChessGame.setupPieces` is
  one place, and `Bishop.java` is one more, whatever you wrote inside it.
- Of which switches is how many of those places were a `switch` that needed a new `case` for the
  bishop. Last week the answer was 1. Look through the places you touched today and count.
- Did anything warn me is one answer per place. Write whether the compiler stopped you before the
  program ran, or whether you found that place by reading the code. If a mistake only showed up
  when the program ran, for example the `Illegal move` line of the sixth move because you forgot
  to place the bishops, write that down as well, and say that the compiler did not see it.

Discussion:

1. Put the three lines next to each other. Did the number of places go down this time? If it
   went up, part of the reason is the ruler, which counts a new class this week and had nothing
   to count last week. The rest is in your session 2 notes. When you started exercise 1 of
   session 2, which parts of the bishop were already written, and which part was missing?
2. Session 2 also had a stretch goal that added a type of piece the program did not have at
   all, the knight. Is this bishop more like session 2's bishop or like session 2's knight?

## Exercise 2 — the knights and the Amazon (stretch goal)

Add the knights on `(0,1)`, `(0,6)`, `(7,1)` and `(7,6)`. Their letter is `N`. You write only
the uppercase letter, in `Knight.getLetter`, because `ChessPiece.getSymbol` lowercases it for
Black by itself, as it does for every piece. A knight moves in an L, two squares along one axis
and one along the other, and it jumps, so there is no path to check.

Then run the game and read the legend under the board, the last line that `ChessBoard.print`
writes. It does not name the knight, and nothing sent you there. Add the knight to it. That line
is one more place, and the compiler did not find it, so count it in the knight's cost line.

Write the cost line of the knight under the bishop's. If you did session 2's stretch goal,
compare it with the knight's line from then. Which places did the compiler find for you, and
which did you have to find yourself?

Then the Amazon, a piece from chess variants that moves like a queen and like a knight. Write
`Amazon extends Queen`, and in `Amazon.isLegalMove` call `super.isLegalMove(board, toRow, toCol)`
for the queen's part. You need the knight's L a second time. Do not copy it. Find a place where
`Knight` and `Amazon` can both use it.

Her name needs one more step. `Amazon`'s constructor has to call a constructor of `Queen`, and
`Queen(String color)` passes the word `"Queen"` up to `ChessPiece`, so an Amazon built through it
is called Queen and is drawn as `Q`. Give `Queen` a second constructor,
`protected Queen(String type, String color)`, that passes both words up, and call that one from
`Amazon` with `"Amazon"`. It is `protected` because only a subclass has a reason to use it.
Write `Amazon.getLetter` too, with `'A'`. (Chapter 6, "Overloading Constructors".)

You do not have to put an Amazon in the game. Try her on a `ChessBoard` of her own, in
`Demo.main`, before the scripted game, and print her type and her symbol.

Discussion:

1. Where did you put the L so that both classes use it? Is there a better place?
2. A Chancellor moves like a rook and like a knight. Should it extend `Rook` or `Knight`? Keep
   the answer for the global reflection at the end.

## Exercise 3 — the design review

No new feature this time, and almost no code. Two questions about choices in this session's
design. Work in pairs, and answer each question in five lines, in the same shape as in
session 2.

1. The alternative, in one sentence.
2. What it makes better.
3. What it makes worse. If you cannot name the cost, you have not understood the design you are
   attacking.
4. What you would have to touch, classes and methods by name.
5. Your verdict. Change it, keep it, or not with what I know today.

### Q1 — should `ChessPiece.isLegalMove` have a body?

The demo folders `B_Inheritance` and `C_AbstractClasses` are the two designs. In `B_Inheritance`,
`ChessPiece.isLegalMove` answers `false` unless a subclass overrides it. In `C_AbstractClasses`
it is abstract, and the game uses that one. Is there any piece, in chess or in a variant you can
imagine, for which a default answer would be the right one? And what does a default cost the
next person who adds a type of piece?

### Q2 — should `Queen` extend `Rook`?

A queen moves like a rook, and diagonally as well. With `Queen extends Rook`, `Queen.isLegalMove`
could call `super.isLegalMove(board, toRow, toCol)` for the straight lines and add only the
diagonals. (Chapter 7, "Using super to Access Superclass Members".) Weigh it. The sentence "a
queen is a rook" becomes true in the program. Where would that be false in chess? Think of every
place where the program holds a `Rook`.

Discussion:

1. Q2 ends in a wish. A queen moves like a rook and like a bishop, and a class can extend only
   one class. Write down, in one sentence, what you would want the language to let you do.
   Session 4 starts from that sentence.
2. Which verdicts came out "not with what I know today"? Write down what was missing each time.

## Global reflection — three cost lines

All notes on the table, those of sessions 1 and 2 included.

1. Read the three cost lines of the bishop aloud, and the knight's if you have it. Where did the
   compiler start to help, and which places did it still not find?
2. Session 2's wish was that forgetting a type of piece should be a compile-time error. Mark what
   this session granted and what it did not.
3. Write two wishes for next week, one sentence each. The first is about a piece that moves like
   two pieces without copying code. The second is about the game. What would have to change in
   `ChessGame` so that you could play against the computer instead of a classmate? Bring both
   sentences to session 4.
