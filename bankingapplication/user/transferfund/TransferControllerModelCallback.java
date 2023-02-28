package console.bankingapplication.user.transferfund;

public interface TransferControllerModelCallback {
    void transferAccFound(String name, int accNo);

    void transferAccNotFound();

    void amountSuccessfullySend(long amount, int accNo);

    void inSufficientFunds();
}
