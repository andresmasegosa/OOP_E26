# Session 5 — Exercises 1, 2 and 3, the game

These exercises start from what you wrote in exercises A and B. Each exercise starts with what
you have to do. The tips are there if you need them.

## Exercise 1 — the knights in the game, and three pieces that move like two

1. Bring the knight of exercise A into the game.
   - Copy `LShape.java` from `A_MoveRule/rules/` into `rules/`, and `Knight.java` from
     `A_MoveRule/` into this folder. The copies belong to this folder's packages now.
   - Place the four knights in `ChessGame.setupPieces`, on `(0,1)`, `(0,6)`, `(7,1)` and `(7,6)`.
   - Add the knight to the legend at the end of `ChessBoard.print`.

   You are done when `Demo` draws the knights as `N` and `n` and the legend names them.
2. Write three pieces from chess variants, each in its own class next to `Knight.java`. A
   Chancellor moves like a rook and like a knight. An Archbishop moves like a bishop and like a
   knight. An Amazon moves like a queen and like a knight. Each class holds the rules its piece
   needs, and none of them writes the L a second time. The three pieces stay out of the game.
3. Write down what the Amazon cost. Copy your three cost lines from the top of session 3's
   `Demo.main` to the top of this `Demo.main`, and add a fourth for the Amazon in this shape.

   ```java
   // Cost of the Amazon, session 5:
   //   places touched: ...   lines in the new class: ...
   //   the same piece in session 3: ...
   ```

### Tips

- In each copy, the `package` line and the `import` line must name `C_ChessGame`. If the compiler
  says that `LShape` cannot be converted to `MoveRule`, one of them still names `A_MoveRule`.
- Try the Amazon on a `ChessBoard` of her own in `Demo.main`, as you tried the knight in exercise
  A. She should answer `true` for a rook's move, a bishop's move and a knight's jump.
- Count one place per method you edited and one per new class, and the lines of `Amazon.java`
  without comments and blank lines. Compare with session 3's Amazon, yours or the one in session
  3's solution.

### Discussion

1. The knight cost more places than the Chancellor, the Archbishop and the Amazon together. Say
   which places the knight needed and the other three did not, and why.
2. Session 3 made the compiler refuse a piece with no rule. This session does not, and a `Knight`
   whose constructor forgets `addRule` compiles and never moves. Say in one sentence what was
   traded for what, and whether you would take the trade.

## Exercise 2 — a player that plays better

1. Before you write any code, read `players/Player.java` and answer these three questions in
   writing.
   - May `Player.chooseMove` return `null`, and what happens if it does?
   - Who checks that a move is legal? Name every class and method that takes part.
   - Is a player that proposes an illegal move asked again, or does it lose its turn?
2. Write `players/GreedyPlayer.java`, a player that plays better than your `CapturePlayer` and
   builds on it.
   - Copy `CapturePlayer.java` from exercise B into `players/`. `GreedyPlayer` extends it.
   - `CapturePlayer` takes the first capture it happens to find. `GreedyPlayer` looks at every
     capture its pieces can make, and makes the one that takes the most valuable enemy piece.
   - When there is no capture on the board, it plays like `CapturePlayer`.
3. Play against it. In the second game of `Demo.main`, the one you play, make `GreedyPlayer` your
   opponent instead of the `RandomPlayer`. You are done when it takes any piece you leave where it
   can reach it.

### Tips

- In the copy of `CapturePlayer`, the `package` and `import` lines must name `C_ChessGame`, as in
  exercise 1.
- To find the captures, walk the board. For each square that holds a piece of yours, look at every
  square that holds an enemy piece, and ask your piece `ChessPiece.isLegalMove` whether it can
  move there.
- Keep the best capture found so far. You choose the values, as long as the king is worth more
  than all the other pieces together.
- When there is nothing to capture, answer `super.chooseMove(board, color)`, which is now
  `CapturePlayer`'s answer. (Chapter 7, "Using super to Access Superclass Members".)
- Once you have seen the machine game in `Demo.main`, you may comment it out, so that your own
  game starts at once.

### Discussion

1. Look at how you decided the values. You almost certainly compared `ChessPiece.getType()` with
   `"Queen"`, `"Rook"` and the rest. Session 3 took the last `switch` on the type out of
   `ChessPiece`, and here it is again in a class of your own. Say what the type of a piece would
   have to be for the compiler to catch a misspelling. Keep the answer for session 8.
2. The rule that you may not capture your own piece is checked twice, at the start of
   `ChessPiece.isLegalMove` and in `ChessBoard.movePiece`. Say which of the two checks you would
   keep if you had to remove one, and why. Then say which class and method hold the rule that
   says whose turn it is.
3. `ChessGame` did not change by one line for `GreedyPlayer`. Would any line of it have had to
   change if `Player` had been an abstract class instead of an interface? Say which classes would
   have changed instead.

## Exercise 3 — the design review

Without writing any code, you judge four decisions in the design of the game, comparing each one
with an alternative, and you draw its class diagram.

The four questions.

- Q1. Who should tell a captured piece that it was captured, the board, the game or the piece
  itself, and what should the piece do about it? Today `ChessBoard.movePiece` writes the capturing
  piece over it, and the captured piece still says it stands on the square where it was taken.
  Session 2 left this question for today, in exercise 2 of its sheet.
- Q2. Should the board know that a console exists? `ChessBoard.print` writes to `System.out`. The
  alternative is a board that returns its picture as a `String` and lets the caller decide what to
  do with it.
- Q3. Who should detect check? Nothing in this game knows what check is, and a game ends when a
  king is captured. Say which class should hold the method, what it needs to look at and what it
  would have to be given. Do not write it.
- Q4. Should `ChessPiece` be an interface? After exercise 1, every piece class holds only a
  constructor and a letter. Weigh two alternatives to today's abstract class, an interface that
  each piece class implements, and one concrete class with no subclasses that is built with the
  rules it is given. Answer once for each alternative.

### Tips

- Answer each question in five lines, as in sessions 2 and 3. They are the alternative in one
  sentence, what it makes better, what it makes worse, what you would have to touch by class and
  method, and your verdict, which can be "change it", "keep it" or "not with what I know today".
- A king is in check when an enemy piece could legally move onto its square. Every part of that
  answer already exists.
- For Q4, say for each design what the pieces share as a type and as code, and what
  `ChessGame.setupPieces` would look like.
- The diagram shows every class and interface of this folder after exercise 1, and which class
  implements, extends and holds which. Write `<<interface>>` above every interface and
  `<<abstract>>` above every abstract class. The class map of session 2 is the shape to follow.
- Work with a partner, and leave at least forty minutes for this exercise.

### Discussion

1. Which verdicts came out "not with what I know today"? Write down what was missing each time.
2. Three of these four questions are about something the game does not have. Say what that
   suggests about when a responsibility question is worth answering.

## Global reflection — four cost lines

All notes on the table, those of sessions 1, 2 and 3 included.

1. Read the four cost lines aloud. Session 3's line was about a piece that moves in a new way.
   Session 5's is about a piece that moves in two ways you already had. Say in one sentence what
   kind of change each design is cheap for.
2. Session 3 left no `switch` anywhere, and exercise 2 put one back in a class of your own. Say
   what all of them had in common, in both sessions. Keep the answer for session 8.
3. Write one wish for the sessions after next. Here is where to look for it. When a piece is
   captured the board forgets it, and the game keeps no list of the moves that have been played.
   Both are the same missing thing, and so is the `new MoveRule[4]` in `ChessPiece` with the
   comment about a fifth rule. Write one sentence saying what you would want to be able to do.
