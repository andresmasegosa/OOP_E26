# Session 7 — Exercise D, equal cards in a set and in a map

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print. Predict the
   sizes and the values, not the order in which a `HashSet` prints.
2. Write `Card.equals` and `Card.hashCode`, as in `President.java`, so that two cards with the same
   name are equal. Then, under the `EXERCISE D` comment in `Demo.main`, count the cards of `hand`
   in a `Map<Card, Integer>`. Print how many times the Ace of Hearts appears.

   You are done when part 3 prints `Cards in the set: 4` and the demo prints 3 for the Ace of
   Hearts.

## Tips

- `Map.getOrDefault(card, 0)` answers `0` for a card that is not in the map yet.
- `Map.put` with a key that is already in the map replaces its value.

## Discussion

1. Comment out `Card.hashCode`, with its `@Override`, and run again. What changes, and why?
