package console.busticketbooking.login;

import console.busticketbooking.admin.AdminView;
import console.busticketbooking.user.UserView;
import console.busticketbooking.dto.Admin;
import console.busticketbooking.dto.User;

import java.util.Scanner;

public class LoginView implements LoginViewCallback{
    private LoginControllerViewCallback loginController;
    private Scanner sc=new Scanner(System.in);

    public LoginView(){
        this.loginController=new LoginController(this);
    }

    public void init(){
        start();
    }

    private void start() {
        System.out.printf("\n%70s", "<------ Welcome to Bus Ticket Booking Appliation ------>");
        while (true) {
            System.out.println("\n1. User login");
            System.out.println("2. Admin login");
            System.out.println("3. User Signup");
            System.out.println("4. Admin Signup");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        userLogin();
                        break;
                    case 2:
                        adminLogin();
                        break;
                    case 3:
                        userSignUp();
                        break;
                    case 4:
                        adminSignUp();
                        break;
                    case 0:
                        loginController.upload();
                        System.exit(0);
                    default:
                        throw new RuntimeException();
                }
            }catch (Exception e){
                System.out.println("Invalid Input!");
            }
        }
    }

    private void adminSignUp() {
        System.out.printf("%50S\n","<-- Sign up -->");
        System.out.println("Enter the admin name ");
        String adminName=sc.nextLine();
        while(true) {
            System.out.println("Enter the password ");
            String password = sc.nextLine();
            System.out.println("Re-enter the password");
            if (password.equals(sc.nextLine())) {
                Admin admin= new Admin(adminName,password);
                loginController.addAdmin(admin);
                break;
            }else{
                System.out.println("Password doesn't match");
            }
        }
    }


    private void userSignUp() {
        System.out.printf("%50S\n","<-- Sign up -->");
        System.out.println("Enter the user name ");
        String userName=sc.nextLine();
        while(true) {
            System.out.println("Enter the password ");
            String password = sc.nextLine();
            System.out.println("Re-enter the password");
            if (password.equals(sc.nextLine())) {
                User user= new User(userName,password);
                loginController.addUser(user);
                break;
            }else{
                System.out.println("Password doesn't match");
            }
        }
    }

    private void adminLogin() {
        System.out.printf("%50S\n","<-- Admin login page -->");
        System.out.println("Enter the Admin name :");
        String userName=sc.nextLine();
        System.out.println("Enter the password :");
        String password=sc.nextLine();
        loginController.verifyAdmin(userName,password);
    }

    private void userLogin() {
        System.out.printf("%50S\n","<-- User login page -->");
        System.out.println("Enter the username :");
        String userName=sc.nextLine();
        System.out.println("Enter the password :");
        String password=sc.nextLine();
        loginController.verifyUser(userName,password);
    }

    @Override
    public void userCreationSuccess(boolean admin) {
        if(admin)
            System.out.println("Admin created successfully\n");
        else
            System.out.println("User created successfully\n");
        start();
    }

    @Override
    public void userCreationFailed(boolean admin) {
        if(admin)
            System.out.println("Admin name already exists!\n");
        else
            System.out.println("User name already exists!\n");
        start();
    }

    @Override
    public void adminVerificationFailed() {
        System.out.println("Invalid Credentials!");
        start();
    }

    @Override
    public void adminVerificationSuccess(Admin admin) {
        System.out.println("Admin login successfull");
        System.out.println("Welcome "+admin.getAdminName());
        AdminView av=new AdminView();
        av.init(admin);

    }

    @Override
    public void userVerificationSuccess(User user) {
        System.out.println("Admin login successfull");
        System.out.println("Welcome "+user.getUserName());
        UserView uv=new UserView();
        uv.init(user);

    }
}
