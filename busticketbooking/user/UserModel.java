package console.busticketbooking.user;

import console.busticketbooking.dto.Booking;
import console.busticketbooking.dto.Bus;
import console.busticketbooking.dto.Passenger;
import console.busticketbooking.dto.User;
import console.busticketbooking.repository.Repository;

import java.util.List;

public class UserModel implements UserModelCallback {
    private UserControllerModelCallBack userController;
    private Repository data=Repository.getInstance();

    public UserModel(UserController userController) {
        this.userController=userController;
    }

    @Override
    public void findBus(String from, String to, String date) {
        List<Bus> foundBus=data.findBus(from,to,date);
        if(foundBus.isEmpty()){
            userController.noBusFound();
        }else{
            userController.showfoundBus(foundBus);
        }
    }

    @Override
    public void findSelectedBusSeats(int selectedId, List<Bus> foundBus) {
        Bus bus=data.findSelectedBusSeats(selectedId,foundBus);
        if(bus==null){
            userController.selectedWrongBus(foundBus);
        }else{
            userController.selectedBusFound(bus);
        }
    }

    @Override
    public void addBooking(List<Passenger> passengers, Bus bus, User user) {
        int amount=data.addBooking(passengers,bus,user);
        if(amount>=1){
            userController.bookingAddSuccess(amount);
        }else{
            userController.bookingAddFailed();
        }
    }

    @Override
    public void getAllBooking(User user) {
        List<Booking> bookings=data.getAllBooking(user);
        if(bookings.isEmpty()){
            userController.noBookingsFound();
        }else{
            userController.showAllBookings(bookings);
        }
    }

    @Override
    public void findAllBookings(User user) {
        List<Booking> bookings=data.getAllBooking(user);
        if(bookings.isEmpty()){
            userController.noBookingsFound();
        }else{
            userController.foundbookingforCancel(bookings);
        }
    }

    @Override
    public void cancelBooking(int cancelId, User user, Bus bus, List<Passenger> passengers) {
        int amount=data.cancelBooking(cancelId,user,bus,passengers);
        if(amount>0){
            userController.seatCancellationSuccess(amount,cancelId);
        }else{
            userController.seatCancellationFailed(cancelId);
        }
    }
}
