import java.util.ArrayList;
import java.util.List;

public class ImpFakeBank implements Bank{
    private List<Account> _accountlists;
    public ImpFakeBank()
    {
        this._accountlists = new ArrayList<>();
        this._accountlists.add(new Account(1,this));
        this._accountlists.add(new Account(0,this));
    }
    @Override
    public Account getAccount(int Kontonr) {
        return this._accountlists.get(Kontonr);
    }
}
