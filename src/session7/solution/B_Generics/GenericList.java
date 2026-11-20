package session7.solution.B_Generics;

/**
 * Exercise B. GenericList with a type parameter, T, in the shape of
 * StackWithGenerics.
 *
 * Every Object of the provided version is a T now, except the one in
 * new Object[100]. Java cannot create an array of T, so the array is made of
 * Object and cast, as in StackWithGenerics, and -Xlint:all reports the same
 * unchecked cast. The cast is safe for the same reason too. Only add puts
 * anything into the array, and add only takes a T.
 *
 * A GenericList<Giraffe> gives back a Giraffe from get, so Demo.main reads
 * element 0 with no cast. The cast to Book, which stopped the program when it
 * ran, no longer compiles. That is the discussion question of exercise B.
 */
public class GenericList<T> {
    private T[] array;
    private int count = 0;

    public GenericList() {
        array = (T[]) new Object[100];   // the same unchecked cast as in StackWithGenerics
    }

    public void add(T o) {
        array[count++] = o;
    }

    public T get(int i) {
        return array[i];
    }
}
