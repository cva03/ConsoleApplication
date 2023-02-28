package console.flightreservation.user.booking;

import console.flightreservation.dto.Flight;
import console.flightreservation.dto.Passenger;
import console.flightreservation.dto.User;

import java.util.List;

public class BookingController implements BookingControllerViewCallback, BookingControllerModelCallback {
    private BookingviewControllerCallback bookingView;
    private BookingModelControllerCallback bookingModel;
    public BookingController(Bookingview bookingView) {
        this.bookingView=bookingView;
        this.bookingModel=new BookingModel(this);
    }

    @Override
    public void checkflight(String from, String to, String date) {
        bookingModel.checkFlight(from, to, date);
    }


    @Override
    public void addBooking(Flight flight, List<Passenger> passengerList, User user) {
        bookingModel.addBooking(flight,passengerList,user);
    }

    @Override
    public void flightNotFound() {
        bookingView.flightNotFound();
    }

    @Override
    public void flightfound(List<Flight> foundFlights) {
        bookingView.flightfound(foundFlights);
    }

    @Override
    public void bookingSuccessfull(User user) {
        bookingView.bookingSuccessful(user);
    }

    @Override
    public void bookingUnSuccessfull(User user) {
        bookingView.bookingUnSuccessfull(user);
    }

}
