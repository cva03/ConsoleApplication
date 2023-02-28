package console.flightreservation.user.showbooking;

import console.flightreservation.dto.Bookings;

import java.util.List;

public interface ShowViewControllerCallback {
    void noBookingsFound();

    void bookingsFound(List<Bookings> bookings);
}
