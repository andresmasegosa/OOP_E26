# Assignment 4 — The gym, in the format of the exam

## What you do

At a gym, members book places in workouts such as spinning and yoga. `GymBookings.java` keeps the
members and the workouts, and it does the bookings. It works, but it is written without objects,
like the festival program of assignment 2. Its `main` does three tasks, and each task prints a
result.

1. Task 1 lists the members.
2. Task 2 has the members book Monday's workouts. One of the bookings is refused.
3. Task 3 prints what each member pays for the month.

You write this program again with objects, in four exercises that follow the order of the exam.
Exercise 2 adds three types of membership to the program, and exercise 4 adds one task. Each
exercise starts from a copy of your solution to the one before, so you hand in four versions of the
program.

## The rules

You work on your own and without AI, as in assignments 1 to 3. IntelliJ's code generators, for
example for constructors, getters, `toString`, `equals` and `hashCode`, are allowed. Keep
IntelliJ's full line code completion switched off. Hand in on Moodle by Sunday 6 December at 23:59.

The exam lasts four hours. Try to do this assignment in about four hours, and finish all four
exercises even if it takes you longer.

## Getting started

1. Unzip `assignment4.zip` into the `src` folder of the course project, next to `assignment3`.
2. Run `GymBookings`, in `assignment4/base`, and look at what each task prints. In
   `GymBookings.main`, each task starts with a comment, `Task 1`, `Task 2` and `Task 3`. Leave
   `GymBookings.java` as it is.
3. Do exercise 1 in the package `assignment4.exercise1`, where `Main.java` and the skeletons of
   three classes already are.

The packages of the four exercises, `assignment4.exercise1` to `assignment4.exercise4`, are already
there, each with its own `Main.java`. To start exercises 2, 3 and 4, copy into the package of the
exercise all the `.java` files of the exercise before apart from `Main.java`, all at once. Then copy
the code inside `Main.main` of the exercise before into `Main.main` of the new exercise. For
exercise 4, also copy the tests of exercise 3 into a new package `assignment4.exercise4` in the
`test` folder. Then check that each copied file starts with the package of its new folder, for
example `package assignment4.exercise2;`, and that no file mentions another exercise, in an import
or in the code. Leave the files you copied from as they are. If an exercise does not work, start the
next one from the last exercise that works. Each exercise has its own `Main`, so check that you run
the `Main` of the exercise you are working on.

## Assessment criteria

Your code is assessed on how well it follows the object-oriented concepts of the course. In
exercise 1, tasks 1 to 3 give the same results as `GymBookings`, with the same booking refused and
the same bills. Exercise 2 changes the bills of task 3 and shows the new ones, and exercises 3 and
4 keep them. Your lines do not have to look the same as the lines of `GymBookings` or of this
sheet, and they can list the members and the workouts in another order. A program that gives the
right results but is not object-oriented is not valid.

These are the minimum requirements in every exercise.

- The members and the workouts are objects, and each object keeps its own data. Nothing outside an
  object can change that data directly.
- A workout never has more bookings than places. A booking that is refused changes nothing.
- Each class does the work that belongs to its own data. `Main.main` tells the story, and the
  objects do the work.

Some requirements are left open on purpose. You decide how to meet them, and you justify your
decisions in comments in the code, where each exercise asks for them. When you change a class,
update its comment.

## Exercise 1 — classes

Go to `GymBookings.main`, and read the code of the three tasks and the methods they call.

- The package `exercise1` has a skeleton of three classes, as a suggestion. `Member` is one member
  of the gym and works out the member's bill. `Workout` is one workout, with its places, and it
  accepts or refuses each booking. `Gym` has the members and the workouts of the gym. Each skeleton
  shows where the fields go and gives some of the methods, with empty bodies. Add the fields and
  the other methods you need, and write the code of every method. The design is still yours, so you
  can change the skeletons, or write other classes instead if you think they are better.
- Under the three comments in `Main.main` of `exercise1`, write the code that does tasks 1 to 3
  with objects of your classes. It gives the same results as `GymBookings`.
- Do not use inheritance or write interfaces of your own in this exercise, because exercise 2 is
  about inheritance. You can use everything else from the course, collections included.
