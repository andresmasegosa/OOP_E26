package session11.B_Evaluation;

/** A whole number in the expression, such as 3. */
public class IntegerNode extends Node {

    private int value;

    public IntegerNode(String text) {
        super(text);
        this.value = Integer.parseInt(text);
    }

    public int getValue() {
        return value;
    }

    /** Answers whether the text is a whole number, such as 3 or 42. */
    public static boolean detectNode(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitInteger(this);
    }
}
