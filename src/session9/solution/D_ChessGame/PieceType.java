package session9.solution.D_ChessGame;

/**
 * Exercise 2. The type of a piece, with what it is worth to GreedyPlayer on
 * the usual scale, and 100 for the king. Each type holds the number that
 * GreedyPlayer.valueOf gave it. The centaur keeps the 1 that valueOf gave a
 * type it did not know.
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
