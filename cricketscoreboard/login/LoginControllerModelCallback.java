package console.cricketscoreboard.login;

import console.cricketscoreboard.dto.Staff;

public interface LoginControllerModelCallback {


    void staffVerificationFailed();

    void staffVerificationSucess(Staff staff);

    void staffCreationSuccess();

    void staffCreationFailed();
}
