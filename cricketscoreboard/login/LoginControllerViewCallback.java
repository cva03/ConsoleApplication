package console.cricketscoreboard.login;

import console.cricketscoreboard.dto.Staff;

public interface LoginControllerViewCallback {


    void verifyAdmin(String userName, String password);

    void addStaff(Staff staff);

    void upload();
}
