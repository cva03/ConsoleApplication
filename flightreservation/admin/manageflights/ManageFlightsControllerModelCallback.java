package console.flightreservation.admin.manageflights;

import console.flightreservation.dto.Flight;

import java.util.List;

public interface ManageFlightsControllerModelCallback {
    void addSuccessfull();

    void addFailed();

    void flightFound(Flight flight);

    void flightNotFound();

    void deletionSuccessfull();

    void deletionUnsuccessfull();

    void listAllFlights(List<Flight> flights);

    void noFlightsFound();

    void adminCreationSuccessfull();

    void userCreationSuccessfull();

    void adminCreationFailed();

    void userCreationFailed();
}
