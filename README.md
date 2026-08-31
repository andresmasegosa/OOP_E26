# OOP E26 — course code

Code for the Autumn 2026 edition of Object-Oriented Programming (module
`DSNSWCB332`), 3rd semester of Software, AAU Copenhagen.

## The running example

In this course we build one program and keep working on it the whole semester:
a chess game.

Session 1 gives you a working chess game with no object-oriented programming
in it, only variables, arrays, conditionals, loops and static methods. It
works, but it is painful to grow, and we will be measuring that cost
throughout the course. The sessions after that rebuild and extend the same
game as we learn better tools: classes and encapsulation, inheritance and
interfaces, collections, tests, exceptions and design patterns.

Each session is a package under `src/`, with a `README.md` that says what to
prepare before class, and an `EXERCISES.md`.

| Session | Contents |
|---|---|
| [session1](src/session1/README.md) | Intro to Java, through chess: the game with no objects |
| session2… | added as the course advances |

## How to open the project

1. Install [IntelliJ IDEA](https://www.jetbrains.com/idea/) (the Community
   Edition is enough) and a JDK, version 21 or newer.
2. Clone or download this repository and open the folder in IntelliJ.
3. If the sources are not detected automatically, right-click on `src` and
   choose *Mark Directory as* → *Sources Root*.
4. Open `src/session1/A_HelloChess.java` and press the green ▶ next to `main`.
