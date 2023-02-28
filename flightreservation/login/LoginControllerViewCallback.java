package console.flightreservation.login;

public interface LoginControllerViewCallback {

    void verifyUser(String userName, String password);

    void verifyAdmin(String userName, String password);

    void checkpasswords(String userName, String password, String repassword);

    void upload();
}
