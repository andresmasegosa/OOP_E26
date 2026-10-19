package session7.E_ChessGame.rules;

import session7.E_ChessGame.ChessBoard;

/**
 * One way of moving, which any piece may hold. MoveRule.allows answers whether
 * a move from one square to another follows this rule with a clear path. It
 * reads the board and changes nothing. It does not look at the colour of a
 * piece on the target square, because ChessPiece.isLegalMove does.
 */
public interface MoveRule {

    boolean allows(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol);
}
