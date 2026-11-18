package session11.C_ChessGame.listeners;

import session11.C_ChessGame.ChessPiece;
import session11.C_ChessGame.Color;
import session11.C_ChessGame.PieceType;
import session11.C_ChessGame.players.Move;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps a score for each player. When a player captures a piece,
 * the player gets as many points as the piece is worth (PieceType.getValue).
 * Capturing the king ends the game, so the king gives no points. After each
 * capture that gives points, Scoreboard prints the score.
 */
public class Scoreboard implements GameListener {

    private Map<Color, Integer> points = new HashMap<>();

    public Scoreboard() {
        points.put(Color.WHITE, 0);
        points.put(Color.BLACK, 0);
    }

    @Override
    public void moveMade(ChessPiece piece, Move move, ChessPiece captured) {
        if (captured == null || captured.getType() == PieceType.KING) {
            return;
        }
        Color color = piece.getColor();
        points.put(color, points.get(color) + captured.getType().getValue());
        System.out.println("Score: WHITE " + points.get(Color.WHITE) + ", BLACK " + points.get(Color.BLACK));
    }
}
