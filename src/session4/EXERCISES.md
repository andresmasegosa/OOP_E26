# Session 4 — Exercises

Every exercise works in the folder [`C_ChessGame`](C_ChessGame/). The demo folders
[`A_MoveRule`](A_MoveRule/) and [`B_Player`](B_Player/) are there to read and run. Two lines in
them are meant to be uncommented to see a compiler error, and each file says which ones and what
the error is. Exercises 1 and 3 are the core of the session. Leave at least forty minutes for
exercise 3.

The game is fifteen files in three packages. `C_ChessGame` itself holds the pieces, the board and
the game; `C_ChessGame.rules` holds `MoveRule` and the two classes that implement it;
`C_ChessGame.players` holds `Player` and the two classes that implement it. Two interfaces, then:
`MoveRule` says that something can decide whether the geometry of a move is allowed, and `Player`
says that something can choose a move. `ChessPiece` is still abstract and `King`,
`Queen`, `Rook` and `Bishop` still extend it, exactly as in session 3, but none of them writes an
`isLegalMove` any more. Each one says its name, its letter and its ways of moving, and
`ChessPiece.isLegalMove` asks the rules. `ChessBoard` is session 3's file, unchanged. `Movements` does not
exist any more. `ChessGame` lost the keyboard and gained two players.

The naming rules of the earlier sessions still hold. Both demo folders have a class called `Demo`,
and in this sheet `Demo` always means the one in `C_ChessGame`, with `Demo.main` its `main`
method. That is where the code you write goes, unless an exercise says otherwise. Methods are
written with their class in front. `ChessPiece.isLegalMove` is the one every piece uses,
`MoveRule.allows` is what a rule answers, and `Player.chooseMove` is what a player is asked.

You need your notes from sessions 1, 2 and 3 on the table, and in particular the three cost lines
at the top of session 3's `Demo.main`. Each exercise ends with a short discussion, first in pairs
and then with the class, and the session closes with a global reflection. Write your notes as you
go. Where a question rests on the book, the section is given in brackets. The book is *Java: A
Beginner's Guide*, 8th edition, and this week's chapter is chapter 8.

## Exercise 0 — warm-up: which lines compile?

Run the two demos in order, `A_MoveRule/Demo` and `B_Player/Demo`. Before you run each one, read
its `main` and write down what every `println` will print.

Each demo folder also has lines to uncomment, with the compiler error they produce written next to
them. There are two. Do each one, compile, check that you get that error, and then put the line
back as it was.

- `A_MoveRule/Demo.java`, the commented line at the end of `main`.
- `B_Player/Demo.java`, the commented line at the end of `main`.
- `B_Player/Demo.java` also has a line that is not an error. Swap `RandomPlayer` for
  `KeyboardPlayer` as the comment says, run it, and put it back.

Then open `C_ChessGame/Demo.java` and run it. Two `RandomPlayer` objects play a whole game, a
different one every time, and then you play against one of them. The machine game ends by itself
when a king is captured, and two players this bad can take a hundred moves to find one, so watch
as much of it as you need and stop it if you want. Several moves are refused along the way. A `RandomPlayer` looks at the board and only proposes
moves that the piece's own rules allow, so write down where the refused ones came from, and which
class knows the rule that refused them.

Discussion. Bring it answered in writing.

1. Open `session3/E_ChessGame/ChessBoard.java` and this session's side by side. Apart from the
   package line they are the same file, although every piece on that board was rewritten. Then
   look for `Movements.java` in this session; it is not there. Session 3's had three static
   methods. Say where each of them is now, by class name, and say in one sentence what a rule
   object has that a static method did not.

## Exercise 1 — the knights, and three pieces that move like two

Session 3 ended with a wish. A piece that moves like two pieces, without copying code. In session 3
the Amazon had to extend `Queen` and borrow the knight's L from somewhere. Here a piece holds its
ways of moving, so moving like two pieces is holding two rules.

