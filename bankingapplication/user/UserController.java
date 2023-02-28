package console.bankingapplication.user;

import console.bankingapplication.dto.Account;
import console.bankingapplication.dto.MoneyRequest;
import console.bankingapplication.dto.TransactionHistory;

import java.util.List;

public class UserController implements UserControllerViewCallback, UserControllerModelCallback{

    private UserViewCallback userView;
    private UserModelCallback userModel;

    public UserController(UserView userView) {
        this.userView=userView;
        this.userModel=new UserModel(this);
    }

    @Override
    public void changePassword(String password, Account account) {
        userModel.changePassword(password,account);
    }

    @Override
    public void showTransactions(Account account) {
        userModel.showTransactions(account);
    }

    @Override
    public void getBalance(Account account) {
        userModel.getBalance(account);
    }

    @Override
    public void checkAcc(int accNo) {
        userModel.checkAcc(accNo);
    }

    @Override
    public void requestMoney(long amount, int accNo, String description, Account account) {
        userModel.requestMoney(amount,accNo,description,account);
    }

    @Override
    public void findRequest(Account account) {
        userModel.findRequest(account);
    }

    @Override
    public void payRequest(long amount, int fromAccNo, Account account, int selectedId) {
        userModel.payRequest(amount,fromAccNo,account,selectedId);
    }

    @Override
    public void passwordChangeSuccessfull(String password, Account account) {
        userView.passwordChangeSuccessfull(password,account);
    }

    @Override
    public void noTransactionsFound() {
        userView.noTransactionsFound();
    }

    @Override
    public void transactionsfound(List<TransactionHistory> trans) {
        userView.showTransactions(trans);
    }

    @Override
    public void showBalance(long balance) {
        userView.showBalance(balance);
    }

    @Override
    public void requestAccFound(String accName, int accNo) {
        userView.requestAccFound(accName,accNo);
    }

    @Override
    public void requestAccNotFound() {
        userView.requestAccNotFound();
    }

    @Override
    public void requestSuccess(long amount, int accNo) {
        userView.requestSucess(amount,accNo);
    }

    @Override
    public void showRequest(List<MoneyRequest> requests) {
        userView.showRequest(requests);
    }

    @Override
    public void noRequestFound() {
        userView.noRequestFound();
    }

    @Override
    public void requestPaymentSuccess(long amount, int fromAccNo) {
        userView.requestPaymentSuccess(amount,fromAccNo);
    }

    @Override
    public void requestPaymentFailed(long amount, int fromAccNo) {
        userView.requestPaymentFailed(amount,fromAccNo);
    }
}
