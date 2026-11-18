package session11.A_Visitor;

/**
 * Reads one expression and counts its operations with a visitor. Demo passes
 * the visitor to the expression, and the expression passes it to each node.
 */
public class Demo {

    public static void main(String[] args) {
        MathExpression expression = new MathExpression("3 + 2 + 4 =");
        System.out.println(expression);

        CountOperationsVisitor counter = new CountOperationsVisitor();
        expression.accept(counter);
        System.out.println("Sum operations: " + counter.getSums());

        // --- EXERCISE A --------------------------------------------------
        // See EXERCISES.md. The new visitor, and the expression with a -,
        // go here.
    }
}