Work in this order.

- Write `C_ChessGame/rules/LShape.java`, a `MoveRule` for the knight's move, two squares along one
  axis and one along the other. A knight jumps, so there is no path to walk. It is the first rule
  that does not look at the board at all, and the shortest of the three.
- Write `C_ChessGame/Knight.java`, a subclass of `ChessPiece`. It goes in the package next to the
  other pieces, not in `rules/`, and it will need an `import` line for the rule it uses. Start with an empty class, only the
  package line and `public class Knight extends ChessPiece { }`, and compile. Session 3's exercise
  1 met three compiler errors in a row. Here you meet two, and the third is missing on purpose.
  Copy both into your notes.
- Now finish the class and put the knights on the board: place the four in `ChessGame.setupPieces`,
  on `(0,1)`, `(0,6)`, `(7,1)` and `(7,6)`. Run `Demo` and make sure they are drawn as `N` and `n`.
- Now the third error that never came. Comment out the `addRule` line in your `Knight` constructor
  and compile. It compiles. Run it and watch a knight. Write down in one sentence what happened
  and why the compiler said nothing. Then put the line back.
- Then the three pieces from chess variants. A Chancellor moves like a rook and like a knight. An
  Archbishop moves like a bishop and like a knight. An Amazon moves like a queen and like a knight.
  Write the three classes. None of them may contain the L a second time. You do not have to put
  them in the game; try an Amazon on a `ChessBoard` of her own in `Demo.main`, before the machine
  game.

Then write down what it cost. Copy your three cost lines from the top of session 3's `Demo.main`
to the top of this `Demo.main`, and add a fourth.

```java
// Cost of the Amazon, session 4:
//   places touched: ...   lines in the new class: ...
//   the same piece in session 3: ...
```

Count as before. Places touched is the number of methods you edited, and a new class counts as one
place. For the last line, compare it with the Amazon of session 3's stretch goal, either the one
you wrote or the one in session 3's published solution.

Discussion:

1. The knight cost more than the Chancellor, the Archbishop and the Amazon together. Say which
   places the knight needed and the other three did not, and why.
2. Session 3 made the compiler refuse a piece with no rule. This session does not. Say in one
   sentence what was traded for what, and whether you would take the trade.

## Exercise 2 — a player that plays better

`ChessGame` asks a `Player` for a move and does not care what a `Player` is. Prove it: write a
better one, and beat the one that comes with the game.

Read the javadoc of `Player.chooseMove` first, before you write a line. It is the whole of what a
`Player` is promised and the whole of what it must deliver, because an interface has no code to
read instead. Answer these three in writing.

1. May `chooseMove` return `null`, and what happens if it does?
2. Who checks that the move is legal? Name the class and the method.
3. What happens when a player proposes an illegal move? Is it asked again, or does it lose its
   turn?

Then write `C_ChessGame/players/GreedyPlayer.java`. It takes an enemy piece when it can, and plays like
`RandomPlayer` when it cannot.

