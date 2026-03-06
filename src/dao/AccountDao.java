package dao;

import Model.Account;
import Model.Transaction;
import Model.enums.AccountType;
import Model.exceptions.InsufficientFundsException;

import java.util.List;

public interface AccountDao {
    // CRUD
    // 1 - create
    String createAccount(Account account);
    // 2 - read
    Account getAccountById(Long id);
    // 3 - update
    List<Account> getAccountByType(AccountType accountType);
    // 4 - delete
    String deposit(Long id, double amount);
    // 5 - read
    String withdraw(Long id, double amount);
    String deleteAccountById(Long id);
    List<Transaction> getTransactionsHistory(Long id);
    double getTotalBalance(Long id);
}
