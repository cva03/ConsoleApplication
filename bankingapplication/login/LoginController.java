package console.bankingapplication.login;

import console.bankingapplication.dto.Account;

public class LoginController implements LoginControllerViewCallback,LoginControllerModelCallback{

    private LoginViewcallback loginview;
    private LoginModelCallback loginmodel;

    public LoginController(LoginView loginView) {
        this.loginview=loginView;
        this.loginmodel=new LoginModel(this);
    }

    @Override
    public void createAccount(Account account) {
        loginmodel.createAccount(account);
    }

    @Override
    public void checkUser(int accNo, String password) {
        loginmodel.checkUser(accNo,password);
    }

    @Override
    public void updateDetails() {
        loginmodel.updateDetails();
    }

    @Override
    public void accountCreationSuccess(int accountNo) {
        loginview.accountCreationSuccess(accountNo);
    }

    @Override
    public void loginSuccess(Account account) {
        loginview.loginSuccess(account);
    }

    @Override
    public void loginfail() {
        loginview.loginFail();
    }
}
