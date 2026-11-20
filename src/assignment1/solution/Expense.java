package assignment1.solution;

/**
 * One payment a flatmate made for the flat, and how it is split.
 *
 * The payer is a reference to a Flatmate object, not a position in an array.
 * When somebody moves out and the flat reorders its array, the expense still
 * points at the person who paid.
 */
public class Expense {

    private String type;          // "Equal", "Rent" or "One flatmate"
    private Flatmate payer;
    private int amount;           // kroner
    private String description;
    private Flatmate forWhom;     // only used by "One flatmate", null for the other types

    /** An expense shared by the whole flat, of type "Equal" or "Rent". */
    public Expense(String type, Flatmate payer, int amount, String description) {
        this(type, payer, amount, description, null);
    }

    /** An expense with every field. forWhom is only used by "One flatmate". */
    public Expense(String type, Flatmate payer, int amount, String description, Flatmate forWhom) {
        this.type = type;
        this.payer = payer;
        this.amount = amount;
        this.description = description;
        this.forWhom = forWhom;
    }

    public String getType() {
        return type;
    }

    public Flatmate getPayer() {
        return payer;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Flatmate getForWhom() {
        return forWhom;
    }

    /** How this expense is split, for the printed lines. */
    public String describeSplit() {
        switch (type) {
            case "Equal":
                return "split equally";
            case "Rent":
                return "split by room size";
            case "One flatmate":
                return "for one flatmate";
            default:
                return "?";
        }
    }

    /** This expense as one line of text. */
    public String getLine() {
        return payer.getName() + " paid " + amount + " kr: " + description + " (" + describeSplit() + ")";
    }
}
