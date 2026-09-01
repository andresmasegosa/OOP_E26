package session2.C_Constructors;

/**
 * Session 2, step C — the class learns to be born whole.
 *
 * With steps A and B, creating a piece took five statements: one 'new' and
 * four field assignments. Forget one and you get a half-piece — run the
 * demo to meet a queen called null. Nothing in the language reminded you.
 *
 * A CONSTRUCTOR is a special method that runs when 'new' creates the
 * object. It has the same name as the class and no return type, and its
 * parameters are the data the object cannot exist without. From now on it
 * is IMPOSSIBLE to create a ChessPiece without saying what it is and where
 * it stands.
 */
public class ChessPiece {

    public String type;
    public String color;
    public int row;
    public int col;

    /**
     * The parameters reuse the fields' names, so inside this constructor
     * the bare word 'type' means the parameter. this.type is how we name
     * the field: 'this' is the object currently being built.
     */
    public ChessPiece(String type, String color, int row, int col) {
        this.type = type;
        this.color = color;
        this.row = row;
        this.col = col;
    }

    /**
     * A second constructor with the SAME name and a DIFFERENT parameter
     * list: that is OVERLOADING, and Java picks by what you pass. This one
     * speaks session 1's language — a board letter like 'Q' or 'q' — and
     * translates it: the case is the color, the letter is the type.
     */
    public ChessPiece(char letter, int row, int col) {
        this.type = typeFromLetter(letter);
        if (Character.isUpperCase(letter)) {
            this.color = "White";
        } else {
            this.color = "Black";
        }
        this.row = row;
        this.col = col;
    }

    /** Session 1's pieceName, repurposed: from a letter to a type name. */
    private static String typeFromLetter(char letter) {
        switch (Character.toUpperCase(letter)) {
            case 'K':
                return "King";
            case 'Q':
                return "Queen";
            case 'R':
                return "Rook";
            case 'B':
                return "Bishop";
            default:
                return "?";   // a letter nobody knows. Sound familiar? (Session 1, exercise 1.)
        }
    }

    public String describe() {
        return color + " " + type + " at (" + row + "," + col + ")";
    }

    public boolean isWhite() {
        return color.equals("White");
    }
}
