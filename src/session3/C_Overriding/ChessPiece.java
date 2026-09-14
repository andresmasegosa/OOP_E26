package session3.C_Overriding;

/**
 * Session 3, step C. The superclass asks the question, and each subclass
 * gives its own answer.
 *
 * isLegalMove is now declared here, in ChessPiece, so every ChessPiece can be
 * asked. A subclass that declares a method with the same name and the same
 * parameters overrides it. When the object is a Queen, Queen's version runs,
 * whatever the type of the variable that holds her. Java picks the version
 * while the program runs, by looking at the object (chapter 7, "Method
 * Overriding" and "Overridden Methods Support Polymorphism").
 *
 * The type is back as a String, passed up by each subclass, so that the demo
 * can print what each piece is. Session 2's ChessPiece had the same field.
 */
public class ChessPiece {

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

    /**
     * The version that runs when a subclass does not override this method. A
     * piece nobody taught cannot move. It is session 2's silent default
     * branch, moved into the superclass.
     */
    public boolean isLegalMove(int toRow, int toCol) {
        return false;
    }
}
