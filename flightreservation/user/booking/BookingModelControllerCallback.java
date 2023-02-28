package console.flightreservation.user.booking;

import console.flightreservation.dto.Flight;
import console.flightreservation.dto.Passenger;
import console.flightreservation.dto.User;

import java.util.List;

public interface BookingModelControllerCallback {
    void checkFlight(String from, String to, String date);

    void addBooking(Flight flight, List<Passenger> passengerList, User user);

}
