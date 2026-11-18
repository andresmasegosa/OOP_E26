package session11.B_Evaluation;

/** The symbol +, which adds the numbers on each side of it. */
public class SumNode extends Node {

    public SumNode(String text) {
        super(text);
    }

    /** Answers whether the text is the symbol +. */
    public static boolean detectNode(String text) {
        return text.equals("+");
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitSum(this);
    }
}
