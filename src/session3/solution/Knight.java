package session3.solution;

/**
 * The knight. SOLUTION (exercise 2): the new type costs a class and four lines
 * in ChessGame.setupPieces — plus the new Movements.isLegalKnightMove, a third
 * place, which this solution pays for up front because the Amazon needs the
 * same L. No switch anywhere, and the compiler found the rule, the letter, the
 * constructor and the class name in setupPieces by itself.
 */
public class Knight extends ChessPiece {

    public Knight(String color) {
        super("Knight", color);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        return Movements.isLegalKnightMove(getRow(), getCol(), toRow, toCol);
    }

    @Override
    protected char getLetter() {
        return 'N';   // SOLUTION
    }
}
