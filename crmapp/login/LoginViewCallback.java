package console.crmapp.login;

import console.crmapp.dto.Admin;

public interface LoginViewCallback {

    void adminCreationSuccessfull();

    void adminCreationFailed();

    void adminVerificationSuccess(Admin admin);

    void adminVerificationFailed();
}
