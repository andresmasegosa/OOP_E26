# OOP E26 — course code

Code for the Autumn 2026 edition of **Object-Oriented Programming** (module
`DSNSWCB332`), 3rd semester of Software, AAU Copenhagen.

## The running example

This course grows **one program** across the whole semester: a chess game.

- **Session 1** shows a working chess game built with no object-oriented programming at
  all — just variables, arrays, conditionals, loops and static methods. It works, and
  it is painful to grow. We measure the pain.
- The following sessions rebuild and extend the same game as we learn better tools:
  classes and encapsulation, inheritance and interfaces, collections, tests,
  exceptions, design patterns.

Each session is a package under `src/`, with its own `README.md` (what to prepare
before class) and `EXERCISES.md`.

| Session | Contents |
|---|---|
| [session1](src/session1/README.md) | Intro to Java, through chess: the game with no objects |
| session2… | *(coming as the course advances)* |

## How to open the project

1. Install [IntelliJ IDEA](https://www.jetbrains.com/idea/) (Community Edition is
   enough) and a JDK, version 21 or newer.
2. Clone or download this repository and open the folder in IntelliJ.
3. If sources are not detected automatically: right-click `src` → *Mark Directory as*
   → *Sources Root*.
4. Open `src/session1/A_HelloChess.java` and press the green ▶ next to `main`.
