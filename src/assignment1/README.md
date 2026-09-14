# Assignment 1 — The flat share

This is the first assignment of the course that you hand in. You work on your own and hand it in on Moodle by Sunday 20 September at 23:59. Mads, the TA, reads it and sends you feedback.

The assignment uses only what we have seen up to session 2. The flat share will come back in the next assignments, rebuilt with the tools of the later sessions.

Do it without AI assistance of any kind. IntelliJ's code generators, for example for getters and setters, are fine, but AI autocompletion and chat assistants are not, and that includes the course tutor. IntelliJ Ultimate comes with an AI completion that is switched on by default, called full line code completion. Switch it off before you start. You find it by searching for "full line" in IntelliJ's settings. You may talk about the assignment with your classmates, but what you hand in must be your own.

## The program you start from

Unzip `assignment1.zip` into the `src` folder of the course project, next to `session1` and `session2`. The new folder `assignment1` has `FlatShare.java`, the program you start from, and `expected-output.txt`, which is what your program must print when you are done. `EXERCISE.yml` tells AI assistants not to help with this assignment.

`FlatShare.java` keeps the accounts of a shared flat, with no objects at all, like the chess game of session 1. Start with the comment at the top of the file. It explains how the arrays store the flatmates and what each type of expense does.

`FlatShare.main` tells one month in the flat. Freja, Ali, Mathilde and Jonas live there, and they pay the rent and some bills. Later in the month Mathilde moves out and Sofie moves in. At the end, Jonas wants to move out too.

A balance is in whole kroner. A positive balance means that the others owe that flatmate money, and a negative balance means that the flatmate owes the others. Money only moves between flatmates, so all the balances together always add up to 0.

To keep the code short, the program leaves out edge cases on purpose. It never checks for a name that does not exist, a negative amount, a full array or an amount that does not divide exactly, because none of that happens in this month. Your version does not have to check for them either.

## Exercise 1 — what goes wrong

Nothing from this exercise is handed in, but exercise 2 needs it.

- Run `FlatShare` and compare what it prints with `expected-output.txt`, line by line, the history at the end included. For each difference, find the method or methods of `FlatShare` that cause it, and write them down.
- The last lines of `FlatShare.main` are a sabotage, commented out. Uncomment them and run again. Freja gets 500 kr out of nowhere, and nothing in the program stops it. Then comment them out again.

## Exercise 2 — the same flat, made of objects

Now write the program again, with objects. Leave `FlatShare.java` as it is.

- Write four classes in the folder `assignment1`, next to `FlatShare.java`, and start each file with `package assignment1;`. `Flatmate` is one person who lives in the flat. `Expense` is one payment. `Flat` keeps the flatmates and the history of expenses, in arrays. `Main` has the method `main` and nothing else, and `Main.main` tells the same month as `FlatShare.main`.
- Inside the classes the design is yours. You decide what each class stores and what each class does, as long as you follow these four rules.

1. Every field of every class is private. (Chapter 6, "Controlling Access to Class Members".)
2. An expense keeps a reference to the `Flatmate` who paid it, not a position in an array and not a name. After Mathilde moves out, the history must still say that Mathilde paid for the groceries. (Chapter 4, "Reference Variables and Assignment".)
3. Adding an expense to the flat is the only public way to change a balance. `Main` never changes a balance on its own.
4. A flatmate whose balance is not 0 cannot move out. The method that moves a flatmate out prints the line you see for Jonas in `expected-output.txt` and returns `false`, like `ChessBoard.placePiece` in session 2 when it refuses a piece.

- Last, copy the sabotage line `balances[0] = balances[0] + 500;` from `FlatShare.main` into `Main.main` and rewrite it for your design, so that it writes directly into a private field of one of your classes. Compile it, and leave it commented out with the error message of the compiler copied under it.

Until exercise 3 splits the rent, your program also refuses to let Mathilde move out, because Mathilde's balance is not 0 yet. That is expected.

## Exercise 3 — the rent

`FlatShare` records the rent but never splits it. Teach your program to split the rent by room size, so that every flatmate pays in proportion to the square meters of their room. In this month the four rooms add up to 50 m2, and 10000 kr is 200 kr per square meter. Freja's part is 2800 kr, Ali's 2400 kr, Mathilde's 2000 kr and Jonas's 2800 kr. Freja paid the landlord, so Freja's balance also goes up by the whole 10000 kr.

When exercises 2 and 3 are done, your program prints exactly what is in `expected-output.txt`, with the balances in the order the flatmates moved in.

Then write down what the rent cost you, as a comment at the top of `Main.main`, in the same shape as the cost lines of session 2.

```java
// Cost of the rent, FlatShare.java:  places touched: ...   of which switches: ...   did anything warn me: ...
// Cost of the rent, my design:       places touched: ...   of which switches: ...   did anything warn me: ...
```

Places touched is the number of methods you edited or wrote for the rent. You do not change `FlatShare.java`, so for the first line count the methods you would have to edit or write there.

## What you hand in

You hand in two files on Moodle, by Sunday 20 September at 23:59. Moodle does not accept a hand-in after that.

- A zip of your folder `assignment1`, with `FlatShare.java` and your four classes.
- A PDF of one page with your class diagram and your answers to the three questions below.

Draw the class diagram with one box per class. The name of the class goes on top. Under the name go the fields, and under the fields go the constructors and methods. Put `+` in front of what is public, `-` in front of what is private, `#` in front of what is protected, and nothing in front of what has no modifier. Draw an arrow from a class to every class it keeps in a field. The box of `ChessPiece` from session 2, shortened, looks like this.

```
ChessPiece
----------------------------------------
- String type
- String color
----------------------------------------
+ ChessPiece(String type, String color)
+ String getType()
```

You can draw it by hand and take a photo, or use any drawing tool.

Answer each question in a few sentences.

1. Which methods in your design can change a balance, and from which class is each of them called? Why can `Main` not repeat the sabotage of `FlatShare`?
2. The history of `FlatShare` says that Sofie paid for the groceries, before Sofie even lived in the flat. Why does that happen, and what in your design prevents it?
3. Look at your two cost lines. Did anything tell you where the rent had to go? What would you want the compiler to do when a type of expense is forgotten in a `switch`?

## Feedback

Mads looks at four things.

- Your program prints exactly what is in `expected-output.txt`.
- Your four classes follow the four rules of exercise 2.
- The sabotage line is in `Main.main`, commented out, with its error message.
- Your class diagram matches your code, and your answers explain your reasons.

For each of the four, the feedback tells you in words what went well and what to improve. You do not get a mark or a grade for this assignment.
