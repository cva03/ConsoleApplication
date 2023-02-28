package console.crmapp.login;

import console.crmapp.dto.Admin;

public class LoginController implements LoginControllerViewCallback, LoginControllerModelCallBack {
    private LoginViewCallback loginView;
    private LoginModelCallback loginModel;

    public LoginController(LoginView loginView) {
        this.loginView=loginView;
        this.loginModel=new LoginModel(this);
    }


    @Override
    public void addAdmin(Admin admin) {
        loginModel.addAdmin(admin);
    }

    @Override
    public void verifyAdmin(String userName, String password) {
        loginModel.verifyAdmin(userName,password);
    }

    @Override
    public void close() {
        loginModel.close();
    }

    @Override
    public void adminCreationSuccessfull() {
        loginView.adminCreationSuccessfull();
    }

    @Override
    public void adminCreationFailed() {
        loginView.adminCreationFailed();
    }

    @Override
    public void adminVerificationSuccess(Admin admin) {
        loginView.adminVerificationSuccess(admin);
    }

    @Override
    public void adminVerificationFailed() {
        loginView.adminVerificationFailed();
    }
}
