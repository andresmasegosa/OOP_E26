# Session 1 — Exercises

Every exercise changes one single file, [`E_ChessGame.java`](E_ChessGame.java).
The demo files `A_` to `D_` are there to read and run, never to edit.
Exercises 1, 3 and 4 are the core of the session; do them in order. Exercise 2
is a stretch goal.

Each exercise ends with a short discussion, first in pairs and then with the
class, and the session closes with a global reflection that uses your notes
from all of them. So write your notes down as you go.

## Exercise 0 — warm-up: make the code yours

Run the files `A_` to `E_`. Then, in the `main` method of
[`E_ChessGame.java`](E_ChessGame.java):

- Add two moves of your own to the scripted game, one legal and one illegal.
  Predict the output before you run.
- Play a full game with a classmate until one king falls.

## Exercise 1 — wake up the bishops

The bishops are on the board, but the program does not know how they move:
diagonally, any number of squares. Teach it.

Work in [`E_ChessGame.java`](E_ChessGame.java) and only there. A good place to
start reading is `isLegalMove`, although it is not the only place you will end
up touching. You are done when the move `movePiece(board, 7, 5, 5, 3)` in
`main` succeeds.

Once it does, run the program and read the output carefully. It says

`White ? moves (7,5) -> (5,3)`

That `?` comes from `pieceName`, the method that turns a piece letter into a
name for the printed messages. Nobody taught it the bishop either. Fix that
too.

Then write down what this change cost you. Not lines of code; the shape of the
change. How many different methods did you end up editing? How many of them
were a `switch` that had to learn about bishops? Keep the notes, because we
will make this exact change again on better designs of the same game, and
compare.

Discussion:

1. Did anything in the program warn you that the bishop was missing, or did
   you have to hunt for the places one by one? Both failures you just fixed, a
   bishop that cannot move and a bishop called `?`, were silent. What would
   you want to happen instead when a piece type is forgotten somewhere? Keep
   your answer. In session 3 we build a version where forgetting a piece is a
   compile-time error.
2. Imagine the program grows more switches of this kind: a point value per
   piece, a Unicode symbol per piece. Adding one new piece type then means
   touching how many places? And who keeps the list of those places?

## Exercise 2 — the knights (stretch goal)

Add the knights: `'N'` for White, `'n'` for Black, starting on `(0,1)`,
`(0,6)`, `(7,1)` and `(7,6)`.

Work again in [`E_ChessGame.java`](E_ChessGame.java). Start in `setupBoard`,
which builds the initial position; after Exercise 1 you already know where the
rest hides. A knight moves in an L, two squares along one axis and one along
the other. And unlike every other piece, the knight jumps, so there is no path
to check at all. Record the cost of the change again, the same way as in
Exercise 1.

Discussion:

1. Was this change easier or harder than the bishops? What does that tell you
   about where this program is heading as it grows?
2. The knight is the first piece whose rule does not fit the three
   `isLegal...Move` helpers, because there is no path to check. Where did its
   rule end up in your code? And is `isLegalMove` getting easier or harder to
   read?

## Exercise 3 — count the moves

Your chess club wants statistics: how many times has each piece moved?

This is the first exercise where the design is yours. There are no objects in
this program, a piece is just a `char` inside an array, so the central
question is where you store each piece's counter. Think about it and sketch
your idea before writing any code, and if you can, compare it with a
classmate's first. There is more than one workable answer, and they fail in
different ways. That is exactly what we want to see.

Work in [`E_ChessGame.java`](E_ChessGame.java). You will touch at least
`movePiece`, which is where a move actually happens.

- When a piece moves, print its counter: `White Queen has now moved 3 times`.
- Decide what must happen to the counter of a piece that gets captured, and
  make your code do it.
- Then answer two questions using your program: how many times has the white
  queen moved so far? And how many times has each of the two white rooks
  moved?

Discussion:

1. Compare storage designs with your classmates. To answer about the queen,
   did you have to search the board for her? And the rooks: can your storage
   tell one rook from the other at all? What would "the first rook" even mean
   in this program?
2. Where does your storage live? Created in `main` and handed to `movePiece`
   as a parameter, or a `static` variable at the top of the class? What did
   that choice cost you?
3. The counter is information about one piece, yet neither the piece's letter
   nor its square is a way to hold on to that piece over time. If the club
   asks for a second statistic tomorrow, say squares traveled, what do you
   have to add and keep in sync? Write down in one sentence what this program
   is missing. Session 2 gives it a name, and a variable that keeps pointing
   at the same queen wherever she goes.

## Exercise 4 — the sabotage

The two saboteur lines are already written for you in the `main` method of
[`E_ChessGame.java`](E_ChessGame.java); search the file for `EXERCISE 4`. They
put a second white queen on the board out of nowhere. Uncomment them and run.

Discussion:

1. `movePiece` carefully enforces the rules of chess, and the saboteur simply
   did not go through `movePiece`. Why did no rule stop it?
2. Which parts of the program are able to write on the board array? And which
   parts should be able to? Write your answer down in one sentence. Session 2
   has a name for it.

## Global reflection — the state of this program

Do this at the end, with all your notes on the table. The program works. You
played it, and you extended it three times. So the question is no longer
whether it works. The question is what it costs to keep working on it.

1. Pick one piece, say the bishop, and list every place in the program that
   knows something about bishops: how it moves, what it is called, where it
   starts, how many times it has moved. How many places is that? And what
   keeps them consistent with each other?
2. Read back the costs from exercises 1 to 3 and your one-sentence answers
   from exercises 3 and 4. They are four symptoms of the same underlying
   problem. Try to state that problem in one sentence.
3. Write a wish list: three things you would want from the language so that
   this program becomes safer and cheaper to grow. Keep it. Session 2 starts
   by granting some of them, and by measuring what they cost.
