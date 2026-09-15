package session4.B_Player.rules;

import session4.B_Player.ChessBoard;

/**
 * Moving along a row or a column, up to maxDistance squares, without jumping
 * over anything.
 *
 * The arithmetic is session 1's, and you have read it three times: the two
 * squares must share a row or a column, the distance must not be more than
 * this rule allows, and every square strictly between the two must be empty.
 * What changed is where it lives. It used to be two static methods,
 * isLegalHorizontalMove and isLegalVerticalMove, that anybody could call about
 * anything. Here it is the body of one object.
 *
 * And the maximum distance is a field now. In session 3 it was a number each
 * piece passed on every call, 7 for a rook and 1 for a king, so the number
 * lived in the piece. Here it lives in the rule, and one class serves both
 * pieces because the two objects hold different numbers.
 */
public class StraightLine implements MoveRule {

    private int maxDistance;

    public StraightLine(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    /** Not in MoveRule. Step A's demo shows what that means. */
    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public boolean allows(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        // Exactly one of the two must change, and by no more than maxDistance.
        if (rowDistance != 0 && colDistance != 0) {
            return false;               // not a straight line at all
        }
        if (rowDistance == 0 && colDistance == 0) {
            return false;               // staying put is not a move
        }
        if (rowDistance > maxDistance || colDistance > maxDistance) {
            return false;               // too far for this rule
        }

        // Walk the squares strictly between the two ends: all must be empty.
        // The target square itself may hold an enemy piece, which is a
        // capture, and the board is the one that checks whose piece it is.
        int rowStep = step(fromRow, toRow);
        int colStep = step(fromCol, toCol);
        int row = fromRow + rowStep;
        int col = fromCol + colStep;
        while (row != toRow || col != toCol) {
            if (board.getPieceAt(row, col) != null) {
                return false;           // another piece is in the way
            }
            row = row + rowStep;
            col = col + colStep;
        }
        return true;
    }

    /** -1, 0 or +1: which way to walk along one axis. */
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
