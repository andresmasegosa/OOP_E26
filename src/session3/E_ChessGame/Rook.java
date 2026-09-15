package session3.E_ChessGame;

/**
 * The rook, any distance along a row or a column. This is the "Rook" case of
 * session 2's switch, moved into a class of its own.
 */
public class Rook extends ChessPiece {

    public Rook(String color) {
        super("Rook", color);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(board, getRow(), getCol(), toRow, toCol, 7)
                || Movements.isLegalVerticalMove(board, getRow(), getCol(), toRow, toCol, 7);
    }

    @Override
    protected char getLetter() {
        return 'R';
    }
}
