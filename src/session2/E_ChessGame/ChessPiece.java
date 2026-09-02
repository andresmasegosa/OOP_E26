package session2.E_ChessGame;

/**
 * A piece of the refactored chess game.
 *
 * Everything session 1 knew about a piece is now in ONE place:
 *   - what it is: type and color, as Strings — the char survives only as
 *     the printed symbol (see getSymbol);
 *   - where it stands: row and col, kept in step with the board;
 *   - how it may move: isLegalMove, the one method that still switches on
 *     the type. Remember this switch. It is the last of its kind in the
 *     program, and session 3 is about making it disappear.
 *
 * This is step D's ChessPiece with behaviour added, and the same protocol:
 * a piece is born off the board, at (-1,-1), and the BOARD places it. A
 * piece does not even know which board it stands on. When the board wants
 * to know whether a move is legal it hands itself over — see
 * isLegalMove(board, toRow, toCol) — because walking the path between two
 * squares needs a board, and the board is the one asking.
 */
public class ChessPiece {

    private String type;    // "King", "Queen", "Rook" or "Bishop"
    private String color;   // "White" or "Black"
    private int row = -1;   // (-1,-1) until a board places the piece — as in step D
    private int col = -1;

    /** Step D's constructor, unchanged: what the piece is, not where. */
    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    /**
     * An overloaded constructor that speaks session 1's language: 'Q' is
     * the white queen, 'q' the black one. Its only line CHAINS to the
     * constructor above with this(...): translate the letter, then build
     * the piece the normal way.
     */
    public ChessPiece(char letter) {
        this(typeFromLetter(letter), colorFromLetter(letter));
    }

    /** Session 1's pieceName, repurposed: from a letter to a type name. */
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
            default:
                return "?";
        }
    }

    /** Uppercase letters are White — session 1's convention, remembered here. */
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

    /**
     * The char for printing the board: session 1's letters, computed from
     * type and color instead of stored. The piece stores ONE representation
     * and derives the others — so they can never disagree.
     */
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
            default:
                symbol = '?';
                break;
        }
        if (!isWhite()) {
            symbol = Character.toLowerCase(symbol);
        }
        return symbol;
    }

    /**
     * May this piece move to (toRow, toCol) on that board? Each type has
     * its own rule, so we switch on the type — exactly like session 1's
     * isLegalMove did. The refactor moved the switch HOME, into the piece;
     * it did not kill it. Whether it can be killed is session 3's question.
     *
     * The board is a parameter, not a field: the piece does not need to
     * know its board, only to answer a question about it. The Movements
     * helpers walk the path on that board and check that nothing blocks it.
     */
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
            default:
                // A piece nobody taught to move. The bishops, again — and
                // again nothing warned us. EXERCISES.md, exercise 1.
                return false;
        }
    }

    // Only the board relocates pieces — as in step D. These doors are
    // protected: open to this package (that is: the board) and, from
    // session 3 on, to subclasses. Not to the rest of the program.
    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
