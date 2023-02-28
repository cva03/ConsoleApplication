package console.crmapp.login;

import console.crmapp.dto.Admin;
import console.crmapp.repository.Repository;

public class LoginModel implements LoginModelCallback {
    private LoginControllerModelCallBack loginController;
    private Repository data=Repository.getInstance();

    public LoginModel(LoginController loginController) {
        this.loginController=loginController;
    }



    @Override
    public void addAdmin(Admin admin) {
        if(data.addAdmin(admin)){
            loginController.adminCreationSuccessfull();
        }else{
            loginController.adminCreationFailed();
        }
    }

    @Override
    public void verifyAdmin(String userName, String password) {
        Admin admin=data.verifyAdmin(userName,password);
        if(admin!=null){
            loginController.adminVerificationSuccess(admin);
        }else {
            loginController.adminVerificationFailed();
        }
    }

    @Override
    public void close() {
        data.close();
    }
}
