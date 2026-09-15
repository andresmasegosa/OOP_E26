package session3.C_AbstractClasses;

/** The queen. The rule is step B's; only the constructor's println is gone. */
public class Queen extends ChessPiece {

    public Queen(String color, int row, int col) {
        super("Queen", color);
        setRow(row);
        setCol(col);
    }

    @Override
    public boolean isLegalMove(int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalVerticalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalDiagonalMove(row, col, toRow, toCol, 7);
    }
}
