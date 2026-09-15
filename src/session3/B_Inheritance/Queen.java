package session3.B_Inheritance;

/**
 * A Queen is a ChessPiece. The words "extends ChessPiece" give this class
 * everything ChessPiece declares, so what is written here is only what makes
 * a queen different: her constructor and her rule.
 */
public class Queen extends ChessPiece {

    public Queen(String color, int row, int col) {
        super("Queen", color);   // runs ChessPiece's constructor, so the ChessPiece part exists before the lines below
        setRow(row);             // protected in ChessPiece, and a subclass may call it
        setCol(col);
        System.out.println("  the Queen constructor runs");
    }

    // @Override asks the compiler to check that this method really does
    // override a method of the superclass.
    @Override
    public boolean isLegalMove(int toRow, int toCol) {
        // row and col are declared in ChessPiece and every Queen has them.
        return Movements.isLegalHorizontalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalVerticalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalDiagonalMove(row, col, toRow, toCol, 7);
    }
}
