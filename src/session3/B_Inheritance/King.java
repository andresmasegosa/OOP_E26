package session3.B_Inheritance;

/** The king: one square, in any direction. Compare with Queen.java and Rook.java. */
public class King extends ChessPiece {

    public King(String color, int row, int col) {
        super("King", color);
        setRow(row);
        setCol(col);
        System.out.println("  the King constructor runs");
    }

    @Override
    public boolean isLegalMove(int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(row, col, toRow, toCol, 1)
                || Movements.isLegalVerticalMove(row, col, toRow, toCol, 1)
                || Movements.isLegalDiagonalMove(row, col, toRow, toCol, 1);
    }
}
