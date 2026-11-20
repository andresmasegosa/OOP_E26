package session2.solution;

/**
 * Session 2 — OFFICIAL SOLUTION, movements side.
 *
 * No exercise touches this file: the knight needs no path check (it
 * jumps), and the bishop only needed a case in ChessPiece. It is here
 * unchanged so the solution folder compiles and runs on its own.
 */
public class Movements {

    public static boolean isLegalHorizontalMove(ChessBoard board, int fromRow, int fromCol,
                                                int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        if (rowDistance != 0 || colDistance == 0 || colDistance > maxDistance) {
            return false;
        }

        int col = Math.min(fromCol, toCol) + 1;
        int lastCol = Math.max(fromCol, toCol);
        while (col < lastCol) {
            if (board.getPieceAt(fromRow, col) != null) {
                return false;
            }
            col++;
        }
        return true;
    }

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

    public static boolean isLegalDiagonalMove(ChessBoard board, int fromRow, int fromCol,
                                              int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        if (rowDistance != colDistance || rowDistance == 0 || rowDistance > maxDistance) {
            return false;
        }

        int rowStep;
        if (toRow > fromRow) {
            rowStep = 1;
        } else {
            rowStep = -1;
        }

        int colStep;
        if (toCol > fromCol) {
            colStep = 1;
        } else {
            colStep = -1;
        }

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
