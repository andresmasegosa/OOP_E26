package session2.solution;

/**
 * Session 2 — OFFICIAL SOLUTION, board side.
 *
 * Two changes: after a successful move, the board tells the piece to count
 * it (exercise 2), and the legend it prints names the knight (exercise 5).
 * Everything else is exactly the session's ChessBoard.
 */
public class ChessBoard {

    private ChessPiece[][] pieces = new ChessPiece[8][8];

    public ChessPiece getPieceAt(int row, int col) {
        if (!isOnBoard(row, col)) {
            return null;
        }
        return pieces[row][col];
    }

    private static boolean isOnBoard(int row, int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }

    public boolean placePiece(int row, int col, ChessPiece piece) {
        if (!isOnBoard(row, col)) {
            return false;
        }
        if (pieces[row][col] != null) {
            return false;
        }
        pieces[row][col] = piece;
        piece.setRow(row);
        piece.setCol(col);
        return true;
    }

    public boolean movePiece(ChessPiece piece, int toRow, int toCol) {
        if (piece == null) {
            return false;
        }
        if (!isOnBoard(piece.getRow(), piece.getCol())) {
            return false;
        }
        if (!isOnBoard(toRow, toCol)) {
            return false;
        }

        ChessPiece target = pieces[toRow][toCol];
        if (target != null && target.isWhite() == piece.isWhite()) {
            return false;
        }

        if (!piece.isLegalMove(this, toRow, toCol)) {
            return false;
        }

        pieces[piece.getRow()][piece.getCol()] = null;
        pieces[toRow][toCol] = piece;
        piece.setRow(toRow);
        piece.setCol(toCol);

        // SOLUTION (exercise 2): the move happened, so the board — the only
        // class that can know — tells the piece to count it. recordMove is
        // protected: reachable from here, not from the whole program.
        piece.recordMove();

        return true;
    }

    public void print() {
        System.out.println();
        System.out.println("        0 1 2 3 4 5 6 7   <- col");
        System.out.println("      +-----------------+");
        for (int row = 0; row < 8; row++) {
            System.out.print("row " + row + " | ");
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = pieces[row][col];
                if (piece == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(piece.getSymbol() + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("      +-----------------+");
        System.out.println("      UPPERCASE = White, lowercase = black");
        // SOLUTION (exercise 5): the legend names the knight.
        System.out.println("      K king, Q queen, R rook, B bishop, N knight, . empty square");
    }
}
