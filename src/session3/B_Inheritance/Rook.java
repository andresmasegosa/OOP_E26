package session3.B_Inheritance;

/** A Rook is a ChessPiece too. Compare with Queen.java. Only the rule differs. */
public class Rook extends ChessPiece {

    public Rook(String color, int row, int col) {
        super(color);
        setRow(row);
        setCol(col);
        System.out.println("  the Rook constructor runs");
    }

    /** Step A's rule. */
    public boolean isLegalMove(int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - getRow());
        int colDistance = Math.abs(toCol - getCol());
        if (rowDistance == 0 && colDistance == 0) {
            return false;
        }
        return rowDistance == 0 || colDistance == 0;
    }
}
