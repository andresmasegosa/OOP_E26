package session1; // Packages are explained in Session 2. For now, just leave this line as it is.

/**
 * Session 1, step A — our very first Java program.
 *
 * Every Java program starts running in a `main` method like the one below.
 * This one prints a chess board... a completely fake one: it is text we
 * wrote by hand, line by line.
 *
 * By the end of this session the board will be real: stored in memory,
 * printed by a loop, and with pieces that move by the rules.
 * That program is E_ChessGame, at the end of this folder.
 */
public class A_HelloChess {

    public static void main(String[] args) {
        // A variable holds a value. This one holds a text (a String).
        String welcome = "Welcome to OOP E26!";
        System.out.println(welcome);
        System.out.println();

        System.out.println("r . b q k b . r");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println("R . B Q K B . R");
    }
}
