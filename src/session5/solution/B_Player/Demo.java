package session5.solution.B_Player;

import session5.solution.B_Player.players.CapturePlayer;
import session5.solution.B_Player.players.Move;
import session5.solution.B_Player.players.Player;

/**
 * Step B. A Player is a type, and two classes with nothing in common have it.
 *
 * The pieces and the board are step A's, unchanged; look in rules/ and you
 * will find the same three files. What is new is the folder players/, and the
 * question it answers is not how a piece moves but who decides which move to
 * make.
 */
public class Demo {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.placePiece(7, 3, new Queen("White"));
        board.placePiece(7, 0, new Rook("White"));
        board.placePiece(0, 4, new Queen("Black"));
        board.placePiece(4, 0, new Rook("Black"));   // within reach of both white pieces
        board.print();

        // The variable has the type Player, and the object is a CapturePlayer.
        // Put new KeyboardPlayer() on this line instead, with its import line
        // at the top, and this demo asks you for the moves. Not one other line
        // changes, because nothing here knows more about the object than that
        // it is a Player.
        Player white = new CapturePlayer();   // exercise B: prefers sampled captures on (4,0)

        System.out.println();
        System.out.println("Asking the player three times, as White:");
        for (int i = 0; i < 3; i++) {
            // chooseMove may answer null, which means the player stops (see the contract in players/Player.java).
            Move move = white.chooseMove(board, "White");
            System.out.println("  " + move);
        }
        System.out.println();
        System.out.println("Each move is by a white piece and follows that piece's rules.");
        System.out.println("CapturePlayer asks RandomPlayer for up to 100 suggestions.");
        System.out.println("It returns the first capture, or the last suggestion if none captures.");
        System.out.println("In this position, look for moves to the black rook on (4,0).");
        System.out.println("No move ever lands on a white piece. ChessPiece.isLegalMove refuses");
        System.out.println("that before it asks the rules.");

        // --- One line that does not compile --------------------------------
        //
        // An interface has no constructor, because it has no code to run: it
        // is a list of methods and a promise, and there is nothing to build.
        // Uncomment and compile.
        //
        // Player nobody = new Player();
        //
        // error: Player is abstract; cannot be instantiated
        //
        // A Player variable is fine, as white above shows. What cannot exist
        // is an object that is a Player and nothing more specific.

        // --- EXERCISE B, solved ------------------------------------------
        // CapturePlayer inherits Player through RandomPlayer, so the
        // variable above keeps its Player type when the object changes.
    }
}
