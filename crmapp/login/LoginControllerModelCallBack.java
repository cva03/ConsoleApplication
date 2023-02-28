package console.crmapp.login;

import console.crmapp.dto.Admin;

public interface LoginControllerModelCallBack {

    void adminCreationSuccessfull();

    void adminCreationFailed();

    void adminVerificationSuccess(Admin admin);

    void adminVerificationFailed();
}
