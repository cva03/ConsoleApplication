package console.busticketbooking.user;


import console.busticketbooking.dto.Booking;
import console.busticketbooking.dto.Bus;
import console.busticketbooking.dto.Passenger;
import console.busticketbooking.dto.User;

import java.util.List;

public class UserController implements UserControllerViewCallback, UserControllerModelCallBack {
    private UserViewCallback userView;
    private UserModelCallback userModel;

    public UserController(UserView userView) {
        this.userView=userView;
        this.userModel=new UserModel(this);
    }

    @Override
    public void findBus(String from, String to, String date) {
        userModel.findBus(from,to,date);
    }

    @Override
    public void noBusFound() {
        userView.noBusFound();
    }

    @Override
    public void showfoundBus(List<Bus> foundBus) {
        userView.showFoundBus(foundBus);
    }

    @Override
    public void findSelectedBusSeats(int selectedId, List<Bus> foundBus) {
        userModel.findSelectedBusSeats(selectedId,foundBus);
    }

    @Override
    public void addBooking(List<Passenger> passengers, Bus bus, User user) {
        userModel.addBooking(passengers,bus,user);
    }

    @Override
    public void getAllBooking(User user) {
        userModel.getAllBooking(user);
    }

    @Override
    public void findAllBookings(User user) {
        userModel.findAllBookings(user);
    }

    @Override
    public void cancelBooking(int cancelId, User user, Bus bus, List<Passenger> passengers) {
        userModel.cancelBooking(cancelId,user,bus,passengers);
    }

    @Override
    public void selectedWrongBus(List<Bus> foundBus) {
        userView.selectedWrongBus(foundBus);
    }

    @Override
    public void selectedBusFound(Bus bus) {
        userView.selectedBusFound(bus);
    }

    @Override
    public void bookingAddSuccess(int amount) {
        userView.bookingAddSuccess(amount);
    }

    @Override
    public void bookingAddFailed() {
        userView.bookingAddFailed();
    }

    @Override
    public void noBookingsFound() {
        userView.noBookingsFound();
    }

    @Override
    public void showAllBookings(List<Booking> bookings) {
        userView.showAllBookings(bookings);
    }

    @Override
    public void foundbookingforCancel(List<Booking> bookings) {
        userView.foundbookingforCancel(bookings);
    }

    @Override
    public void seatCancellationSuccess(int amount, int cancelId) {
        userView.seatCancellationSuccess(amount,cancelId);
    }

    @Override
    public void seatCancellationFailed(int cancelId) {
        userView.seatCancellationFailed(cancelId);
    }
}
