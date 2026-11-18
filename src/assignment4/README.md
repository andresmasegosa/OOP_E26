# Assignment 4 — The gym, in the format of the exam

## What you do

At a gym, members book places in workouts such as spinning and yoga. `GymBookings.java` keeps the
members, the workouts and the bookings. It works, but it is written without objects, like the
festival program of assignment 2. Its `main` does three tasks, and each task prints a result.

1. Task 1 lists the members.
2. Task 2 has the members book Monday's workouts. Some of the bookings are refused.
3. Task 3 prints what each member pays for the month.

You write this program again with objects, in four exercises that follow the order of the exam,
and in exercise 4 you add one task to it. Each exercise starts from a copy of your solution to the
one before, so you hand in four versions of the program.

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
3. Do exercise 1 in the package `assignment4.exercise1`, where `Main.java` already is.

To start exercises 2, 3 and 4, create the package of the exercise in `assignment4`, and copy into it
all the `.java` files of the exercise before, all at once. For exercise 4, do the same with the
tests of exercise 3, in the `test` folder. Then check that each copied file starts with the package
of its new folder, for example `package assignment4.exercise2;`, and that no file mentions another
exercise, in an import or in the code. Leave the files you copied from as they are. If an exercise
does not work, start the next one from the last exercise that works. Each exercise has its own
`Main`, so check that you run the `Main` of the exercise you are working on.

## Assessment criteria

Your code is assessed on how well it follows the object-oriented concepts of the course. In every
exercise, tasks 1 to 3 give the same results as `GymBookings`, with the same bookings refused and
the same bills, but their lines do not have to look the same. They can also list the members and
the workouts in another order. A program that gives the same results but is not object-oriented is
not valid.

These are the minimum requirements in every exercise.

- The members and the workouts are objects, and each object keeps its own data. Nothing outside an
  object can change that data directly.
- A workout never has more members than places, and never has the same member twice. A booking that
  is refused changes nothing.
- Each class does the work that belongs to its own data. `Main.main` tells the story, and the
  objects do the work.

Some requirements are left open on purpose. You decide how to meet them, and you justify your
decisions in comments in the code, where each exercise asks for them. When you change a class,
update its comment.

## Exercise 1 — classes

Go to `GymBookings.main`, and read the code of the three tasks and the methods they call.

- Create the classes you think you need. Then, under the three comments in `Main.main` of
  `exercise1`, write the code that does tasks 1 to 3 with objects of your classes. It gives the
  same results as `GymBookings`.
- Do not use inheritance or write interfaces of your own in this exercise, because exercise 2 is
  about inheritance. You can use everything else from the course, collections included. Until
  exercise 2, the type of membership can be a field, and a `switch` or an `if` on it is fine.
- Start each class you create with a comment that says what the class is for and why you created
  it. Do the same for the classes you create in the other exercises.

## Exercise 2 — inheritance

Copy your exercise 1 into the package `assignment4.exercise2`.

- In `GymBookings` the type of membership, basic, premium or student, is a letter, and
  `GymBookings.bill` and `GymBookings.describe` use a `switch` on the letter. Use inheritance for
  the types of membership. What all types share goes in one superclass, written once. Each type is
  a subclass that adds only what makes it different, such as how it works out the bill. No `switch`
  or `if` on the type of membership is left.
- In a comment at the top of your superclass, say what you put in it and what you left to the
  subclasses, and why.

## Exercise 3 — collections, exceptions and unit tests

Copy your exercise 2 into the package `assignment4.exercise3`.

- Use collections for the groups of objects your program keeps, and do not use arrays, apart from
  `String[] args` in `Main.main`. Each time you use a collection, think about whether it should be a
  `List`, a `Set` or a `Map`, and justify your choice in a comment.
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
  one. Also give it a method `cancel` that takes a member. If the member has a place, `cancel`
  removes the member from the workout and prints the `Omar cancelled Spinning` line of the results
  below. Then it calls `placeFreed` on every listener, in the order they were added. If the member
  has no place, `cancel` changes nothing.
- Write a class `EntranceScreen` that implements `PlaceListener`, and make your member class
  implement it too. Their `placeFreed` methods print the `Screen` line and the `To Mikkel` line of
  the results below.
- In `Main.main`, task 4 adds a screen and then Mikkel as listeners of Spinning. Then Omar cancels
  Spinning, and after that Mikkel books Spinning, as in task 2.

These are the results of task 4.

```
Task 4. A free place
  Omar cancelled Spinning
  Screen: a place is free in Spinning
  To Mikkel: a place is free in Spinning
  Mikkel booked Spinning
```

- In a comment at the top of `Main.java` in `assignment4.exercise4`, say which class is the subject
  and which classes are its observers. Also say why your workout class would not change if the gym
  added a new kind of listener.
- The tests you copied from exercise 3 still pass.

## What you hand in

You hand in two zip files. `assignment4_src.zip` has your folder `assignment4` from `src`, with the
four exercise folders. `assignment4_test.zip` has your folder `assignment4` from `test`. Everything
must compile. If a task does not work, leave it out of `Main.main`, and if a test does not compile,
delete it.

Mads, the TA, gives each exercise from 0 to 3 points, as in the exam, and writes why. 3 means only
minor problems, 2 means some problems, 1 means some serious problems, and 0 means nothing done or
many serious problems. An exercise whose comments do not give your reasons gets at most 2 points,
and an exercise whose program is not object-oriented gets 0. The points are feedback, and there is
no mark.
