package session9.solution.D_ChessGame;

import session9.solution.D_ChessGame.rules.Diagonal;
import session9.solution.D_ChessGame.rules.StraightLine;

/**
 * The queen moves like a rook and like a bishop. It holds a StraightLine and
 * a Diagonal, both with a reach of seven.
 */
public class Queen extends ChessPiece {

    public Queen(Color color) {          // exercise 1
        super(PieceType.QUEEN, color);     // exercise 2
        addRule(new StraightLine(7));
        addRule(new Diagonal(7));
    }

    @Override
    protected char getLetter() {
        return 'Q';
    }
}
