package session10.solution.C_ChessGame;

import session10.solution.C_ChessGame.rules.Diagonal;
import session10.solution.C_ChessGame.rules.Leap;
import session10.solution.C_ChessGame.rules.StraightLine;

/**
 * The centaur moves like a king or like a knight. It is not placed in the
 * game. Exercise 1. Its knight's jump is a Leap(2, 1).
 */
public class Centaur extends ChessPiece {

    public Centaur(Color color) {
        super(PieceType.CENTAUR, color);
        addRule(new StraightLine(1));
        addRule(new Diagonal(1));
        addRule(new Leap(2, 1));                                    // exercise 1
    }

    @Override
    protected char getLetter() {
        return 'C';
    }
}
