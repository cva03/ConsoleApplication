package console.busticketbooking.admin;

import console.busticketbooking.dto.Bus;

import java.util.List;

public class AdminController implements AdminControllerViewCallback,AdminControllerModelCallBack{
    private AdminViewCallback adminView;
    private AdminModelCallback adminModel;

    public AdminController(AdminView adminView) {
        this.adminView=adminView;
        this.adminModel=new AdminModel(this);
    }

    @Override
    public void getAllBus() {
        adminModel.getAllBus();
    }

    @Override
    public void addBus(Bus bus) {
        adminModel.addBus(bus);
    }

    @Override
    public void cancelBus(int travelId) {
        adminModel.cancelBus(travelId);
    }

    @Override
    public void printSeats(int travelId) {
        adminModel.printSeats(travelId);
    }

    @Override
    public void emptyBusList() {
        adminView.emptyBusList();
    }

    @Override
    public void showAllBus(List<Bus> busList) {
        adminView.showAllBus(busList);
    }

    @Override
    public void busAddedSuccess(Bus bus) {
        adminView.busAddedSuccess(bus);
    }

    @Override
    public void busCancelSuccess(int travelId) {
        adminView.busCancelSuccess(travelId);
    }

    @Override
    public void wrongTravelid(int travelId) {
        adminView.wrongTravelId(travelId);
    }

    @Override
    public void printAllSeats(Bus bus) {
        adminView.printAllSeats(bus);
    }

}
