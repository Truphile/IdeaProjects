public class Account {
    private int balance;
    private String name;
    private String password;
    private int accountNumber;


    public Account(String name, String password, int accountNumber) {
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;

    }

    public int getBalance(String correctPassword) {
        validatePassword(correctPassword);
        return balance;
    }

    public void deposit(int amount) {
        validateDeposit(amount);
        amount += balance;
        balance = amount;

    }

    private void validateDeposit(int amount) {
        if (amount < 0) {
            throw new NegativeDepositException("Invalid deposit amount");
        }

    }

    public void withdraw(int amount, String Password) {
        validateWithdraw(amount);
        validatePassword(Password);
        validateBalanceBeforeWithdraw(amount);
        balance = balance - amount;
    }

    private void validateWithdraw(int amount) {
        if (amount < 0) {
            throw new NegativeWithdrawException("Invalid withdrawal amount");
        }
    }

    private void validatePassword(String Password) {
        if (!this.password.equals(Password)) {
            throw new IncorrectPasswordException("wrong password");
        }
    }

    private void validateBalanceBeforeWithdraw(int amount) {
        if (amount > balance) {
            throw new ExcessWithdrawException("Insufficient balance");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}