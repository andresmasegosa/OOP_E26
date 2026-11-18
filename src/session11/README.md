# Session 11 — Design patterns II

This session brings one more design pattern, Visitor. A visitor is an operation on objects of
different classes, written in a class of its own. With a visitor, a new operation does not change
the classes of the objects. The example of the session is a math expression such as `3 + 2 + 4 =`,
and at the end we come back to the chess game.

## Before class

1. On Refactoring Guru, read the page on
   [Visitor](https://refactoring.guru/design-patterns/visitor), up to the end of its section
   "Structure". The page calls each class that a visitor visits an element.
2. Unzip `session11_test.zip` into your `test` folder, as you unzipped `session11_src.zip` into
   `src`.

## In class

We go through the two step folders in order. Each step is shown in class, and then you do its
exercise. After that comes the game.

| Folder | What it shows |
|---|---|
| [`A_Visitor`](A_Visitor/) | the Visitor pattern, operations on the nodes of an expression, each in a class of its own |
| [`B_Evaluation`](B_Evaluation/) | one more operation on the same expression, its value |
| [`C_ChessGame`](C_ChessGame/) | the game from session 10, with a visitor that finds the moves of each piece |

Each folder has its own `EXERCISES.md` and `EXERCISE.yml`. The tests of `C_ChessGame` are in
`test/session11`, in a folder with the same name.
