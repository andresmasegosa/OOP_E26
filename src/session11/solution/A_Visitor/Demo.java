package session11.solution.A_Visitor;

/**
 * Reads one expression and counts its operations with a visitor. Demo passes
 * the visitor to the expression, and the expression passes it to each node.
 * Exercise A. Demo counts the numbers too, and then reads an expression with
 * a -.
 *
 * Discussion. In a calculator with stable number and operator classes,
 * new operations on expressions are likely to be the more common change.
 * Each operation is one visitor; a new node type changes every visitor.
 * A calculator that often adds operators could lead to the other choice.
 */
public class Demo {

    public static void main(String[] args) {
        MathExpression expression = new MathExpression("3 + 2 + 4 =");
        System.out.println(expression);

        CountOperationsVisitor counter = new CountOperationsVisitor();
        expression.accept(counter);
        System.out.println("Sum operations: " + counter.getSums());

        // --- EXERCISE A, solved --------------------------------------------
        CountIntegersVisitor integers = new CountIntegersVisitor();
        expression.accept(integers);
        System.out.println("Integers: " + integers.getIntegers());

        MathExpression withMinus = new MathExpression("3 + 2 - 1 + 5 =");

        CountOperationsVisitor counter2 = new CountOperationsVisitor();
        withMinus.accept(counter2);
        System.out.println("Sum operations: " + counter2.getSums());
        System.out.println("Subtraction operations: " + counter2.getSubtractions());

        CountIntegersVisitor integers2 = new CountIntegersVisitor();
        withMinus.accept(integers2);
        System.out.println("Integers: " + integers2.getIntegers());
    }
}
