package Model;

import Model.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private long ID;
    private static long counter;
    private String ownerName;
    private AccountType accountType;
    private List<Transaction> transactions =  new ArrayList<>();
    private double balance;

    public Account(String ownerName, AccountType accountType) {
        this.ownerName = ownerName;
        this.accountType = accountType;
        this.ID = ++counter;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
    public double deposit(double amount) {
        balance = balance + amount;
        return balance;
    }
    public double withdraw(double amount) {
        balance = balance - amount;
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", ID=" + ID +
                ", counter=" + counter +
                ", ownerName='" + ownerName + '\'' +
                ", transactions=" + transactions +
                ", balance=" + balance +
                '}';
    }
}
