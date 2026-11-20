package session10.solution.C_ChessGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests of ChessBoard, which keeps its pieces in a Map.
 */
public class ChessBoardTest {

    private ChessBoard board;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
    }

    @Test
    public void placePieceOnATakenSquare() {
        ChessPiece rook = new Rook(Color.WHITE);
        board.placePiece(4, 4, rook);
        assertFalse(board.placePiece(4, 4, new Knight(Color.BLACK)));
        assertEquals(rook, board.getPieceAt(4, 4));
    }

    @Test
    public void movePieceEmptiesTheSquareLeft() {
        ChessPiece rook = new Rook(Color.WHITE);
        board.placePiece(4, 4, rook);
        board.movePiece(rook, 4, 0);
        assertNull(board.getPieceAt(4, 4));
        assertEquals(rook, board.getPieceAt(4, 0));
    }

    @Test
    public void captureLeavesThePieceThatCaptured() {
        ChessPiece rook = new Rook(Color.WHITE);
        board.placePiece(4, 4, rook);
        board.placePiece(4, 0, new Knight(Color.BLACK));
        board.movePiece(rook, 4, 0);
        assertEquals(rook, board.getPieceAt(4, 0));
    }

    @Test
    public void movePieceRefusesAnIllegalMove() {
        ChessPiece rook = new Rook(Color.WHITE);
        board.placePiece(4, 4, rook);
        assertThrows(IllegalMoveException.class, () -> board.movePiece(rook, 6, 6));
        assertEquals(rook, board.getPieceAt(4, 4));
    }
}
