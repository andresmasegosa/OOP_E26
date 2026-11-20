package session2.solution;

import java.util.Scanner;

/**
 * Session 2 — OFFICIAL SOLUTION, game side.
 *
 * Changes grown onto the session's ChessGame:
 *   Exercise 2: movePiece prints each piece's counter after it moves.
 *   Exercise 5: the knights stand in the initial position (the legend
 *               that names them is the board's, in ChessBoard.print).
 *
 * The scripted game, the club's statistics, the ghost and the exercise 3
 * leftovers live in Demo.java, where main is.
 */
public class ChessGame {

    private ChessBoard board;
    private boolean whiteToMove = true;

    public ChessGame() {
        this.board = new ChessBoard();
        setupPieces();
    }

    public ChessBoard getBoard() {
        return board;
    }

    /** The initial position — twelve pieces, plus the knights (exercise 5). */
    private void setupPieces() {
        // Black pieces (lowercase), top of the board.
        board.placePiece(0, 0, new ChessPiece('r'));
        board.placePiece(0, 1, new ChessPiece('n'));   // SOLUTION (exercise 5)
        board.placePiece(0, 2, new ChessPiece('b'));
        board.placePiece(0, 3, new ChessPiece('q'));
        board.placePiece(0, 4, new ChessPiece('k'));
        board.placePiece(0, 5, new ChessPiece('b'));
        board.placePiece(0, 6, new ChessPiece('n'));   // SOLUTION (exercise 5)
        board.placePiece(0, 7, new ChessPiece('r'));

        // White pieces (uppercase), bottom of the board.
        board.placePiece(7, 0, new ChessPiece('R'));
        board.placePiece(7, 1, new ChessPiece('N'));   // SOLUTION (exercise 5)
        board.placePiece(7, 2, new ChessPiece('B'));
        board.placePiece(7, 3, new ChessPiece('Q'));
        board.placePiece(7, 4, new ChessPiece('K'));
        board.placePiece(7, 5, new ChessPiece('B'));
        board.placePiece(7, 6, new ChessPiece('N'));   // SOLUTION (exercise 5)
        board.placePiece(7, 7, new ChessPiece('R'));
    }

    public void printBoard() {
        board.print();
    }

    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        ChessPiece piece = board.getPieceAt(fromRow, fromCol);
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

        // SOLUTION (exercise 2): print the counter after every made move,
        // in session 1's exact words — but no parallel array pays for it.
        System.out.println(piece.getColor() + " " + piece.getType()
                + " has now moved " + piece.getMoveCount() + " times");
        return true;
    }

    /**
     * Play from the keyboard — the session's loop, unchanged by any
     * exercise: one line of four numbers per move, the format repeated on
     * every turn, a typo answered with a message instead of a crash.
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

            if (!keyboard.hasNextLine()) {
                System.out.println();
                System.out.println("Thanks for playing!");
                return;
            }
            String line = keyboard.nextLine().trim();
            if (line.equals("q") || line.equals("quit")) {
                System.out.println("Thanks for playing!");
                return;
            }

            String cleaned = line.replace(",", " ").replace("(", " ").replace(")", " ").replace("->", " ");

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

    /** One turn of the keyboard game; "White moves first" is enforced here. */
    private void takeTurn(int fromRow, int fromCol, int toRow, int toCol) {
        ChessPiece chosen = board.getPieceAt(fromRow, fromCol);
        if (chosen == null) {
            System.out.println("There is no piece on (" + fromRow + "," + fromCol + ")");
        } else if (chosen.isWhite() != whiteToMove) {
            System.out.println("That piece is not yours! The " + chosen.getColor() + " " + chosen.getType()
                    + " on (" + fromRow + "," + fromCol + ") belongs to the other player.");
        } else if (movePiece(fromRow, fromCol, toRow, toCol)) {
            whiteToMove = !whiteToMove;
        }
    }
}
