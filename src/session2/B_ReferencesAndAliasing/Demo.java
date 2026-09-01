package session2.B_ReferencesAndAliasing;

/**
 * What does a ChessPiece variable actually hold?
 *
 * Not the object. Objects live on the HEAP, a storage area managed by the
 * JVM. A variable holds a REFERENCE — an arrow pointing at an object — and
 * the assignment 'b = a' copies the arrow, never the object. When two
 * variables point at the same object, that is called ALIASING.
 *
 * Session 1, exercise 3, discussion 3 asked what that program was missing:
 * "neither the piece's letter nor its square is a way to hold on to that
 * piece over time." This file is the answer. A reference keeps pointing at
 * the same queen wherever she goes.
 *
 * Before you run: for every println below, write down what you expect.
 */
public class Demo {

    public static void main(String[] args) {
        ChessPiece queen = new ChessPiece();
        queen.type = "Queen";
        queen.color = "White";
        queen.row = 7;
        queen.col = 3;

        // Copy the reference. NO new object is created here — 'new' has
        // run only once so far. One queen, two names.
        ChessPiece sameQueen = queen;

        // Move her and bump her counter through ONE of the two names...
        sameQueen.row = 4;
        sameQueen.moveCount = sameQueen.moveCount + 1;

        // ...and look at her through the other. Same object, same fields.
        System.out.println("queen:     " + queen.describe());
        System.out.println("sameQueen: " + sameQueen.describe());

        // A second 'new' is a second object — even if every field matches.
        ChessPiece twin = new ChessPiece();
        twin.type = "Queen";
        twin.color = "White";
        twin.row = 4;
        twin.col = 3;
        twin.moveCount = 1;

        // Between references, == asks: SAME OBJECT? (not: same contents?)
        System.out.println("queen == sameQueen: " + (queen == sameQueen));
        System.out.println("queen == twin:      " + (queen == twin));

        // That is also why strings are compared with equals(): with ==,
        // "White" == color would ask "same object?", and two equal texts
        // can perfectly well live in two different objects.

        // Where session 1 needed board coordinates to talk about a piece —
        // and lost track of her the moment she moved — a reference follows
        // the object itself. THAT is what the counter exercise was missing,
        // and its name is: identity.

        // Last thing. When no reference points at an object any more, the
        // JVM's garbage collector reclaims its memory. You never delete
        // objects in Java; you let go of them:
        twin = queen;   // nobody points at the twin now — she is gone.
        System.out.println("after twin = queen: " + twin.describe());
    }
}
