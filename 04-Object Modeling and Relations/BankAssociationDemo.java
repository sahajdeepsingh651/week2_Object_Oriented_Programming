import java.util.*;

class Bank {
    String bankName;
    ArrayList<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialBalance) {
        Account newAccount = new Account(customer, this, initialBalance);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        System.out.println("Account opened for " + customer.name + " in " + bankName);
    }
}

class Customer {
    String name;
    ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Account(s) of " + name + ":");
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.bank.bankName + ", Balance: " + acc.balance);
        }
    }
}

class Account {
    Customer customer;
    Bank bank;
    double balance;

    public Account(Customer customer, Bank bank, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.balance = balance;
    }
}

class BankAssociationDemo {
    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        Bank sbi = new Bank("SBI Bank");

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        hdfc.openAccount(alice, 10000);
        sbi.openAccount(alice, 20000);
        sbi.openAccount(bob, 15000);

        System.out.println();
        alice.viewBalance();
        System.out.println();
        bob.viewBalance();
    }
}
