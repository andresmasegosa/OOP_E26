package session11.solution.C_ChessGame;

/**
 * The type of a piece, with what it is worth to GreedyPlayer on the usual
 * scale, and 100 for the king. The centaur is worth 1.
 */
public enum PieceType {
    KING(100),
    QUEEN(9),
    ROOK(5),
    BISHOP(3),
    KNIGHT(3),
    CENTAUR(1);

    private int value;

    PieceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
