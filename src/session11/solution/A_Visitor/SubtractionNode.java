package session11.solution.A_Visitor;

/**
 * Exercise A. The symbol -, which takes the number after it from the number
 * before it. A new kind of node, so NodeVisitor has a new method for it.
 */
public class SubtractionNode extends Node {

    public SubtractionNode(String text) {
        super(text);
    }

    /** Answers whether the text is the symbol -. */
    public static boolean detectNode(String text) {
        return text.equals("-");
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitSubtraction(this);
    }
}
