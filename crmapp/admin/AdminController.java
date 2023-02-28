package console.crmapp.admin;

import console.crmapp.dto.Customer;
import console.crmapp.dto.Interaction;

import java.util.List;

public class AdminController implements AdminControllerViewCallback,AdminControllerModelCallback{
    private AdminViewCallback adminView;
    private AdminModelCallback adminModel;
    public AdminController(AdminView adminView) {
        this.adminView=adminView;
        this.adminModel=new AdminModel(this);
    }


    @Override
    public void getAllCustomers() {
        adminModel.getAllCustomers();
    }

    @Override
    public void getAllInteractions() {
        adminModel.getAllInteractions();
    }

    @Override
    public void addInteraction(Interaction interaction) {
        adminModel.addInteraction(interaction);
    }

    @Override
    public void addCustomer(Customer customer) {
       adminModel.addCustomer(customer);
    }

    @Override
    public void checkCustomerForInteraction(int customerId) {
        adminModel.checkCustomerForInteraction(customerId);
    }

    @Override
    public void checkCustomerIdForUpdation(int id) {
        adminModel.checkCustomerForUpdation(id);
    }

    @Override
    public void updateCustomer(int id, String name, String email, String phone) {
        adminModel.updateCustomer(id,name,email,phone);
    }

    @Override
    public void checkInteractionForUpdation(int id) {
        adminModel.checkInteractionForUpdation(id);
    }

    @Override
    public void updateInteraction(int customerId, int id, String type, String notes) {
        adminModel.updateInteraction(customerId,id,type,notes);
    }

    @Override
    public void checkInteractionForDeletion(int id) {
        adminModel.checkInteractionForDeletion(id);
    }

    @Override
    public void checkCustomerForDeletion(int id) {
        adminModel.checkCustomerForDeletion(id);
    }

    public void deleteCustomer(int id) {
        adminModel.deleteCustomer(id);
    }

    public void deleteInteraction(int id) {
        adminModel.deleteInteraction(id);
    }

    @Override
    public void noCustomersFound() {
        adminView.noCustomersFound();
    }

    @Override
    public void showAllCustomers(List<Customer> customers) {
        adminView.showAllCustomers(customers);
    }

    @Override
    public void noInteractionFound() {
        adminView.noInteractionFound();
    }

    @Override
    public void showAllInteractions(List<Interaction> interactions) {
        adminView.showAllInteractions(interactions);
    }

    @Override
    public void interactionsAddedSuccessfully(int interactionId) {
        adminView.interactionsAddedSuccessfully(interactionId);
    }

    @Override
    public void interactionAddFailed() {
        adminView.interactionAddFailed();
    }

    @Override
    public void customerAddedSuccessfully(int id) {
        adminView.customerAddedSuccessfully(id);
    }

    @Override
    public void getInteraction(int customerId) {
        adminView.getInteraction(customerId);
    }

    @Override
    public void customerFoundForUpdation(Customer customer) {
        adminView.customerFoundForUpdation(customer);
    }

    @Override
    public void customerNotFoundForUpdation(int id) {
        adminView.customerNotFoundForUpdation(id);
    }

    @Override
    public void customerUpdationSucessfull() {
        adminView.customerUpdationSucessfull();
    }

    @Override
    public void interactionFoundForUpdation(Interaction interaction) {
        adminView.interactionFoundForUpdation(interaction);
    }

    @Override
    public void interactionNotFoundForUpdation() {
        adminView.interactionNotFoundForUpdation();
    }

    @Override
    public void InteractionUpdationSuccessfull() {
        adminView.InteractionUpdationSuccessfull();
    }

    @Override
    public void interactionFoundForDeletion(Interaction interaction) {
        adminView.interactionFoundForDeletion(interaction);
    }

    @Override
    public void interactionNotFoundForDeletion() {
        adminView.interactionNotFoundForDeletion();
    }

    @Override
    public void customerFoundForDeletion(Customer customer) {
        adminView.customerFoundForDeletion(customer);
    }

    @Override
    public void customerNotFoundForDeletion(int id) {
        adminView.customerNotFoundForDeletion();
    }

    @Override
    public void customerDeletionSuccessfull() {
        adminView.customerDeletionSuccessfull();
    }

    @Override
    public void interactionDeletionSuccessfull() {
        adminView.interactionDeletionSuccessfull();
    }
}
