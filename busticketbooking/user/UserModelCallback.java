package console.busticketbooking.user;

import console.busticketbooking.dto.Bus;
import console.busticketbooking.dto.Passenger;
import console.busticketbooking.dto.User;

import java.util.List;

public interface UserModelCallback {
    void findBus(String from, String to, String date);

    void findSelectedBusSeats(int selectedId, List<Bus> foundBus);

    void addBooking(List<Passenger> passengers, Bus bus, User user);

    void getAllBooking(User user);

    void findAllBookings(User user);

     void cancelBooking(int cancelId, User user, Bus bus, List<Passenger> passengers);
}
