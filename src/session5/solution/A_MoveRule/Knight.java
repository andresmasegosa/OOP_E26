package session5.solution.A_MoveRule;

import session5.solution.A_MoveRule.rules.LShape;

/** Exercise A. One rule, the L. */
public class Knight extends ChessPiece {

    public Knight(String color) {
        super("Knight", color);
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'N';
    }
}
