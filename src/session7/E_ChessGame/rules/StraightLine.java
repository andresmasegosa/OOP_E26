package session7.E_ChessGame.rules;

import session7.E_ChessGame.ChessBoard;

/**
 * Moving along a row or a column, up to maxDistance squares, without jumping
 * over another piece. A rook holds a StraightLine(7), and a king a
 * StraightLine(1).
 */
public class StraightLine implements MoveRule {

    private int maxDistance;

    public StraightLine(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean allows(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        if (rowDistance != 0 && colDistance != 0) {
            return false;               // not along a row or a column
        }
        if (rowDistance == 0 && colDistance == 0) {
            return false;               // staying put is not a move
        }
        if (rowDistance > maxDistance || colDistance > maxDistance) {
            return false;
        }

        // Every square strictly between the two ends must be empty.
        int rowStep = step(fromRow, toRow);
        int colStep = step(fromCol, toCol);
        int row = fromRow + rowStep;
        int col = fromCol + colStep;
        while (row != toRow || col != toCol) {
            if (board.getPieceAt(row, col) != null) {
                return false;
            }
            row = row + rowStep;
            col = col + colStep;
        }
        return true;
    }

    /** The direction to walk along one axis, -1, 0 or +1. */
    private static int step(int from, int to) {
        if (to > from) {
            return 1;
        }
        if (to < from) {
            return -1;
        }
        return 0;
    }
}
