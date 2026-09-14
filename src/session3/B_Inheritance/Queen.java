package session3.B_Inheritance;

/**
 * A Queen is a ChessPiece. The words "extends ChessPiece" give this class
 * everything ChessPiece declares, so what is written here is only what makes
 * a queen different, her constructor and her rule.
 */
public class Queen extends ChessPiece {

    public Queen(String color, int row, int col) {
        super(color);   // runs ChessPiece's constructor, so the ChessPiece part exists before the lines below
        setRow(row);    // protected in ChessPiece, and a subclass may call it
        setCol(col);
        System.out.println("  the Queen constructor runs");
    }

    /** Step A's rule. */
    public boolean isLegalMove(int toRow, int toCol) {
        // The field row exists inside every Queen, but it is private to
        // ChessPiece, so this class reads it through getRow(). Write row
        // instead of getRow() on the next line and compile.
        //
        // error: row has private access in ChessPiece
        int rowDistance = Math.abs(toRow - getRow());
        int colDistance = Math.abs(toCol - getCol());
        if (rowDistance == 0 && colDistance == 0) {
            return false;
        }
        return rowDistance == 0 || colDistance == 0 || rowDistance == colDistance;
    }
}
