package session9.D_ChessGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests of ChessBoard, which keeps its pieces in a Map since session 7.
 */
public class ChessBoardTest {

    private ChessBoard board;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
    }

    @Test
    public void placePieceOnATakenSquare() {
        ChessPiece rook = new Rook("White");
        board.placePiece(4, 4, rook);
        assertFalse(board.placePiece(4, 4, new Knight("Black")));
        assertEquals(rook, board.getPieceAt(4, 4));
    }

    @Test
    public void movePieceEmptiesTheSquareLeft() {
        ChessPiece rook = new Rook("White");
        board.placePiece(4, 4, rook);
        board.movePiece(rook, 4, 0);
        assertNull(board.getPieceAt(4, 4));
        assertEquals(rook, board.getPieceAt(4, 0));
    }

    @Test
    public void captureLeavesThePieceThatCaptured() {
        ChessPiece rook = new Rook("White");
        board.placePiece(4, 4, rook);
        board.placePiece(4, 0, new Knight("Black"));
        board.movePiece(rook, 4, 0);
        assertEquals(rook, board.getPieceAt(4, 0));
    }
}
