class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int duration;

    FixedDepositAccount(String accountNumber, double balance, int duration) {
        super(accountNumber, balance);
        this.duration = duration;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit");
        System.out.println("Duration: " + duration + " months");
    }
}

public class AccountTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("S101", 5000, 3.5);
        CheckingAccount ca = new CheckingAccount("C101", 3000, 1000);
        FixedDepositAccount fda = new FixedDepositAccount("F101", 10000, 12);

        sa.displayBalance();
        sa.displayAccountType();

        System.out.println();

        ca.displayBalance();
        ca.displayAccountType();

        System.out.println();

        fda.displayBalance();
        fda.displayAccountType();
    }
}
