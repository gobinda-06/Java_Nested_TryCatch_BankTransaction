import java.util.*;

class BankTransaction {
    private int balance;

    // Constructor
    public BankTransaction(int n) {
        this.balance = n;
    }

    // Withdraw method with nested try-catch
    public void withdraw(int amount) {
        try {
            System.out.println("Transaction started...");

            try {
                if (amount <= 0) {
                    throw new ArithmeticException("Invalid amount entered: " + amount);
                }

                if (amount > balance) {
                    throw new Exception("Insufficient Balance! Your current balance: ₹" + balance);
                }

                balance -= amount;
                System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
            } 
            catch (ArithmeticException e) {
                System.out.println("Inner Catch: " + e.getMessage());
            }

        } 
        catch (Exception e) {
            System.out.println("Outer Catch: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your initial balance: ");
        int bal = sc.nextInt();

        BankTransaction user = new BankTransaction(bal);

        System.out.print("Enter withdrawal amount: ");
        int amount = sc.nextInt();

        user.withdraw(amount);
        sc.close();
    }
}
