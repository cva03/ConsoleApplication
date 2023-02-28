package console.bankingapplication.login;

import console.bankingapplication.dto.Account;

public interface LoginViewcallback {
    void accountCreationSuccess(int accountNo);

    void loginSuccess(Account account);

    void loginFail();
}
