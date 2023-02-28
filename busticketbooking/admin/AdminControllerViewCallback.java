package console.busticketbooking.admin;

import console.busticketbooking.dto.Bus;

public interface AdminControllerViewCallback {
    void getAllBus();

    void addBus(Bus bus);

    void cancelBus(int travelId);

    void printSeats(int travelId);

}
