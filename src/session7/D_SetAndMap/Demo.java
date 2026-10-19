package session7.D_SetAndMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Step D. A Set keeps one copy of each element. A Map keeps a value for each
 * key, and finds the value by its key.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("Part 1, a Set<String>");
        Set<String> cardNames = new HashSet<>();
        cardNames.add("Ace of Hearts");
        cardNames.add("Ace of Hearts");
        cardNames.add("Queen of Spades");
        cardNames.add("Queen of Spades");
        cardNames.add("Ten of Hearts");
        cardNames.add("Two of Clubs");
        cardNames.remove("Ten of Hearts");
        System.out.println("Cards in the set: " + cardNames.size());
        for (String name : cardNames) {                 // a HashSet has an order of its own
            System.out.println("  " + name);
        }

        System.out.println();
        System.out.println("Part 2, a Map<President, Integer>");
        // The keys are Presidents. The values are Integers, an int as an object.
        Map<President, Integer> birthYear = new HashMap<>();
        birthYear.put(new President("George Washington"), 1732);
        birthYear.put(new President("Abraham Lincoln"), 1809);
        birthYear.put(new President("Barack Obama"), 1961);
        Integer obamaYear = birthYear.get(new President("Barack Obama"));   // a new President
        System.out.println("Mr. Obama was born in: " + obamaYear);

        System.out.println();
        System.out.println("Part 3, a Set<Card>");
        Set<Card> cards = new HashSet<>();
        cards.add(new Card("Ace of Hearts"));
        cards.add(new Card("Ace of Hearts"));
        cards.add(new Card("Queen of Spades"));
        cards.add(new Card("Queen of Spades"));
        cards.add(new Card("Ten of Hearts"));
        cards.add(new Card("Two of Clubs"));
        System.out.println("Cards in the set: " + cards.size());

        System.out.println();
        System.out.println("Part 4, a List<Card>");
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("Ace of Hearts"));
        hand.add(new Card("Queen of Spades"));
        hand.add(new Card("Ace of Hearts"));
        hand.add(new Card("Ten of Hearts"));
        hand.add(new Card("Ace of Hearts"));
        hand.add(new Card("Two of Clubs"));
        hand.add(new Card("Queen of Spades"));
        System.out.println("Cards in the hand: " + hand.size());
        System.out.println("The hand: " + hand);        // a List prints as [a, b, c]

        // This line does not compile. Uncomment it and compile.
        // Card first = cards.get(0);
        // error: cannot find symbol
        //   symbol:   method get(int)

        // --- EXERCISE D --------------------------------------------------
        // Card gets equals and hashCode. Then count the hand here, in a
        // Map<Card, Integer>. See EXERCISES.md.
    }
}
