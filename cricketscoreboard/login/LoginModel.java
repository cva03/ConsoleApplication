package console.cricketscoreboard.login;

import console.cricketscoreboard.dto.Staff;
import console.cricketscoreboard.repository.Repository;

public class LoginModel implements LoginModelCallback {
    private LoginControllerModelCallback loginController;
    private Repository data=Repository.getInstance();

    public LoginModel(LoginController loginController) {
        this.loginController=loginController;
    }


    @Override
    public void verifyAdmin(String userName, String password) {
        Staff staff=data.checkAdmin(userName,password);
        if(staff==null){
            loginController.staffVerificationFailed();
        }else{
            loginController.staffVerificationSucess(staff);
        }
    }

    @Override
    public void addStaff(Staff staff) {
        if(data.addStaff(staff)){
            loginController.staffCreationSuccess();
        }else{
            loginController.staffCreationFailed();
        }
    }

    @Override
    public void upload() {
        data.upload();
    }
}
