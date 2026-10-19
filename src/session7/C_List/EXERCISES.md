# Session 7 — Exercise C, a comparator that orders people by age

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Write `AgeOrder.java`, a class that implements `Comparator<Person>` and orders people by age,
   youngest first. `StringAlphabeticalOrder.java` is the model. Then, in `Demo.main`, uncomment the
   line `Collections.sort(people, ...);` and put `new AgeOrder()` in place of the dots.

   You are done when `Demo` prints Jakob, then Anders, then Mads.

## Tips

- `AgeOrder.compare` answers a negative number when the first person is younger, a positive number
  when the first person is older, and zero for the same age. `Integer.compare` does this for two
  ages. (Chapter 8, "Implementing Interfaces".)

## Discussion

1. `people` is built as a `LinkedList`. What would change in `Demo.java` if it were built as an
   `ArrayList`?
