package session11.solution.C_ChessGame.listeners;

import session11.solution.C_ChessGame.ChessBoard;
import session11.solution.C_ChessGame.ChessPiece;
import session11.solution.C_ChessGame.PieceType;
import session11.solution.C_ChessGame.players.Move;
import session11.solution.C_ChessGame.rules.MoveFinder;

/**
 * Exercise 2. After each move, checks whether a piece of the player who moved
 * can now take the other king, and prints Check! when one can. It finds the moves
 * of each of those pieces with a MoveFinder.
 */
public class CheckAnnouncer implements GameListener {

    private ChessBoard board;

    public CheckAnnouncer(ChessBoard board) {
        this.board = board;
    }

    @Override
    public void moveMade(ChessPiece piece, Move move, ChessPiece captured) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessPiece mine = board.getPieceAt(row, col);
                if (mine == null || mine.getColor() != piece.getColor()) {
                    continue;
                }
                MoveFinder finder = new MoveFinder(board, mine);
                mine.acceptRules(finder);
                for (Move next : finder.getMoves()) {
                    ChessPiece target = board.getPieceAt(next.getToRow(), next.getToCol());
                    if (target != null && target.getType() == PieceType.KING) {
                        System.out.println("Check!");
                        return;
                    }
                }
            }
        }
    }
}
