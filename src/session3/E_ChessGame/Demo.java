package session3.E_ChessGame;

/**
 * Starts the game, as in session 2. Every folder of this session has a class
 * called Demo, and this is the one EXERCISES.md means when it says Demo or
 * Demo.main, the class session3.E_ChessGame.Demo.
 */
public class Demo {

    public static void main(String[] args) {
        // --- EXERCISE 1: your three cost lines go here, at the top of main.

        // --- EXERCISE 2 (stretch): try your Amazon here, on a ChessBoard of her own.

        ChessGame game = new ChessGame();
        game.printBoard();

        // --- The scripted game ---------------------------------------------
        // The short game of sessions 1 and 2, with one move changed and one
        // added. Move 3 used to send a rook onto its own bishop, and there are
        // no bishops yet, so here the black king goes onto its own queen. The
        // seventh move sends a bishop straight up, which no bishop may do.

        game.movePiece(7, 3, 4, 3);   // White queen straight up: legal
        game.movePiece(0, 0, 2, 2);   // Black rook diagonally: illegal
        game.movePiece(0, 4, 0, 3);   // Black king onto its own queen: illegal
        game.movePiece(4, 3, 0, 3);   // The white queen captures the black queen
        game.movePiece(0, 4, 0, 3);   // and the black king takes revenge.
        game.movePiece(7, 5, 5, 3);   // White bishop: there is none on (7,5). Exercise 1!
        game.movePiece(7, 2, 5, 2);   // White bishop straight up: illegal, with or without a bishop

        game.printBoard();

        // Now it is your turn at the keyboard.
        game.play();
    }
}
