package session10.solution.B_Observer;

/**
 * One BankStatistics listens to two accounts, and adds up what is deposited
 * in both. Exercise B. A third account has a SkatMonitor too.
 */
public class Demo {

    public static void main(String[] args) {
        BankStatistics bankStatistics = new BankStatistics();

        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.addListener(bankStatistics);
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.addListener(bankStatistics);

        System.out.println("Total Bank Balance: " + bankStatistics.getTotalBankBalance());

        bankAccount1.deposit(1000);
        bankAccount2.deposit(3000);

        System.out.println("Total Bank Balance: " + bankStatistics.getTotalBankBalance());

        // --- EXERCISE B, solved --------------------------------------------
        BankAccount bankAccount3 = new BankAccount();
        bankAccount3.addListener(bankStatistics);
        bankAccount3.addListener(new SkatMonitor());

        bankAccount3.deposit(500_000);
        bankAccount3.deposit(1_500_000);
        bankAccount3.deposit(50_000);

        System.out.println("Total Bank Balance: " + bankStatistics.getTotalBankBalance());
    }
}
