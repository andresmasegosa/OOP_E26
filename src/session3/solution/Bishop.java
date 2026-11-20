package session3.solution;

/**
 * The bishop. SOLUTION (exercise 1): a class of its own, with its rule and the
 * constructor the compiler asked for.
 */
public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super("Bishop", color);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        return Movements.isLegalDiagonalMove(board, getRow(), getCol(), toRow, toCol, 7);
    }

    @Override
    protected char getLetter() {
        return 'B';   // SOLUTION
    }
}
