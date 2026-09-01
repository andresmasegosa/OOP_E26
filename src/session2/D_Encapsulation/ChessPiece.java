package session2.D_Encapsulation;

/**
 * Session 2, step D — the fields go private.
 *
 * Until now every field was public: any code anywhere could write
 * queen.col = 5 and the piece would believe it — no rule ran, no path was
 * checked. The demo shows the damage.
 *
 * ENCAPSULATION is the fix: fields are private, and the only ways in are
 * the methods the class chooses to offer — its doors. A public field is a
 * hole in the wall; a method is a door with a doorkeeper, and the
 * doorkeeper can validate, refuse, and keep the object consistent.
 *
 * The rule from here to the end of the course: EVERYTHING PRIVATE UNLESS
 * THERE IS A REASON. For every member, the visibility is a decision.
 */
public class ChessPiece {

    private String type;
    private String color;
    private int row;
    private int col;

    /** A piece is born off the board: (-1,-1) means "placed nowhere yet". */
    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
        this.row = -1;
        this.col = -1;
    }

    // GETTERS. Reading is harmless, so these doors are open to everyone.
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isWhite() {
        return color.equals("White");
    }

    public String describe() {
        return color + " " + type + " at (" + row + "," + col + ")";
    }

    // There are NO public setRow/setCol doors: a piece's square is the
    // BOARD's business, and pieces will move by asking the board (step E).
    // These two are 'protected' — stricter than public, looser than
    // private: classes in this same package (that is: the board) may call
    // them, and so will subclasses when those arrive in session 3.
    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
