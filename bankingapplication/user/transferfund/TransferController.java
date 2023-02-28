package console.bankingapplication.user.transferfund;

import console.bankingapplication.dto.Account;

public class TransferController implements TransferControllerViewCallback,TransferControllerModelCallback{

    private TransferviewCallback transferView;
    private TransferModelCallback transferModel;


    public TransferController(TransferView transferView) {
        this.transferView=transferView;
        this.transferModel=new TransferModel(this);

    }

    @Override
    public void checkTransferAccount(int accNo) {
        transferModel.checkTransferAccount( accNo);
    }

    @Override
    public void checkAmount(long amount, int accNo, Account account) {
        transferModel.checkAmount(amount,accNo,account);
    }

    @Override
    public void transferAccFound(String name, int accNo) {
        transferView.transferAccFound(name, accNo);
    }

    @Override
    public void transferAccNotFound() {
        transferView.transferAccNotFound();
    }

    @Override
    public void amountSuccessfullySend(long amount, int accNo) {
        transferView.amountSuccessfullySend(amount,accNo);
    }

    @Override
    public void inSufficientFunds() {
        transferView.inSufficientFunds();
    }
}
