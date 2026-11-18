package session11.B_Evaluation;

/**
 * Reads two expressions with a + and a -, and writes each of them out. The
 * code is that of A_Visitor with the - that exercise A adds.
 */
public class Demo {

    public static void main(String[] args) {
        MathExpression first = new MathExpression("3 + 2 - 1 + 5 =");
        MathExpression second = new MathExpression("10 - 4 - 3 =");
        System.out.println(first);
        System.out.println(second);

        // --- EXERCISE B --------------------------------------------------
        // See EXERCISES.md. Print each expression again, with its value.
    }
}
