package session4.C_ChessGame;

/**
 * Session 3's board, and not one line of it changed. Open
 * session3/E_ChessGame/ChessBoard.java next to this file: apart from the
 * package line and this comment, they are the same file, although the
 * pieces on it no longer write their own rules.
 *
 * The board keeps session 2's four doors, placePiece, getPieceAt, movePiece
 * and print, and its three invariants. Pieces stand on real squares, there
 * is one piece per square, and a piece and the board agree on where the
 * piece stands.
 */
public class ChessBoard {

    private ChessPiece[][] pieces = new ChessPiece[8][8];

    public ChessPiece getPieceAt(int row, int col) {
        if (!isOnBoard(row, col)) {
            return null;
        }
        return pieces[row][col];
    }

    /**
     * Does this square exist? The ONE place in the program that knows the
     * board is 8x8. Static: it is about coordinates, not about what this
     * board holds.
     */
    private static boolean isOnBoard(int row, int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }

    /**
     * Session 2's door, unchanged. It refuses squares off the board and
     * squares already taken, and keeps the piece's own coordinates in step.
     */
    public boolean placePiece(int row, int col, ChessPiece piece) {
        if (!isOnBoard(row, col)) {
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
     * The one legal way to move, unchanged since session 2. The board still
     * hands itself to the piece as 'this', and the piece still asks its own
     * rules; what changed is that the piece holds them instead of writing
     * them.
     */
    public boolean movePiece(ChessPiece piece, int toRow, int toCol) {
        if (piece == null) {
            return false;               // there is no piece to move
        }
        if (!isOnBoard(piece.getRow(), piece.getCol())) {
            return false;               // a piece that stands nowhere cannot move
        }
        if (!isOnBoard(toRow, toCol)) {
            return false;               // both squares must exist
        }

        // You may capture an enemy piece, but never one of your own. This
        // rule is the board's, and no MoveRule knows about it. Exercise 1
        // makes you meet that on purpose.
        ChessPiece target = pieces[toRow][toCol];
        if (target != null && target.isWhite() == piece.isWhite()) {
            return false;
        }

        // Each piece knows its own rules, and the board just asks.
        if (!piece.isLegalMove(this, toRow, toCol)) {
            return false;
        }

        pieces[piece.getRow()][piece.getCol()] = null;
        pieces[toRow][toCol] = piece;   // a captured piece is simply no longer
                                        // on the board: the array forgets it
        piece.setRow(toRow);
        piece.setCol(toCol);
        return true;
    }

    /**
     * Draws the board, the same picture as session 1, to the character.
     *
     * This method talks to the console, and that is now a question with a
     * name. Whether a board should know that a console exists is exercise
     * 3, and session 7 will give a second reason to change it: what is
     * printed cannot be tested, what is returned as a String can.
     */
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
        System.out.println("      K king, Q queen, R rook, B bishop, . empty square");
    }
}
