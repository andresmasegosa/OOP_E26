package session3.C_Overriding;

/** The queen, overriding ChessPiece.isLegalMove with her own rule. */
public class Queen extends ChessPiece {

    public Queen(String color, int row, int col) {
        super("Queen", color);
        setRow(row);
        setCol(col);
    }

    // @Override asks the compiler to check that this method really overrides
    // a method of the superclass. This one does, so the line changes nothing
    // here. King.java shows the day it matters.
    @Override
    public boolean isLegalMove(int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - getRow());
        int colDistance = Math.abs(toCol - getCol());
        if (rowDistance == 0 && colDistance == 0) {
            return false;
        }
        return rowDistance == 0 || colDistance == 0 || rowDistance == colDistance;
    }
}
