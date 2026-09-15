package session3.E_ChessGame;

import java.util.Scanner;   // our first import: Scanner lives in the package java.util

/**
 * Session 3. The same chess game as session 2, with the pieces rebuilt as a
 * family of classes.
 *
 * Almost nothing in this file changed. The board, the turn, the narration of
 * a move and the keyboard loop are session 2's. What changed is where the
 * pieces come from. Session 2 wrote new ChessPiece('Q'), and ChessPiece is
 * abstract now, so setupPieces creates a Rook, a Queen or a King directly.
 *
 * Run Demo and read the output carefully, because one thing differs from
 * session 2. The bishops are not on the board at all, which is exercise 1.
 *
 * THE RULES (mini-chess, unchanged)
 *   Only kings, queens, rooks and bishops, and knights once exercise 2 adds
 *   them. No pawns, no check, no castling. You capture by moving onto an
 *   enemy piece.
 */
public class ChessGame {

    private ChessBoard board;             // the game HAS a board: no longer a parameter
    private boolean whiteToMove = true;   // whose turn: no longer a local variable of play()

    /**
     * A game is born whole, with its board and the eight pieces of this
     * week's position on it. A ChessGame without a board makes no sense, so
     * the constructor does not let one exist.
     */
    public ChessGame() {
        this.board = new ChessBoard();
        setupPieces();
    }

    /**
     * The board this game is played on. Reading it is harmless — and yet
     * this door hands out the board itself, with its own doors attached.
     * Session 2's exercise 3 asked what that lets an outsider do.
     */
    public ChessBoard getBoard() {
        return board;
    }

    /**
     * The initial position of session 2, without the bishops. Session 2 wrote
     * new ChessPiece('r'), one constructor for every type of piece. ChessPiece
     * is abstract now, so the game creates the piece it wants directly, and the
     * compiler checks every class name on these eight lines.
     */
    private void setupPieces() {
        // There are no bishops. Exercise 1 is about them.

        // Black pieces, top of the board.
        board.placePiece(0, 0, new Rook("Black"));
        board.placePiece(0, 3, new Queen("Black"));
        board.placePiece(0, 4, new King("Black"));
        board.placePiece(0, 7, new Rook("Black"));

        // White pieces, bottom of the board.
        board.placePiece(7, 0, new Rook("White"));
        board.placePiece(7, 3, new Queen("White"));
        board.placePiece(7, 4, new King("White"));
        board.placePiece(7, 7, new Rook("White"));
    }

    /** Shows the board. The game asks; the board knows how to draw itself. */
    public void printBoard() {
        board.print();
    }

    /**
     * Tries a move given as squares, session 1 style, and narrates what
     * happened in session 1's exact words. Notice how little this method
     * knows: the board decides, the pieces know their rules, and this
     * method just talks. (It does not check whose turn it is — the
     * keyboard game does, in takeTurn. The scripted game in Demo's main
     * moves both sides freely.)
     */
    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        // No bounds to check here: the board answers null for a square that
        // does not exist, and null is refused by movePiece like any other
        // missing piece.
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
        } else {
            System.out.println(piece.getColor() + " " + piece.getType()
                    + " moves (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol + ")");
        }
        return true;
    }

    /**
     * Play from the keyboard. White and Black take turns, and a move is
     * typed as one line of four numbers: the square of the piece, then the
     * square it goes to — fromRow fromCol toRow toCol, for example 7 3 4 3.
     *
     * This is session 1's loop with two changes on the surface: it repeats
     * how to type a move on every turn, and a mistyped line gets a message
     * instead of a crash. Under the surface everything changed: "the piece
     * on a square" is an object, asking whether it is White means asking
     * the piece itself, and whose turn it is is a field of this game.
     *
     * Scanner is the same tool as in session 1. Reading a whole line
     * (nextLine) and then looking at it before taking numbers out of it
     * (hasNextInt) is what makes a typo forgivable — nothing about classes
     * or objects in that, so do not look for the session in here.
     */
    public void play() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println();
        System.out.println("Your turn! White plays the UPPERCASE pieces and moves first.");

        while (true) {
            printBoard();

            String player;
            if (whiteToMove) {
                player = "White";
            } else {
                player = "Black";
            }
            System.out.println(player + " to move. Type the square of the piece and the square it goes to,");
            System.out.println("as four numbers: fromRow fromCol toRow toCol   (for example: 7 3 4 3). Type q to quit.");
            System.out.print(player + " > ");

            if (!keyboard.hasNextLine()) {      // the input ended (Ctrl-D, or a file ran out)
                System.out.println();
                System.out.println("Thanks for playing!");
                return;
            }
            String line = keyboard.nextLine().trim();
            if (line.equals("q") || line.equals("quit")) {
                System.out.println("Thanks for playing!");
                return;
            }

            // Be forgiving about punctuation: "7,3 4,3" and "(7,3) -> (4,3)",
            // which is how the game itself writes a move, both mean 7 3 4 3.
            String cleaned = line.replace(",", " ").replace("(", " ").replace(")", " ").replace("->", " ");

            // Pull the four numbers out of the line. A second Scanner reads
            // the line the way the first one reads the keyboard, and
            // hasNextInt() lets us look before we take: a typo produces a
            // message, not a crash.
            Scanner numbers = new Scanner(cleaned);
            int[] squares = new int[4];
            int found = 0;
            while (found < 4 && numbers.hasNextInt()) {
                squares[found] = numbers.nextInt();
                found++;
            }

            if (found < 4 || numbers.hasNext()) {
                System.out.println("Sorry, I did not understand \"" + line + "\"."
                        + " A move is four numbers between 0 and 7, for example: 7 3 4 3");
            } else {
                takeTurn(squares[0], squares[1], squares[2], squares[3]);
            }
        }
    }

    /**
     * One turn of the keyboard game: there must be a piece on the first
     * square, it must belong to the player whose turn it is, and then the
     * move is tried; if it was made, the turn passes. This is where "White
     * moves first" is enforced — the board knows nothing about turns.
     * Session 2's exercise 3 asked what that allows.
     */
    private void takeTurn(int fromRow, int fromCol, int toRow, int toCol) {
        ChessPiece chosen = board.getPieceAt(fromRow, fromCol);   // null off the board too
        if (chosen == null) {
            System.out.println("There is no piece on (" + fromRow + "," + fromCol + ")");
        } else if (chosen.isWhite() != whiteToMove) {
            System.out.println("That piece is not yours! The " + chosen.getColor() + " " + chosen.getType()
                    + " on (" + fromRow + "," + fromCol + ") belongs to the other player.");
        } else if (movePiece(fromRow, fromCol, toRow, toCol)) {
            whiteToMove = !whiteToMove;   // the move was made: other player's turn
        }
    }
}
