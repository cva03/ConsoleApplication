package console.crmapp.admin;

import console.crmapp.dto.Customer;
import console.crmapp.dto.Interaction;

import java.util.List;

public interface AdminViewCallback {
    void noCustomersFound();

    void showAllCustomers(List<Customer> customers);

    void showAllInteractions(List<Interaction> interactions);

    void noInteractionFound();

    void interactionsAddedSuccessfully(int interactionId);

    void interactionAddFailed();

    void customerAddedSuccessfully(int id);

    void getInteraction(int customerId);

    void customerFoundForUpdation(Customer customer);

    void customerNotFoundForUpdation(int id);

    void customerUpdationSucessfull();

    void interactionFoundForUpdation(Interaction interaction);

    void interactionNotFoundForUpdation();

    void InteractionUpdationSuccessfull();

    void interactionFoundForDeletion(Interaction interaction);

    void interactionNotFoundForDeletion();

    void customerFoundForDeletion(Customer customer);

    void customerNotFoundForDeletion();

    void customerDeletionSuccessfull();

    void interactionDeletionSuccessfull();
}
