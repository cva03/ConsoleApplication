package console.flightreservation.admin.manageflights;

import console.flightreservation.dto.Flight;

public interface ManageFlightsControllerViewCallback {

    void checkFlight(int flightId, String date, String departure);

    void createuser(String name, String password, boolean admin);

    void addFlights(Flight flight);

    void deleteFlight(Flight flight);

    void showFlights();
}
