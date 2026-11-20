package session5.solution.C_ChessGame.players;

import session5.solution.C_ChessGame.ChessBoard;
import session5.solution.C_ChessGame.ChessPiece;

/**
 * Exercise B, copied into the game in exercise 2, because GreedyPlayer
 * extends it. RandomPlayer, except that it takes an enemy piece whenever it
 * finds one to take.
 *
 * It asks its parent for moves and looks at the target of each. The first
 * one that lands on an enemy piece is its answer. If a hundred moves bring
 * no capture, it plays the last suggestion. It does not compare future
 * replies or guarantee a stronger game. It excludes its own pieces because
 * ChessPiece.isLegalMove refuses a target of the mover's own colour and a
 * RandomPlayer only proposes what isLegalMove allows.
 *
 * It finds a capture by luck, not by looking. When a capture is rare, a
 * hundred tries can miss it, and GreedyPlayer's walk over the board is the
 * answer to that.
 *
 * It never says implements Player, and it is one all the same, through
 * RandomPlayer. That is the discussion question of exercise B.
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
                return move;                // an enemy piece: take it
            }
        }
        return move;                        // no capture found: play the last one
    }
}
