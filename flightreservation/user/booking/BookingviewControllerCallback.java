package console.flightreservation.user.booking;

import console.flightreservation.dto.Flight;
import console.flightreservation.dto.User;

import java.util.List;

public interface BookingviewControllerCallback {
    void checkflight();

    void showBookings();

    void removeBookings();

    void actionFailed();

    void flightNotFound();

    void flightfound(List<Flight> foundFlights);

    void seatCheckfailed(Flight flight, List<Flight> foundFlights);

    void seatCheckSuccess(int seats, Flight flight, List<Flight> foundFlights);

    void bookingSuccessful(User user);

    void bookingUnSuccessfull(User user);

    void logOut();

    void confirmLogout();

    void logOutTermination();

    void wrongFlightId(List<Flight> foundFlights);

    void showSeats(Flight flight, List<Flight> foundFlights);
}
