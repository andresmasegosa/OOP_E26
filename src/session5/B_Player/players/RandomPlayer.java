package session5.B_Player.players;

import java.util.Random;

import session5.B_Player.ChessBoard;
import session5.B_Player.ChessPiece;

/**
 * A player that plays by itself.
 *
 * Read it next to KeyboardPlayer. They do the same job, they have the same
 * one method, and they share not a single field: one holds a Scanner, the
 * other holds a Random. There is no common code for a superclass to hold, and
 * that is the shape an interface is for.
 *
 * What it does is small. It looks for a square holding a piece of its own
 * colour, then for a square that piece's own rules allow, and proposes that.
 * No looking ahead, no preferring a capture, no idea whose turn it is. It is
 * still enough to play a whole game by itself.
 *
 * Notice where it asks about the rules: piece.isLegalMove, the method step A
 * gave a body to. A player does not know what a MoveRule is, and does not need
 * to.
 *
 * Its whole state is one Random, written on one line. KeyboardPlayer's whole
 * state is one Scanner, written on one line. Two classes, the same job, and
 * not one field in common.
 */
public class RandomPlayer implements Player {

    private Random random = new Random();

    /**
     * Look for a piece of mine, then for a square its rules allow. Returns
     * null if a great many tries find nothing, which the contract in Player
     * says means this player stops.
     */
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
        return null;                    // it could not find a move at all
    }
}
