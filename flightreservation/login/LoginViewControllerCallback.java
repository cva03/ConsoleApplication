package console.flightreservation.login;

import console.flightreservation.dto.User;

public interface LoginViewControllerCallback {
    void userLogin();

    void adminLogin();

    void actionFailed();

    void userVerificationSuccess(User user);

    void invalidCredentials();

    void adminVerificationSuccess(User user);

    void signUp();

    void creationPasswordMismatch();

    void userCreationSuccess(String userName);

    void usercreationFailed();
}
