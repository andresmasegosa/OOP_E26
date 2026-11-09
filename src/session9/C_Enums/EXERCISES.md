# Session 9 — Exercise C, a team as an enum

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print.
2. Write `Team.java`, an enum with the values `BLUE` and `RED`. In `TeamPlayer`, keep the team as
   a `Team` instead of a `String`. Then build Mia and Jonas in `Demo` with `Team.BLUE`.

   You are done when `Demo` prints `Same team: true`, and the line
   `new TeamPlayer("Ida", "Green");` does not compile when you add it to `Demo.main`. Then delete
   the line.

## Tips

- `Team.java` looks like `Day.java`.

## Discussion

1. `TeamPlayer.isOnSameTeamAs` can now compare the two teams with `==`. Why is that safe for an
   enum, when it was not for two `String`s? (Chapter 12, "Enumeration Fundamentals".)
