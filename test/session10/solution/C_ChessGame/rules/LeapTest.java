package session10.solution.C_ChessGame.rules;

import org.junit.jupiter.api.Test;
import session10.solution.C_ChessGame.ChessBoard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Exercise 1. A test of Leap alone. The camel jumps three squares in one
 * direction and one in the other. A jump does not use the board, so an empty
 * board is enough.
 */
public class LeapTest {

    @Test
    public void camelLeapsThreeAndOne() {
        ChessBoard board = new ChessBoard();
        MoveRule camel = new Leap(3, 1);
        assertTrue(camel.allows(board, 4, 4, 1, 5));
        assertTrue(camel.allows(board, 4, 4, 5, 1));
        assertFalse(camel.allows(board, 4, 4, 2, 5));
    }
}
