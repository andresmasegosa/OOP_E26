package session3.D_AbstractClasses;

/** The king, with step C's misspelled name fixed and @Override in place. */
public class King extends ChessPiece {

    public King(String color, int row, int col) {
        super("King", color);
        setRow(row);
        setCol(col);
    }

    @Override
    public boolean isLegalMove(int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - getRow());
        int colDistance = Math.abs(toCol - getCol());
        if (rowDistance == 0 && colDistance == 0) {
            return false;
        }
        return rowDistance <= 1 && colDistance <= 1;
    }
}
