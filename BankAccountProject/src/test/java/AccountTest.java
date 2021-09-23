import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    void Test_Get_Balance_Expected_Empty()
    {
        Account enKonto = new Account(1,new ImpFakeBank());
        Money amount =  enKonto.getBalance();
        Money Expected = new Money();
        assertEquals(Expected.value(),amount.value());
    }
    @Test
    void Test_Get_Balance_Expected_Value_is_10()
    {
        Account enKonto = new Account(1,new ImpFakeBank());
        Money amount =  enKonto.getBalance();
        enKonto.insertMoney(10.0);
        Money expected = new Money();
        expected.SetValue(10.0);
        assertEquals(expected.value(),amount.value());
    }
    @Test
    void Test_Get_Balance_Expected_Value_is_20_When_Twice_10_Deposited()
    {
        Account enKonto = new Account(1,new ImpFakeBank());
        Money amount =  enKonto.getBalance();
        enKonto.insertMoney(10.0);
        enKonto.insertMoney(10.0);
        Money expected = new Money();
        expected.SetValue(20.0);
        assertEquals(expected.value(),amount.value());
    }
    @Test
    void Test_Transfer_1_Money_To_Other_Account()
    {
        Account SenderKonto = new Account(1,new ImpFakeBank());
        Account destinationKonto = new Account(2,new ImpFakeBank());

        SenderKonto.transfer(1.0,destinationKonto);

        assertEquals(SenderKonto.getBalance().value(),-1.0);
        assertEquals(destinationKonto.getBalance().value(),1.0);

    }
    @Test
    void Test_Transfer_1_Money_To_Other_Accountnumber() {
        //Fordi jeg har introduceret Bank i Account Konstruktoren
        //så vil alle mine test skabe sig når jeg opretter en Account. Det har jeg rettet ovenover.
        //Man kan diskutere om der er en bedre måde at implementere denne test
        //da jeg lige har gjort alle ældre test mindre igennemskuelige med denne metode at issolere på.
        //en lille udfordring til jer kunne være at finde en bedre måde at lave denne test på
        //Det ved jeg kan lade sig gøre men jeg har som sagt i klassen brugt minimal tid på dette
        //Da TDD jo kræver Rød, Grøn Refactor skal man ikke Glemme at Refactor også gælder for testne.
        Bank aBank = new ImpFakeBank();
        Account SenderKonto = aBank.getAccount(1);
        int destinationKontonr = 0;
        Account destinationKonto = aBank.getAccount(destinationKontonr);
        SenderKonto.transfer(1.0,destinationKontonr);

        assertEquals(-1.0,SenderKonto.getBalance().value());
        assertEquals(1.0,destinationKonto.getBalance().value());
    }
}
