package session7.A_ObjectMethods;

/**
 * A person with a first name, a last name, an age and, if there is one, a
 * middle name. This is the class of exercise A. It has the fields and the
 * constructors, and none of the methods that President overrides.
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
}
