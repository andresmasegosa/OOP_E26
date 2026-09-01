package session2.A_ClassesAndObjects;

/**
 * Creating objects from the ChessPiece class and talking to them.
 * Run me, then read ChessPiece.java next to this file.
 */
public class Demo {

    public static void main(String[] args) {
        // 'new' creates one object in memory — one actual piece.
        ChessPiece queen = new ChessPiece();
        queen.type = "Queen";     // the dot reaches into THIS object's fields
        queen.color = "White";
        queen.row = 7;
        queen.col = 3;

        ChessPiece king = new ChessPiece();
        king.type = "King";
        king.color = "Black";
        king.row = 0;
        king.col = 4;

        // Two objects, each with its own copies of the four fields.
        System.out.println(queen.describe());
        System.out.println(king.describe());
        System.out.println("Is the queen White? " + queen.isWhite());
        System.out.println("Is the king White?  " + king.isWhite());

        // Session 1 flashback: there, "the white queen" was the char 'Q'
        // in board[7][3] — and her name, her color and her rules had to be
        // hunted down in switches all over the file. Here, everything the
        // program knows about THIS queen travels together, inside one
        // object.
    }
}
