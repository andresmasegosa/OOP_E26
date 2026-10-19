# Session 7 — Exercise B, a list with a type parameter

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Give `GenericList` a type parameter `T`, as `StackWithGenerics` has one. `GenericList.add` takes
   a `T`, and `GenericList.get` gives back a `T`.
   - In `Demo.main`, make `genericList` a `GenericList<Giraffe>`, and read `first` from it with no
     cast.
   - Uncomment the line `Book book = (Book) genericList.get(0);`. It no longer compiles. Write the
     compiler's message under it, and comment it out again.

   You are done when `Demo` runs as before and the `(Book)` line has the compiler's message under
   it.

## Tips

- Make the array as `StackWithGenerics` does, with `(T[]) new Object[100]`. The warning javac gives
  for that line is expected. (Chapter 13, "Generics Fundamentals".)

## Discussion

1. Before your change, the `(Book)` line stopped the program while it ran. Now it does not compile.
   Who finds the mistake in each case, and when?
