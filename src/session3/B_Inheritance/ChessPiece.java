package session3.B_Inheritance;

/**
 * Session 3, step B. The part every piece shares, written once.
 *
 * In step A, Queen and Rook each declared a color, a row and a col, a getter
 * and a constructor, line for line the same. That shared part now lives here.
 * Queen and Rook say "extends ChessPiece" and get it without writing it
 * again. ChessPiece is their superclass, and Queen and Rook are its
 * subclasses (chapter 7, "Inheritance Basics").
 *
 * A subclass gets two things from its superclass. It gets the code, so a
 * Queen has getColor without declaring it. And it gets the type, so a Queen
 * can be stored wherever a ChessPiece is expected. Demo shows both.
 *
 * The println in the constructor is there only so that you can see when the
 * constructor runs. The game in E_ChessGame has no such line.
 */
public class ChessPiece {

    private String color;
    private int row = -1;   // born off the board, as in session 2
    private int col = -1;

    public ChessPiece(String color) {
        this.color = color;
        System.out.println("  the ChessPiece constructor runs, color " + color);
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

    // Protected, as in session 2. The comment there promised that subclasses
    // would be allowed to call these two, and Queen and Rook do.
    protected void setRow(int row) {
        this.row = row;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
