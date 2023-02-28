package console.flightreservation.user.cancelbooking;

import console.flightreservation.dto.Bookings;

public interface CancelviewControllerCallback {
    void bookingFound(Bookings booking);

    void bookingNotFound(int bookingId);

    void exitCancellation();

    void cancellationSuccess(int bookingId);

    void cancellationFailed();
}
