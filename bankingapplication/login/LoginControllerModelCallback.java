package console.bankingapplication.login;

import console.bankingapplication.dto.Account;

public interface LoginControllerModelCallback {
    void accountCreationSuccess(int accountNo);

    void loginSuccess(Account account);

    void loginfail();
}
