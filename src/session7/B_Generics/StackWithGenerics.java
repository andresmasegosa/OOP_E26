package session7.B_Generics;

/**
 * StackWithoutGenerics with a type parameter, T, written in angle brackets
 * after the class name. T stands for a class, and the code that creates a
 * stack says which one. Inside this file T is the type of the elements, where
 * StackWithoutGenerics says Object.
 *
 * In a StackWithGenerics<Giraffe>, T is Giraffe. push takes a Giraffe, and
 * pop gives back a Giraffe, with no cast. (Chapter 13, "A Simple Generics
 * Example".)
 */
public class StackWithGenerics<T> {
    private T[] stack;
    private int count = 0;

    public StackWithGenerics() {
        // new T[100] does not compile, so the array is made of Object and cast
        // to T[]. The compiler cannot check that cast, and it says so. With
        // -Xlint:all you get "warning: [unchecked] unchecked cast" for this
        // line, and without it a note that the file "uses unchecked or unsafe
        // operations". The warning also says "T extends Object", which only
        // means that T can be any class. The warning is expected here. Only
        // push puts anything into the array, and push only takes a T.
        stack = (T[]) new Object[100];
    }

    public T pop() {
        return stack[--count];
    }

    public void push(T o) {
        stack[count++] = o;
    }

}
