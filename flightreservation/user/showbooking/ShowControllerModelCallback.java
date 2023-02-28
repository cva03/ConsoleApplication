package console.flightreservation.user.showbooking;

import console.flightreservation.dto.Bookings;

import java.util.List;

public interface ShowControllerModelCallback {
    void noBookingsFound();

    void bookingsFound(List<Bookings> bookings);
}
