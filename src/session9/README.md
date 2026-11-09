# Session 9 — Error handling and enums

Until now a method that could not do its job answered false or printed a message. This session
lets it throw an exception instead, which the caller catches. Then come enums, types with a fixed
list of values. They replace the colours and the types that the game still writes as strings.

## Before class

1. In *Java: A Beginner's Guide* (Herbert Schildt), read chapter 9 from "The Exception Hierarchy"
   to the end of "Catching Subclass Exceptions", and its section "Throwing an Exception".
2. In the same book, read chapter 12 from "Enumerations" to the end of "Constructors, Methods,
   Instance Variables, and Enumerations".
3. Unzip `session9_test.zip` into your `test` folder, as you unzipped `session9_src.zip` into
   `src`.

## In class

We go through the three step folders in order. Each step is shown in class, and then you do its
exercise. After that comes the game, with three exercises.

| Folder | What it shows |
|---|---|
| [`A_ThrowAndCatch`](A_ThrowAndCatch/) | `throw`, `try` and `catch` |
| [`B_CustomExceptions`](B_CustomExceptions/) | exceptions of your own, and `assertThrows` |
| [`C_Enums`](C_Enums/) | enums, and an enum with a constructor |
| [`D_ChessGame`](D_ChessGame/) | the game from session 8, with enums and an exception of its own |

Each folder has its own `EXERCISES.md` and `EXERCISE.yml`. The tests of `B_CustomExceptions` and
`D_ChessGame` are in `test/session9`, in folders with the same names.
