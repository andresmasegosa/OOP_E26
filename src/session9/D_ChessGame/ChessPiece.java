package session9.D_ChessGame;

import session9.D_ChessGame.rules.MoveRule;

import java.util.ArrayList;
import java.util.List;

/**
 * A piece of the game, with its type and its colour. It holds the rules it
 * moves by, and ChessPiece.isLegalMove asks them. Each kind of piece is a
 * subclass that adds its rules in its constructor. A piece stands at (-1,-1)
 * until a board places it.
 */
public abstract class ChessPiece {

    private String type;        // "King", "Queen", "Rook", "Bishop", "Knight" or "Centaur"
    private String color;       // "White" or "Black"
    private int row = -1;
    private int col = -1;
    // The ways this piece may move, added one at a time by ChessPiece.addRule.
    private List<MoveRule> rules = new ArrayList<>();

    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    protected final void addRule(MoveRule rule) {
        rules.add(rule);
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
        for (MoveRule rule : rules) {
            if (rule.allows(board, row, col, toRow, toCol)) {
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

    /** The piece as its colour and its type, such as Black Rook. */
    @Override
    public String toString() {
        return getColor() + " " + getType();
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
