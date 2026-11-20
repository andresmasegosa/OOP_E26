package session3.solution;

/** The king, as in the session. */
public class King extends ChessPiece {

    public King(String color) {
        super("King", color);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(board, getRow(), getCol(), toRow, toCol, 1)
                || Movements.isLegalVerticalMove(board, getRow(), getCol(), toRow, toCol, 1)
                || Movements.isLegalDiagonalMove(board, getRow(), getCol(), toRow, toCol, 1);
    }

    @Override
    protected char getLetter() {
        return 'K';
    }
}
