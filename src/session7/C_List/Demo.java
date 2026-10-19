package session7.C_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Step C. A List keeps objects in order, and it grows and shrinks as you add
 * and remove them. List is an interface, and ArrayList and LinkedList are two
 * classes that implement it. Collections.sort sorts a list in the order that
 * a Comparator gives.
 */
public class Demo {

    public static void main(String[] args) {
        List<String> cards = new ArrayList<>();
        cards.add("Ace of Hearts");
        cards.add("Queen of Spades");
        cards.add("Ten of Hearts");
        cards.add("Ace of Hearts");
        cards.add("Two of Clubs");

        cards.remove(1);

        int index = cards.indexOf("Ten of Hearts");
        System.out.println("Index of Ten of Hearts: " + index);
        System.out.println("The cards, after remove(1):");
        for (String card : cards) {
            System.out.println("  " + card);
        }

        List<String> hand = new ArrayList<>();
        hand.add("Ace of Hearts");
        hand.add("Queen of Spades");
        hand.add("Ten of Hearts");
        hand.add("Ace of Hearts");
        hand.add("Two of Clubs");

        Comparator<String> alphabetical = new StringAlphabeticalOrder();
        Collections.sort(hand, alphabetical);

        System.out.println();
        System.out.println("The same five cards, sorted with a StringAlphabeticalOrder:");
        for (String card : hand) {
            System.out.println("  " + card);
        }

        List<Person> people = new LinkedList<>();
        people.add(new Person("Anders", 23));
        people.add(new Person("Mads", 28));
        people.add(new Person("Jakob", 21));

        // Collections.sort(people, ...);   // exercise C

        System.out.println();
        System.out.println("The people:");
        for (Person person : people) {
            System.out.println("  " + person);
        }

        // This line does not compile. Uncomment it and compile.
        // Comparator<Person> byName = new StringAlphabeticalOrder();
        // error: incompatible types: StringAlphabeticalOrder cannot be converted to Comparator<Person>

        // --- EXERCISE C --------------------------------------------------
        // Write AgeOrder.java, and use it on the sort line above. See EXERCISES.md.
    }
}
