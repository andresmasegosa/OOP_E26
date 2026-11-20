package session5.solution.C_ChessGame.players;

import session5.solution.C_ChessGame.ChessBoard;
import session5.solution.C_ChessGame.ChessPiece;

/**
 * Exercise 2. A player that takes the most valuable piece it can reach, and
 * otherwise plays like exercise B's CapturePlayer.
 *
 * It extends CapturePlayer instead of implementing Player from scratch, so
 * "play something, anything" is one call to super and not thirty lines
 * copied. CapturePlayer takes the first capture it happens to find; this
 * one looks at every capture on the board and keeps the best. Inheritance
 * for what it is, composition for what a piece can do, and here inheritance
 * again, because a greedy player IS a capture player with one idea added, as
 * a capture player is a random player with one idea added.
 *
 * It lives in the players package and never mentions a MoveRule. It asks
 * ChessPiece.isLegalMove, which is all a player needs and all it is given.
 *
 * valueOf compares the piece's String type with names such as "Queen".
 * A type that matches none of those names, such as "Qeen", silently gets
 * the fallback value 1. These comparisons do not give the compiler a list
 * of the permitted piece names.
 */
public class GreedyPlayer extends CapturePlayer {

    @Override
    public Move chooseMove(ChessBoard board, String color) {
        Move best = null;
        int bestValue = 0;

        for (int fromRow = 0; fromRow < 8; fromRow++) {
            for (int fromCol = 0; fromCol < 8; fromCol++) {
                ChessPiece mine = board.getPieceAt(fromRow, fromCol);
                if (mine == null || !mine.getColor().equals(color)) {
                    continue;
                }
                for (int toRow = 0; toRow < 8; toRow++) {
                    for (int toCol = 0; toCol < 8; toCol++) {
                        ChessPiece target = board.getPieceAt(toRow, toCol);
                        if (target == null || target.getColor().equals(color)) {
                            continue;           // empty, or one of mine
                        }
                        if (!mine.isLegalMove(board, toRow, toCol)) {
                            continue;
                        }
                        int value = valueOf(target);
                        if (value > bestValue) {
                            bestValue = value;
                            best = new Move(fromRow, fromCol, toRow, toCol);
                        }
                    }
                }
            }
        }

        if (best != null) {
            return best;
        }
        return super.chooseMove(board, color);   // nothing to take: play like CapturePlayer
    }

    /** What a piece is worth. The usual scale, with the king above everything. */
    private static int valueOf(ChessPiece piece) {
        String type = piece.getType();
        if (type.equals("King")) {
            return 100;
        }
        if (type.equals("Queen")) {
            return 9;
        }
        if (type.equals("Rook")) {
            return 5;
        }
        if (type.equals("Bishop") || type.equals("Knight")) {
            return 3;
        }
        return 1;
    }
}
