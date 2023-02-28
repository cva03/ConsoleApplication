package console.busticketbooking.admin;

import console.busticketbooking.dto.Bus;

import java.util.List;

public interface AdminControllerModelCallBack {
    void emptyBusList();

    void showAllBus(List<Bus> busList);

    void busAddedSuccess(Bus bus);

    void busCancelSuccess(int travelId);

    void wrongTravelid(int travelId);

    void printAllSeats(Bus bus);

}
