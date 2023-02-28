package console.crmapp.admin;

import console.crmapp.dto.Customer;
import console.crmapp.dto.Interaction;

public interface AdminModelCallback {
    void getAllCustomers();

    void getAllInteractions();

    void addInteraction(Interaction interaction);

    void addCustomer(Customer customer);

    void checkCustomerForInteraction(int customerId);

    void checkCustomerForUpdation(int id);

    void updateCustomer(int id,String name, String email, String phone);

    void checkInteractionForUpdation(int id);

    void updateInteraction(int customerId, int id, String type, String notes);

    void checkInteractionForDeletion(int id);

    void checkCustomerForDeletion(int id);

    void deleteCustomer(int id);

    void deleteInteraction(int id);
}
