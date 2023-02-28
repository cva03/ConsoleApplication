package console.cricketscoreboard.login;

import console.cricketscoreboard.dto.Staff;

public interface LoginViewCallback {

    void staffVerificationSucess(Staff staff);

    void staffVerificationFailed();

    void staffCreationSuccess();

    void staffCreationFailed();
}
