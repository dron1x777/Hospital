package DataBase;

import Model.Account;
import Model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Account> Accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(List<Account> accounts) {
        Accounts = accounts;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "Accounts=" + Accounts +
                '}';
    }
}
