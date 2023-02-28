package console.cricketscoreboard.login;

import console.cricketscoreboard.dto.Staff;

public class LoginController implements LoginControllerViewCallback, LoginControllerModelCallback {
    private LoginModelCallback loginModel;
    private LoginViewCallback loginView;

    public LoginController(LoginView loginView) {
        this.loginView=loginView;
        this.loginModel=new LoginModel(this);
    }


    @Override
    public void verifyAdmin(String userName, String password) {
        loginModel.verifyAdmin(userName,password);
    }

    @Override
    public void addStaff(Staff staff) {
        loginModel.addStaff(staff);
    }

    @Override
    public void upload() {
        loginModel.upload();
    }

    @Override
    public void staffVerificationFailed() {
        loginView.staffVerificationFailed();
    }

    @Override
    public void staffVerificationSucess(Staff staff) {
        loginView.staffVerificationSucess(staff);
    }

    @Override
    public void staffCreationSuccess() {
        loginView.staffCreationSuccess();
    }

    @Override
    public void staffCreationFailed() {
        loginView.staffCreationFailed();
    }
}
