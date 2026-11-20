package session11.solution.A_Visitor;

/** The symbol =, which ends the expression. */
public class EqualNode extends Node {

    public EqualNode(String text) {
        super(text);
    }

    /** Answers whether the text is the symbol =. */
    public static boolean detectNode(String text) {
        return text.equals("=");
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitEqual(this);
    }
}
