package console.flightreservation.user.showbooking;

import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;

import java.util.List;

public class ShowController implements ShowControllerViewCallback, ShowControllerModelCallback {
    private ShowViewControllerCallback showView;
    private ShowModelContollerCallback showModel;
    public ShowController(ShowView showView) {
        this.showView=showView;
        this.showModel=new ShowModel(this);
    }

    @Override
    public void checkBookings(User user) {
        showModel.checkBookings(user);
    }

    @Override
    public void noBookingsFound() {
        showView.noBookingsFound();
    }

    @Override
    public void bookingsFound(List<Bookings> bookings) {
        showView.bookingsFound(bookings);
    }
}
