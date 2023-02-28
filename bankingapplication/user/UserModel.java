package console.bankingapplication.user;

import console.bankingapplication.dto.Account;
import console.bankingapplication.dto.MoneyRequest;
import console.bankingapplication.dto.TransactionHistory;
import console.bankingapplication.repository.Repository;

import java.util.List;

public class UserModel implements UserModelCallback{

    private UserControllerModelCallback userController;
    private Repository data=Repository.getInstance();

    public UserModel(UserController userController) {
        this.userController=userController;
    }


    @Override
    public void changePassword(String password, Account account) {
        data.changePassword(password,account);
        userController.passwordChangeSuccessfull(password,account);
    }

    @Override
    public void showTransactions(Account account) {
        List<TransactionHistory> trans=data.getTransactions(account);
        if(trans.size()<1){
            userController.noTransactionsFound();
        }else{
            userController.transactionsfound(trans);
        }

    }

    @Override
    public void getBalance(Account account) {
       long balance= data.getBalance(account);
       userController.showBalance(balance);
    }

    @Override
    public void checkAcc(int accNo) {
       String accName= data.checkTransferAcc(accNo);
        if(!accName.equals(" ")){
            userController.requestAccFound(accName,accNo);
        }else {
            userController.requestAccNotFound();
        }
    }

    @Override
    public void requestMoney(long amount, int accNo, String description, Account account) {
       data.requestMoney(amount,accNo,description,account);
       userController.requestSuccess(amount,accNo);
    }

    @Override
    public void findRequest(Account account) {
        List<MoneyRequest> requests=data.findMoneyRequest(account);
        if(requests.size()>0){
            userController.showRequest(requests);
        }else{
            userController.noRequestFound();
        }
    }

    @Override
    public void payRequest(long amount, int fromAccNo, Account account, int selectedId) {
        if(data.payRequest(amount,fromAccNo,account,selectedId)){
            userController.requestPaymentSuccess(amount,fromAccNo);
        }else{
            userController.requestPaymentFailed(amount,fromAccNo);
        }
    }
}
