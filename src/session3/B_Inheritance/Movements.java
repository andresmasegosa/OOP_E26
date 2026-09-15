package session3.B_Inheritance;

/**
 * Session 1's three movement helpers, and session 2's, cut down to the shape
 * of a move.
 *
 * The full versions live in E_ChessGame. They take the board as well, because
 * a queen may not jump over a piece, and they walk the squares in between.
 * These demo steps have no board, so these check only the shape: is this a
 * row, a column or a diagonal, and is it short enough? Same three names, same
 * parameters in the same order, one fewer.
 *
 * They are static: they belong to no piece in particular, they are pure
 * geometry. Where rules like these should live — in a helper class, in the
 * pieces, or in the board — is a real design question, and session 4 takes it
 * up properly.
 */
public class Movements {

    /** Same row, the column changes by 1 to maxDistance. */
    public static boolean isLegalHorizontalMove(int fromRow, int fromCol,
                                                int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);
        return rowDistance == 0 && colDistance != 0 && colDistance <= maxDistance;
    }

    /** Same column, the row changes by 1 to maxDistance. */
    public static boolean isLegalVerticalMove(int fromRow, int fromCol,
                                              int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);
        return colDistance == 0 && rowDistance != 0 && rowDistance <= maxDistance;
    }

    /** Row and column change by the same amount, 1 to maxDistance. */
    public static boolean isLegalDiagonalMove(int fromRow, int fromCol,
                                              int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);
        return rowDistance == colDistance && rowDistance != 0 && rowDistance <= maxDistance;
    }
}
