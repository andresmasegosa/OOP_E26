package session3.C_AbstractClasses;

/** The king. The rule is step B's; only the constructor's println is gone. */
public class King extends ChessPiece {

    public King(String color, int row, int col) {
        super("King", color);
        setRow(row);
        setCol(col);
    }

    @Override
    public boolean isLegalMove(int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(row, col, toRow, toCol, 1)
                || Movements.isLegalVerticalMove(row, col, toRow, toCol, 1)
                || Movements.isLegalDiagonalMove(row, col, toRow, toCol, 1);
    }
}
