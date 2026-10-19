# Session 7 — Generics and collections

Until now a group of objects was an array. This session replaces arrays with lists, sets and
maps from `java.util`. Sets and maps only work with your own classes once those classes have
`equals` and `hashCode`, so that is where we start.

## Before class

1. In *Java: A Beginner's Guide* (Herbert Schildt), read the section "The Object Class" of
   chapter 7, and chapter 13 from "Generics Fundamentals" to the end of "A Simple Generics
   Example".
2. Read the pages on `Collection`, `Set`, `List` and `Map` in the
   [Collections trail](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)
   of the Java Tutorials.

## In class

We go through the four step folders in order. Each step is shown in class, and then you do its
exercise. After that comes the game, with three exercises.

| Folder | What it shows |
|---|---|
| [`A_ObjectMethods`](A_ObjectMethods/) | `equals`, `hashCode` and `toString` |
| [`B_Generics`](B_Generics/) | a class with a type parameter |
| [`C_List`](C_List/) | a `List`, and sorting it with a `Comparator` |
| [`D_SetAndMap`](D_SetAndMap/) | a `Set` and a `Map` |
| [`E_ChessGame`](E_ChessGame/) | the game from session 5, improved with lists and a map |

Each folder has its own `EXERCISES.md` and `EXERCISE.yml`.
