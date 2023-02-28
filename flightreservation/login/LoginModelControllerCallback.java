package console.flightreservation.login;

public interface LoginModelControllerCallback {
    void verifyUser(String userName, String password);

    void verifyAdmin(String userName, String password);

    void upload();

    void checkPasswords(String userName, String password, String repassword);
}
