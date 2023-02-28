package console.bankingapplication.user;

import console.bankingapplication.dto.Account;

public interface UserModelCallback {

    void changePassword(String password, Account account);

    void showTransactions(Account account);

    void getBalance(Account account);

    void checkAcc(int accNo);

    void requestMoney(long amount, int accNo, String description, Account account);

    void findRequest(Account account);

    void payRequest(long amount, int fromAccNo, Account account, int selectedId);
}
