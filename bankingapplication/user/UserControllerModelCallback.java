package console.bankingapplication.user;

import console.bankingapplication.dto.Account;
import console.bankingapplication.dto.MoneyRequest;
import console.bankingapplication.dto.TransactionHistory;

import java.util.List;

public interface UserControllerModelCallback {
    void passwordChangeSuccessfull(String password, Account account);

    void noTransactionsFound();

    void transactionsfound(List<TransactionHistory> trans);

    void showBalance(long balance);

    void requestAccFound(String accName, int accNo);

    void requestAccNotFound();

    void requestSuccess(long amount, int accNo);

    void showRequest(List<MoneyRequest> requests);

    void noRequestFound();

    void requestPaymentSuccess(long amount, int fromAccNo);

    void requestPaymentFailed(long amount, int fromAccNo);
}
