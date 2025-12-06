import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BankTest {

    @Test
    public void testCreateAccount_AccountStartsWithZeroBalance() {
        BankApp bank = new BankApp();
        int accNo = bank.createAccount("babe", "pass");

        assertEquals(0, bank.checkBalance(accNo, "pass"));
    }

    @Test
    public void testDeposit500_AccountBalanceIs500() {
        BankApp bank = new BankApp();
        int accNo = bank.createAccount("babe", "pass");

        bank.deposit(accNo, 500);
        assertEquals(500, bank.checkBalance(accNo, "pass"));
    }

    @Test
    public void testDeposit500_Withdraw300_BalanceIs200() {
        BankApp bank = new BankApp();
        int acc = bank.createAccount("babe", "pass");

        bank.deposit(acc, 500);
        bank.withdraw(acc, 300, "pass");

        assertEquals(200, bank.checkBalance(acc, "pass"));
    }

    @Test
    public void testNewAccountCreatedInBankA_and_BankB_Deposit5hInA_transfer2hToB_BalanceInA3h_BalanceInB2h() {
        BankApp bank = new BankApp();

        int accA = bank.createAccount("Nelson", "pass");
        int accB = bank.createAccount("Eniife", "pass2");

        bank.deposit(accA, 500);
        bank.transfer(accA, accB, 200, "pass");

        assertEquals(300, bank.checkBalance(accA, "pass"));
        assertEquals(200, bank.checkBalance(accB, "pass2"));
    }

    @Test
    public void testDepositNegativeAmount_ThrowsException() {
        BankApp bank = new BankApp();
        int acc1 = bank.createAccount("babe", "pass");

        assertThrows(NegativeDepositException.class, () -> bank.deposit(acc1,-100));
    }

    @Test
    public void testWithdrawNegativeAmount_ThrowsException() {
        BankApp bank = new BankApp();
        int acc = bank.createAccount("babe", "pass");
        assertThrows(NegativeWithdrawException.class, () -> bank.withdraw(acc, -20, "pass"));
    }

    @Test
    public void testTransferWrongPassword_ThrowsException() {
        BankApp bank = new BankApp();
        int acc1 = bank.createAccount("Alice", "pass4");
        int acc2 = bank.createAccount("Bob", "pass5");

        bank.deposit(acc1, 400);
        assertThrows(IncorrectPasswordException.class, () -> bank.transfer(acc1, acc2, 100, "wrong"));
    }





}
