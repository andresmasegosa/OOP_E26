package session8.D_ChessGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests of ChessPiece.isLegalMove. ChessPieceTest.setUp builds an empty board
 * before every test, and each test places the pieces it needs.
 */
public class ChessPieceTest {

    private ChessBoard board;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
    }

    @Test
    public void rookMovesAlongARow() {
        ChessPiece rook = new Rook("White");
        board.placePiece(4, 4, rook);
        assertTrue(rook.isLegalMove(board, 4, 0));
    }

    // --- EXERCISE 1 --------------------------------------------------
    // Write three more tests here. See src/session8/D_ChessGame/EXERCISES.md.
}
