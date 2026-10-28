# Session 8 — Unit tests

Until now we checked a program by running it and reading what it prints. This session writes
tests instead. A test is a small method that checks one thing, and JUnit runs it for you.

## Before class

1. In the JUnit User Guide, read the page
   [Test Classes and Methods](https://docs.junit.org/6.1.3/writing-tests/test-classes-and-methods.html),
   up to the end of its first example.
2. Make a test folder, once. In IntelliJ, right-click your project folder, choose New, then
   Directory, and call it `test`. It sits next to `src`. Then right-click `test` and choose Mark
   Directory as, then Test Sources Root.
3. Unzip `session8_test.zip` into `test`, as you unzipped `session8_src.zip` into `src`.
4. Add JUnit to your project, once. Open `test/session8/A_FirstTest/BankAccountTest.java`. If the
   word `junit` in its imports is red, put the cursor on it and press Alt+Enter (Option+Enter on a
   Mac). Choose Add 'JUnit5' to classpath, not 'JUnit4', and press OK in the window that opens.

## In class

We go through the three step folders in order. Each step is shown in class, and then you do its
exercise. After that comes the game, with three exercises.

| Folder | What it shows |
|---|---|
| [`A_FirstTest`](A_FirstTest/) | a test class, `@Test` and `assertEquals` |
| [`B_BlackBox`](B_BlackBox/) | `@BeforeEach`, and testing a method from its Javadoc |
| [`C_TDD`](C_TDD/) | writing the test before the code |
| [`D_ChessGame`](D_ChessGame/) | the game from session 7, with tests of its own |

Each folder has its own `EXERCISES.md` and `EXERCISE.yml`. The tests are in `test/session8`, in
folders with the same names. A test class is in the same package as the class it tests.
