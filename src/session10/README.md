# Session 10 — Design patterns I

Until now most sessions brought something new in Java. This session brings no new Java. It gives
names to ways of arranging classes that come back in program after program, called design
patterns. We look at two of them, Strategy and Observer. The chess game has used Strategy since
session 5, and today it gets Observer too.

## Before class

1. On Refactoring Guru, read the pages on
   [Strategy](https://refactoring.guru/design-patterns/strategy) and
   [Observer](https://refactoring.guru/design-patterns/observer), each up to the end of its
   section "Structure". The Observer page calls a listener a subscriber.
2. Unzip `session10_test.zip` into your `test` folder, as you unzipped `session10_src.zip` into
   `src`.

## In class

We go through the two step folders in order. Each step is shown in class, and then you do its
exercise. After that comes the game, with two exercises.

| Folder | What it shows |
|---|---|
| [`A_Strategy`](A_Strategy/) | the Strategy pattern, a behaviour kept in an object of its own |
| [`B_Observer`](B_Observer/) | the Observer pattern, listeners that hear about a change |
| [`C_ChessGame`](C_ChessGame/) | the game from session 9, with both patterns |

Each folder has its own `EXERCISES.md` and `EXERCISE.yml`. The tests of `C_ChessGame` are in
`test/session10`, in a folder with the same name.
