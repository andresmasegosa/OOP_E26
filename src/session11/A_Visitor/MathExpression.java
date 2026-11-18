package session11.A_Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * An expression such as 3 + 2 + 4 =, kept as a list of nodes from left to
 * right. MathExpression.accept passes a visitor to every node, so a visitor
 * gets every node and does not need to know how the nodes are stored.
 */
public class MathExpression {

    private List<Node> nodes = new ArrayList<>();

    /**
     * Reads a text such as "3 + 2 + 4 =", with a space between each two
     * symbols. A symbol it does not know stops it with an exception.
     */
    public MathExpression(String text) {
        for (String part : text.trim().split(" ")) {
            if (IntegerNode.detectNode(part)) {
                nodes.add(new IntegerNode(part));
            } else if (SumNode.detectNode(part)) {
                nodes.add(new SumNode(part));
            } else if (EqualNode.detectNode(part)) {
                nodes.add(new EqualNode(part));
            } else {
                throw new IllegalArgumentException("Unknown symbol '" + part + "'");
            }
        }
    }

    /** Passes the visitor to every node, from left to right. */
    public void accept(NodeVisitor visitor) {
        for (Node node : nodes) {
            node.accept(visitor);
        }
    }

    /** The expression as it was written, such as 3 + 2 + 4 =. */
    @Override
    public String toString() {
        String text = "";
        for (Node node : nodes) {
            if (!text.isEmpty()) {
                text = text + " ";
            }
            text = text + node.getText();
        }
        return text;
    }
}
