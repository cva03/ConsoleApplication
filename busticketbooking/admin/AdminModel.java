package console.busticketbooking.admin;

import console.busticketbooking.dto.Admin;
import console.busticketbooking.dto.Bus;
import console.busticketbooking.repository.Repository;

import java.util.List;

public class AdminModel implements AdminModelCallback {
    private AdminControllerModelCallBack adminController;
    private Repository data= Repository.getInstance();

    public AdminModel(AdminController adminController) {
        this.adminController=adminController;
    }

    @Override
    public void getAllBus() {
        List<Bus> busList=data.getAllBus();
        if(busList.isEmpty()){
            adminController.emptyBusList();
        }else
            adminController.showAllBus(busList);
    }

    @Override
    public void addBus(Bus bus) {
        data.addBus(bus);
        adminController.busAddedSuccess(bus);
    }

    @Override
    public void cancelBus(int travelId) {
        if(data.cancelBus(travelId)){
            adminController.busCancelSuccess(travelId);
        }else{
            adminController.wrongTravelid(travelId);
        }
    }

    @Override
    public void printSeats(int travelId) {
        Bus bus=data.printSeats(travelId);
        adminController.printAllSeats(bus);
    }

}
