package session7.B_Generics;

/**
 * Step B. A stack of Objects takes any object, and what it gives back needs a
 * cast. A stack with a type parameter takes only the class you name, and
 * gives it back with no cast.
 */
public class Demo {

    public static void main(String[] args) {
        StackWithoutGenerics giraffeStack = new StackWithoutGenerics();
        Giraffe giraffe1 = new Giraffe();
        giraffeStack.push(giraffe1);
        Giraffe giraffe2 = (Giraffe) giraffeStack.pop();   // pop gives back an Object
        System.out.println("StackWithoutGenerics, a giraffe pushed and popped:");
        System.out.println("  the same giraffe back: " + (giraffe2 == giraffe1));

        Book book1 = new Book();
        giraffeStack.push(book1);                          // it takes a book too

        // This line compiles and then stops the program. Uncomment it, run,
        // and comment it out again.
        // Giraffe popped = (Giraffe) giraffeStack.pop();
        // Exception in thread "main" java.lang.ClassCastException:
        // class session7.B_Generics.Book cannot be cast to class session7.B_Generics.Giraffe

        Book book2 = (Book) giraffeStack.pop();
        System.out.println("The same stack, a book pushed and popped:");
        System.out.println("  the same book back: " + (book2 == book1));

        StackWithGenerics<Giraffe> genericGiraffeStack = new StackWithGenerics<>();
        Giraffe giraffe3 = new Giraffe();
        genericGiraffeStack.push(giraffe3);
        Giraffe giraffe4 = genericGiraffeStack.pop();       // no cast
        System.out.println();
        System.out.println("StackWithGenerics<Giraffe>, a giraffe pushed and popped:");
        System.out.println("  the same giraffe back: " + (giraffe4 == giraffe3));

        // This line does not compile. Uncomment it and compile.
        // genericGiraffeStack.push(book1);
        // error: incompatible types: Book cannot be converted to Giraffe

        // GenericList holds Objects, like StackWithoutGenerics.
        GenericList genericList = new GenericList();
        Giraffe giraffe = new Giraffe();
        genericList.add(giraffe);
        Giraffe first = (Giraffe) genericList.get(0);       // get gives back an Object
        System.out.println();
        System.out.println("GenericList, a giraffe added and element 0 read back:");
        System.out.println("  the same giraffe back: " + (first == giraffe));

        // This line compiles and then stops the program. Uncomment it, run,
        // and comment it out again.
        // Book book = (Book) genericList.get(0);
        // Exception in thread "main" java.lang.ClassCastException:
        // class session7.B_Generics.Giraffe cannot be cast to class session7.B_Generics.Book

        // --- EXERCISE B --------------------------------------------------
        // GenericList gets a type parameter. See EXERCISES.md.
    }
}
