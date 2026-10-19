package session7.E_ChessGame.players;

import session7.E_ChessGame.ChessBoard;
import session7.E_ChessGame.ChessPiece;

/**
 * A RandomPlayer that takes an enemy piece when it finds one. It asks
 * RandomPlayer.chooseMove for up to a hundred moves, and plays the first one
 * that lands on an enemy piece. If none does, it plays the last one.
 */
public class CapturePlayer extends RandomPlayer {

    @Override
    public Move chooseMove(ChessBoard board, String color) {
        Move move = null;
        for (int attempt = 0; attempt < 100; attempt++) {
            move = super.chooseMove(board, color);
            if (move == null) {
                return null;                // RandomPlayer found nothing at all
            }
            ChessPiece target = board.getPieceAt(move.getToRow(), move.getToCol());
            if (target != null && !target.getColor().equals(color)) {
                return move;
            }
        }
        return move;
    }
}
