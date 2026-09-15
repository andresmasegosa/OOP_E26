package session3.E_ChessGame;

/**
 * The queen, any distance along a row, a column or a diagonal. This is the
 * "Queen" case of session 2's switch, moved into a class of its own.
 */
public class Queen extends ChessPiece {

    public Queen(String color) {
        super("Queen", color);
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
