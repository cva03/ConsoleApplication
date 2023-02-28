package console.bankingapplication.user.transferfund;

import console.bankingapplication.dto.Account;
import console.bankingapplication.repository.Repository;

public class TransferModel implements TransferModelCallback {

    private TransferControllerModelCallback transferController;
    private Repository data=Repository.getInstance();

    public TransferModel(TransferController transferController) {
        this.transferController=transferController;
    }

    @Override
    public void checkTransferAccount(int accNo) {
        String name=data.checkTransferAcc(accNo);
        if(!name.equals(" ")){
            transferController.transferAccFound(name,accNo);
        }else {
            transferController.transferAccNotFound();
        }
    }

    @Override
    public void checkAmount(long amount, int accNo, Account account) {
        if(data.sendAmount(amount,accNo,account)){
            transferController.amountSuccessfullySend(amount,accNo);
        }else{
            transferController.inSufficientFunds();
        }

    }
}
