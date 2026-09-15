package session3.E_ChessGame;

/**
 * A piece of the game, now at the top of a family of classes.
 *
 * ChessPiece is abstract. It keeps what every piece shares, and that is
 * almost all of session 2's ChessPiece, the type and the color, the square,
 * the getters and the protected setters. The fields are private here, as in
 * session 2, so King, Queen and Rook read their square through getRow and
 * getCol. The demo steps B_ and C_ declared the same fields protected, so
 * that a subclass could read row and col directly. Both compile, and the
 * game keeps session 2's choice. What it lost is the switch in
 * isLegalMove. The rule of each type of piece lives in its own subclass,
 * King, Queen and Rook. isLegalMove is abstract, so a new type of piece
 * without a rule does not compile. It also lost the constructor that took a
 * letter: nobody can write new ChessPiece(...) any more, so ChessGame names
 * the class it wants.
 *
 * Two methods are abstract now, not one: the rule of the piece and the
 * letter it is drawn with. Session 2 found the letter with a switch on the
 * type; here the subclass answers, and there is no switch left in this class.
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
     * The letter this piece is drawn with, in uppercase. Session 2 worked it
     * out with a switch on the type. Here every subclass answers for itself,
     * exactly as it does for its rule, and a type of piece that forgets its
     * letter does not compile either.
     */
    protected abstract char getLetter();

    /**
     * The char for printing the board, as in session 2: the piece's own
     * letter, lowercase for Black. This part is the same for every piece, so
     * it stays here and only getLetter is left to the subclass.
     */
    public char getSymbol() {
        char symbol = getLetter();
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
