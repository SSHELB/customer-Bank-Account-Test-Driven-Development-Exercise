import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    void Test_Get_Value_Expect_0()
    {
        Money amount = new Money();
        assertEquals(amount.value(),0.0);
    }
    @Test
    void Test_Get_Value_Expect_10()
    {
        Money amount = new Money();
        amount.SetValue(10.0);
        assertEquals(amount.value(),10.0);
    }
}
