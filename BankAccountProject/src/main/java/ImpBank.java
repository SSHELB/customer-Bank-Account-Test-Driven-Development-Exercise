import java.util.ArrayList;
import java.util.List;

public class ImpBank implements Bank{
    private List<Account> _accountlists;

    public ImpBank() {
        this._accountlists = new ArrayList<Account>();
    }

    public  Account getAccount(int destinationKontonr) {
        return this._accountlists.get(destinationKontonr);
    }
}
