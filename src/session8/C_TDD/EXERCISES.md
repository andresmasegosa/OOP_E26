# Session 8 — Exercise C, a badminton player, test first

The exercise is the three numbered steps. In each one you write the test first and run it. It is
red, and a test that does not compile counts as red. Then you write just enough code to make it
green.

1. In `test/session8/C_TDD/BadmintonPlayerTest.java`, write the test `newPlayer`. A new
   `BadmintonPlayer` called Mia has the name Mia, and `BadmintonPlayer.getWins` and
   `BadmintonPlayer.getLosses` answer 0. Then write `BadmintonPlayer.java` in `src/session8/C_TDD`.
2. Write the test `wonMatch`. After two calls to `BadmintonPlayer.wonMatch`, the player has won
   2 matches. Then write `wonMatch`.
3. Write the test `lostMatch` in the same way, and then `BadmintonPlayer.lostMatch`.

   You are done when `BadmintonPlayerTest` has three green tests, and every method of
   `BadmintonPlayer` was written after the test that uses it.

## Tips

- IntelliJ can create a class or a method that a test asks for. Put the cursor on the red name
  and press Alt+Enter (Option+Enter on a Mac). If it asks where to put the class, choose the folder
  under `src`.

## Discussion

1. Is there a line in `BadmintonPlayer` that no test asked for?
