// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getter and Setter methods (Encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    // Constructor
    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.03; // Fixed interest rate for current account
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= (getBalance() + overdraftLimit)) {
            System.out.println("Loan approved for: $" + amount);
        } else {
            System.out.println("Loan request exceeds the overdraft limit.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // Eligible for loan if balance is more than $5000
    }
}

// Main class to test the banking system
public class BankingSystem {
    public static void main(String[] args) {
        // Creating instances of different bank accounts
        BankAccount savingsAccount = new SavingsAccount("SA123", "John Doe", 5000, 4.5);
        BankAccount currentAccount = new CurrentAccount("CA123", "Jane Doe", 3000, 2000);

        // List of accounts (polymorphism)
        BankAccount[] accounts = { savingsAccount, currentAccount };

        // Process each account and calculate interest
        for (BankAccount account : accounts) {
            System.out.println("\nAccount Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());

            // Calculate and display interest
            System.out.println("Interest: $" + account.calculateInterest());
        }

        // Apply loan for CurrentAccount
        CurrentAccount ca = (CurrentAccount) currentAccount;  // Type casting to access loanable methods
        ca.applyForLoan(1500);
        System.out.println("Loan eligibility: " + (ca.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
    }
}
