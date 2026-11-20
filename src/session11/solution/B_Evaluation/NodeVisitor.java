package session11.solution.B_Evaluation;

/**
 * Something to do with the nodes of a MathExpression, such as counting them.
 * It has one visit method for each kind of node. A node calls the method meant
 * for it from its accept method, so a visitor never checks which kind of node
 * it has.
 */
public interface NodeVisitor {

    void visitInteger(IntegerNode node);

    void visitSum(SumNode node);

    void visitSubtraction(SubtractionNode node);

    void visitEqual(EqualNode node);
}
