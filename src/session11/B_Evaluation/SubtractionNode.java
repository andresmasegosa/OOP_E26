package session11.B_Evaluation;

/**
 * The symbol -, which takes the number after it from the number before it. It
 * is the node that exercise A of A_Visitor adds.
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
