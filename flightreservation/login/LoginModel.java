package console.flightreservation.login;

import console.flightreservation.dto.User;
import console.flightreservation.repository.Repository;

public class LoginModel implements LoginModelControllerCallback {
    private LoginControllerModelCallback loginController;

    public LoginModel(LoginController loginController) {
        this.loginController=loginController;
    }

    private Repository data= Repository.getInstance();


    @Override
    public void verifyUser(String userName, String password) {
        User user=data.checkUserLogin(userName,password);
       if(user!=null){
           loginController.userVerificationSuccess(user);
       }else{
           loginController.invalidCredentials();
       }
    }

    @Override
    public void verifyAdmin(String userName, String password) {
        User user=data.checkAdminLogin(userName,password);
        if(user!=null){
            loginController.adminVerificationSuccess(user);
        }else{
            loginController.invalidCredentials();
        }
    }

    @Override
    public void upload() {
        data.uploadFiles();
    }


    @Override
    public void checkPasswords(String userName, String password, String repassword) {
        if(password.equals(repassword)){
            if(data.createuser(userName,password,false)){
                loginController.userCreationSuccess(userName);
            }else{
                loginController.userCreationFailed();
            }
        }else{
            loginController.creationPasswordMismatch();
        }
    }
}
