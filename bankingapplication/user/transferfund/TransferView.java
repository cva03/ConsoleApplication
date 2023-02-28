package console.bankingapplication.user.transferfund;

import console.bankingapplication.dto.Account;
import console.bankingapplication.user.UserView;

import java.util.Scanner;

public class TransferView implements TransferviewCallback{

    private TransferControllerViewCallback transferController;
    private Account account;
    private Scanner sc=new Scanner(System.in);


    public TransferView(){
        this.transferController=new TransferController(this);
    }

    public void init(Account account){
        this.account=account;
        start();
    }

    private void start(){
        System.out.println("Enter the account number you want to transfer money");
        int accNo=sc.nextInt();
        sc.nextLine();
        if(accNo==account.getAccountNumber()){
            System.out.println("You cant send money from your own account number!");
            start();
        }
        transferController.checkTransferAccount(accNo);
    }

    @Override
    public void transferAccFound(String name, int accNo) {
        System.out.println("Transfer accound holder name: "+name);

        System.out.println("Enter the amount you want to tranfer (or) Enter 0 to exit");
        long amount=sc.nextLong();
        sc.nextLine();
        if(amount==0){
            UserView uv=new UserView();
            uv.init(account);
        }else{
            System.out.println("Enter CONFIRM (in full caps) to send ");
            if(sc.nextLine().equals("CONFIRM")) {
                transferController.checkAmount(amount, accNo, account);
            }else{
                System.out.println("Transfer Cancelled , Redirecting to main menu");
                UserView uv=new UserView();
                uv.init(account);
            }
        }
    }

    @Override
    public void transferAccNotFound() {
        System.out.println("Accound number not found , enter the valid account number\n");
        start();
    }

    @Override
    public void amountSuccessfullySend(long amount, int accNo) {
        System.out.println(amount+" rupees send successfully to the account number "+accNo);
        System.out.println("\npress any key to go to main menu ");
        sc.nextLine();
        UserView uv=new UserView();
        uv.init(account);
    }

    @Override
    public void inSufficientFunds() {
        System.out.println("Insufficient funds\n");
        System.out.println("press any key to go to main menu ");
        sc.nextLine();
        UserView uv=new UserView();
        uv.init(account);
    }
}