- Start each class with a comment that says what the class is for and why it is in your program.
  In the skeletons, your comment replaces the one that is there. Do the same for the classes you
  create in the other exercises.

## Exercise 2 — inheritance

Copy your exercise 1 into the package `assignment4.exercise2`.

In this exercise the gym has three types of membership, and what a member pays depends on the
type. A basic member pays 60 kr for each workout booked in the month, which is what every member
pays in `GymBookings`. A premium member pays 300 kr a month, for any number of workouts. A student
member pays 50 kr for each workout, but never more than 80 kr a month. Freja is a premium member,
Omar is a basic member and Sofie is a student member.

- Use inheritance for the types of membership. What all types share goes in one superclass, written
  once, and your member class can be that superclass. Each type is a subclass that adds only what
  makes it different, such as how it works out the bill. Do not use a `switch` or an `if` on the
  type of membership.
- In a comment at the top of your superclass, say what you put in it and what you left to the
  subclasses, and why.

Tasks 1 and 2 do not change. These are the results of task 3 in this exercise.

```
Task 3. The bills
  Freja: booked 1, pays 300 kr
  Omar: booked 1, pays 60 kr
  Sofie: booked 2, pays 80 kr
  Total: 440 kr
```

## Exercise 3 — collections, exceptions and unit tests

Copy your exercise 2 into the package `assignment4.exercise3`.

- Use collections for the groups of objects your program keeps, and do not use arrays, apart from
  `String[] args` in `Main.main`. If you already used collections in exercise 1 or 2, you do not
  need to change them. If your program still uses arrays, replace them with collections now. For
  every collection in your program, think about whether it should be a `List`, a `Set` or a `Map`,
  and justify your choice in a comment.
- Write at least one exception class of your own that extends `RuntimeException`, and throw it
  where your program refuses something. Give it a message that says what went wrong, and say in a
  comment why you throw it there.
- Write unit tests with JUnit in the `test` folder of the course project, in a new package
  `assignment4.exercise3`. Write at least one test of a method that works out a result, such as a
  bill, and one test that uses `assertThrows` to check your exception. All your tests pass.

## Exercise 4 — the Observer pattern

Copy your exercise 3 into the package `assignment4.exercise4`, and copy its tests into the package
`assignment4.exercise4` of the `test` folder.

This exercise adds task 4, which `GymBookings` does not have. A member can now cancel a booking, and
then the workout notifies its listeners that a place is free. Write it with the Observer pattern, in
these steps.

- Write an interface `PlaceListener` with one method, `void placeFreed(Workout workout)`, where
  `Workout` is your workout class.
- Give your workout class a list of `PlaceListener` objects and a method `addListener` that adds
  one. Also give it a method `cancel` that takes a member. `cancel` gives the member's place back,
  so the workout has one more free place and the member has booked one workout less. It prints the
  `Freja cancelled Spinning` line of the results below, and then it calls `placeFreed` on every
  listener, in the order they were added. You can assume that the member has a place in the
  workout.
- Write a class `EntranceScreen` that implements `PlaceListener`, and make your member class
  implement it too. Their `placeFreed` methods print the `Screen` line and the `To Omar` line of
  the results below, respectively.
- In `Main.main`, task 4 adds a screen and then Omar as listeners of Spinning. Then Freja cancels
  Spinning, and after that Omar books Spinning, as in task 2.

These are the results of task 4.

```
Task 4. A free place
  Freja cancelled Spinning
  Screen: a place is free in Spinning
  To Omar: a place is free in Spinning
  Omar booked Spinning
```

- In the comment at the top of `Main.java` in `assignment4.exercise4`, in place of the one that is
  there, say which class is the subject and which classes are its observers. Also say why your
  workout class would not change if the gym added a new kind of listener.
- The tests you copied from exercise 3 still pass.

## What you hand in

You hand in two zip files. `assignment4_src.zip` has your folder `assignment4` from `src`, with the
four exercise folders. `assignment4_test.zip` has your folder `assignment4` from `test`. Everything
must compile. If a task does not work, leave it out of `Main.main`, and if a test does not compile,
delete it.

Mads, the TA, gives you written feedback on each exercise. There are no points and no mark.
