package session8.solution.D_ChessGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Exercise 3. The tests of Centaur, each written before the rule that makes it green.
 */
public class CentaurTest {

    private ChessBoard board;
    private ChessPiece centaur;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        centaur = new Centaur("White");
        board.placePiece(4, 4, centaur);
    }

    @Test
    public void centaurMovesOneSquareAlongARow() {   // step 1
        assertTrue(centaur.isLegalMove(board, 4, 5));
        assertFalse(centaur.isLegalMove(board, 4, 6));
    }

    @Test
    public void centaurMovesOneSquareDiagonally() {  // step 2
        assertTrue(centaur.isLegalMove(board, 5, 5));
        assertFalse(centaur.isLegalMove(board, 6, 6));
    }

    @Test
    public void centaurJumpsLikeAKnight() {          // step 3
        assertTrue(centaur.isLegalMove(board, 6, 5));
    }
}
