package session7.B_Generics;

/**
 * A stack of up to 100 elements, kept in an array of Object. push puts an
 * element on top, and pop takes the top one off and gives it back.
 *
 * Every class extends Object, so this stack takes an object of any class, a
 * Giraffe or a Book. What pop gives back is an Object, and the code that pops
 * casts it to the class it expects. Popping an empty stack stops the program,
 * so the demo never does it.
 */
public class StackWithoutGenerics {
    private Object[] stack;
    private int count = 0;

    public StackWithoutGenerics() {
        stack = new Object[100];
    }

    public Object pop() {
        return stack[--count];
    }

    public void push(Object o) {
        stack[count++] = o;
    }

}
