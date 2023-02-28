package console.bankingapplication.login;

import console.bankingapplication.dto.Account;

public interface LoginModelCallback {
    void createAccount(Account account);

    void checkUser(int accNo, String password);

    void updateDetails();
}
