package session11.C_ChessGame;

import session11.C_ChessGame.rules.Diagonal;
import session11.C_ChessGame.rules.Leap;
import session11.C_ChessGame.rules.StraightLine;

/**
 * The centaur, from session 8, moves like a king or like a knight. It is not
 * placed in the game. Its knight's jump is a Leap(2, 1).
 */
public class Centaur extends ChessPiece {

    public Centaur(Color color) {
        super(PieceType.CENTAUR, color);
        addRule(new StraightLine(1));
        addRule(new Diagonal(1));
        addRule(new Leap(2, 1));
    }

    @Override
    protected char getLetter() {
        return 'C';
    }
}
