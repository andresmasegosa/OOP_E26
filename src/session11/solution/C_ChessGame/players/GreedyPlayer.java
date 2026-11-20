package session11.solution.C_ChessGame.players;

import session11.solution.C_ChessGame.ChessBoard;
import session11.solution.C_ChessGame.Color;
import session11.solution.C_ChessGame.ChessPiece;

/**
 * A CapturePlayer that takes the most valuable enemy piece it can reach. It
 * looks at every capture on the board and keeps the best one. When there is no
 * capture, it plays like CapturePlayer. What a piece is worth comes from its
 * PieceType.
 */
public class GreedyPlayer extends CapturePlayer {

    @Override
    public Move chooseMove(ChessBoard board, Color color) {
        Move best = null;
        int bestValue = 0;

        for (int fromRow = 0; fromRow < 8; fromRow++) {
            for (int fromCol = 0; fromCol < 8; fromCol++) {
                ChessPiece mine = board.getPieceAt(fromRow, fromCol);
                if (mine == null || mine.getColor() != color) {
                    continue;
                }
                for (int toRow = 0; toRow < 8; toRow++) {
                    for (int toCol = 0; toCol < 8; toCol++) {
                        ChessPiece target = board.getPieceAt(toRow, toCol);
                        if (target == null || target.getColor() == color) {
                            continue;           // empty, or one of mine
                        }
                        if (!mine.isLegalMove(board, toRow, toCol)) {
                            continue;
                        }
                        int value = target.getType().getValue();
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
