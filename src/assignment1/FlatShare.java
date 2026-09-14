package assignment1;

/**
 * Assignment 1 — The flat share, the program you start from.
 *
 * This program keeps the accounts of a shared flat, and it has no objects at
 * all. Like the chess game of session 1, it is made of variables, arrays,
 * if/else, switch, loops and static methods. It runs, and main tells one
 * month of the flat.
 *
 * THE FLATMATES
 *   A flatmate is one position in three parallel arrays. The flatmate in
 *   position 2 has the name names[2], a room of roomSizes[2] square meters
 *   and the balance balances[2]. Only the first flatmateCount positions are
 *   in use.
 *
 * THE BALANCES
 *   A balance is in whole kroner. A positive balance means the others owe
 *   that flatmate money, and a negative balance means that flatmate owes the
 *   others. Money only moves between flatmates, so the balances of everybody
 *   in the flat always add up to 0.
 *
 * THE EXPENSES
 *   When a flatmate pays for something, addExpense records it in the history
 *   arrays and changes the balances. Each kind of expense has a letter.
 *     'E'  split equally between everybody who lives in the flat
 *     'P'  for one flatmate, who owes the whole amount
 *     'R'  the rent, split by the size of each room
 *   The program does not know how to split the rent yet. The rent is
 *   recorded, and nothing happens to the balances.
 *
 * EDGE CASES ARE LEFT OUT ON PURPOSE
 *   To keep the code short, the program does not check for things that never
 *   happen in this month, such as a name that does not exist, a negative
 *   amount, more flatmates than the arrays can hold, or an amount that does
 *   not divide exactly. Your own version does not have to check for them
 *   either.
 */
public class FlatShare {

    // The flatmates, one position per person.
    static String[] names = new String[6];
    static int[] roomSizes = new int[6];     // square meters
    static int[] balances = new int[6];      // kroner
    static int flatmateCount = 0;

    // The history, one position per expense, in the order they were paid.
    static char[] expenseTypes = new char[20];
    static int[] expensePayers = new int[20];     // the position of the payer in names
    static int[] expenseAmounts = new int[20];    // kroner
    static String[] expenseDescriptions = new String[20];
    static int expenseCount = 0;

    public static void main(String[] args) {
        System.out.println("September in the flat");

        moveIn("Freja", 14);
        moveIn("Ali", 12);
        moveIn("Mathilde", 10);
        moveIn("Jonas", 14);

        addExpense('R', "Freja", 10000, "Rent", null);
        addExpense('E', "Mathilde", 480, "Groceries", null);
        addExpense('E', "Jonas", 320, "Internet", null);
        addExpense('P', "Ali", 450, "Concert ticket for Jonas", "Jonas");

        // Mathilde pays Freja back and moves out. Sofie moves into the free room.
        addExpense('P', "Mathilde", 1720, "Paying Freja back", "Freja");
        moveOut("Mathilde");
        moveIn("Sofie", 10);
        addExpense('E', "Sofie", 200, "Cleaning supplies", null);

        // Jonas wants to move out too, and still owes money.
        moveOut("Jonas");

        printBalances();
        printHistory();

        // --- The sabotage ------------------------------------------------
        // Uncomment the two lines below and run again. Freja gets 500 kr out
        // of nowhere, and the total moves by the same 500 kr. Nothing stops
        // the first line, because any code in the program can write any balance.
        //
        // balances[0] = balances[0] + 500;
        // printBalances();
    }

    /** A new flatmate moves in, with a balance of 0. */
    static void moveIn(String name, int roomSize) {
        names[flatmateCount] = name;
        roomSizes[flatmateCount] = roomSize;
        balances[flatmateCount] = 0;
        flatmateCount++;
        System.out.println(name + " moves in (" + roomSize + " m2)");
    }

    /**
     * A flatmate moves out. The last flatmate in the arrays moves into the
     * position that is left free, so that there are no gaps.
     */
    static void moveOut(String name) {
        int position = findFlatmate(name);
        int last = flatmateCount - 1;
        names[position] = names[last];
        roomSizes[position] = roomSizes[last];
        balances[position] = balances[last];
        flatmateCount--;
        System.out.println(name + " moves out");
    }

    /** The position of the flatmate with this name, or -1 if there is none. */
    static int findFlatmate(String name) {
        for (int i = 0; i < flatmateCount; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * A flatmate paid for something. The expense goes into the history, and
     * then the balances change. The balance of the payer goes up by the whole
     * amount, and the balance of everyone who shares the expense goes down by
     * their part. How the parts are worked out depends on the kind of expense.
     * forWhom is only used by the kind 'P', and the other kinds pass null.
     */
    static void addExpense(char type, String payerName, int amount, String description, String forWhom) {
        int payer = findFlatmate(payerName);

        expenseTypes[expenseCount] = type;
        expensePayers[expenseCount] = payer;
        expenseAmounts[expenseCount] = amount;
        expenseDescriptions[expenseCount] = description;
        expenseCount++;
        System.out.println(expenseLine(expenseCount - 1));

        switch (type) {
            case 'E':
                splitEqually(payer, amount);
                break;
            case 'P':
                chargeOneFlatmate(payer, findFlatmate(forWhom), amount);
                break;
            default:
                // A kind of expense nobody has taught this program to split.
                // The rent, 'R', ends up here. See README.md.
                break;
        }
    }

    /** Everybody in the flat pays the same part, the payer included. */
    static void splitEqually(int payer, int amount) {
        balances[payer] = balances[payer] + amount;
        int part = amount / flatmateCount;
        for (int i = 0; i < flatmateCount; i++) {
            balances[i] = balances[i] - part;
        }
    }

    /** One flatmate owes the whole amount to the payer. */
    static void chargeOneFlatmate(int payer, int flatmate, int amount) {
        balances[payer] = balances[payer] + amount;
        balances[flatmate] = balances[flatmate] - amount;
    }

    /** How an expense of this kind is split, for the printed lines. */
    static String typeName(char type) {
        switch (type) {
            case 'E':
                return "split equally";
            case 'P':
                return "for one flatmate";
            default:
                return "?";
        }
    }

    /** One expense of the history as a line of text. */
    static String expenseLine(int expense) {
        return names[expensePayers[expense]] + " paid " + expenseAmounts[expense] + " kr: "
                + expenseDescriptions[expense] + " (" + typeName(expenseTypes[expense]) + ")";
    }

    /** The balance of every flatmate, and the total. */
    static void printBalances() {
        System.out.println();
        System.out.println("Balances (+ the others owe you money, - you owe the others)");
        int total = 0;
        for (int i = 0; i < flatmateCount; i++) {
            System.out.println("  " + names[i] + ": " + balances[i] + " kr");
            total = total + balances[i];
        }
        System.out.println("  Total: " + total + " kr (always 0 when the accounts are right)");
    }

    /** Every expense of the month, in the order they were paid. */
    static void printHistory() {
        System.out.println();
        System.out.println("History");
        for (int i = 0; i < expenseCount; i++) {
            System.out.println("  " + expenseLine(i));
        }
    }
}
