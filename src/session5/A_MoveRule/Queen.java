package session5.A_MoveRule;

import session5.A_MoveRule.rules.Diagonal;
import session5.A_MoveRule.rules.StraightLine;

/**
 * The queen. Compare it with session 3's Queen: there the class held a
 * method with three calls to Movements in it. Here it holds no method at
 * all, only a constructor that says its name and its two ways of moving.
 */
public class Queen extends ChessPiece {

    public Queen(String color) {
        super("Queen", color);
        addRule(new StraightLine(7));
        addRule(new Diagonal(7));
    }

    @Override
    protected char getLetter() {
        return 'Q';
    }
}
