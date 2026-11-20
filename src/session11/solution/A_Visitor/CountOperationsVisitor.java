package session11.solution.A_Visitor;

/**
 * Counts the operations in an expression. A number and the = are not
 * operations, so their visit methods do nothing. Exercise A. It counts the
 * subtractions apart from the sums.
 */
public class CountOperationsVisitor implements NodeVisitor {

    private int sums = 0;
    private int subtractions = 0;                                   // exercise A

    @Override
    public void visitInteger(IntegerNode node) {
        // A number is not an operation.
    }

    @Override
    public void visitSum(SumNode node) {
        sums++;
    }

    @Override
    public void visitSubtraction(SubtractionNode node) {            // exercise A
        subtractions++;
    }

    @Override
    public void visitEqual(EqualNode node) {
        // The = ends the expression. It is not an operation.
    }

    public int getSums() {
        return sums;
    }

    public int getSubtractions() {                                  // exercise A
        return subtractions;
    }
}
