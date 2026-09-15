package session4.C_ChessGame;

import session4.C_ChessGame.rules.MoveRule;

/**
 * A piece of the game. Session 3's abstract class, with its rule taken out
 * and put into objects.
 *
 * Session 3 said: a piece is a King, a Queen or a Rook, and each subclass
 * writes its own isLegalMove. This session says: a piece IS still a King, a
 * Queen or a Rook, and it HAS the ways it is allowed to move. isLegalMove
 * has a body again, the same body for every piece, and it asks the rules.
 *
 * What that buys is in exercise 1. A piece that moves like two pieces is a
 * piece that holds two rules, and neither inheritance nor copying is needed.
 *
 * The rules live in the package rules/, next door, and the players in
 * players/. Neither of those packages knows the other exists, and neither
 * knows about ChessGame. This class is the only place where a piece and a
 * rule meet.
 *
 * What it costs is worth saying out loud. Exercise 1 of session 3 met three
 * compiler errors in a row, the rule, the letter and the constructor. Here
 * you meet two of the three. The letter is still abstract and the
 * constructor still has to be called, so the compiler names both. The rule
 * is no longer abstract, because isLegalMove has a body again, so a piece
 * that calls super and forgets addRule compiles and simply never moves.
 * That is what composition costs, and exercise 2 makes you meet it.
 *
 * There is no switch in this class, and none anywhere in this session.
 * Session 3 took the last two out: the letter is getLetter, answered by each
 * subclass, and ChessGame names the class it wants instead of turning a
 * letter into a piece. What is left is subtler and session 8 deals with it:
 * a piece's type and its colour are still Strings that nobody can check.
 *
 * Session 2's protocol has not changed. A piece is born off the board, at
 * (-1,-1), and the board places it.
 */
public abstract class ChessPiece {

    private String type;        // "King", "Queen", "Rook" or "Bishop"
    private String color;       // "White" or "Black"
    private int row = -1;       // (-1,-1) until a board places the piece
    private int col = -1;
    // The ways this piece is allowed to move, filled in by addRule. Four is
    // enough for every piece of this game and of exercise 2; a fifth would
    // crash here, and session 6 gives us the tool that takes the number away.
    private MoveRule[] rules = new MoveRule[4];
    private int ruleCount = 0;

    /**
     * A piece is born with a name and a colour, off the board, at (-1,-1).
     * How it moves is added next, one rule at a time.
     */
    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Give this piece one more way of moving. A subclass calls it once per
     * rule, right after super(...), and that is the whole of what a class
     * like Queen or Bishop contains.
     *
     * It is protected, so only the pieces themselves may do it, and final,
     * so no subclass may change what adding a rule means.
     */
    protected final void addRule(MoveRule rule) {
        rules[ruleCount] = rule;
        ruleCount++;
    }

    /**
     * May this piece move to (toRow, toCol) on that board? One yes among
     * the rules is enough. Nothing in this method knows which rules a piece
     * holds, or how many, and that is why it never has to change again.
     *
     * What this method does NOT decide: whether the target holds a piece of
     * your own color, and whose turn it is. ChessBoard.movePiece keeps the
     * first and ChessGame.takeTurn keeps the second.
     */
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        for (int i = 0; i < ruleCount; i++) {
            if (rules[i].allows(board, row, col, toRow, toCol)) {
                return true;
            }
        }
        return false;
    }

    /** How many ways this piece can move. Exercise 2 counts with it. */
    public int countRules() {
        return ruleCount;
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
     * The letter this piece is drawn with, in uppercase. Session 3's method,
     * unchanged: every subclass answers for itself, and a type of piece that
     * forgets its letter does not compile.
     */
    protected abstract char getLetter();

    /**
     * The char for printing the board: the piece's own letter, lowercase for
     * Black. Session 3's method, unchanged.
     */
    public char getSymbol() {
        char symbol = getLetter();
        if (!isWhite()) {
            symbol = Character.toLowerCase(symbol);
        }
        return symbol;
    }

    // Only the board relocates pieces, as in sessions 2 and 3. Protected
    // opens these two to the classes of this package, the board among them,
    // and to every subclass in every package. The board needs the first
    // half of that sentence. Whether anybody needs the second is a question
    // worth asking of any protected member you write.
    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
