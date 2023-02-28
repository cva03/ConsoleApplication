package console.crmapp.admin;

import console.crmapp.dto.Customer;
import console.crmapp.dto.Interaction;
import console.crmapp.repository.Repository;

import java.util.List;

public class AdminModel implements AdminModelCallback{
    private AdminControllerModelCallback adminController;
    private Repository data=Repository.getInstance();
    public AdminModel(AdminController adminController) {
        this.adminController=adminController;
    }

    @Override
    public void getAllCustomers() {
        List<Customer> customers=data.getAllCustomer();
        if(customers.isEmpty()){
            adminController.noCustomersFound();
        }
        adminController.showAllCustomers(customers);
    }

    @Override
    public void getAllInteractions() {
        List<Interaction> interactions=data.getAllInteraction();
        if(interactions.isEmpty()){
            adminController.noInteractionFound();
        }
        adminController.showAllInteractions(interactions);

    }

    @Override
    public void addInteraction(Interaction interaction) {
        int id=data.addInteraction(interaction);
        adminController.interactionsAddedSuccessfully(interaction.getId());
    }

    @Override
    public void addCustomer(Customer customer) {
        data.addCustomer(customer);
        adminController.customerAddedSuccessfully(customer.getId());
    }

    @Override
    public void checkCustomerForInteraction(int customerId) {
        if(data.checkCustomerForInteraction(customerId)){
            adminController.getInteraction(customerId);
        }else{
            adminController.interactionAddFailed();
        }
    }

    @Override
    public void checkCustomerForUpdation(int id) {
        Customer customer=data.checkCustomerForUpdation(id);
        if(customer!=null){
            adminController.customerFoundForUpdation(customer);
        }else{
            adminController.customerNotFoundForUpdation(id);
        }
    }

    @Override
    public void updateCustomer(int id, String name, String email, String phone) {
        data.updateCustomer(id, name,email,phone);
        adminController.customerUpdationSucessfull();
    }

    @Override
    public void checkInteractionForUpdation(int id) {
        Interaction interaction=data.checkInteractionForUpdation(id);
        if(interaction!=null){
            adminController.interactionFoundForUpdation(interaction);
        }else{
            adminController.interactionNotFoundForUpdation();
        }
    }

    @Override
    public void updateInteraction(int customerId, int id, String type, String notes) {
        data.updateInteraction(customerId,id,type,notes);
        adminController.InteractionUpdationSuccessfull();
    }

    @Override
    public void checkInteractionForDeletion(int id) {
       Interaction interaction=data.checkInteractionForDeletion(id);
        if(interaction!=null){
            adminController.interactionFoundForDeletion(interaction);
        }else{
            adminController.interactionNotFoundForDeletion();
        }

    }

    @Override
    public void checkCustomerForDeletion(int id) {
        Customer customer=data.checkCustomerForDeletion(id);
        if(customer!=null){
            adminController.customerFoundForDeletion(customer);
        }else{
            adminController.customerNotFoundForDeletion(id);
        }
    }

    @Override
    public void deleteCustomer(int id) {
        data.deleteCustomer(id);
        adminController.customerDeletionSuccessfull();
    }

    @Override
    public void deleteInteraction(int id) {
        data.deleteInteraction(id);
        adminController.interactionDeletionSuccessfull();
    }
}
