package console.flightreservation.user.cancelbooking;

import console.flightreservation.dto.Bookings;

public interface CancelControllerModelCallback {
    void bookingFound(Bookings booking);

    void bookingNotFound(int bookingId);

    void cancellationSuccess(int bookingId);

    void cancellationFailed();
}
