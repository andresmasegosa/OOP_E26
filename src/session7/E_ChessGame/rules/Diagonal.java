package session7.E_ChessGame.rules;

import session7.E_ChessGame.ChessBoard;

/**
 * Moving along a diagonal, up to maxDistance squares, without jumping over
 * another piece. A bishop holds a Diagonal(7), and a king a Diagonal(1).
 */
public class Diagonal implements MoveRule {

    private int maxDistance;

    public Diagonal(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean allows(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        // On a diagonal the row and the column change by the same amount, at least one.
        if (rowDistance != colDistance || rowDistance == 0 || rowDistance > maxDistance) {
            return false;
        }

        // Every square strictly between the two ends must be empty.
        int rowStep = step(fromRow, toRow);
        int colStep = step(fromCol, toCol);
        int row = fromRow + rowStep;
        int col = fromCol + colStep;
        while (row != toRow) {
            if (board.getPieceAt(row, col) != null) {
                return false;
            }
            row = row + rowStep;
            col = col + colStep;
        }
        return true;
    }

    /** The direction to walk along one axis, -1 or +1. */
    private static int step(int from, int to) {
        if (to > from) {
            return 1;
        }
        return -1;
    }
}
