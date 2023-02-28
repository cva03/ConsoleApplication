package console.flightreservation.user.booking;

import console.flightreservation.dto.Flight;
import console.flightreservation.dto.Passenger;
import console.flightreservation.dto.User;
import console.flightreservation.repository.Repository;

import java.util.List;

public class BookingModel implements BookingModelControllerCallback {
    private BookingControllerModelCallback bookingController;
    public BookingModel(BookingController bookingController) {
        this.bookingController=bookingController;
    }
    private Repository data= Repository.getInstance();

    @Override
    public void checkFlight(String from, String to, String date) {
        List<Flight> foundFlights =data.checkFlight(from,to,date);
        if(foundFlights.isEmpty()){
            bookingController.flightNotFound();
        }else {
            bookingController.flightfound(foundFlights);
        }
    }

    @Override
    public void addBooking(Flight flight, List<Passenger> passengerList, User user) {
        if(data.addBooking(flight,passengerList,user)){
            bookingController.bookingSuccessfull(user);
        }else{
            bookingController.bookingUnSuccessfull(user);
        }
    }

}
