package session2.E_ChessGame;

/**
 * Session 1's three path-checking helpers, retrained to read an object
 * board instead of a char[][]. Same names, same rules, same shape — only
 * "is this square empty?" changed: it used to be board[row][col] == '.',
 * now it is board.getPieceAt(row, col) == null.
 *
 * They are static: they belong to no piece in particular, they are pure
 * geometry. Whether rules like these should live in their own helper
 * class, in the pieces, or in the board is a real design question — we
 * take it up properly in session 4.
 */
public class Movements {

    /**
     * Horizontal move: same row, the column changes by at most
     * maxDistance, and every square strictly BETWEEN the two must be
     * empty. (The target square itself may hold an enemy piece: that is a
     * capture, and the board checks whose piece it is.)
     */
    public static boolean isLegalHorizontalMove(ChessBoard board, int fromRow, int fromCol,
                                                int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        // Not horizontal, not moving at all, or moving too far.
        if (rowDistance != 0 || colDistance == 0 || colDistance > maxDistance) {
            return false;
        }

        // Walk the squares between the two columns: all must be empty.
        int col = Math.min(fromCol, toCol) + 1;
        int lastCol = Math.max(fromCol, toCol);
        while (col < lastCol) {
            if (board.getPieceAt(fromRow, col) != null) {
                return false;   // another piece is in the way
            }
            col++;
        }
        return true;
    }

    /** Vertical move: same column, the row changes. Same idea as horizontal. */
    public static boolean isLegalVerticalMove(ChessBoard board, int fromRow, int fromCol,
                                              int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        if (colDistance != 0 || rowDistance == 0 || rowDistance > maxDistance) {
            return false;
        }

        int row = Math.min(fromRow, toRow) + 1;
        int lastRow = Math.max(fromRow, toRow);
        while (row < lastRow) {
            if (board.getPieceAt(row, fromCol) != null) {
                return false;
            }
            row++;
        }
        return true;
    }

    /**
     * Diagonal move: row and column change by the same amount. To walk the
     * path we step one square at a time in the right direction, which is
     * +1 or -1 on each axis.
     */
    public static boolean isLegalDiagonalMove(ChessBoard board, int fromRow, int fromCol,
                                              int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        if (rowDistance != colDistance || rowDistance == 0 || rowDistance > maxDistance) {
            return false;
        }

        int rowStep;   // +1 going down, -1 going up
        if (toRow > fromRow) {
            rowStep = 1;
        } else {
            rowStep = -1;
        }

        int colStep;   // +1 going right, -1 going left
        if (toCol > fromCol) {
            colStep = 1;
        } else {
            colStep = -1;
        }

        // Walk the squares strictly between the two ends: all must be empty.
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
}
