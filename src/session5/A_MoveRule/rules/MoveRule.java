package session5.A_MoveRule.rules;

import session5.A_MoveRule.ChessBoard;

/**
 * One way of moving. Not one piece's rule: one rule, which any piece may use,
 * and which several pieces may use at once.
 *
 * This is where session 1's geometry finally lands. In session 1 it was three
 * static methods in the file next to main; in sessions 2 and 3 it was three
 * static methods in a class called Movements, and that class's javadoc asked
 * every week whether rules like these should live in a helper class, in the
 * pieces, or in the board. The answer this session gives is none of the
 * three. A way of moving is a thing, so it gets a class, and the arithmetic
 * lives inside it. Movements is gone.
 *
 * THE CONTRACT.
 *
 *   - allows answers whether the geometry of this move is right, and whether
 *     the path is clear. It is asked before anything moves.
 *   - board is there to look at. A rule reads squares through
 *     ChessBoard.getPieceAt and changes nothing.
 *   - The square the piece comes from and the square it goes to are given as
 *     numbers, not as a piece. A rule does not know whose rule it is, which is
 *     what lets two pieces share one.
 *   - What the rule does NOT answer: whether the target holds a piece of your
 *     own colour, and whose turn it is. The board and the game keep those.
 */
public interface MoveRule {

    boolean allows(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol);
}
