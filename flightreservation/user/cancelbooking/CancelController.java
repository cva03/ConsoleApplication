package console.flightreservation.user.cancelbooking;

import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;

public class CancelController implements CancelControllerViewCallback, CancelControllerModelCallback {
    private CancelviewControllerCallback cancelView;
    private CancelModelControllerCallback cancelModel;
    public CancelController(CancelView cancelView) {
        this.cancelView=cancelView;
        this.cancelModel=new CancelModel(this);
    }

    @Override
    public void checkBooking(int bookingId, User user) {
        cancelModel.checkBooking(bookingId,user);
    }

    @Override
    public void delete(Bookings booking) {
        cancelModel.delete(booking);
    }


    @Override
    public void bookingFound(Bookings booking) {
        cancelView.bookingFound(booking);
    }

    @Override
    public void bookingNotFound(int bookingId) {
        cancelView.bookingNotFound(bookingId);
    }

    @Override
    public void cancellationSuccess(int bookingId) {
        cancelView.cancellationSuccess(bookingId);
    }

    @Override
    public void cancellationFailed() {
        cancelView.cancellationFailed();
    }
}
