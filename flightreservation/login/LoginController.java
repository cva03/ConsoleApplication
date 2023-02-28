package console.flightreservation.login;

import console.flightreservation.dto.User;

public class LoginController implements LoginControllerViewCallback, LoginControllerModelCallback {
    private LoginModelControllerCallback loginModel;
    private LoginViewControllerCallback loginView;

    public LoginController(LoginView loginView) {
        this.loginView=loginView;
        this.loginModel=new LoginModel(this);
    }


    @Override
    public void verifyUser(String userName, String password) {
        loginModel.verifyUser(userName,password);
    }

    @Override
    public void verifyAdmin(String userName, String password) {
        loginModel.verifyAdmin(userName,password);
    }

    @Override
    public void checkpasswords(String userName, String password, String repassword) {
        loginModel.checkPasswords(userName,password,repassword);
    }

    @Override
    public void upload() {
        loginModel.upload();
    }

    @Override
    public void userVerificationSuccess(User user) {
        loginView.userVerificationSuccess(user);
    }

    @Override
    public void invalidCredentials() {
        loginView.invalidCredentials();
    }

    @Override
    public void adminVerificationSuccess(User user) {
        loginView.adminVerificationSuccess(user);
    }

    @Override
    public void userCreationSuccess(String userName) {
        loginView.userCreationSuccess(userName);
    }

    @Override
    public void userCreationFailed() {
        loginView.usercreationFailed();
    }

    @Override
    public void creationPasswordMismatch() {
        loginView.creationPasswordMismatch();
    }
}
