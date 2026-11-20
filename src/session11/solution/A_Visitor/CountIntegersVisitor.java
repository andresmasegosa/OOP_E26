package session11.solution.A_Visitor;

/**
 * Exercise A. Counts the numbers in an expression. It is a new operation, and
 * no node class changed for it.
 */
public class CountIntegersVisitor implements NodeVisitor {

    private int integers = 0;

    @Override
    public void visitInteger(IntegerNode node) {
        integers++;
    }

    @Override
    public void visitSum(SumNode node) {
        // An operation is not a number.
    }

    @Override
    public void visitSubtraction(SubtractionNode node) {
        // An operation is not a number.
    }

    @Override
    public void visitEqual(EqualNode node) {
        // The = is not a number.
    }

    public int getIntegers() {
        return integers;
    }
}
