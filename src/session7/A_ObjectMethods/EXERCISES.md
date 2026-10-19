# Session 7 — Exercise A, a person that prints and compares itself

The exercise is the two numbered steps. The tips are there if you need them.

1. Read `Demo.main` and, before you run it, write down what you expect it to print. For the hash
   codes, predict only whether the two numbers are the same.
2. Write `Person.equals`, `Person.hashCode` and `Person.toString`, each with `@Override`, as in
   `President.java`.
   - Two people are equal when they have the same first name, last name and age. The middle name
     does not count.
   - `Person.hashCode` uses the same fields as `Person.equals`.
   - A person prints as `Anders Madsen, 48`, or as `Anders M Madsen, 48` with a middle name.

   You are done when `Demo` prints the two people that way, then `They are equal` and the same
   hash code twice.

## Tips

- `President.java` uses `Objects.equals` and `Objects.hash`, from `java.util`. You can use them
  too. (Chapter 7, "The Object Class".)
- A person without a middle name has `""` in `middleName`. `middleName.isEmpty()` answers `true`
  for it.

## Discussion

1. What would `Demo` print for the two hash codes if `Person.hashCode` used the middle name too?
