package session9.D_ChessGame;

import java.util.Objects;

/**
 * A square of the board, known by its row and its column. Two positions with
 * the same row and column are equal and have the same hash code, so ChessBoard
 * finds a piece with a new Position built for the same square.
 */
public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Position that = (Position) other;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
