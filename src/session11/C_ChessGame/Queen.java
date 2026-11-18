package session11.C_ChessGame;

import session11.C_ChessGame.rules.Diagonal;
import session11.C_ChessGame.rules.StraightLine;

/**
 * The queen moves like a rook and like a bishop. It holds a StraightLine and
 * a Diagonal, both with a reach of seven.
 */
public class Queen extends ChessPiece {

    public Queen(Color color) {
        super(PieceType.QUEEN, color);
        addRule(new StraightLine(7));
        addRule(new Diagonal(7));
    }

    @Override
    protected char getLetter() {
        return 'Q';
    }
}
