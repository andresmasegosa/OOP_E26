package session11.solution.C_ChessGame.rules;

import org.junit.jupiter.api.Test;
import session11.solution.C_ChessGame.Bishop;
import session11.solution.C_ChessGame.ChessBoard;
import session11.solution.C_ChessGame.Color;
import session11.solution.C_ChessGame.Knight;
import session11.solution.C_ChessGame.Rook;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise 1. Two tests of MoveFinder: a rule that jumps, and a rule that walks
 * along a line and stops at the pieces in its way.
 */
public class MoveFinderTest {

    @Test
    public void knightInTheCornerHasTwoMoves() {
        ChessBoard board = new ChessBoard();
        Knight knight = new Knight(Color.WHITE);
        board.placePiece(0, 0, knight);

        MoveFinder finder = new MoveFinder(board, knight);
        knight.acceptRules(finder);

        assertEquals(2, finder.getMoves().size());
    }

    @Test
    public void rookStopsAtThePiecesInItsWay() {
        ChessBoard board = new ChessBoard();
        Rook rook = new Rook(Color.WHITE);
        board.placePiece(4, 4, rook);
        board.placePiece(4, 6, new Bishop(Color.WHITE));    // its own piece: it stops before it
        board.placePiece(1, 4, new Knight(Color.BLACK));    // an enemy: it can take it, and stops there

        MoveFinder finder = new MoveFinder(board, rook);
        rook.acceptRules(finder);

        assertEquals(11, finder.getMoves().size());
    }
}
