package session3.D_AbstractClasses;

/**
 * Session 3, step D. A class nobody can create, and a method every subclass
 * must write.
 *
 * Two things changed since step C, and both are the word abstract. The class
 * is abstract, so nobody can create a plain ChessPiece any more, only a
 * Queen, a Rook or a King. And isLegalMove is abstract. It has no body, and
 * every class that extends ChessPiece has to write one, or that class does
 * not compile (chapter 7, "Using Abstract Classes").
 *
 * This is the wish session 2 ended with. Forget the rule of a piece, and the
 * compiler tells you.
 *
 * An abstract class is still a class. It has fields and a constructor, and
 * its subclasses inherit its ordinary methods exactly as in step B.
 */
public abstract class ChessPiece {

    private String type;
    private String color;
    private int row = -1;
    private int col = -1;

    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

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

    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }

    /** Every subclass must say how its piece moves. There is no default any more. */
    public abstract boolean isLegalMove(int toRow, int toCol);
}
