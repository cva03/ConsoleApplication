package console.crmapp.admin;

import console.crmapp.dto.Admin;
import console.crmapp.dto.Customer;
import console.crmapp.dto.Interaction;
import console.crmapp.login.LoginView;

import java.util.List;
import java.util.Scanner;

public class AdminView implements  AdminViewCallback{
    private AdminControllerViewCallback adminController;
    private Admin admin;
    private Scanner sc=new Scanner(System.in);

    public AdminView(){
        this.adminController=new AdminController(this);
    }
    public void init(Admin admin){
        this.admin=admin;
        start();
    }

    private void start(){
        while (true) {
            System.out.printf("\n%50s","<---- Admin page Admin: "+admin.getAdminName()+" ---->");
            System.out.println("\n1. View all customers");
            System.out.println("2. Add a customer");
            System.out.println("3. Update a customer");
            System.out.println("4. Delete a customer");
            System.out.println("5. View all interactions");
            System.out.println("6. Add an interaction");
            System.out.println("7. Update an interaction");
            System.out.println("8. Delete an interaction");
            System.out.println("0. Exit");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        adminController.getAllCustomers();
                        break;
                    case 2:
                        addCustomer();
                        break;
                    case 3:
                        updateCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 5:
                        adminController.getAllInteractions();
                        break;
                    case 6:
                        addInteraction();
                        break;
                    case 7:
                        updateInteraction();
                        break;
                    case 8:
                        deleteInteraction();
                        break;
                    case 0:
                        LoginView lv=new LoginView();
                        lv.init();
                    default:
                        throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Invalid Input!");
            }
        }
    }


    private void updateCustomer() {
        System.out.printf("\n%50s\n", "<---- Update Customer ---->");
        System.out.println("Enter customer ID to update:");
        int id = sc.nextInt();
        sc.nextLine();
        adminController.checkCustomerIdForUpdation(id);
    }

    private void deleteCustomer() {
        System.out.printf("\n%50s\n", "<---- Delete Customer ---->");
        while(true){
            try {
                System.out.println("Enter Customer ID to delete:");
                int id = sc.nextInt();
                sc.nextLine();
                adminController.checkCustomerForDeletion(id);
                break;
            }catch (Exception e){
                System.out.println("Enter valid input");
            }
        }
    }

    private void addInteraction() {
        System.out.printf("\n%50s\n", "<---- Add new Interaction ---->");
        int customerId;
        while (true) {
            try {
                System.out.println("Enter Customer-ID:");
                customerId = sc.nextInt();
                sc.nextLine();
                adminController.checkCustomerForInteraction(customerId);
                break;
            } catch (Exception e) {
                System.out.println("Customer-Id should be in number");
            }
        }
    }

    private void updateInteraction() {
        System.out.printf("\n%50s\n", "<---- Update Interaction ---->");
        System.out.println("Enter interaction ID to update:");
        int id = sc.nextInt();
        sc.nextLine();
        adminController.checkInteractionForUpdation(id);
    }

    private void deleteInteraction() {
        System.out.printf("\n%50s\n", "<---- Delete Interaction ---->");
        while(true){
            try {
                System.out.println("Enter Interaction ID to delete:");
                int id = sc.nextInt();
                sc.nextLine();
                adminController.checkInteractionForDeletion(id);
                break;
            }catch (Exception e){
                System.out.println("Enter valid input");
            }
        }
    }

    private void addCustomer() {
        System.out.printf("\n%50s\n","<---- Add new customer ---->");
        System.out.println("Enter customer name:");
        String name = sc.nextLine();
        System.out.println("Enter customer email:");
        String email = sc.nextLine();
        System.out.println("Enter customer phone:");
        String phone = sc.nextLine();
        Customer customer = new Customer(name, email, phone);
        adminController.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    @Override
    public void noCustomersFound() {
        System.out.println("No customers added yet");
        pressAnyKey();
    }

    @Override
    public void showAllCustomers(List<Customer> customers) {
        System.out.printf("\n%50s\n","<---- Customer List ---->");
        System.out.printf("\n%-15s%-25s%-45s%-20s%-15s","Id","Name","E-mail","Phone","Interactions");
        for(Customer customer:customers){
            customer.print();
        }
        pressAnyKey();
    }

    @Override
    public void showAllInteractions(List<Interaction> interactions) {
        System.out.printf("\n%50s\n","<---- Interaction List ---->");
        System.out.printf("\n%-15s%-15s%-30s%-50s","Id","Customer-Id","Type","Notes");
        for(Interaction interaction:interactions){
            interaction.print();
        }
        pressAnyKey();
    }

    @Override
    public void noInteractionFound() {
        System.out.println("No interactions found");
        pressAnyKey();
    }

    @Override
    public void interactionsAddedSuccessfully(int interactionId) {
        System.out.println("Interaction added successfully and the interaction id is : "+ interactionId);
    }

    @Override
    public void interactionAddFailed() {
        System.out.println("Invalid customer id");
        System.out.println("Enter 1 to add-Interaction any other key to go to main menu");
        if(sc.nextLine().equals("1")){
            addInteraction();
        }else{
            start();
        }
    }

    @Override
    public void customerAddedSuccessfully(int id) {
        System.out.println("Customer added successfully and the customer id is : "+id);
        pressAnyKey();
    }

    @Override
    public void getInteraction(int customerId) {
        System.out.println("Enter interaction type:");
        String type = sc.nextLine();
        System.out.println("Enter interaction notes:");
        String notes = sc.nextLine();
        Interaction interaction=new Interaction(customerId, type, notes);
        adminController.addInteraction(interaction);
    }

    @Override
    public void customerFoundForUpdation(Customer customer) {
        System.out.println("The customer name is : " +customer.getName());
        System.out.println("Enter new customer name:");
        String name = sc.nextLine();
        System.out.println("Enter new customer email:");
        String email = sc.nextLine();
        System.out.println("Enter new customer phone:");
        String phone = sc.nextLine();
        adminController.updateCustomer(customer.getId(),name, email, phone);
    }

    @Override
    public void customerNotFoundForUpdation(int id) {
        System.out.println("No custumer found for the given id");
        System.out.println("Enter 1 to Re-enter customer id any other key to go to main menu");
        if(sc.nextLine().equals("1")){
            updateCustomer();
        }else{
            start();
        }
    }

    @Override
    public void customerUpdationSucessfull() {
        System.out.println("Customer updation successfull");
        start();
    }

    @Override
    public void interactionFoundForUpdation(Interaction interaction) {
        System.out.println("The customer id of this interaction is  "+ interaction.getCustomerId());
        System.out.println("Enter new interaction type:");
        String type = sc.nextLine();
        System.out.println("Enter new interaction notes:");
        String notes = sc.nextLine();
        adminController.updateInteraction(interaction.getCustomerId(),interaction.getId(),type,notes);
        System.out.println("Interaction updated successfully.");

    }

    @Override
    public void interactionNotFoundForUpdation() {
        System.out.println("No interaction found for the given id");
        System.out.println("Enter 1 to Re-enter Interaction-id any other key to go to main menu");
        if(sc.nextLine().equals("1")){
            updateInteraction();
        }else{
            start();
        }
    }

    @Override
    public void InteractionUpdationSuccessfull() {
        System.out.println("Interaction updation Successfull");
        start();
    }

    @Override
    public void interactionFoundForDeletion(Interaction interaction) {
        System.out.println("The Customer id is "+interaction.getCustomerId()+" and the interaction type is "+interaction.getType());
        System.out.println("Enter 1 to Delete any other key to go to main menu");
        if(sc.nextLine().equals("1")){
            adminController.deleteInteraction(interaction.getId());
        }else{
            start();
        }

    }

    @Override
    public void interactionNotFoundForDeletion() {
        System.out.println("No interaction found for the given id");
        System.out.println("Enter 1 to Re-enter Interaction-id any other key to go to main menu");
        if(sc.nextLine().equals("1")){
            deleteInteraction();
        }else{
            start();
        }
    }

    @Override
    public void customerFoundForDeletion(Customer customer) {
        System.out.println("The customer name is "+customer.getName()+" and the id is "+customer.getId());
        System.out.println("Deleting customer will also delete their interactions");
        System.out.println("Enter 1 to Delete any other key to go to main menu");
        if(sc.nextLine().equals("1")){
            adminController.deleteCustomer(customer.getId());
        }else{
            start();
        }

    }

    @Override
    public void customerNotFoundForDeletion() {
        System.out.println("No customer found for the given id");
        System.out.println("Enter 1 to Re-enter Customer-id any other key to go to main menu");
        if(sc.nextLine().equals("1")){
            deleteCustomer();
        }else{
            start();
        }
    }

    @Override
    public void customerDeletionSuccessfull() {
        System.out.println("Customer deleted successfully");
        start();
    }

    @Override
    public void interactionDeletionSuccessfull() {
        System.out.println("Interaction deleted successfully");
        start();
    }

    private void pressAnyKey() {
        System.out.println("\nPress any key to go to Main-menu");
        sc.nextLine();
        start();
    }
}
