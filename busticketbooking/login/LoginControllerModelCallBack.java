package console.busticketbooking.login;

import console.busticketbooking.dto.Admin;
import console.busticketbooking.dto.User;

public interface LoginControllerModelCallBack {
    void userCreationSuccess(boolean b);

    void userCreationFailed(boolean b);

    void adminVerificationFailed();

    void adminVerificationSuccess(Admin admin);

    void userVerificationSuccess(User user);
}
