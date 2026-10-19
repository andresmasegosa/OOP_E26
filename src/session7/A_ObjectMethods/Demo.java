package session7.A_ObjectMethods;

/**
 * Step A. Every class inherits equals, hashCode and toString from Object.
 * The equals of Object answers the same as ==. President overrides the three
 * methods, and Person overrides none of them.
 */
public class Demo {

    public static void main(String[] args) {
        President p1 = new President("Barack Obama");
        President p2 = new President("Barack Obama");

        System.out.println("p1 prints as " + p1);   // + calls toString
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("Hash code of p1: " + p1.hashCode());
        System.out.println("Hash code of p2: " + p2.hashCode());

        Person person1 = new Person("Anders", "Madsen", 48);
        Person person2 = new Person("Anders", "M", "Madsen", 48);

        System.out.println();
        System.out.println("person1 prints as " + person1);
        System.out.println("person2 prints as " + person2);
        if (person1.equals(person2)) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }
        System.out.println("Hash code of person1: " + person1.hashCode());
        System.out.println("Hash code of person2: " + person2.hashCode());

        // --- EXERCISE A --------------------------------------------------
        // Person gets equals, hashCode and toString. See EXERCISES.md.
    }
}
