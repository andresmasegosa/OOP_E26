package session7.E_ChessGame.players;

import session7.E_ChessGame.ChessBoard;
import session7.E_ChessGame.ChessPiece;

import java.util.Random;

/**
 * A player that moves at random. It picks a square with a piece of its own,
 * and then a target that the piece's rules allow. It does not look ahead, and
 * it does not prefer a capture.
 */
public class RandomPlayer implements Player {

    private Random random = new Random();

    /** Returns null when many tries find no move at all. */
    @Override
    public Move chooseMove(ChessBoard board, String color) {
        for (int attempt = 0; attempt < 500; attempt++) {
            int fromRow = random.nextInt(8);
            int fromCol = random.nextInt(8);

            ChessPiece piece = board.getPieceAt(fromRow, fromCol);
            if (piece == null || !piece.getColor().equals(color)) {
                continue;               // an empty square, or not one of mine
            }

            // That piece gets a few chances before another one is picked.
            for (int target = 0; target < 30; target++) {
                int toRow = random.nextInt(8);
                int toCol = random.nextInt(8);
                if (piece.isLegalMove(board, toRow, toCol)) {
                    return new Move(fromRow, fromCol, toRow, toCol);
                }
            }
        }
        return null;
    }
}
