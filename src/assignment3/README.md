# Assignment 3 — The festival volunteers, with collections, tests and exceptions

## What you do

In assignment 2 you wrote the festival volunteers program with objects. Now you take your own
program and improve it with collections, unit tests and exceptions. There is one exercise for each.

You do not add any new task. Your program still does tasks 1 to 4 and gives the same results as
before. You only change how it is written.

Each exercise tells you what to use, and you decide how to use it. At the end of each exercise
there is a question about your choices. Write your answers in `assignment3/answers.txt`.

## Getting started

You work on your own and without AI, as in assignments 1 and 2. Keep IntelliJ's full line code
completion switched off. Hand in on Moodle by Sunday 22 November at 23:59.

You start from your own program of assignment 2, and its four tasks have to work. If you did not
do assignment 2, or part of it does not work, finish assignment 2 first. It is still on Moodle, in
`assignment2.zip`.

1. Unzip `assignment3.zip` into the `src` folder of the course project, next to `assignment2`.
2. Copy all your `.java` files from `assignment2` into `assignment3`, except
   `FestivalVolunteers.java`. Check that each file starts with `package assignment3;`. Leave
   `assignment2` as it is.
3. In the `test` folder of the course project, create a package `assignment3`. Your tests go there.
4. Run `Main.main` in `assignment3`. It should print the results of tasks 1 to 4, the same as in
   assignment 2.

If you got feedback from Mads on assignment 2, fix those points in `assignment3`.

## Assessment criteria

We look at how you use collections, `toString`, unit tests and exceptions. Your design of
assignment 2 is not assessed again. But your program must still be object-oriented, and it must
still give the results of tasks 1 to 4. It is fine if its lines look different, or if it lists the
volunteers in another order.

## Exercise 1 — collections and `toString`

- Introduce collections in your program, and stop using arrays. The only array that can stay is
  `String[] args` in `Main.main`.
- Use the collection that each case needs, and think about whether it should be a `List`, a `Set`
  or a `Map`.
- Try to do all your prints by overriding `toString` in your classes.

Run `Main.main` after each change to check that tasks 1 to 4 still give the same results. Then
answer question 1 in `answers.txt`.

### Question 1

> What do you think you gained by using collections instead of arrays? Say what you keep in each
> collection, and why you chose that collection and not another one.

## Exercise 2 — unit tests

- Look at the methods of your classes and choose several of them, at least three.
- Write unit tests for them with JUnit, in the package `assignment3` that you created in `test`.
- Run your tests every time you write a new one. When you hand in, all of them must pass.

Then answer question 2 in `answers.txt`.

### Question 2

> How did you write your unit tests, and what did you base them on? Why did you test these methods
> and not others?

## Exercise 3 — exceptions

- Add exceptions to your program where they make sense, in at least three places. Think of what
  can go wrong, for example when a method or a constructor gets a value it cannot accept.
- Give each exception a message that says what went wrong. At least one of them must be your own
  exception class, one that extends `RuntimeException`.
- Test your exceptions too. For each place, write a test that uses `assertThrows` to check that
  the exception is thrown.

Check again that tasks 1 to 4 give the same results and that all your tests pass. Then answer
question 3 in `answers.txt`.

### Question 3

> Why did you add these exceptions? What logic did you follow to decide where to throw each one,
> and when to write your own exception class?

## What you hand in

You hand in two zip files. `assignment3_src.zip` has your folder `assignment3` from `src`, with
`answers.txt` inside. `assignment3_test.zip` has your folder `assignment3` from `test`. Everything
must compile, so if a test does not compile, delete it before you hand in. Three to five sentences
per answer are enough, as long as you give your reasons.

Mads, the TA, tells you for each exercise whether it is done, partly done or not done, and why.
There is no mark. An exercise is done when your code does what the exercise asks and your answer
gives your reasons. If only one of the two is there, it is partly done. If neither is there, or
the program is no longer object-oriented, it is not done. Small slips are pointed out, but they do
not change the verdict.
