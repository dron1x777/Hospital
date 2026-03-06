package Service.ServiceImpl;

import DataBase.DataBase;
import Model.Account;
import Model.Transaction;
import Model.enums.AccountType;
import Model.exceptions.InsufficientFundsException;
import Service.AccountService;
import dao.daoImple.AccountDaoImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    DataBase dataBase = new DataBase();
    AccountDaoImpl accountDaoImpl = new AccountDaoImpl(dataBase);

    @Override
    public String createAccount(Account account) throws InsufficientFundsException {
        if (account == null) {
            throw new InsufficientFundsException("Account is null");
        }
        if (account.getOwnerName() == null || account.getOwnerName().isEmpty()) {
            throw new InsufficientFundsException("Account name is null");
        }
        if (account.getAccountType() == null) {
            throw new InsufficientFundsException("Account type is null");
        }
        if (account.getID() == 0) {
            throw new InsufficientFundsException("Account ID is null");
        }
        accountDaoImpl.createAccount(account);
        return "Account created successfully";
    }

    @Override
    public Account getAccountById(Long id) throws InsufficientFundsException {
        if (id == 0) {
            throw new InsufficientFundsException("Account ID is null");
        }
        return accountDaoImpl.getAccountById(id);
    }

    @Override
    public List<Account> getAccountByType(AccountType accountType) throws InsufficientFundsException {
        if (accountType == null) {
            throw new InsufficientFundsException("Account type is null");
        }
        return accountDaoImpl.getAccountByType(accountType);
    }

    @Override
    public String deposit(Long id, double amount) throws InsufficientFundsException {
        if (id == 0) {
            throw new InsufficientFundsException("Account ID is null");
        }
        if (amount <= 0) {
            throw new InsufficientFundsException("Amount is negative");
        }
        accountDaoImpl.deposit(id, amount);
        return "Account deposited successfully";
    }

    @Override
    public String withdraw(Long id, double amount) throws InsufficientFundsException {
        if (id == 0) {
            throw new InsufficientFundsException("Account ID is null");
        }
        if (amount <= 0) {
            throw new InsufficientFundsException("Amount is negative");
        }
        if (amount > accountDaoImpl.getAccountById(id).getBalance()) {
            throw new InsufficientFundsException("Amount is greater than balance");
        }
        accountDaoImpl.withdraw(id, amount);
        return "Account withdraw successfully";
    }

    @Override
    public String deleteAccountById(Long id) throws InsufficientFundsException {
        if (id == 0) {
            throw new InsufficientFundsException("Account ID is null");
        }
        accountDaoImpl.deleteAccountById(id);
        return "Account deleted successfully";
    }

    @Override
    public List<Transaction> getTransactionsHistory(Long id) throws InsufficientFundsException {
        if (id == 0) {
            throw new InsufficientFundsException("Account ID is null");
        }
        return accountDaoImpl.getTransactionsHistory(id);
    }

    @Override
    public double getTotalBalance(Long id) throws InsufficientFundsException {
        if (id == 0) {
            throw new InsufficientFundsException("Account ID is null");
        }
        return accountDaoImpl.getTotalBalance(id);
    }
}
