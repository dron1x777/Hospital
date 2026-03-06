package dao.daoImple;

import DataBase.DataBase;
import Model.Account;
import Model.Transaction;
import Model.enums.AccountType;
import Model.enums.TransactionType;
import Model.exceptions.InsufficientFundsException;
import dao.AccountDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private DataBase db;

    public AccountDaoImpl(DataBase dataBase) {
        this.db = dataBase;
    }


    @Override
    public String createAccount(Account account) {
        db.getAccounts().add(account);
        return "";
    }

    @Override
    public Account getAccountById(Long id) {
        for (Account account : db.getAccounts()) {
            if (account.getID() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public List<Account> getAccountByType(AccountType accountType) {
        List<Account> accounts = new ArrayList<>();
        for (Account account : db.getAccounts()) {
            if (account.getAccountType().equals(accountType)) {
                accounts.add(account);
            }
        }
        return accounts;
    }

    @Override
    public String deposit(Long id, double amount) {
        for (Account account : db.getAccounts()) {
            if (account.getID() == id) {
                account.getTransactions().add(new Transaction(TransactionType.DEPOSIT, amount));
                account.setBalance(account.deposit(amount));
            }
        }
        return "";
    }

    @Override
    public String withdraw(Long id, double amount){
        for (Account account : db.getAccounts()) {
            if (account.getID() == id) {
                account.getTransactions().add(new Transaction(TransactionType.WITHDRAW, amount));
                account.setBalance(account.withdraw(amount));
            }
        }
        return "";
    }

    @Override
    public String deleteAccountById(Long id) {
        Iterator<Account> iterator = db.getAccounts().iterator();

        while (iterator.hasNext()) {
            Account account = iterator.next();

            if (account.getID() == id) {
                iterator.remove();
            }
        }
        return "";
    }

    @Override
    public List<Transaction> getTransactionsHistory(Long id) {
        for (Account account : db.getAccounts()) {
            if (account.getID() == id) {
                return account.getTransactions();
            }
        }
        return null;
    }

    @Override
    public double getTotalBalance(Long id) {
        for (Account account : db.getAccounts()) {
            if (account.getID() == id) {
                System.out.println(account.getBalance());
                return 0;
            }
        }
        return 0;
    }
}
