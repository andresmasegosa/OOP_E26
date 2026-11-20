package session3.solution;

/**
 * The Amazon, a piece from chess variants that moves like a queen and like a
 * knight. SOLUTION (exercise 2): she extends Queen, passes her own type up
 * through Queen's protected constructor, asks super.isLegalMove for the
 * queen's part, and shares the knight's L with Knight through
 * Movements.isLegalKnightMove instead of copying it.
 *
 * A Chancellor, a rook and a knight, cannot be written the same way: it would
 * have to extend Rook and Knight at once, and a class extends one class. That
 * is the wish session 5 starts from.
 */
public class Amazon extends Queen {

    public Amazon(String color) {
        super("Amazon", color);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        return super.isLegalMove(board, toRow, toCol)
                || Movements.isLegalKnightMove(getRow(), getCol(), toRow, toCol);
    }

    @Override
    protected char getLetter() {
        return 'A';   // SOLUTION
    }
}
