package console.flightreservation.user.cancelbooking;

import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;
import console.flightreservation.repository.Repository;

public class CancelModel implements CancelModelControllerCallback {
    private CancelControllerModelCallback cancelController;
    private Repository data= Repository.getInstance();
    public CancelModel(CancelController cancelController) {
        this.cancelController=cancelController;
    }

    @Override
    public void checkBooking(int bookingId, User user) {
        Bookings booking=data.checkBooking(bookingId,user);
        if(booking!=null){
            cancelController.bookingFound(booking);
        }else{
            cancelController.bookingNotFound(bookingId);
        }
    }

    @Override
    public void delete(Bookings booking) {
        if(data.deleteBooking(booking)){
            cancelController.cancellationSuccess(booking.getBookingId());
        }else{
            cancelController.cancellationFailed();
        }
    }
}
