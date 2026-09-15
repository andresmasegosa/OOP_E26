package session3.B_Inheritance;

/**
 * Session 3, step B. The part every piece shares, written once — and the
 * question every piece can be asked.
 *
 * Step A left two complaints, and this class answers both at once. Queen and
 * Rook were the same file twice, with one line different. And the board could
 * not hold them: an array has one element type, and an array of Object held
 * them but could not be asked anything.
 *
 * A subclass gets two things from its superclass. It gets the CODE, so a
 * Queen has getColor without declaring it. And it gets the TYPE, so a Queen
 * can be stored wherever a ChessPiece is expected, and asked anything
 * ChessPiece declares (chapter 7, "Inheritance Basics").
 *
 * isLegalMove is declared here, so every ChessPiece can be asked. A subclass
 * that declares a method with the same name and the same parameters overrides
 * it. When the object is a Queen, Queen's version runs, whatever the type of
 * the variable that holds her, and Java picks the version while the program
 * runs, by looking at the object (chapter 7, "Method Overriding" and
 * "Overridden Methods Support Polymorphism").
 *
 * The println in the constructor is there only so that you can see when the
 * constructor runs. The game in E_ChessGame has no such line.
 */
public class ChessPiece {

    // Protected, so that the subclasses can read them directly, the way each
    // class read its own three fields in step A. Nothing else changed: they
    // are declared once here instead of once per piece.
    protected String type;    // "King", "Queen" or "Rook", passed up by each subclass
    protected String color;
    protected int row = -1;   // born off the board, as in session 2
    protected int col = -1;

    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
        System.out.println("  the ChessPiece constructor runs, color " + color);
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

    // Protected, as in session 2. The comment there promised that subclasses
    // would be allowed to call these two, and Queen, Rook and King do.
    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }

    /**
     * The version that runs when a subclass does not override this method. A
     * piece nobody taught cannot move. It is session 2's silent default
     * branch, moved into the superclass — and it is still silent, which is
     * what the last lines of Demo show. Step C takes the default away.
     */
    public boolean isLegalMove(int toRow, int toCol) {
        return false;
    }
}
