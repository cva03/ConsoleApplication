package console.flightreservation.admin.manageflights;

import console.flightreservation.dto.Flight;

public interface ManageFlightsModelControllerCallback {
    void showFlights();

    void checkFlight(int flightId, String date, String departure);

    void deleteFlight(Flight flight);

    void createuser(String name, String password, boolean admin);

    void addFlights(Flight flight);
}
