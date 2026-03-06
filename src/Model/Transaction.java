package Model;

import Model.enums.AccountType;
import Model.enums.TransactionType;

import java.time.LocalDate;
import java.util.Arrays;

public class Transaction {
    private TransactionType transactionType;
    private double amount;
    private LocalDate date;

    public Transaction(TransactionType transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", transactionType=" + transactionType +
                ", date=" + date +
                '}';
    }
}