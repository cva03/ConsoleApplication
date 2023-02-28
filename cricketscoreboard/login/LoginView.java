package console.cricketscoreboard.login;


import console.cricketscoreboard.dto.Staff;
import console.cricketscoreboard.staff.StaffView;
import console.cricketscoreboard.viewer.ViewerView;

import java.util.Scanner;

public class LoginView implements LoginViewCallback {
    private Scanner sc=new Scanner(System.in);
    private LoginControllerViewCallback loginController;
    public LoginView(){
        this.loginController=new LoginController(this);
    }

    private void start(){
        System.out.printf("\n%50S","<-- Welcome to Cricket Score Board -->");
        int choice;
        while(true) {
            System.out.println("\n1. Staff Login");
            System.out.println("2. Viewer");
            System.out.println("3. ScoreBoard staff signup");
            System.out.println("0. Exit");
            try {
                System.out.println("Enter your choice");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        staffLogin();
                        break;
                    case 2:
                        viewer();
                        break;
                    case 3:
                        signUp();
                        break;
                    case 0:
                        loginController.upload();
                        System.exit(0);
                    default:
                        throw new NumberFormatException();

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }

    }

    private void signUp() {
        System.out.printf("\n%50S\n","<-- Staff SignUp page -->");
        System.out.println("Enter the staff name ");
        String staffName=sc.nextLine();
        while(true) {
            System.out.println("Enter the password ");
            String password = sc.nextLine();
            System.out.println("Re-enter the password");
            if (password.equals(sc.nextLine())) {
                Staff staff= new Staff(staffName,password);
                loginController.addStaff(staff);
                break;
            }else{
                System.out.println("Password doesn't match");
            }
        }
    }

    private void viewer() {
        ViewerView vv=new ViewerView();
        vv.init();

    }

    private void staffLogin() {
        System.out.printf("\n%50S\n","<-- Staff login page -->");
        System.out.println("Enter the staff name :");
        String userName=sc.nextLine();
        System.out.println("Enter the password :");
        String password=sc.nextLine();
        loginController.verifyAdmin(userName,password);
    }

    @Override
    public void staffVerificationSucess(Staff staff) {
        System.out.println("Staff login successfull");
        StaffView staffView=new StaffView();
        staffView.init(staff);
    }

    @Override
    public void staffVerificationFailed() {
        System.out.println("Invalid creditials\n");
        start();
    }

    @Override
    public void staffCreationSuccess() {
        System.out.println("Staff Profile created successfully\n");
        start();
    }

    @Override
    public void staffCreationFailed() {
        System.out.println("Staff name already exits\n");
        start();
    }

    public void init() {
        start();
    }
}
