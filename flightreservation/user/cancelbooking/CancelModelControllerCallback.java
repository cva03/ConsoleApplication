package console.flightreservation.user.cancelbooking;

import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;

public interface CancelModelControllerCallback {
    void checkBooking(int bookingId, User user);

    void delete(Bookings booking);
}
