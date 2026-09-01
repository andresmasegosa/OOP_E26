package session2.B_ReferencesAndAliasing;

/**
 * Session 2, step B — the same class as step A, plus ONE new field:
 * moveCount.
 *
 * moveCount is the statistic your chess club asked for in session 1,
 * exercise 3 — the one that needed a second 8x8 array which movePiece kept
 * in sync by hand. Now it is just... a field. Data about the piece, living
 * inside the piece.
 *
 * The demo next door is about what a ChessPiece VARIABLE really holds —
 * which is the thing session 1's design could never give you.
 */
public class ChessPiece {

    public String type;
    public String color;
    public int row;
    public int col;
    public int moveCount;   // how many times this piece has moved

    public String describe() {
        return color + " " + type + " at (" + row + "," + col + ")"
                + ", moves so far: " + moveCount;
    }

    public boolean isWhite() {
        return color.equals("White");
    }
}
