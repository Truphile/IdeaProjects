import java.util.ArrayList;
import java.util.List;

public class BankApp {

    private final List<Account> accounts = new ArrayList<>();
    private int AccountNumbers;


    public int createAccount(String name, String password) {
        Account account = new Account(name, password,AccountNumbers++);
        accounts.add(account);
        return account.getAccountNumber();

    }

    public int checkBalance(int accNo, String password) {
        Account account = accounts.get(accNo);
        return account.getBalance(password);
    }

    public void deposit(int accNo, int amount) {
        Account account = findAccount(accNo);
        account.deposit(amount);
    }

    private Account findAccount(int accNo) {
        return accounts.get(accNo);
    }

    public void withdraw(int acc, int amount, String password) {
        Account account = findAccount(acc);
        account.withdraw(amount, password);
    }

    public void transfer(int accA, int accB, int amount, String password) {
        Account sender = findAccount(accA);
        Account reciever = findAccount(accB);
        sender.withdraw(amount, password);
        reciever.deposit(amount);
    }



}

