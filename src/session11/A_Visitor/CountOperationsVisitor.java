package session11.A_Visitor;

/**
 * Counts the operations in an expression. A number and the = are not
 * operations, so their visit methods do nothing.
 */
public class CountOperationsVisitor implements NodeVisitor {

    private int sums = 0;

    @Override
    public void visitInteger(IntegerNode node) {
        // A number is not an operation.
    }

    @Override
    public void visitSum(SumNode node) {
        sums++;
    }

    @Override
    public void visitEqual(EqualNode node) {
        // The = ends the expression. It is not an operation.
    }

    public int getSums() {
        return sums;
    }
}
