package console.flightreservation.admin.manageflights;

import console.flightreservation.dto.Flight;

import java.util.List;

public interface ManageFlightsViewControllerCallback {
    void addFlight();

    void removeFlight();

    void actionFailed();

    void addSuccessfull();

    void addFailed();

    void flightFound(Flight flight);

    void flightNotFound();

    void exitDeletion();

    void deletionSuccessfull();

    void deletionUnuccessfull();

    void listAllFlights(List<Flight> flights);

    void noFlightsFound();

    void logOut();

    void confirmLogout();

    void logOutTermination();

    void addUser();

    void addAdmin();

    void adminCreationSuccessfull();

    void adminCreationFailed();

    void userCreationSuccessfull();

    void userCreationFailed();
}
