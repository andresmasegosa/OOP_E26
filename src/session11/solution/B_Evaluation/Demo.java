package session11.solution.B_Evaluation;

/**
 * Reads two expressions with a + and a -, and writes each of them out. The
 * code is that of A_Visitor with the - that exercise A adds. Exercise B. Demo
 * writes each expression again, with its value.
 */
public class Demo {

    public static void main(String[] args) {
        MathExpression first = new MathExpression("3 + 2 - 1 + 5 =");
        MathExpression second = new MathExpression("10 - 4 - 3 =");
        System.out.println(first);
        System.out.println(second);

        // --- EXERCISE B, solved --------------------------------------------
        EvaluateVisitor firstValue = new EvaluateVisitor();
        first.accept(firstValue);
        System.out.println(first + " " + firstValue.getResult());

        EvaluateVisitor secondValue = new EvaluateVisitor();
        second.accept(secondValue);
        System.out.println(second + " " + secondValue.getResult());
    }
}
