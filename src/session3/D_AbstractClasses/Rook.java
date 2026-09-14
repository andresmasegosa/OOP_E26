package session3.D_AbstractClasses;

/** The rook. Nothing changed from step C. */
public class Rook extends ChessPiece {

    public Rook(String color, int row, int col) {
        super("Rook", color);
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
        return rowDistance == 0 || colDistance == 0;
    }
}
