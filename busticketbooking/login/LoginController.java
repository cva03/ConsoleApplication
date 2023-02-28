package console.busticketbooking.login;

import console.busticketbooking.dto.Admin;
import console.busticketbooking.dto.User;

public class LoginController implements LoginControllerViewCallback,LoginControllerModelCallBack{
    private LoginViewCallback loginView;
    private LoginModelCallback loginModel;

    public LoginController(LoginView loginView) {
        this.loginView=loginView;
        this.loginModel=new LoginModel(this);
    }


    @Override
    public void addUser(User user) {
        loginModel.addUser(user);
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
    public void verifyUser(String userName, String password) {
        loginModel.verifyUser(userName,password);
    }

    @Override
    public void upload() {
        loginModel.upload();
    }

    @Override
    public void userCreationSuccess(boolean b) {
        loginView.userCreationSuccess(b);
    }

    @Override
    public void userCreationFailed(boolean b) {
        loginView.userCreationFailed(b);
    }

    @Override
    public void adminVerificationFailed() {
        loginView.adminVerificationFailed();
    }

    @Override
    public void adminVerificationSuccess(Admin admin) {
        loginView.adminVerificationSuccess(admin);
    }

    @Override
    public void userVerificationSuccess(User user) {
        loginView.userVerificationSuccess(user);

    }
}
