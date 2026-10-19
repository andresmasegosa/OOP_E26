package session7.C_List;

/**
 * A person with a name and an age. Demo.main keeps three of them in a List.
 *
 * It overrides toString, as Person does in A_ObjectMethods, so a person
 * prints as the name and then the age, Anders, 23. Person has no order of
 * its own. The order of two people goes in a class of its own, a
 * Comparator<Person>.
 */
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}
