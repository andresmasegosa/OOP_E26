package session11.solution.B_Evaluation;

/**
 * Exercise B. Works out the value of an expression, from left to right. It
 * keeps in a field whether the next number is added or subtracted.
 * EvaluateVisitor.visitSum and EvaluateVisitor.visitSubtraction set the field,
 * and EvaluateVisitor.visitInteger uses it.
 */
public class EvaluateVisitor implements NodeVisitor {

    private int result = 0;
    private boolean subtractNext = false;

    @Override
    public void visitInteger(IntegerNode node) {
        if (subtractNext) {
            result = result - node.getValue();
        } else {
            result = result + node.getValue();
        }
    }

    @Override
    public void visitSum(SumNode node) {
        subtractNext = false;
    }

    @Override
    public void visitSubtraction(SubtractionNode node) {
        subtractNext = true;
    }

    @Override
    public void visitEqual(EqualNode node) {
        // The = ends the expression, and the value is in result.
    }

    public int getResult() {
        return result;
    }
}
