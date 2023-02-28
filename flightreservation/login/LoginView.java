package console.flightreservation.login;

import console.flightreservation.admin.manageflights.ManageFlightsView;
import console.flightreservation.user.booking.Bookingview;
import console.flightreservation.dto.User;

import java.util.Scanner;

public class LoginView implements LoginViewControllerCallback {
    private Scanner sc=new Scanner(System.in);
    private LoginControllerViewCallback loginController;
    public LoginView(){
        this.loginController=new LoginController(this);
    }

    private void start(){
        System.out.printf("\n%50S","<-- Welcome to ticket booking application -->");
        System.out.println("\n1. User");
        System.out.println("2. Admin");
        System.out.println("3. Signup");
        System.out.println("0. Exit");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                userLogin();
                break;
            case 2:
                adminLogin();
                break;
            case 3:
                signUp();
            case 0:
                loginController.upload();
                System.exit(0);
            default:
                actionFailed();
        }
    }

    public void init(){
        start();
    }

    @Override
    public void userLogin() {
        System.out.printf("%50S","<-- User login page -->\n");
        System.out.println("Enter the username :");
        String userName=sc.nextLine();
        System.out.println("Enter the password :");
        String password=sc.nextLine();
        loginController.verifyUser(userName,password);
    }

    @Override
    public void adminLogin() {
        System.out.printf("%50S","<-- Admin login page -->\n");
        System.out.println("Enter the Admin name :");
        String userName=sc.nextLine();
        System.out.println("Enter the password :");
        String password=sc.nextLine();
        loginController.verifyAdmin(userName,password);
    }

    @Override
    public void actionFailed() {
        System.out.println("\nInvalid choice\n");
        start();
    }

    @Override
    public void userVerificationSuccess(User user) {
        System.out.println("\nUser login successfull\nWelcome "+ user.getName()+"\n ");
        Bookingview bv=new Bookingview();
        bv.init(user);
    }

    @Override
    public void invalidCredentials() {
        System.out.println("\nInvalid credentials\nRedirecting to login page!\n");
        start();
    }

    @Override
    public void adminVerificationSuccess(User user) {
        System.out.println("\nAdmin login successfull\nWelcome "+ user.getName()+"\n");
        ManageFlightsView mv=new ManageFlightsView();
        mv.init(user);
    }

    @Override
    public void signUp() {
        System.out.printf("%50S","<-- Sign up -->\n");
        System.out.println("Enter the user name ");
        String userName=sc.nextLine();
        System.out.println("Enter the password ");
        String password=sc.nextLine();
        System.out.println("Reenter the password");
        String repassword=sc.nextLine();
        loginController.checkpasswords(userName,password,repassword);
    }

    @Override
    public void creationPasswordMismatch() {
        System.out.println("password mismatch: ");
        signUp();
    }

    @Override
    public void userCreationSuccess(String userName) {
        System.out.println("The user "+userName+" created successfully");
        System.out.println("press any key to go to main page");
        sc.nextLine();
        start();
    }

    @Override
    public void usercreationFailed() {
        System.out.println("User name already exists");
        System.out.println("Redireting to main page");
        start();
    }
}
