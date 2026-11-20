package session5.solution.C_ChessGame.rules;

import session5.solution.C_ChessGame.ChessBoard;

/**
 * Exercise A, copied into the game in exercise 1. The knight's move, two
 * squares along one axis and one along the other.
 *
 * It is the shortest rule of the three and the only one that does not look at
 * the board: a knight jumps, so there is no path to walk. The board parameter
 * stays in the signature because the interface demands it. An implementation
 * may ignore a parameter; what it may not do is leave the method out.
 *
 * It has no maxDistance field either. The L is a shape, not a distance, which
 * is worth pointing at: the other two rules needed a field and this one does
 * not, and the interface does not care.
 */
public class LShape implements MoveRule {

    @Override
    public boolean allows(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);
        return (rowDistance == 2 && colDistance == 1)
                || (rowDistance == 1 && colDistance == 2);
    }
}
