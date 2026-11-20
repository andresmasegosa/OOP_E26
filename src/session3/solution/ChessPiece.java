package session3.solution;

/**
 * Session 3, OFFICIAL SOLUTION, the abstract piece.
 *
 * The session's ChessPiece with its two exercises grown onto it. Every change
 * is marked with a "SOLUTION (exercise N)" comment. Diff this file against
 * E_ChessGame/ChessPiece.java to see what each exercise cost.
 *
 *   Exercise 1: nothing. The bishop costs a class and four lines of
 *               setupPieces, and the compiler finds both.
 *   Exercise 2: nothing here either. Knight and Amazon write their own
 *               getLetter, and the compiler demands it. The only place left
 *               that nothing checks is the legend in ChessBoard.print.
 */
public abstract class ChessPiece {

    private String type;
    private String color;
    private int row = -1;
    private int col = -1;

    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isWhite() {
        return color.equals("White");
    }

    /**
     * The letter this piece is drawn with, in uppercase. Abstract: every
     * subclass answers, and a type of piece that forgets its letter does not
     * compile. SOLUTION: Bishop, Knight and Amazon each write their own, and
     * none of them is a place the compiler failed to find.
     */
    protected abstract char getLetter();

    /** The char for printing the board: the piece's letter, lowercase for Black. */
    public char getSymbol() {
        char symbol = getLetter();
        if (!isWhite()) {
            symbol = Character.toLowerCase(symbol);
        }
        return symbol;
    }

    public abstract boolean isLegalMove(ChessBoard board, int toRow, int toCol);

    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
