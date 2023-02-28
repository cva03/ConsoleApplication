package console.busticketbooking.admin;

import console.busticketbooking.dto.Bus;

import java.util.List;

public interface AdminViewCallback {
    void emptyBusList();

    void showAllBus(List<Bus> busList);

    void busAddedSuccess(Bus bus);

    void busCancelSuccess(int travelId);

    void wrongTravelId(int travelId);

    void printAllSeats(Bus bus);
}
