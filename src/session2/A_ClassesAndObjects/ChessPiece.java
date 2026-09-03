package session2.A_ClassesAndObjects; // Packages are this week's pre-class reading (JBG chapter 8), not a topic of the session. See README.md.

/**
 * Session 2, step A — the first class of the course.
 *
 * In session 1 a piece was a char: 'Q' sitting in a char[8][8]. Everything
 * else the program knew about that piece — its color, its name, whether a
 * move is legal for it — lived somewhere else, in a switch or an if, far
 * from the char itself. That scattering was the subject of session 1's
 * final reflection.
 *
 * A CLASS puts an end to the scattering. It is a template that says: every
 * chess piece has a type, a color and a square — and here is the code that
 * belongs with that data. From one class we can create as many OBJECTS as
 * we want, and each object carries its own copies of the fields.
 *
 * Vocabulary for the week:
 *   class   = the template (this file defines exactly one: ChessPiece)
 *   object  = one piece created from the template, living in memory
 *   field   = a variable inside every object (type, color, row, col)
 *   method  = a function that lives in the class and works on the fields
 *             of the object it is called on
 */
public class ChessPiece {

    // The fields. Every ChessPiece object gets its own copies of these
    // four. They are marked public: ANY code anywhere may read them — and
    // write them. Keep an eye on that word. It becomes the villain of
    // step D.
    public String type;    // "King", "Queen", "Rook" or "Bishop"
    public String color;   // "White" or "Black"
    public int row;        // 0..7, row 0 is the top (Black's side)
    public int col;        // 0..7

    /**
     * A method: code living WITH the data it needs. In session 1 this
     * message was assembled inside movePiece out of two switches
     * (colorName and pieceName). Now the piece describes itself — and no
     * switch is needed, because the type is not a cryptic char that must
     * be translated: it IS the name.
     */
    public String describe() {
        return color + " " + type + " at (" + row + "," + col + ")";
    }

    /**
     * Session 1 answered this question with Character.isUpperCase(piece).
     * Compare. (Strings are compared with equals, not with ==. Why not
     * ==? Step B knows.)
     */
    public boolean isWhite() {
        return color.equals("White");
    }
}
