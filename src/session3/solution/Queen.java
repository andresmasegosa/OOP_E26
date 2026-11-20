package session3.solution;

/**
 * The queen. SOLUTION (exercise 2): a second constructor, protected, so that a
 * subclass such as Amazon can pass its own type up instead of "Queen".
 */
public class Queen extends ChessPiece {

    public Queen(String color) {
        super("Queen", color);
    }

    protected Queen(String type, String color) {
        super(type, color);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(board, getRow(), getCol(), toRow, toCol, 7)
                || Movements.isLegalVerticalMove(board, getRow(), getCol(), toRow, toCol, 7)
                || Movements.isLegalDiagonalMove(board, getRow(), getCol(), toRow, toCol, 7);
    }

    @Override
    protected char getLetter() {
        return 'Q';
    }
}
