package session3.C_Overriding;

/**
 * The king. Or so it looks.
 *
 * Read the name of the method below carefully. It is isLegalmove, with a
 * lowercase m, and there is no @Override above it. Java does not see a
 * misspelled override. It sees a new method that nobody ever calls. Whoever
 * asks a King isLegalMove gets ChessPiece's default false, and the king never
 * moves. It all compiles, and nothing warns you.
 *
 * Run Demo and see it. Then write @Override on the line above the method and
 * compile.
 *
 *   error: method does not override or implement a method from a supertype
 *
 * Fix the name, compile, and run Demo again.
 */
public class King extends ChessPiece {

    public King(String color, int row, int col) {
        super("King", color);
        setRow(row);
        setCol(col);
    }

    public boolean isLegalmove(int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - getRow());
        int colDistance = Math.abs(toCol - getCol());
        if (rowDistance == 0 && colDistance == 0) {
            return false;
        }
        return rowDistance <= 1 && colDistance <= 1;
    }
}
