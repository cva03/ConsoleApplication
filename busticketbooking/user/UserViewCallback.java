package console.busticketbooking.user;

import console.busticketbooking.dto.Booking;
import console.busticketbooking.dto.Bus;

import java.util.List;

public interface UserViewCallback {
    void noBusFound();

    void showFoundBus(List<Bus> foundBus);

    void selectedWrongBus(List<Bus> foundBus);

    void selectedBusFound(Bus bus);

    void bookingAddSuccess(int amount);

    void bookingAddFailed();

    void noBookingsFound();

    void showAllBookings(List<Booking> bookings);

    void foundbookingforCancel(List<Booking> bookings);

    void seatCancellationSuccess(int amount, int cancelId);

    void seatCancellationFailed(int cancelId);
}
