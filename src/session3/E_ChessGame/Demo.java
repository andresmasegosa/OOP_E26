package session3.E_ChessGame;

/**
 * Starts the game, as in session 2. Every folder of this session has a class
 * called Demo, and this is the one EXERCISES.md means when it says Demo or
 * Demo.main, the class session3.E_ChessGame.Demo.
 */
public class Demo {

    public static void main(String[] args) {
        // --- EXERCISE 1: your three cost lines go here, at the top of main.

        ChessGame game = new ChessGame();
        game.printBoard();

        // --- The scripted game ---------------------------------------------
        // The short game of sessions 1 and 2, with one change. Move 3 used to
        // send a rook onto its own bishop, and there are no bishops yet, so
        // here the other rook goes onto its own king.

        game.movePiece(7, 3, 4, 3);   // White queen straight up: legal
        game.movePiece(0, 0, 2, 2);   // Black rook diagonally: illegal
        game.movePiece(7, 7, 7, 4);   // White rook onto its own king: illegal
        game.movePiece(4, 3, 0, 3);   // The white queen captures the black queen
        game.movePiece(0, 4, 0, 3);   // and the black king takes revenge.
        game.movePiece(7, 5, 5, 3);   // White bishop: there is none on (7,5). Exercise 1!

        game.printBoard();

        // --- EXERCISE 3: the saboteur, now a subclass ------------------------
        // Your cheating piece goes on the board here, before play() starts.
        // See EXERCISES.md, exercise 3.

        // Now it is your turn at the keyboard.
        game.play();
    }
}
