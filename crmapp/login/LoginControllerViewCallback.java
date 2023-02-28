package console.crmapp.login;

import console.crmapp.dto.Admin;

public interface LoginControllerViewCallback {


    void addAdmin(Admin admin);

    void verifyAdmin(String userName, String password);

    void close();
}
