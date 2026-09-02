package session2.E_ChessGame;

/**
 * The board of the refactored game: session 1's char[8][8], grown up.
 *
 * The grid is PRIVATE. That is the answer to session 1's sabotage, where
 * any line of code could write any square. The doors are step D's two,
 * plus one:
 *   placePiece — puts a piece on its first square; it can refuse;
 *   getPieceAt — reading, open to everyone;
 *   movePiece  — new: the one legal way a piece changes square.
 *
 * Compare the checks in movePiece with session 1's isLegalMove/movePiece
 * pair: the same rules — but now there is no way around them.
 */
public class ChessBoard {

    private ChessPiece[][] pieces = new ChessPiece[8][8];

    /** The piece standing on (row, col), or null for an empty square. */
    public ChessPiece getPieceAt(int row, int col) {
        return pieces[row][col];
    }

    /**
     * Step D's door, unchanged: refuses squares off the board and squares
     * already taken, and keeps the piece's own coordinates in step. It is
     * public, as in step D — whether it should stay that way once a game
     * is under way is exercise 3's question.
     */
    public boolean placePiece(int row, int col, ChessPiece piece) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            return false;               // no such square
        }
        if (pieces[row][col] != null) {
            return false;               // occupied: one piece per square
        }
        pieces[row][col] = piece;
        piece.setRow(row);
        piece.setCol(col);
        return true;
    }

    /**
     * The one legal way to move. Session 1's movePiece also did the
     * printing; here the board only enforces and updates, and the talking
     * is left to ChessGame. Returns whether the move was made.
     */
    public boolean movePiece(ChessPiece piece, int toRow, int toCol) {
        if (piece == null) {
            return false;               // there is no piece to move
        }
        if (toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            return false;               // both squares must exist
        }

        // You may capture an enemy piece, but never one of your own.
        ChessPiece target = pieces[toRow][toCol];
        if (target != null && target.isWhite() == piece.isWhite()) {
            return false;
        }

        // Each piece knows its own rule — the board just asks, handing
        // itself over: 'this' is this board, the one the path is on.
        if (!piece.isLegalMove(this, toRow, toCol)) {
            return false;
        }

        pieces[piece.getRow()][piece.getCol()] = null;
        pieces[toRow][toCol] = piece;   // a captured piece is simply no longer
                                        // on the board — the array forgets it
        piece.setRow(toRow);
        piece.setCol(toCol);
        return true;
    }
}
