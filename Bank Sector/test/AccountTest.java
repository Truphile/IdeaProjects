import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AccountTest {

    Account account;

    @Before
    public void setUp(){

        account = new Account("sande","correct password",1);
    }

    @Test
    public void testNewAccountCreated_HasZeroBalance(){
        assertEquals(0, account.getBalance("correct password"));
    }

    @Test
    public void testIcanDeposit500_AndBalanceIs500(){
        account.deposit(500);
        assertEquals(500, account.getBalance("correct password"));

    }

    @Test
    public void testICannotDepositNegativeAmount(){
        assertThrows(NegativeDepositException.class, () -> account.deposit(-500));
    }


    @Test
    public void testIcanDeposit500_AndWithdraw300_Balanceis200(){
        account.deposit(500);
        assertEquals(500, account.getBalance("correct password"));

        account.withdraw(300, "correct password");
        assertEquals(200, account.getBalance("correct password"));
    }

    @Test
    public void testICannotWithdrawNegativeAmount(){
        assertThrows(NegativeWithdrawException.class, () -> account.withdraw(-500,"correct password"));
    }

    @Test
    public void testIcanWithdraw500_AndBalanceis0(){
        account.deposit(500);
        assertEquals(500, account.getBalance("correct password"));

        account.withdraw(500,"correct password");
        assertEquals(0, account.getBalance("correct password"));
    }

    @Test
    public void testWithdrawWithWrongPassword_ThrowsException(){
        account.deposit(500);
        assertThrows(IncorrectPasswordException.class, () -> account.withdraw( 100, "wrong password"));
    }

    @Test
    public void testWithdrawMoreThanBalance_ThrowsException() {
        account.deposit(100);
        assertThrows(ExcessWithdrawException.class, () -> account.withdraw(200, "correct password"));
    }

    @Test
    public void testCheckBalanceWithWrongPassword_ThrowsException() {
        account.deposit(200);

        assertThrows(IncorrectPasswordException.class, () -> account.getBalance("wrong password"));
    }

    @Test
    public void testAccountNumberIsCorrect() {
        assertEquals(1, account.getAccountNumber());
    }



    

















}
