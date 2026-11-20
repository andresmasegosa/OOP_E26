package session9.solution.D_ChessGame.players;

import session9.solution.D_ChessGame.ChessBoard;
import session9.solution.D_ChessGame.Color;
import session9.solution.D_ChessGame.ChessPiece;

/**
 * A CapturePlayer that takes the most valuable enemy piece it can reach. It
 * looks at every capture on the board and keeps the best one. When there is no
 * capture, it plays like CapturePlayer. Exercise 2. What a piece is worth
 * comes from its PieceType, and GreedyPlayer.valueOf is gone.
 */
public class GreedyPlayer extends CapturePlayer {

    @Override
    public Move chooseMove(ChessBoard board, Color color) {   // exercise 1
        Move best = null;
        int bestValue = 0;

        for (int fromRow = 0; fromRow < 8; fromRow++) {
            for (int fromCol = 0; fromCol < 8; fromCol++) {
                ChessPiece mine = board.getPieceAt(fromRow, fromCol);
                if (mine == null || mine.getColor() != color) {    // exercise 1
                    continue;
                }
                for (int toRow = 0; toRow < 8; toRow++) {
                    for (int toCol = 0; toCol < 8; toCol++) {
                        ChessPiece target = board.getPieceAt(toRow, toCol);
                        if (target == null || target.getColor() == color) {   // exercise 1
                            continue;           // empty, or one of mine
                        }
                        if (!mine.isLegalMove(board, toRow, toCol)) {
                            continue;
                        }
                        int value = target.getType().getValue();   // exercise 2
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
        return super.chooseMove(board, color);   // nothing to take
    }
}
