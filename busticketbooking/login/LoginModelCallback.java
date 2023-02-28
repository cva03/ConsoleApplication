package console.busticketbooking.login;

import console.busticketbooking.dto.Admin;
import console.busticketbooking.dto.User;

public interface LoginModelCallback {

    void addUser(User user);

    void addAdmin(Admin admin);

    void verifyAdmin(String userName, String password);

    void verifyUser(String userName, String password);

    void upload();
}

