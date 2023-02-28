package console.flightreservation.user.booking;

import console.flightreservation.dto.Flight;
import console.flightreservation.dto.User;

import java.util.List;

public interface BookingControllerModelCallback {

    void flightNotFound();

    void flightfound(List<Flight> foundFlights);

    void bookingSuccessfull(User user);

    void bookingUnSuccessfull(User user);
}
