public class Account {
    private Money _balance;
    private Bank _objBank;
    public Account(int destinationKontonr,Bank objBank) {
        this._balance = new Money();
        this._objBank  = objBank;
    }

    public Money getBalance() {
        return _balance;
    }

    public void insertMoney(double v) {
        double oldBalance = _balance.value();
        oldBalance += v;
        _balance.SetValue(oldBalance);
    }

    public void transfer(double v, Account destinationKonto) {
        insertMoney(-v);
        destinationKonto.insertMoney(v);
    }

    public void transfer(double v, int destinationKontonr) {
        Account destinationKonto = this._objBank.getAccount(destinationKontonr);
        insertMoney(-v);
        destinationKonto.insertMoney(v);
    }
}
