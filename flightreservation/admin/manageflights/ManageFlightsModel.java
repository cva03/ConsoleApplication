package console.flightreservation.admin.manageflights;

import console.flightreservation.dto.Flight;
import console.flightreservation.repository.Repository;

import java.util.List;

public class ManageFlightsModel implements ManageFlightsModelControllerCallback {
    private ManageFlightsControllerModelCallback manageFlightsController;
    private Repository data= Repository.getInstance();
    public ManageFlightsModel(ManageFlightsController manageFlightsController) {
        this.manageFlightsController=manageFlightsController;
    }

    @Override
    public void showFlights() {
        List<Flight> flights=data.getFlights();
        if(!flights.isEmpty()){
            manageFlightsController.listAllFlights(flights);
        }else{
            manageFlightsController.noFlightsFound();
        }

    }



    @Override
    public void checkFlight(int flightId, String date, String departure) {
        Flight flight=data.checkFlight(flightId,date,departure);
        if(flight!=null){
            manageFlightsController.flightFound(flight);
        }else {
            manageFlightsController.flightNotFound();
        }
    }

    @Override
    public void deleteFlight(Flight flight) {
        if(data.deleteFlight(flight)){
            manageFlightsController.deletionSuccessfull();
        }else{
            manageFlightsController.deletionUnsuccessfull();
        }
    }

    @Override
    public void createuser(String name, String password, boolean admin) {
        if(data.createuser(name,password,admin)){
            if(admin)
                manageFlightsController.adminCreationSuccessfull();
            else
                manageFlightsController.userCreationSuccessfull();
        }else{
            if(admin)
                manageFlightsController.adminCreationFailed();
            else
                manageFlightsController.userCreationFailed();
        }
    }

    @Override
    public void addFlights(Flight flight) {
        if(data.addFlights(flight)){
            manageFlightsController.addSuccessfull();
        }else{
            manageFlightsController.addFailed();
        }
    }
}
