
import Model.Account;
import Model.enums.AccountType;
import Model.exceptions.InsufficientFundsException;
import Service.ServiceImpl.AccountServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        Scanner sc = new Scanner(System.in);
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        String name = "";
        AccountType  accountType = null;
        long ID = 0;
        double amount = 0;
        int choose2 = 0;
        while (true) {
            menu();
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter owner name: ");
                    name = sc.next();
                    System.out.println("Enter account type (1 - Savings, 2 - Checking, 3 - Credit): ");
                    choose2 = sc.nextInt();
                    if (choose2 == 1) {
                        accountType = AccountType.SAVINGS;
                    }
                    if (choose2 == 2) {
                        accountType = AccountType.CHECKING;
                    }
                    if (choose2 == 3) {
                        accountType = AccountType.CREDIT;
                    }
                    try {
                        accountServiceImpl.createAccount(new Account(name,accountType));
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter owner ID: ");
                    ID = sc.nextLong();
                    try {
                        System.out.println(accountServiceImpl.getAccountById(ID));
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter account type (1 - Savings, 2 - Checking, 3 - Credit): ");
                    choose2 = sc.nextInt();
                    if (choose2 == 1) {
                        accountType = AccountType.SAVINGS;
                    } else if (choose2 == 2) {
                        accountType = AccountType.CHECKING;
                    } else if (choose2 == 3) {
                        accountType = AccountType.CREDIT;
                    } else {
                        System.out.println("Wrong account type");
                        break;
                    }
                    try {
                        System.out.println(accountServiceImpl.getAccountByType(accountType));
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter account ID: ");
                    ID = sc.nextLong();
                    System.out.println("Enter amount: ");
                    amount = sc.nextDouble();
                    try {
                        accountServiceImpl.deposit(ID, amount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter account ID: ");
                    ID = sc.nextLong();
                    System.out.println("Enter amount: ");
                    amount = sc.nextDouble();
                    try {
                        accountServiceImpl.withdraw(ID, amount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Enter account ID: ");
                    ID = sc.nextLong();
                    try {
                        accountServiceImpl.deleteAccountById(ID);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Enter ID: ");
                    ID = sc.nextLong();
                    try {
                        System.out.println(accountServiceImpl.getTransactionsHistory(ID));
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter ID: ");
                    ID = sc.nextLong();
                    try {
                        accountServiceImpl.getTotalBalance(ID);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case 9:
                        System.out.println("End");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                        break;

            }
        }
    }
    static void menu() {
        System.out.println("""
                Welcome ACCOUNT management!
                1. Create account
                2. Get account by ID
                3. Get account by type
                4. Deposit
                5. Withdraw
                6. Delete account by ID
                7. Get transactions history
                8. Get total balance
                9. EXIT
                """);
    }
}