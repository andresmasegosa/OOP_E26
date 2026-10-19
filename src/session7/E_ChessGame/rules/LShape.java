package session7.E_ChessGame.rules;

import session7.E_ChessGame.ChessBoard;

/**
 * The knight's move, two squares along one axis and one along the other. A
 * knight jumps, so this rule never looks at the board.
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
