package session3.E_ChessGame;

/**
 * A piece of the game, now at the top of a family of classes.
 *
 * ChessPiece is abstract. It keeps what every piece shares, and that is
 * almost all of session 2's ChessPiece, the type and the color, the square,
 * the getters and the protected setters. What it lost is the switch in
 * isLegalMove. The rule of each type of piece lives in its own subclass,
 * King, Queen and Rook. isLegalMove is abstract, so a new type of piece
 * without a rule does not compile.
 *
 * Two switches are still here. getSymbol switches on the type to find the
 * letter the board draws, as in session 2. fromLetter switches on a letter to
 * decide which subclass to create, and exercise 3 asks where it should live.
 *
 * Session 2's protocol has not changed. A piece is born off the board, at
 * (-1,-1), and the board places it.
 */
public abstract class ChessPiece {

    private String type;    // "King", "Queen" or "Rook", passed up by each subclass
    private String color;   // "White" or "Black"
    private int row = -1;   // (-1,-1) until a board places the piece
    private int col = -1;

    /**
     * Nobody can write new ChessPiece(...) any more, because the class is
     * abstract. This constructor still runs, every time a subclass calls
     * super(type, color) from its own constructor.
     */
    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Session 2 created pieces with new ChessPiece('Q'). ChessPiece is abstract
     * now, so nobody can write new ChessPiece(...) at all, and this method
     * turns a letter into an object of the right subclass instead. A letter
     * with no class behind it gives null.
     */
    public static ChessPiece fromLetter(char letter) {
        String color;
        if (Character.isUpperCase(letter)) {
            color = "White";
        } else {
            color = "Black";
        }
        switch (Character.toUpperCase(letter)) {
            case 'K':
                return new King(color);
            case 'Q':
                return new Queen(color);
            case 'R':
                return new Rook(color);
            default:
                return null;   // a letter with no class behind it (the bishops, exercise 1)
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
     * The char for printing the board, as in session 2. The piece stores its
     * type as a String and works the letter out from it, with a switch on the
     * type.
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
     * May this piece move to (toRow, toCol) on that board? In session 2 this
     * method was one switch with a case per type. Here it has no body. Every
     * subclass writes its own, and the compiler checks that it did.
     */
    public abstract boolean isLegalMove(ChessBoard board, int toRow, int toCol);

    // Only the board relocates pieces, as in session 2. Protected opens these
    // two to the classes of this package, the board among them, and to
    // subclasses.
    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
