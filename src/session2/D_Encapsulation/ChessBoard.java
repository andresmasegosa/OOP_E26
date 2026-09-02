package session2.D_Encapsulation;

/**
 * The board, rebuilt around one private field.
 *
 * In session 1 the board was a bare char[8][8], and exercise 4 proved the
 * problem: ANY code could write ANY square. The rules lived in movePiece,
 * but nothing forced anyone to go through movePiece. Your one-sentence
 * answer to that exercise has a name now.
 *
 * The array still exists — as a PRIVATE field. Outside this class, no code
 * can touch it. The doors this class offers are few, and each one defends
 * the board's INVARIANTS — the facts that must stay true no matter what:
 *   - pieces stand on real squares (0..7);
 *   - one piece per square;
 *   - a piece and the board agree on where the piece stands.
 */
public class ChessBoard {

    private ChessPiece[][] pieces = new ChessPiece[8][8];

    /**
     * The door for putting a piece on the board. It can REFUSE — that is
     * the whole point of being a method instead of a public array.
     */
    public boolean placePiece(int row, int col, ChessPiece piece) {
        if (!isOnBoard(row, col)) {
            return false;               // no such square
        }
        if (pieces[row][col] != null) {
            return false;               // occupied: one piece per square
        }
        pieces[row][col] = piece;
        piece.setRow(row);              // the board may: setRow is protected,
        piece.setCol(col);              // and board and piece share a package
        return true;
    }

    /**
     * Reading is harmless: anyone may look at any square — even one that
     * does not exist, and get null back instead of a crash. The board is
     * the one place that knows it is 8x8; nobody asking it has to.
     */
    public ChessPiece getPieceAt(int row, int col) {
        if (!isOnBoard(row, col)) {
            return null;
        }
        return pieces[row][col];
    }

    /** Does this square exist? Static: about coordinates, not about this board. */
    private static boolean isOnBoard(int row, int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }
}
