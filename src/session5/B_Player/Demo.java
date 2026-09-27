package session5.B_Player;

import session5.B_Player.players.Move;
import session5.B_Player.players.Player;
import session5.B_Player.players.RandomPlayer;

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

        // The variable has the type Player, and the object is a RandomPlayer.
        // Put new KeyboardPlayer() on this line instead, with its import line
        // at the top, and this demo asks you for the moves. Not one other line
        // changes, because nothing here knows more about the object than that
        // it is a Player.
        Player white = new RandomPlayer();

        System.out.println();
        System.out.println("Asking the player three times, as White:");
        for (int i = 0; i < 3; i++) {
            Move move = white.chooseMove(board, "White");
            System.out.println("  " + move);
        }
        System.out.println();
        System.out.println("Different every run, and every time the same two things hold.");
        System.out.println("Every move is a white piece, and every move is one that piece's own");
        System.out.println("rules allow. The player asked the pieces; look at");
        System.out.println("RandomPlayer.chooseMove and find the line where it does.");
        System.out.println();
        System.out.println("Run it a few times. Now and then a move takes the black rook on (4,0),");
        System.out.println("but only by chance, because a RandomPlayer does not look for captures.");
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

        // --- EXERCISE B --------------------------------------------------
        //
        // Exercise B, in EXERCISES.md next to this file, is a player of your
        // own, CapturePlayer, in players/ next to RandomPlayer. It goes on the
        // line that declares white, in the place of the RandomPlayer.
    }
}
