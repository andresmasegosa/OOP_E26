package session11.solution.B_Evaluation;

/**
 * Counts the operations in an expression, the sums and the subtractions apart.
 * A number and the = are not operations, so their visit methods do nothing.
 */
public class CountOperationsVisitor implements NodeVisitor {

    private int sums = 0;
    private int subtractions = 0;

    @Override
    public void visitInteger(IntegerNode node) {
        // A number is not an operation.
    }

    @Override
    public void visitSum(SumNode node) {
        sums++;
    }

    @Override
    public void visitSubtraction(SubtractionNode node) {
        subtractions++;
    }

    @Override
    public void visitEqual(EqualNode node) {
        // The = ends the expression. It is not an operation.
    }

    public int getSums() {
        return sums;
    }

    public int getSubtractions() {
        return subtractions;
    }
}
