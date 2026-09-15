package session4.C_ChessGame.players;

/**
 * A move, from one square to another. Four numbers that used to travel as
 * four parameters and now travel together as one object.
 *
 * This class exists because of the interface next to it. A player is asked
 * for a move and has to answer with one thing, and a method returns one
 * value, so the four numbers have to become one object. That is the whole
 * reason, and it is a common one: a type appears because something has to
 * be passed around or returned as a unit.
 *
 * Nothing here is new. It is session 2's ChessPiece shape, fields plus a
 * constructor plus getters, with no rules inside. A Move does not know
 * whether it is legal, which piece makes it, or whose turn it is.
 */
public class Move {

    private int fromRow;
    private int fromCol;
    private int toRow;
    private int toCol;

    public Move(int fromRow, int fromCol, int toRow, int toCol) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public int getFromRow() {
        return fromRow;
    }

    public int getFromCol() {
        return fromCol;
    }

    public int getToRow() {
        return toRow;
    }

    public int getToCol() {
        return toCol;
    }

    /**
     * The move written the way the game writes it, "(7,3) -> (4,3)". Every
     * class inherits toString from Object, and printing an object calls it;
     * this one overrides it so that a Move prints as a move instead of as
     * session4.A_Player.Move@1b6d3586. (Chapter 7, "The Object Class".)
     */
    @Override
    public String toString() {
        return "(" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol + ")";
    }
}
