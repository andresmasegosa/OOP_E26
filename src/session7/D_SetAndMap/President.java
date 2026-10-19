package session7.D_SetAndMap;

import java.util.Objects;

/**
 * A president, known by his name, the same class as in A_ObjectMethods. Part 2
 * of the demo uses presidents as the keys of a map, with the year each one was
 * born as the value.
 *
 * Two presidents are equal when they have the same name, so equals compares
 * the names and hashCode is built from the name. toString answers the name.
 * (Chapter 7, "The Object Class".)
 */
public class President {

    private String name;

    public President(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Two presidents are equal when they have the same name. The parameter is
     * an Object, as in the equals every class inherits, so any object can be
     * passed in. getClass() answers the class an object was built from. The
     * cast to President comes only after that check.
     * (Chapter 7, "Superclass References and Subclass Objects".)
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;              // one object, compared with itself
        }
        if (other == null || getClass() != other.getClass()) {
            return false;             // nothing at all, or not a President
        }
        President that = (President) other;
        return Objects.equals(name, that.name);
    }

    /** A number built from the name, the field that equals compares. */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /** The name, so that a president prints as Barack Obama. */
    @Override
    public String toString() {
        return name;
    }
}
