# Session 1 — Exercises

All exercises change **one single file**: [`E_ChessGame.java`](E_ChessGame.java). The
demo files `A_` to `D_` are read and run, never edited. Exercises 1, 3 and 4 are the
core; do them in order. Exercise 2 is a stretch goal.

Two of them ask you to **write a number or a sentence down**. Keep those notes: we will
come back to them in sessions 2 and 3, when we rebuild this same game with better tools.

## Exercise 0 — warm-up: make the code yours

Run files `A_` to `E_`. Then, in the `main` method of
[`E_ChessGame.java`](E_ChessGame.java):

- Add two moves of your own to the scripted game: one legal, one illegal.
  **Predict the output before running.**
- Play a full game with a classmate until one king falls.

## Exercise 1 — wake up the bishops

The bishops are on the board, but the program does not know how they move: diagonally,
any number of squares. Teach it.

- Where: [`E_ChessGame.java`](E_ChessGame.java), and only there. A good place to start
  reading is `isLegalMove` — but it is not the only place you will end up touching.
- When you are done, the move `movePiece(board, 7, 5, 5, 3)` in `main` must succeed.
- Now run it and read the output carefully. It says:

  `White ? moves (7,5) -> (5,3)`

  That `?` comes from `pieceName`, the method that turns a piece letter into a name
  for the printed messages — and nobody taught it the bishop either. Fix that too.
- **Write down what this change cost you.** Not lines of code — the *shape* of the
  change: How many different methods did you end up editing? How many of them were a
  `switch` that had to learn about bishops? Did anything in the program warn you that
  they were missing, or did you have to hunt for them one by one? Keep your notes: we
  will make this exact change again on better designs of the same game, and compare.

## Exercise 2 — the knights (stretch goal)

Add the knights: `'N'` for White, `'n'` for Black, starting on `(0,1)`, `(0,6)`,
`(7,1)` and `(7,6)`.

- Where: [`E_ChessGame.java`](E_ChessGame.java) again. Start in `setupBoard`, which
  builds the initial position; you already know from Exercise 1 where the rest hides.
- A knight moves in an L: two squares along one axis and one along the other.
- Unlike every other piece, the knight **jumps**: no path check at all.
- Record the cost of the change again, the same way as in Exercise 1. Was this change
  easier or harder than the bishops? What does that tell you about where this program
  is heading as it grows?

## Exercise 3 — count the moves

Your chess club wants statistics: how many times has each piece moved?

There are no objects in this program — a piece is just a `char` inside an array. So:
where do you store each piece's counter?

- Where: [`E_ChessGame.java`](E_ChessGame.java). You will touch at least `movePiece`,
  which is where a move actually happens.
- Implement it. Hint: you will probably need a second 8x8 array (`int[8][8]`), a
  *parallel array* that `movePiece` must keep in sync with the board. You must also
  decide where that array lives: created in `main` and passed to `movePiece` as an
  extra parameter, or a `static` variable at the top of the class? Both work — notice
  what each choice costs you.
- When a piece moves, print its counter: `White Queen has now moved 3 times`.
- Now answer, in writing, one sentence each:
  - What must happen to the counter of a piece that gets captured?
  - If the club later asks for a *second* statistic (say, squares traveled), what would
    you have to add and keep in sync?
  - What is the annoying part of all this?

## Exercise 4 — the sabotage

The two saboteur lines are already written for you: they are in the `main` method of
[`E_ChessGame.java`](E_ChessGame.java) — search the file for `EXERCISE 4`. They conjure
a second white queen out of thin air. Uncomment them and run.

- Why did no rule stop this?
- Which parts of the program are *able* to write on the board array? Which parts
  *should* be able to?
- Write your answer down in one sentence. Session 2 has a name for it.

## Design discussion — in pairs, then with the class

1. "How a queen moves" is knowledge. In how many different places does this program
   hold knowledge about queens? List them.
2. Suppose the game grows to all 6 piece types, and we add more switches like
   `pieceName` (a symbol for each piece, a point value for each piece...). How many
   places must you now touch to add ONE new piece type? Who reminds you if you forget
   one?
3. When the bishops could not move, the program did not crash — the `default` case
   silently answered "illegal". Would you prefer a program where *forgetting a piece is
   a compile-time error*? (Session 3 builds one.)
