package console.cricketscoreboard.login;

import console.cricketscoreboard.dto.Staff;

public interface LoginModelCallback {

    void verifyAdmin(String userName, String password);

    void addStaff(Staff staff);

    void upload();
}
