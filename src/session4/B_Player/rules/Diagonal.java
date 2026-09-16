package session4.B_Player.rules;

import session4.B_Player.ChessBoard;

/**
 * Moving along a diagonal, up to maxDistance squares, without jumping over
 * anything. Session 1's isLegalDiagonalMove, with the distance as a field and
 * the arithmetic inside the class that uses it.
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

        // A diagonal changes both by the same amount, and by at least one.
        if (rowDistance != colDistance || rowDistance == 0 || rowDistance > maxDistance) {
            return false;
        }

        // Walk the squares strictly between the two ends: all must be empty.
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

    /** -1 or +1: which way to walk along one axis. */
    private static int step(int from, int to) {
        if (to > from) {
            return 1;
        }
        return -1;
    }
}
