# Session 1 — Exercises

All exercises change **one single file**: [`E_ChessGame.java`](E_ChessGame.java). The
demo files `A_` to `D_` are read and run, never edited. Exercises 1, 3 and 4 are the
core; do them in order. Exercise 2 is a stretch goal.

Each exercise ends with a short **discussion** (in pairs, then with the class), and the
session closes with a **global reflection** that uses your notes from all of them — so
write your notes down as you go.

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
  `switch` that had to learn about bishops? Keep the notes: we will make this exact
  change again on better designs of the same game, and compare.

**Discuss:**

1. Did anything in the program *warn* you that the bishop was missing, or did you have
   to hunt for the places one by one? Both failures you just fixed — a bishop that
   cannot move, a bishop called `?` — were silent. What would you want to happen
   instead when a piece type is forgotten somewhere? (Keep your answer: session 3
   builds a version where forgetting a piece is a compile-time error.)
2. Imagine the program grows more switches of this kind: a point value per piece, a
   Unicode symbol per piece. Adding ONE new piece type then means touching how many
   places? Who keeps the list of those places?

## Exercise 2 — the knights (stretch goal)

Add the knights: `'N'` for White, `'n'` for Black, starting on `(0,1)`, `(0,6)`,
`(7,1)` and `(7,6)`.

- Where: [`E_ChessGame.java`](E_ChessGame.java) again. Start in `setupBoard`, which
  builds the initial position; you already know from Exercise 1 where the rest hides.
- A knight moves in an L: two squares along one axis and one along the other.
- Unlike every other piece, the knight **jumps**: no path check at all.
- Record the cost of the change again, the same way as in Exercise 1.

**Discuss:**

1. Was this change easier or harder than the bishops? What does that tell you about
   where this program is heading as it grows?
2. The knight is the first piece whose rule does not fit the three `isLegal...Move`
   helpers — there is no path to check. Where did its rule end up in your code, and is
   `isLegalMove` getting easier or harder to read?

## Exercise 3 — count the moves

Your chess club wants statistics: how many times has each piece moved?

There are no objects in this program — a piece is just a `char` inside an array. So:
where do you store each piece's counter?

- Where: [`E_ChessGame.java`](E_ChessGame.java). You will touch at least `movePiece`,
  which is where a move actually happens.
- Implement it. Hint: you will probably need a second 8x8 array (`int[8][8]`), a
  *parallel array* that `movePiece` must keep in sync with the board. You must also
  decide where that array lives: created in `main` and passed to `movePiece` as an
  extra parameter, or a `static` variable at the top of the class? Both work.
- When a piece moves, print its counter: `White Queen has now moved 3 times`.

**Discuss:**

1. What must happen to the counter of a piece that gets captured? Does your code do it?
2. Which option did you pick for the array — extra parameter or `static` variable —
   and what did it cost you?
3. The counter is information *about one piece*, yet it lives far away from the
   piece's other information (its letter, its square). If the club asks for a second
   statistic tomorrow — say, squares traveled — what do you have to add and keep in
   sync? **Write the annoying part down in one sentence.**

## Exercise 4 — the sabotage

The two saboteur lines are already written for you: they are in the `main` method of
[`E_ChessGame.java`](E_ChessGame.java) — search the file for `EXERCISE 4`. They conjure
a second white queen out of thin air. Uncomment them and run.

**Discuss:**

1. `movePiece` carefully enforces the rules of chess... and the saboteur simply did
   not go through `movePiece`. Why did no rule stop it?
2. Which parts of the program are *able* to write on the board array? Which parts
   *should* be able to? **Write your answer down in one sentence** — session 2 has a
   name for it.

## Global reflection — the state of this program

Do this at the end, with all your notes on the table. The program works: you played
it, and you extended it three times. So the question is no longer *does it work?* —
it is *what does it cost to keep working on it?*

1. Pick one piece — say, the bishop — and list **every place in the program that knows
   something about bishops**: how it moves, what it is called, where it starts, how
   many times it has moved. How many places is that? What keeps them consistent with
   each other?
2. Read back the costs from exercises 1–3 and your sentences from exercises 3 and 4.
   They are four symptoms of the same underlying problem. **Try to state that problem
   in ONE sentence.**
3. Write a wish list: three things you would want from the language so that this
   program becomes safer and cheaper to grow. Keep it — session 2 starts by granting
   some of them, and by measuring what they cost.
