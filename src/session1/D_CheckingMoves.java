package session1;

/**
 * Session 1, step D — methods, if/else and switch: is a move legal?
 *
 * A method is a named block of code. We call it with arguments and it can
 * return a value. Instead of one huge main, we split the logic into small
 * methods, each with one job.
 *
 * Here we check one rule in isolation, with no board yet: in which
 * directions, and how far, each kind of piece may move. (The real game,
 * E_ChessGame, also checks that no piece is standing in the way.)
 */
public class D_CheckingMoves {

    public static void main(String[] args) {
        // A king moves one square in any direction.
        System.out.println("King (4,4) -> (5,5): " + isLegalKingMove(4, 4, 5, 5));   // true
        System.out.println("King (4,4) -> (4,6): " + isLegalKingMove(4, 4, 4, 6));   // false: two squares away

        // With a switch, the program chooses what to check based on the piece type.
        System.out.println("Rook (0,0) -> (0,5): " + isLegalDirection('R', 0, 0, 0, 5));   // true
        System.out.println("Rook (0,0) -> (3,5): " + isLegalDirection('R', 0, 0, 3, 5));   // false: not a straight line
        System.out.println("Queen (3,3) -> (6,6): " + isLegalDirection('Q', 3, 3, 6, 6));  // true: diagonal
        System.out.println("Bishop (2,0) -> (4,2): " + isLegalDirection('B', 2, 0, 4, 2)); // false?! Nobody taught
                                                                                           // the program how a
                                                                                           // bishop moves...
    }

    /** A king may move exactly one square, in any direction. */
    static boolean isLegalKingMove(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - fromRow);   // Math.abs = absolute value
        int colDistance = Math.abs(toCol - fromCol);

        if (rowDistance <= 1 && colDistance <= 1) {
            return rowDistance + colDistance > 0;      // staying still is not a move
        } else {
            return false;
        }
    }

    /**
     * Does this piece move in one of its allowed directions?
     * The switch runs the case that matches the piece type.
     */
    static boolean isLegalDirection(char piece, int fromRow, int fromCol, int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        switch (piece) {
            case 'K':
                return rowDistance <= 1 && colDistance <= 1 && rowDistance + colDistance > 0;
            case 'Q':
                // horizontal, vertical or diagonal
                return (rowDistance == 0 && colDistance > 0)
                        || (colDistance == 0 && rowDistance > 0)
                        || (rowDistance == colDistance && rowDistance > 0);
            case 'R':
                // horizontal or vertical only
                return (rowDistance == 0 && colDistance > 0)
                        || (colDistance == 0 && rowDistance > 0);
            default:
                // A piece this program does not know how to move (yet).
                return false;
        }
    }
}
