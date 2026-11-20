package session2.solution;

/**
 * Session 2 — OFFICIAL SOLUTION, piece side.
 *
 * This is the session's ChessPiece with three changes grown onto it:
 *   Exercise 1: the bishops move — ONE new case in isLegalMove.
 *   Exercise 2: moveCount lives inside the piece, grown through recordMove.
 *   Exercise 5: the knights — a case in isLegalMove, plus a letter in
 *               typeFromLetter and a symbol in getSymbol. Count those
 *               places: the rule got cheap, the *type* did not.
 *
 * Every change is marked with a "SOLUTION (exercise N)" comment. Diff this
 * file against E_ChessGame/ChessPiece.java to see exactly what each
 * exercise cost — that cost is the real subject of the session.
 */
public class ChessPiece {

    private String type;
    private String color;
    private int row = -1;
    private int col = -1;

    // SOLUTION (exercise 2): the counter is data about THIS piece, so it
    // lives here — private, like everything without a reason not to be.
    // Compare with session 1's parallel int[8][8]: no syncing, no
    // reset-on-capture bug, no searching the board to find it.
    private int moveCount = 0;

    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public ChessPiece(char letter) {
        this(typeFromLetter(letter), colorFromLetter(letter));
    }

    private static String typeFromLetter(char letter) {
        switch (Character.toUpperCase(letter)) {
            case 'K':
                return "King";
            case 'Q':
                return "Queen";
            case 'R':
                return "Rook";
            case 'B':
                return "Bishop";
            case 'N':
                // SOLUTION (exercise 5): the knight's LETTER — first of the
                // two translation switches that a new type must visit.
                return "Knight";
            default:
                return "?";
        }
    }

    private static String colorFromLetter(char letter) {
        if (Character.isUpperCase(letter)) {
            return "White";
        } else {
            return "Black";
        }
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

    // SOLUTION (exercise 2): reading is harmless — the getter is public.
    public int getMoveCount() {
        return moveCount;
    }

    public char getSymbol() {
        char symbol;
        switch (type) {
            case "King":
                symbol = 'K';
                break;
            case "Queen":
                symbol = 'Q';
                break;
            case "Rook":
                symbol = 'R';
                break;
            case "Bishop":
                symbol = 'B';
                break;
            case "Knight":
                // SOLUTION (exercise 5): the knight's SYMBOL — the second
                // translation switch. Session 1 paid this tax once, in
                // pieceName; the String type pays it twice.
                symbol = 'N';
                break;
            default:
                symbol = '?';
                break;
        }
        if (!isWhite()) {
            symbol = Character.toLowerCase(symbol);
        }
        return symbol;
    }

    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        switch (type) {
            case "King":
                return Movements.isLegalHorizontalMove(board, row, col, toRow, toCol, 1)
                        || Movements.isLegalVerticalMove(board, row, col, toRow, toCol, 1)
                        || Movements.isLegalDiagonalMove(board, row, col, toRow, toCol, 1);
            case "Queen":
                return Movements.isLegalHorizontalMove(board, row, col, toRow, toCol, 7)
                        || Movements.isLegalVerticalMove(board, row, col, toRow, toCol, 7)
                        || Movements.isLegalDiagonalMove(board, row, col, toRow, toCol, 7);
            case "Rook":
                return Movements.isLegalHorizontalMove(board, row, col, toRow, toCol, 7)
                        || Movements.isLegalVerticalMove(board, row, col, toRow, toCol, 7);
            case "Bishop":
                // SOLUTION (exercise 1): the whole bishop fix is this one
                // case. Session 1 needed a second fix in pieceName; here
                // the type IS the name, so there is no second fix.
                return Movements.isLegalDiagonalMove(board, row, col, toRow, toCol, 7);
            case "Knight":
                // SOLUTION (exercise 5): the L-rule. No helper fits — the
                // knight jumps, so there is no path to walk. The rule sits
                // inline, exactly like session 1's, just closer to home.
                int rowDistance = Math.abs(toRow - row);
                int colDistance = Math.abs(toCol - col);
                return (rowDistance == 2 && colDistance == 1)
                        || (rowDistance == 1 && colDistance == 2);
            default:
                return false;
        }
    }

    // SOLUTION (exercise 2): the door through which the counter grows.
    // protected, like setRow/setCol: moving pieces is the board's business,
    // so counting moves is too. A public bump would let anyone inflate the
    // statistics without moving anything.
    protected void recordMove() {
        moveCount = moveCount + 1;
    }

    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
