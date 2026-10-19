package session7.E_ChessGame;

import session7.E_ChessGame.rules.MoveRule;

/**
 * A piece of the game, with its type and its colour. It holds the rules it
 * moves by, and ChessPiece.isLegalMove asks them. Each kind of piece is a
 * subclass that adds its rules in its constructor. A piece stands at (-1,-1)
 * until a board places it.
 */
public abstract class ChessPiece {

    private String type;        // "King", "Queen", "Rook", "Bishop" or "Knight"
    private String color;       // "White" or "Black"
    private int row = -1;
    private int col = -1;
    // The ways this piece may move, added one at a time by ChessPiece.addRule.
    private MoveRule[] rules = new MoveRule[4];
    private int ruleCount = 0;

    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    protected final void addRule(MoveRule rule) {
        rules[ruleCount] = rule;
        ruleCount++;
    }

    /**
     * Answers whether this piece may move to (toRow, toCol). A square that holds
     * a piece of the same colour is refused, and otherwise one rule that allows
     * the move is enough.
     */
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        ChessPiece target = board.getPieceAt(toRow, toCol);
        if (target != null && target.isWhite() == isWhite()) {
            return false;
        }
        for (int i = 0; i < ruleCount; i++) {
            if (rules[i].allows(board, row, col, toRow, toCol)) {
                return true;
            }
        }
        return false;
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

    /** The letter this piece is drawn with, in uppercase. */
    protected abstract char getLetter();

    /** The letter for the board, in lowercase for Black. */
    public char getSymbol() {
        char symbol = getLetter();
        if (!isWhite()) {
            symbol = Character.toLowerCase(symbol);
        }
        return symbol;
    }

    // ChessBoard calls these two when it places or moves this piece.
    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
