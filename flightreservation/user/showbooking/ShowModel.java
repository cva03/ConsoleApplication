package console.flightreservation.user.showbooking;

import console.flightreservation.dto.Bookings;
import console.flightreservation.dto.User;
import console.flightreservation.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ShowModel implements ShowModelContollerCallback {
    private ShowControllerModelCallback showController;
    private Repository data= Repository.getInstance();
    public ShowModel(ShowController showController) {
        this.showController=showController;
    }

    @Override
    public void checkBookings(User user) {
        List<Bookings> bookings=new ArrayList<>();
        bookings=data.findBookings(user);
        if(bookings.isEmpty()){
            showController.noBookingsFound();
        }else{
            showController.bookingsFound(bookings);
        }
    }
}
