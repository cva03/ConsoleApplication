package console.bankingapplication.login;

import console.bankingapplication.dto.Account;

public interface LoginControllerViewCallback {
    void createAccount(Account account);

    void checkUser(int accNo, String password);

    void updateDetails();
}
