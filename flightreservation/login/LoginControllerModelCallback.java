package console.flightreservation.login;

import console.flightreservation.dto.User;

public interface LoginControllerModelCallback {

    void userVerificationSuccess(User user);

    void invalidCredentials();

    void adminVerificationSuccess(User user);

    void userCreationSuccess(String userName);

    void userCreationFailed();

    void creationPasswordMismatch();
}
