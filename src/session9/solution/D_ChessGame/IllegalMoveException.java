package session9.solution.D_ChessGame;

/**
 * Exercise 3. Thrown by ChessBoard.movePiece when it refuses a move, with a
 * message that says why.
 */
public class IllegalMoveException extends RuntimeException {

    public IllegalMoveException(String message) {
        super(message);
    }
}
