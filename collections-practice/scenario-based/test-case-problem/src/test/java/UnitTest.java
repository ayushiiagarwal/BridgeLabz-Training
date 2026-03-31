import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {
    @Test
    public void Test_Deposit_ValidAmount(){
        Program account = new Program(1000);
        account.Deposit(1000);
        assertEquals(2000, account.balance);
    }

    @Test
    public void Test_Deposit_NegativeAmount(){
        Program account = new Program(1000);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            account.Deposit(-1000);
        });
        assertEquals("Deposit amount must be more than 0.", exception.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount(){
        Program account = new Program(1000);
        account.Withdraw(500);
        assertEquals(500, account.balance);
    }

    @Test
    public void Test_Withdraw_InsufficientFunds(){
        Program account = new Program(1000);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            account.Withdraw(1500);
        });
        assertEquals("Insufficient Funds!", exception.getMessage());
    }
}
