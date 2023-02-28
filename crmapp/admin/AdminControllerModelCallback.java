package console.crmapp.admin;

import console.crmapp.dto.Customer;
import console.crmapp.dto.Interaction;

import java.util.List;

public interface AdminControllerModelCallback {
    void noCustomersFound();

    void showAllCustomers(List<Customer> customers);

    void noInteractionFound();

    void showAllInteractions(List<Interaction> interactions);

    void interactionsAddedSuccessfully(int interactionId);

    void interactionAddFailed();

    void customerAddedSuccessfully(int id);

    void getInteraction(int customerId);

    void customerFoundForUpdation(Customer id);

    void customerNotFoundForUpdation(int id);

    void customerUpdationSucessfull();

    void interactionFoundForUpdation(Interaction id);

    void interactionNotFoundForUpdation();

    void InteractionUpdationSuccessfull();

    void interactionFoundForDeletion(Interaction interaction);

    void interactionNotFoundForDeletion();

    void customerFoundForDeletion(Customer customer);

    void customerNotFoundForDeletion(int id);

    void customerDeletionSuccessfull();

    void interactionDeletionSuccessfull();
}
