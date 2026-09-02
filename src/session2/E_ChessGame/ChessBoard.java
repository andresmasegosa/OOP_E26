package session2.E_ChessGame;

/**
 * The board of the refactored game: session 1's char[8][8], grown up.
 *
 * The grid is PRIVATE. That is the answer to session 1's sabotage, where
 * any line of code could write any square. The doors are step D's two,
 * plus two:
 *   placePiece — puts a piece on its first square; it can refuse;
 *   getPieceAt — reading, open to everyone;
 *   movePiece  — new: the one legal way a piece changes square;
 *   print      — new: the board draws itself, session 1's picture.
 *
 * Compare the checks in movePiece with session 1's isLegalMove/movePiece
 * pair: the same rules — but now there is no way around them.
 */
public class ChessBoard {

    private ChessPiece[][] pieces = new ChessPiece[8][8];

    /**
     * The piece standing on (row, col), or null for an empty square — and
     * null, too, for a square that does not exist. Off the board there is
     * no square at all, and null is also what an empty square answers; we
     * accept that blur for now (session 8 gives "no such square" a voice
     * of its own). What it buys today: nobody who asks the board has to
     * check the bounds first. The board knows its own size.
     */
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
     * Step D's door, unchanged: refuses squares off the board and squares
     * already taken, and keeps the piece's own coordinates in step. It is
     * public, as in step D — whether it should stay that way once a game
     * is under way is exercise 3's question.
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
     * The one legal way to move. Session 1's movePiece also did the
     * printing; here the board only enforces and updates, and the talking
     * is left to ChessGame. Returns whether the move was made.
     */
    public boolean movePiece(ChessPiece piece, int toRow, int toCol) {
        if (piece == null) {
            return false;               // there is no piece to move
        }
        if (!isOnBoard(piece.getRow(), piece.getCol())) {
            return false;               // a piece that stands nowhere cannot move
        }
        if (!isOnBoard(toRow, toCol)) {
            return false;               // both squares must exist — as in session 1
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

    /**
     * Draws the board — the same picture as session 1, to the character.
     * The board knows what it looks like, so the board draws it; inside
     * these walls the array is ours to walk, no door needed.
     *
     * One thing to notice for later: this method talks to the console.
     * Whether a board should know that a console exists is a
     * responsibilities question (session 4), and session 7 will give us a
     * concrete reason to change it — what is printed cannot be tested,
     * what is returned as a String can.
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
