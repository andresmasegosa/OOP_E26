package session7.solution.A_ObjectMethods;

import java.util.Objects;

/**
 * A person with a first name, a last name, an age and, if there is one, a
 * middle name. This is the class of exercise A. It came with the fields and
 * the constructors, and exercise A gave it the three methods that President
 * overrides.
 *
 * A person built with the three-argument constructor keeps the empty
 * string "" in middleName, not null.
 */
public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    /** A person without a middle name. */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = "";
        this.age = age;
    }

    /** A person with a middle name. */
    public Person(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Exercise A. Two people are equal when they have the same first name,
     * the same last name and the same age. The middle name does not count, so
     * Anders Madsen and Anders M Madsen, both 48, are equal.
     *
     * The shape is President.equals with three fields instead of one. The
     * names are Strings, so they go through Objects.equals, and the age is an
     * int, so it is compared with ==. The parameter is an Object, because
     * with a Person parameter this would be a second method next to the
     * inherited one, and @Override would not compile.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Person that = (Person) other;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && age == that.age;
    }

    /**
     * Exercise A. Built from exactly the fields that equals compares, and
     * never from the middle name, so that two equal people give the same
     * number. That is the discussion question of exercise A.
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    /**
     * Exercise A. The name and then the age, as "Anders Madsen, 48". The
     * middle name goes in only when there is one, so a person without it
     * prints with no double space.
     */
    @Override
    public String toString() {
        if (middleName.isEmpty()) {
            return firstName + " " + lastName + ", " + age;
        }
        return firstName + " " + middleName + " " + lastName + ", " + age;
    }
}
