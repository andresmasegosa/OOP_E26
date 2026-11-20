package session10.solution.C_ChessGame.listeners;

import session10.solution.C_ChessGame.ChessPiece;
import session10.solution.C_ChessGame.Color;
import session10.solution.C_ChessGame.players.Move;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 2. Counts how many pieces each player has captured, the king
 * included. CaptureCounter.getCaptures returns the count of one colour.
 */
public class CaptureCounter implements GameListener {

    private Map<Color, Integer> captures = new HashMap<>();

    public CaptureCounter() {
        captures.put(Color.WHITE, 0);
        captures.put(Color.BLACK, 0);
    }

    @Override
    public void moveMade(ChessPiece piece, Move move, ChessPiece captured) {
        if (captured != null) {
            captures.put(piece.getColor(), captures.get(piece.getColor()) + 1);
        }
    }

    public int getCaptures(Color color) {
        return captures.get(color);
    }
}
