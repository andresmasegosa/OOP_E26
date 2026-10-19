package session7.C_List;

import java.util.Comparator;

/**
 * The alphabetical order of Strings, as an object.
 *
 * Collections.sort(list) already puts Strings in their own order, letter by
 * letter. A class such as Person has no order of its own, so to sort people
 * Collections.sort has to be told which of two elements goes first. An
 * object whose class implements Comparator tells it. Comparator has one
 * method, compare, and Collections.sort calls it with two elements at a time.
 *
 * This class gives the order Strings already have, written as a
 * Comparator<String> so that you can read how one is built. Both parameters
 * of compare are then Strings. compare answers a negative number when o1
 * goes first, a positive number when o2 goes first, and zero when neither
 * does. String.compareTo already answers that way, so compare passes its
 * answer on. (Chapter 8, "Implementing Interfaces".)
 */
public class StringAlphabeticalOrder implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
