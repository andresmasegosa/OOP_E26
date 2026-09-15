package session4.C_ChessGame;

import session4.C_ChessGame.players.Move;
import session4.C_ChessGame.players.Player;

/**
 * Session 4. The same chess game, and it no longer knows who is playing it.
 *
 * Read the top of this class and the top of session 3's. There the game
 * owned a Scanner, printed the prompt, forgave a typo and pulled four
 * numbers out of a line. None of that is here. The game has two Players,
 * asks the one whose turn it is for a move, and checks it. Whether that
 * player is a person or a program is a question this file cannot answer and
 * does not need to.
 *
 * That is what an interface buys, and Demo.main shows it in one line: the
 * same ChessGame plays a game between two programs and a game between you
 * and a program, and nothing in this file knows the difference.
 *
 * The turn is checked in takeTurn and nowhere else, because movePiece is
 * private now and a move can only arrive through a Player. In session 3 the
 * scripted game in Demo.main moved both sides freely, and the javadoc of
 * ChessGame.movePiece said so.
 *
 * THE RULES (mini-chess, unchanged)
 *   Only kings, queens, rooks and bishops. No pawns, no knights, no
 *   castling. You capture by moving onto an enemy piece. There is no check
 *   and no checkmate, so a game ends when a king is captured.
 */
public class ChessGame {

    private ChessBoard board;
    private boolean whiteToMove = true;
    private Player white;
    private Player black;
    private String winner;                // null while the game is running

    /**
     * A game is born whole: its board, the twelve pieces of this week's
     * position, and its two players. A game without players could not be
     * played, so the constructor does not let one exist.
     */
    public ChessGame(Player white, Player black) {
        this.board = new ChessBoard();
        this.white = white;
        this.black = black;
        setupPieces();
    }

    /**
     * The board this game is played on, as in session 3. Reading it is
     * harmless, and yet this door hands out the board itself, with its own
     * doors attached. Session 2's exercise 3 asked what that lets an
     * outsider do, and the answer has not changed.
     */
    public ChessBoard getBoard() {
        return board;
    }

    /**
     * The initial position, bishops included, built exactly as session 3
     * builds it: the game names the class it wants.
     */
    private void setupPieces() {
        // Black pieces, top of the board.
        board.placePiece(0, 0, new Rook("Black"));
        board.placePiece(0, 2, new Bishop("Black"));
        board.placePiece(0, 3, new Queen("Black"));
        board.placePiece(0, 4, new King("Black"));
        board.placePiece(0, 5, new Bishop("Black"));
        board.placePiece(0, 7, new Rook("Black"));

        // White pieces, bottom of the board.
        board.placePiece(7, 0, new Rook("White"));
        board.placePiece(7, 2, new Bishop("White"));
        board.placePiece(7, 3, new Queen("White"));
        board.placePiece(7, 4, new King("White"));
        board.placePiece(7, 5, new Bishop("White"));
        board.placePiece(7, 7, new Rook("White"));
    }

    /** Shows the board. The game asks; the board knows how to draw itself. */
    public void printBoard() {
        board.print();
    }

    /**
     * Play, from the first move to the last. This is session 3's play(),
     * with everything about the keyboard taken out of it.
     *
     * The loop is four lines of story. Show the position, ask whoever is to
     * move, stop if they have nothing to play, and take the turn.
     *
     * The board is drawn only when it has changed. Session 3 drew it before
     * every attempt, which was fine while a human was typing and is a wall
     * of boards once two scripts are playing.
     */
    public void play() {
        boolean positionChanged = true;

        while (true) {
            if (positionChanged) {
                printBoard();
            }

            String color;
            Player current;
            if (whiteToMove) {
                color = "White";
                current = white;
            } else {
                color = "Black";
                current = black;
            }

            Move move = current.chooseMove(board, color);

            if (move == null) {          // q, or a player that gives up
                System.out.println();
                System.out.println("Thanks for playing!");
                return;
            }

            positionChanged = takeTurn(move);

            if (winner != null) {
                printBoard();
                System.out.println();
                System.out.println(winner + " wins: the other king is off the board.");
                return;
            }
        }
    }

    /**
     * One turn: there must be a piece on the first square, it must belong
     * to the player whose turn it is, and then the move is tried. If it was
     * made, the turn passes, and this method answers true so that play()
     * knows the position is worth drawing again.
     *
     * This is the only place in the program where the turn is decided.
     * Nobody can move a piece without coming through here.
     */
    private boolean takeTurn(Move move) {
        int fromRow = move.getFromRow();
        int fromCol = move.getFromCol();

        ChessPiece chosen = board.getPieceAt(fromRow, fromCol);   // null off the board too
        if (chosen == null) {
            System.out.println("There is no piece on (" + fromRow + "," + fromCol + ")");
            return false;
        }
        if (chosen.isWhite() != whiteToMove) {
            System.out.println("That piece is not yours! The " + chosen.getColor() + " " + chosen.getType()
                    + " on (" + fromRow + "," + fromCol + ") belongs to the other player.");
            return false;
        }
        if (!movePiece(move)) {
            return false;
        }
        whiteToMove = !whiteToMove;   // the move was made: other player's turn
        return true;
    }

    /**
     * Tries a move and narrates what happened, in session 1's exact words.
     * It is private now. In session 3 it was public and Demo.main called it
     * directly, which is how the scripted game moved both sides without
     * anybody checking the turn.
     */
    private boolean movePiece(Move move) {
        int fromRow = move.getFromRow();
        int fromCol = move.getFromCol();
        int toRow = move.getToRow();
        int toCol = move.getToCol();

        ChessPiece piece = board.getPieceAt(fromRow, fromCol);

        // Look at the target BEFORE moving: if an enemy stands there, this
        // move is a capture, and we want to name the victim.
        ChessPiece target = board.getPieceAt(toRow, toCol);

        if (!board.movePiece(piece, toRow, toCol)) {
            System.out.println("Illegal move: (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol
                    + "): not how that piece moves, the path is blocked, or the target is your own piece");
            return false;
        }

        if (target != null) {
            System.out.println(piece.getColor() + " " + piece.getType() + " captures "
                    + target.getColor() + " " + target.getType() + " on (" + toRow + "," + toCol + ")!");

            // No check and no checkmate in this game, so taking the king is
            // how it ends. Note what the test is: a String compared with
            // "King". Session 3 took every switch out of the pieces, and a
            // piece's type is still a String that nobody can check, so a typo
            // here would be silent. Session 8 is where that ends.
            if (target.getType().equals("King")) {
                winner = piece.getColor();
            }
        } else {
            System.out.println(piece.getColor() + " " + piece.getType()
                    + " moves (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol + ")");
        }
        return true;
    }
}
