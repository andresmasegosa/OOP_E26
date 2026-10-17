# Assignment 2 — The festival volunteers, with inheritance

## What you do

At a music festival, volunteers work shifts and earn points. A volunteer with 30 points gets their
festival ticket for free.

`FestivalVolunteers.java` keeps the points of three volunteers. It works, but it is not
object-oriented. It is written without objects, like the chess game of session 1. Its `main` does
three tasks, and each task prints a result.

1. Task 1 lists the volunteers.
2. Task 2 records the bar shifts of the first day and prints the points.
3. Task 3 records the recycling shifts of the second day and prints the points.

You write the same program again with objects, using classes and inheritance. You decide which
classes you write and what each one does. Your program starts in `Main.java`, which is already in
the folder. Its `Main.main` is empty, with one comment for each task, and that is where your
object-oriented version does the tasks, in the same order as `FestivalVolunteers.main`.

Your program gives the same results as `FestivalVolunteers`, but its lines do not have to look the
same. Your code is assessed on the quality of its object-oriented design, as the assessment
criteria below explain.

Exercises 1, 2 and 3 rebuild one task each. Exercise 4 adds a fourth task that
`FestivalVolunteers.java` does not have. Each exercise has two parts, the code you write and a
question about your design that you answer.

## Getting started

You work on your own and without AI, as in assignment 1. Keep IntelliJ's full line code completion
switched off. Hand in on Moodle by Sunday 25 October at 23:59.

Unzip `assignment2.zip` into the `src` folder of the course project, next to `assignment1`. Run
`FestivalVolunteers` and look at what each task prints. In `FestivalVolunteers.main`, each task
starts with a comment, `Task 1`, `Task 2` and `Task 3`. Leave `FestivalVolunteers.java` as it is.

Read all four exercises before you choose your classes. Write your classes in the folder
`assignment2`, next to `Main.java`, and start each file with `package assignment2;`. Write your
answers to the four questions in `assignment2/answers.txt`.

## Assessment criteria

Your code is assessed only on how well it follows the object-oriented concepts seen in the course.
Your program must give the same results as `FestivalVolunteers.java`, with the same shifts and the
same points for every volunteer, but its lines do not have to look the same. That is required, but
it is not enough. A program that gives the same results but is not object-oriented is not valid.

These are the minimum requirements.

- The volunteers and the shifts are objects, and each object keeps its own data. Nothing outside
  an object can change that data directly.
- A volunteer's points change only when the volunteer works a shift.
- Each class does the work that belongs to its own data. `Main.main` tells the story of the
  festival, and the objects do the work.
- Bar shifts and recycling shifts, and the leader shifts of exercise 4, are different types of
  shift with much in common. Every shift is worked by one volunteer for a number of hours. Use
  inheritance for this. What all shifts share goes in one superclass, written once. Each type of
  shift is a subclass that adds only what makes it different, such as how it earns its points. A
  new type of shift is then one more subclass, and the rest of the program does not have to
  change.

Your code is also assessed on the other object-oriented concepts of the course.

## Exercise 1 — task 1, the volunteers

Task 1 adds the volunteers of the festival and lists them. Go to `Task 1` in
`FestivalVolunteers.main`, and read its code and the methods it calls to see what it does.

1. Create the classes you think you need for this task. Then, under the comment `Task 1` in
   `Main.main`, write the code that does task 1 with objects of your classes. It gives the same
   results as task 1 of `FestivalVolunteers`.
2. Answer question 1 in `answers.txt`, with your reasons.

### Question 1

> `FestivalVolunteers` keeps Oskar in position 2 of three arrays. Where does your program keep what
> it knows about Oskar, and how many objects for Oskar are there?

## Exercise 2 — task 2, the first day

Task 2 is the first day of the festival, when the volunteers work bar shifts and earn points. Go
to `Task 2` in `FestivalVolunteers.main`, and read its code and the methods it calls to see what it
does.

1. Create the classes you think you need for this task, or add to the ones you already have.
   Then, under the comment `Task 2` in `Main.main`, write the code that does task 2 with objects of
   your classes. It gives the same results as task 2 of `FestivalVolunteers`.
2. Answer question 2 in `answers.txt`, with your reasons.

### Question 2

> Which methods in your design can change a volunteer's points, and from which class is each of
> them called? Could `Main.main` give Oskar 100 points without a shift?

## Exercise 3 — task 3, the second day

Task 3 is the second day, when the volunteers collect cups for recycling. A recycling shift is a
second type of shift, next to the bar shift. Go to `Task 3` in `FestivalVolunteers.main`, and read
its code and the methods it calls to see what it does.

1. Create the classes you think you need for this task, or add to the ones you already have.
   Then, under the comment `Task 3` in `Main.main`, write the code that does task 3 with objects of
   your classes. It gives the same results as task 3 of `FestivalVolunteers`.
2. Answer question 3 in `answers.txt`, with your reasons.

### Question 3

> How does your program work out the points of a bar shift and of a recycling shift? Which method
> runs in each case, and how does Java choose it?

## Exercise 4 — task 4, the team leaders

`FestivalVolunteers` does not have this task. On the third day, Ida leads the bar team for 8 hours,
and Malik leads the recycling team for 4. A leader shift is a third type of shift. It earns 2
points per hour, or 3 if the volunteer has helped at 3 festivals or more before this one. These are
its results, written the way `FestivalVolunteers` would print them.

```
Task 4. Day 3, the team leaders
  Ida worked 8 h, Bar team leader: 24 points (2 per hour, 3 after 3 festivals)
  Malik worked 4 h, Recycling team leader: 8 points (2 per hour, 3 after 3 festivals)
  Points: Ida 42 (ticket), Malik 30 (ticket), Oskar 28
```

1. Create the classes you think you need for this task, or add to the ones you already have.
   Then, under the comment `Task 4` in `Main.main`, write the code that does task 4 with objects of
   your classes.
2. Answer question 4 in `answers.txt`, with your reasons.

### Question 4

> Which classes did the leader shift make you write or change, and why? To add it to
> `FestivalVolunteers.java` instead, which methods would you change, and would anything warn you
> if you forgot one?

## What you hand in

A zip of your folder `assignment2`, with your classes, `Main.java` and `answers.txt`. The code must
compile. If task 4 does not work, leave it out of `Main.main`. Your answers are about the program
you hand in, so read them again when you finish exercise 4. Three to five sentences per answer are
enough.

Mads, the TA, writes for each exercise whether it is done, partly done or not done, and why. There
is no mark. An exercise is done when it gives the results of its task with code that meets the
assessment criteria, and its answer gives reasons. It is partly done when only one of the two is
there. It is not done when neither is there, or when the program is not object-oriented. A small
slip against a requirement is pointed out and does not change the verdict.
