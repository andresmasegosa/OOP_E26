package session11.solution.C_ChessGame.players;

import session11.solution.C_ChessGame.ChessBoard;
import session11.solution.C_ChessGame.Color;
import session11.solution.C_ChessGame.ChessPiece;
import session11.solution.C_ChessGame.rules.MoveFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A player that moves at random. Exercise 1. It finds every move that the rules
 * of its pieces allow, with a MoveFinder, and picks one of them, so it returns
 * null only when it has no move at all. It does not look ahead, and it does not
 * prefer a capture.
 */
public class RandomPlayer implements Player {

    private Random random = new Random();

    /** Returns null only when no piece of this colour has a move. */
    @Override
    public Move chooseMove(ChessBoard board, Color color) {
        List<Move> moves = new ArrayList<>();                       // exercise 1
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = board.getPieceAt(row, col);
                if (piece != null && piece.getColor() == color) {
                    MoveFinder finder = new MoveFinder(board, piece);
                    piece.acceptRules(finder);
                    moves.addAll(finder.getMoves());
                }
            }
        }
        if (moves.isEmpty()) {
            return null;
        }
        return moves.get(random.nextInt(moves.size()));
    }
}
