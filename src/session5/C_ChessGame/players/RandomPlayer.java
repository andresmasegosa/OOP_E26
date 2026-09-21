package session5.C_ChessGame.players;

import session5.C_ChessGame.ChessBoard;
import session5.C_ChessGame.ChessPiece;

import java.util.Random;

/**
 * A player that plays by itself. This is the answer to the second wish
 * session 3 closed with.
 *
 * The code is step B's, line for line. Open
 * B_Player/players/RandomPlayer.java next to this file if you want to check.
 *
 * What it looks for: a square holding a piece of its own colour, and then a
 * target that piece's own rules allow. Nothing else. It does not look ahead,
 * it does not prefer a capture, and it does not know whose turn it is. That
 * is enough to play a whole game by itself, which is what Demo.main shows.
 *
 * It still gets refused sometimes, and on purpose. ChessPiece.isLegalMove
 * answers about the piece's rules, and the rule that you may not capture a
 * piece of your own colour is not there, it is in ChessBoard.movePiece. A
 * player cannot ask about a rule that lives in the board. Watch a game and you
 * will see the refusals; who checks what is exercise 3's business.
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
