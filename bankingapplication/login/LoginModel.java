package console.bankingapplication.login;

import console.bankingapplication.dto.Account;
import console.bankingapplication.repository.Repository;

public class LoginModel implements LoginModelCallback{

    private LoginControllerModelCallback loginController;
    private Repository data=Repository.getInstance();

    public LoginModel(LoginController loginController) {
        this.loginController=loginController;
    }

    @Override
    public void createAccount(Account account) {
        int accountNo=data.createAccount(account);
        if(accountNo!=0){
            loginController.accountCreationSuccess(accountNo);
        }
    }

    @Override
    public void checkUser(int accNo, String password) {
        Account account=data.checkUser(accNo,password);
        if(account!=null){
            loginController.loginSuccess(account);
        }else{
            loginController.loginfail();
        }
    }

    @Override
    public void updateDetails() {
        data.updateDetails();
    }
}
