package console.flightreservation.user.cancelbooking;

import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;

public interface CancelControllerViewCallback {
    void checkBooking(int bookingId, User user);

    void delete(Bookings booking);
}
