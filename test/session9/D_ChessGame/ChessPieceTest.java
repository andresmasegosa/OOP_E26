package session9.D_ChessGame;

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

    @Test
    public void rookDoesNotMoveDiagonally() {
        ChessPiece rook = new Rook("White");
        board.placePiece(4, 4, rook);
        assertFalse(rook.isLegalMove(board, 6, 6));
    }

    @Test
    public void rookDoesNotJumpOverAPiece() {
        ChessPiece rook = new Rook("White");
        board.placePiece(4, 4, rook);
        board.placePiece(4, 2, new Knight("Black"));
        assertFalse(rook.isLegalMove(board, 4, 0));
    }

    @Test
    public void rookDoesNotMoveOntoItsOwnColour() {
        ChessPiece rook = new Rook("White");
        board.placePiece(4, 4, rook);
        board.placePiece(4, 2, new Knight("White"));
        assertFalse(rook.isLegalMove(board, 4, 2));
    }
}
