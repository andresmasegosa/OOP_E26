package assignment1.solution;

/**
 * The flat: who lives in it, what they have paid, and the rules of its accounts.
 *
 * Both arrays are private. No code outside this class can write a balance or
 * an entry of the history, so every change goes through the methods below.
 * That is how this class keeps the balances adding up to 0, and how it stops
 * a flatmate from moving out with a balance that is not 0.
 */
public class Flat {

    private Flatmate[] flatmates = new Flatmate[6];
    private int flatmateCount = 0;

    private Expense[] history = new Expense[20];
    private int expenseCount = 0;

    /** A new flatmate moves in. */
    public void moveIn(Flatmate flatmate) {
        flatmates[flatmateCount] = flatmate;
        flatmateCount++;
        System.out.println(flatmate.getName() + " moves in (" + flatmate.getRoomSize() + " m2)");
    }

    /**
     * A flatmate moves out, but only with a balance of 0. Otherwise that part
     * of the accounts would leave the flat, and the balances of the others
     * would no longer add up to 0. Returns whether the flatmate moved out.
     */
    public boolean moveOut(Flatmate flatmate) {
        if (flatmate.getBalance() != 0) {
            System.out.println(flatmate.getName() + " cannot move out with a balance of "
                    + flatmate.getBalance() + " kr");
            return false;
        }
        int position = positionOf(flatmate);
        flatmates[position] = flatmates[flatmateCount - 1];
        flatmates[flatmateCount - 1] = null;
        flatmateCount--;
        System.out.println(flatmate.getName() + " moves out");
        return true;
    }

    /** The position of this flatmate in the array. == is true only for the same object. */
    private int positionOf(Flatmate flatmate) {
        for (int i = 0; i < flatmateCount; i++) {
            if (flatmates[i] == flatmate) {
                return i;
            }
        }
        return -1;
    }

    /** A flatmate paid for something. The expense goes into the history, and the balances change. */
    public void addExpense(Expense expense) {
        history[expenseCount] = expense;
        expenseCount++;
        System.out.println(expense.getLine());

        switch (expense.getType()) {
            case "Equal":
                splitEqually(expense.getPayer(), expense.getAmount());
                break;
            case "Rent":
                splitByRoomSize(expense.getPayer(), expense.getAmount());
                break;
            case "One flatmate":
                chargeOneFlatmate(expense.getPayer(), expense.getForWhom(), expense.getAmount());
                break;
            default:
                // A type nobody has taught this program to split. As in
                // FlatShare, nothing warns about it.
                break;
        }
    }

    /** Everybody in the flat pays the same part, the payer included. */
    private void splitEqually(Flatmate payer, int amount) {
        payer.changeBalance(amount);
        int part = amount / flatmateCount;
        for (int i = 0; i < flatmateCount; i++) {
            flatmates[i].changeBalance(-part);
        }
    }

    /** Each flatmate pays in proportion to the square meters of their room. */
    private void splitByRoomSize(Flatmate payer, int amount) {
        payer.changeBalance(amount);
        int totalSize = 0;
        for (int i = 0; i < flatmateCount; i++) {
            totalSize = totalSize + flatmates[i].getRoomSize();
        }
        for (int i = 0; i < flatmateCount; i++) {
            flatmates[i].changeBalance(-amount * flatmates[i].getRoomSize() / totalSize);
        }
    }

    /** One flatmate owes the whole amount to the payer. */
    private void chargeOneFlatmate(Flatmate payer, Flatmate forWhom, int amount) {
        payer.changeBalance(amount);
        forWhom.changeBalance(-amount);
    }

    /** The balance of every flatmate, and the total. */
    public void printBalances() {
        System.out.println();
        System.out.println("Balances (+ the others owe you money, - you owe the others)");
        int total = 0;
        for (int i = 0; i < flatmateCount; i++) {
            System.out.println("  " + flatmates[i].getName() + ": " + flatmates[i].getBalance() + " kr");
            total = total + flatmates[i].getBalance();
        }
        System.out.println("  Total: " + total + " kr (always 0 when the accounts are right)");
    }

    /** Every expense of the month, in the order they were paid. */
    public void printHistory() {
        System.out.println();
        System.out.println("History");
        for (int i = 0; i < expenseCount; i++) {
            System.out.println("  " + history[i].getLine());
        }
    }
}
