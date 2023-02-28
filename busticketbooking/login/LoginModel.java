package console.busticketbooking.login;


import console.busticketbooking.dto.Admin;
import console.busticketbooking.dto.User;
import console.busticketbooking.repository.Repository;

public class LoginModel implements LoginModelCallback{
    private LoginControllerModelCallBack loginController;
    private Repository data=Repository.getInstance();

    public LoginModel(LoginController loginController) {
        this.loginController=loginController;
    }

    @Override
    public void addUser(User user) {
        if(data.addUser(user)){
            loginController.userCreationSuccess(false);
        }else{
            loginController.userCreationFailed(false);
        }
    }

    @Override
    public void addAdmin(Admin admin) {
        if(data.addAdmin(admin)){
            loginController.userCreationSuccess(true);
        }else{
            loginController.userCreationFailed(true);
        }
    }

    @Override
    public void verifyAdmin(String userName, String password) {
        Admin admin=data.verifyAdmin(userName,password);
        if(admin!=null){
            loginController.adminVerificationSuccess(admin);
        }else{
            loginController.adminVerificationFailed();
        }
    }

    @Override
    public void verifyUser(String userName, String password) {
        User user=data.verifyUser(userName,password);
        if(user!=null){
            loginController.userVerificationSuccess(user);
        }else{
            loginController.adminVerificationFailed();
        }
    }

    @Override
    public void upload() {
        data.upload();
    }
}
