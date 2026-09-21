package session5.B_Player;

import session5.B_Player.rules.MoveRule;

/**
 * The piece of session 3, with one field added and one method changed.
 *
 * The field is MoveRule[] rules, and it changes what a piece is. In session
 * 3 a piece WAS a kind of thing that knew its own rule, written into the
 * body of its own isLegalMove. Here a piece HAS rules, objects it was
 * handed when it was built, and isLegalMove asks them.
 *
 * Read a subclass constructor. It says what the piece is called, and then
 * it says how it moves, one line per way of moving. That is the whole of a
 * class like Queen. Nothing there mentions an array: the array is in here,
 * and addRule is the only door to it.
 *
 * The class is still abstract, so that a piece is still a King or a Queen
 * and not a ChessPiece and nothing more. Exercise 3 asks whether the
 * subclasses still earn their keep now that they hold nothing but a call to
 * super.
 */
public abstract class ChessPiece {

    private String type;
    private String color;
    private int row = -1;
    private int col = -1;
    // The ways this piece is allowed to move, filled in by addRule. Four is
    // enough for every piece of this game and of exercise 2; a fifth would
    // crash here, and session 6 gives us the tool that takes the number away.
    private MoveRule[] rules = new MoveRule[4];
    private int ruleCount = 0;

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
     * May this piece move to (toRow, toCol)? It used to be abstract, and
     * every subclass wrote its own. Here it has a body again, and the body
     * is the same for every piece: ask the rules, and one yes is enough.
     *
     * Nothing in this method knows which rules they are, or how many.
     */
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        for (int i = 0; i < ruleCount; i++) {
            if (rules[i].allows(board, row, col, toRow, toCol)) {
                return true;
            }
        }
        return false;
    }

    /** How many ways this piece can move. Step A's demo prints it. */
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
     * unchanged: every subclass answers for itself.
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

    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
