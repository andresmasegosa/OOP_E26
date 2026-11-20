package session11.solution.C_ChessGame.rules;

/**
 * Exercise 1. Something to do with the move rules of a piece, such as finding
 * the moves they allow. It has one visit method for each kind of rule, and each
 * rule calls the method meant for it from its accept method.
 */
public interface RuleVisitor {

    void visitStraightLine(StraightLine rule);

    void visitDiagonal(Diagonal rule);

    void visitLeap(Leap rule);
}
