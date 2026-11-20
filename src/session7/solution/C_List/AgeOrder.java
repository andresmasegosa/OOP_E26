package session7.solution.C_List;

import java.util.Comparator;

/**
 * Exercise C. The order of people by age, youngest first.
 *
 * It is StringAlphabeticalOrder with Person in the angle brackets and another
 * line in compare. The ages are private, so compare asks each person for
 * getAge(), and Integer.compare turns the two ages into the negative number,
 * zero or positive number that compare has to answer. A student who writes
 * o1.getAge() - o2.getAge() has a correct answer for any real age.
 * Integer.compare is the habit worth showing, because a subtraction of two
 * very large or very small ints can overflow and change its sign.
 *
 * Two people of the same age compare as zero, and Collections.sort then
 * leaves them in the order they had in the list.
 */
public class AgeOrder implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
