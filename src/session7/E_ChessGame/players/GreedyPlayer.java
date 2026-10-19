package session7.E_ChessGame.players;

import session7.E_ChessGame.ChessBoard;
import session7.E_ChessGame.ChessPiece;

/**
 * A CapturePlayer that takes the most valuable enemy piece it can reach. It
 * looks at every capture on the board and keeps the best one. When there is no
 * capture, it plays like CapturePlayer.
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
        return super.chooseMove(board, color);   // nothing to take
    }

    /** What a piece is worth, on the usual scale, with 100 for the king. */
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
