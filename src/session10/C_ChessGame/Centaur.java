package session10.C_ChessGame;

import session10.C_ChessGame.rules.Diagonal;
import session10.C_ChessGame.rules.LShape;
import session10.C_ChessGame.rules.StraightLine;

/**
 * The centaur, from session 8, moves like a king or like a knight. It is not
 * placed in the game.
 */
public class Centaur extends ChessPiece {

    public Centaur(Color color) {
        super(PieceType.CENTAUR, color);
        addRule(new StraightLine(1));
        addRule(new Diagonal(1));
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'C';
    }
}
