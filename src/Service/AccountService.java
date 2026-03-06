package Service;

import Model.Account;
import Model.Transaction;
import Model.enums.AccountType;
import Model.exceptions.InsufficientFundsException;

import java.util.List;

public interface AccountService {
    // CRUD
    // 1 - create
    String createAccount(Account account) throws InsufficientFundsException;
    // 2 - read
    Account getAccountById(Long id) throws InsufficientFundsException;
    // 3 - update
    List<Account> getAccountByType(AccountType accountType) throws InsufficientFundsException;
    // 4 - delete
    String deposit(Long id, double amount) throws InsufficientFundsException;
    // 5 - read
    String withdraw(Long id, double amount) throws InsufficientFundsException;
    String deleteAccountById(Long id) throws InsufficientFundsException;
    List<Transaction> getTransactionsHistory(Long id) throws InsufficientFundsException;
    double getTotalBalance(Long id) throws InsufficientFundsException;
}
