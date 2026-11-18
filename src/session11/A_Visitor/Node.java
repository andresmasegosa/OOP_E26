package session11.A_Visitor;

/**
 * One symbol of a MathExpression, such as a number, a + or the = at the end.
 * Each kind of symbol is a subclass of Node, and a node keeps the text it was
 * read from.
 *
 * Node.accept is abstract, so every subclass writes its own. Inside
 * IntegerNode.accept the object is an IntegerNode, so it can call the visit
 * method meant for numbers, and the compiler checks the call.
 */
public abstract class Node {

    private String text;

    public Node(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    /** Calls the method of the visitor that is meant for this kind of node. */
    public abstract void accept(NodeVisitor visitor);
}
