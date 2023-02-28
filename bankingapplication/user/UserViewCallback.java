package console.bankingapplication.user;

import console.bankingapplication.dto.Account;
import console.bankingapplication.dto.MoneyRequest;
import console.bankingapplication.dto.TransactionHistory;

import java.util.List;

public interface UserViewCallback {
    void passwordChangeSuccessfull(String password, Account account);

    void showTransactions(List<TransactionHistory> trans);

    void noTransactionsFound();

    void showBalance(long balance);

    void requestAccFound(String accName, int accNo);

    void requestAccNotFound();

    void requestSucess(long amount, int accNo);

    void showRequest(List<MoneyRequest> requests);

    void noRequestFound();

    void requestPaymentSuccess(long amount, int fromAccNo);

    void requestPaymentFailed(long amount, int fromAccNo);
}
