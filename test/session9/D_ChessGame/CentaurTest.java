package session9.D_ChessGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The tests of Centaur, written in session 8 before the rules that make them green.
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
    public void centaurMovesOneSquareAlongARow() {
        assertTrue(centaur.isLegalMove(board, 4, 5));
        assertFalse(centaur.isLegalMove(board, 4, 6));
    }

    @Test
    public void centaurMovesOneSquareDiagonally() {
        assertTrue(centaur.isLegalMove(board, 5, 5));
        assertFalse(centaur.isLegalMove(board, 6, 6));
    }

    @Test
    public void centaurJumpsLikeAKnight() {
        assertTrue(centaur.isLegalMove(board, 6, 5));
    }
}
