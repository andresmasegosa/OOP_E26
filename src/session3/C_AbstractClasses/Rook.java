package session3.C_AbstractClasses;

/** The rook. The rule is step B's; only the constructor's println is gone. */
public class Rook extends ChessPiece {

    public Rook(String color, int row, int col) {
        super("Rook", color);
        setRow(row);
        setCol(col);
    }

    @Override
    public boolean isLegalMove(int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalVerticalMove(row, col, toRow, toCol, 7);
    }
}