- It extends `RandomPlayer`, so when it finds nothing to capture it can answer
  `super.chooseMove(board, color)` and be done. (Chapter 7, "Using super to Access Superclass
  Members".)
- To find a capture it walks the board it was handed: for each square holding a piece of its own
  colour, and each square holding an enemy piece, it asks the first piece whether its rules allow
  the move.
- When several captures are possible it takes the most valuable enemy piece. You decide the
  values. Nine for a queen, five for a rook and three for a bishop is the usual scale, and the
  king is worth more than all of them together.
- Then change one of the two arguments of `new ChessGame(...)` at the bottom of `Demo.main` and
  play a game against it.

You are done when a game runs from the first move to a quit, with you on one side and
`GreedyPlayer` on the other, and it takes any piece you leave where it can reach it.

Discussion:

1. Look at how you decided the values. You almost certainly compared `getType()` with `"Queen"`,
   `"Rook"` and the rest. Session 3 took the last `switch` on the type out of `ChessPiece`, and
   here it is again in a class of your own. Say what the type of a piece would have to be for the
   compiler to catch a misspelling. Keep the answer for session 8.
2. `GreedyPlayer` looks at the board and `RandomPlayer` looks at it less. Neither can ask whose
   turn it is, and neither can ask whether the target is one of its own pieces. Say why not, and
   where those two rules live.
3. `ChessGame` was written before `GreedyPlayer` existed and did not change by one line. Which
   line of `ChessGame` would have had to change if `Player` had been an abstract class instead of
   an interface?

## Exercise 3 — the design review: who is responsible for what

No new feature, and almost no code. Four questions about who should hold something, and a diagram.
Each one is a question the code itself has been carrying since an earlier session; the javadoc that
asks it is named. Work in pairs, and answer each question in five lines, in the same shape as in
sessions 2 and 3.

1. The alternative, in one sentence.
2. What it makes better.
3. What it makes worse. If you cannot name the cost, you have not understood the design you are
   attacking.
4. What you would have to touch, classes and methods by name.
5. Your verdict. Change it, keep it, or not with what I know today.

### Q1 — who tells the captured piece?

Session 2 left this question for today, in exercise 2 of its sheet. `ChessBoard.movePiece` writes
the capturing piece into the square, and the captured piece is simply no longer in the array. The
object is still alive, it still says it stands on the square it was taken on, and nobody told it
anything. Who should tell it, the board, the game or the piece itself? And what should the piece do
about it?

### Q2 — should the board know that a console exists?

The javadoc of `ChessBoard.print` has been asking this since session 3. It writes to `System.out`.
Consider a board that returns its picture as a `String` and lets the caller decide what to do with
it. Session 7 will hand you a second reason to prefer one of the two; do not go looking for it,
decide with what you have today.

### Q3 — who detects check?

Nothing in this game knows what check is, and a game ends here when a king is captured, which is
not how chess works. A king is in check when some enemy piece could legally move onto its square.
Every part needed for that answer already exists. Say which class should hold the method, what it
needs to look at, and what it would have to be given. Do not write it.

### Q4 — should `ChessPiece` be an interface?

After exercise 1, `Knight`, `Bishop` and `Chancellor` hold nothing but a constructor and a letter,
and every piece's behaviour lives in its rules. So consider `ChessPiece` as an interface, with the
colour, the square and the rules held by each class that implements it. And consider the other end
too, one concrete `ChessPiece` class with no subclasses at all, built with the rules it is given.
Three designs, and the game uses the middle one.

Then the diagram. Draw the classes of `C_ChessGame` as they stand after exercise 1, with
`<<interface>>` above every interface and `<<abstract>>` above every abstract class. Show which
class implements which interface, which class extends which, and which class holds which. The class
map handed out in session 2 is the shape to follow.

Discussion:

1. Which verdicts came out "not with what I know today"? Write down what was missing each time.
2. Three of these four questions are about something the game does not have. Say what that
   suggests about when a responsibility question is worth answering.

## Global reflection — four cost lines

All notes on the table, those of sessions 1, 2 and 3 included.

1. Read the four cost lines aloud. Session 3's line was about a piece that moves in a new way.
   Session 4's is about a piece that moves in two ways you already had. Say in one sentence what
   kind of change each design is cheap for.
2. Session 3 left no `switch` anywhere, and exercise 2 put one back in a class of your own. Say
   what all of them had in common, in both sessions. Keep the answer for session 8.
3. Write one wish for the sessions after next. Here is where to look for it. When a piece is
   captured the board forgets it, and the game keeps no list of the moves that have been played.
   Both are the same missing thing, and so is the `new MoveRule[4]` in `ChessPiece` with the
   comment about a fifth rule. Write one sentence saying what you would want to be able to do.
